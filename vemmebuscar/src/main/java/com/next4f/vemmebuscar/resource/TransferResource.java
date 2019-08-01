package com.next4f.vemmebuscar.resource;

import com.next4f.vemmebuscar.domain.*;
import com.next4f.vemmebuscar.resource.request.CostRequest;
import com.next4f.vemmebuscar.resource.request.CustomerRequest;
import com.next4f.vemmebuscar.service.*;
import com.next4f.vemmebuscar.util.DateUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.awt.print.Pageable;
import java.util.*;

@RestController
@CrossOrigin("*")
public class TransferResource {

    Logger LOGGER = LoggerFactory.getLogger(TransferResource.class);

    @Autowired
    private TransferService transferService;

    @Autowired
    private ComuneService comuneService;

    @Autowired
    private ArrivalService arrivalService;

    @Autowired
    private VanTypeService vanTypeService;

    @Autowired
    private DestinationService destinationService;

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @Autowired
    private MailService mailService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private SkiCenterService skiCenterService;

    @Autowired
    private OtherPlaceSerivce otherPlaceSerivce;

    @Autowired
    private FlightService flightService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/transfer/exclusive")
    public ResponseEntity<?> generateCustomerPurchaseOrderOneWayTrip(@RequestBody CustomerRequest customerRequest) {

        LOGGER.info(customerRequest.toString());

        Company company = companyService.findFirstById(customerRequest.getCompanyId());
        customerRequest.setCompanyName(company.getName());
        customerRequest.setAdditionalServices(customerRequest.getSpecialOrder());
        customerRequest.setBabychair(customerRequest.getChildCarSeat());

        //HOT FIX por que el front decidió mandarme la fecha así REMOVER DESPUÉS!!
        if (customerRequest.getArrival().equals("TO_AIRPORT"))
            customerRequest.setTransferLocalDateTime(customerRequest.getDepartureDateTime());
        else
            customerRequest.setTransferLocalDateTime(customerRequest.getArrivalDateTime());

        customerRequest.setReturnLocalDateTime(customerRequest.getDepartureDateTime());
        //Fin de esta basofia, debes ponerte de acuerdo con el front!!!

        DateUtils.pastYearAndMonthAnHourDateValidation(DateUtils.stringToLocalDateTime(customerRequest.getTransferLocalDateTime()));

        Comune comune = null;

        SkiCenter skiCenter = null;

        OtherPlace otherPlace = null;

        if (customerRequest.getComuneDestination() != null) {
            comuneService.countryGuardClause(customerRequest.getCountryDestination());
            comuneService.regionGuarClause(customerRequest.getRegionDestination());
            comune = comuneService.findByName(customerRequest.getComuneDestination());
        }

        if (customerRequest.getSkiCenterId() != null) {
            skiCenter = skiCenterService.findById(customerRequest.getSkiCenterId());
        } else if (customerRequest.getDestinationId() != null) {
            otherPlace = otherPlaceSerivce.findById(customerRequest.getDestinationId());
        }


        ArrivalEnum arrivalEnum = arrivalService.findArrivalEnum(customerRequest.getArrival());

        Arrival arrival = arrivalService.findByName(arrivalEnum);

        VanEnum vanEnum = vanTypeService.findVanEnum(VanEnum.EXCLUSIVE.toString());

        VanType vanType = vanTypeService.findByType(vanEnum);

        TripEnum tripEnum = TripEnum.valueOf(customerRequest.getTrip());

        //List<Destination> destinationList = destinationService.findAllByVanTypeAndComuneAndArrivalAndTripEnum(vanType, comune, arrival, tripEnum);

        Integer amountOfHumans = customerRequest.getAdults() + customerRequest.getChildren() + customerRequest.getBabies();

        Destination destination = null;

        if (customerRequest.getComuneDestination() != null) {
            destination = destinationService.findFirstDestinationByRangeOfAmountOfHumansAndVanTypeAndComuneAndArrivalAndTripEnum(amountOfHumans, vanType, comune, arrival, tripEnum);
        } else if (customerRequest.getSkiCenterId() != null) {
            destination = destinationService.findFirstDestinationByRangeOfAmountOfHumansAndVanTypeAndSkiCenterAndArrivalAndTripEnum(amountOfHumans, vanType, skiCenter, arrival, tripEnum);
        } else if (customerRequest.getDestinationId() != null) {
            destination = destinationService.findFirstDestinationByRangeOfAmountOfHumansAndVanTypeAndOtherPlaceAndArrivalAndTripEnum(amountOfHumans, vanType, otherPlace, arrival, tripEnum);
        }
        //  Destination destination = destinationService.findFirstDestinationByRangeOfAmountOfHumans(destinationList, amountOfHumans);

        Transfer transfer = new Transfer();
        transfer.setNumberOfAdults(customerRequest.getAdults());
        transfer.setNumberOfChildren(customerRequest.getChildren());
        transfer.setNumberOfBabies(customerRequest.getBabies());
        transfer.setDestination(destination);
        transfer.setServiceType(ServiceEnum.GO_TO);
        transfer.setPayment(PaymentEnum.OFFLINE);
        transfer.setFullAddress(customerRequest.getFullAddress());
        transfer.setDate(DateUtils.stringToLocalDateTime(customerRequest.getTransferLocalDateTime()).toLocalDate());
        transfer.setHour(DateUtils.stringToLocalDateTime(customerRequest.getTransferLocalDateTime()).toLocalTime());

        if(customerRequest.getTrip().equals(TripEnum.ROUND_TRIP.name())){
        transfer.setReturnDate(DateUtils.stringToLocalDateTime(customerRequest.getReturnLocalDateTime()).toLocalDate());
        transfer.setReturnHour(DateUtils.stringToLocalDateTime(customerRequest.getReturnLocalDateTime()).toLocalTime());
        }
        transfer.setWheelchair(customerRequest.getWheelchair());
        transfer.setAdditionalServices(customerRequest.getAdditionalServices());

        PurchaseOrder purchaseOrder = purchaseOrderService.save(purchaseOrderService.createPurchaseOrder(transfer));


        transfer.setPurchaseOrder(purchaseOrder);

        Customer customer = new Customer();
        customer.setName(customerRequest.getCustomerName());
        customer.setEmail(customerRequest.getCustomerEmail());
        customer.setPassport(customerRequest.getPassport());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());

        transfer.setCustomer(customer);


        Flight flight = new Flight();
        flight.setCompanyName(customerRequest.getCompanyName());
        flight.setFlightNumber(customerRequest.getFlightNumber());
        transfer.setFlight(flight);


        Map<String, Object> map = new HashMap<>();
        map.put("TRANSFER", transfer);

        Runnable emailTask = () -> {
            try {
                //  mailService.sendAgencyEmail();
                mailService.sendCustomerEmail(customerRequest, purchaseOrder);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        };

        new Thread(emailTask).start();

        flight = flightService.save(flight);

        Optional<Customer> customerOptional = customerService.findByEmail(customerRequest.getCustomerEmail());

        if (!customerOptional.isPresent())
            customer = customerService.save(customer);
        else
            customer = customerOptional.get();

        transfer.setPurchaseOrder(purchaseOrder);
        transfer.setCustomer(customer);
        transferService.save(transfer);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/transfer/exclusive/price")
    public ResponseEntity<?> getCost(@RequestBody CostRequest costRequest) {
        LOGGER.info(costRequest.toString());
        Comune comune = null;
        SkiCenter skiCenter = null;
        OtherPlace otherPlace = null;

        if (costRequest.getComuneDestination() != null) {
            comuneService.countryGuardClause(costRequest.getCountryDestination());
            comuneService.regionGuarClause(costRequest.getRegionDestination());
            comune = comuneService.findByName(costRequest.getComuneDestination());
        } else if (costRequest.getSkiCenterId() != null) {
            skiCenter = skiCenterService.findById(costRequest.getSkiCenterId());
        } else if (costRequest.getDestinationId() != null) {
            otherPlace = otherPlaceSerivce.findById(costRequest.getDestinationId());
        }

        ArrivalEnum arrivalEnum = arrivalService.findArrivalEnum(costRequest.getArrival());
        Arrival arrival = arrivalService.findByName(arrivalEnum);
        VanEnum vanEnum = vanTypeService.findVanEnum(VanEnum.EXCLUSIVE.toString());
        VanType vanType = vanTypeService.findByType(vanEnum);
        TripEnum tripEnum = TripEnum.valueOf(costRequest.getTrip());

        Integer amountOfHumans = costRequest.getAdults() + costRequest.getChildren() + costRequest.getBabies();
        Destination destination = null;

        if (costRequest.getComuneDestination() != null) {
            destination = destinationService.findFirstDestinationByRangeOfAmountOfHumansAndVanTypeAndComuneAndArrivalAndTripEnum(amountOfHumans, vanType, comune, arrival, tripEnum);
        } else if (costRequest.getSkiCenterId() != null) {
            destination = destinationService.findFirstDestinationByRangeOfAmountOfHumansAndVanTypeAndSkiCenterAndArrivalAndTripEnum(amountOfHumans, vanType, skiCenter, arrival, tripEnum);
        } else if (costRequest.getDestinationId() != null) {
            destination = destinationService.findFirstDestinationByRangeOfAmountOfHumansAndVanTypeAndOtherPlaceAndArrivalAndTripEnum(amountOfHumans, vanType, otherPlace, arrival, tripEnum);
        }

        Transfer transfer = new Transfer();
        transfer.setNumberOfAdults(costRequest.getAdults());
        transfer.setNumberOfChildren(costRequest.getChildren());
        transfer.setNumberOfBabies(costRequest.getBabies());
        transfer.setDestination(destination);
        transfer.setServiceType(ServiceEnum.GO_TO);
        transfer.setPayment(PaymentEnum.OFFLINE);
        PurchaseOrder purchaseOrder = purchaseOrderService.createPurchaseOrder(transfer);
        purchaseOrder.setOrderStatus(OrderStatusEnum.PENDING);

        Map<String, Double> map = new HashMap<>();

        map.put("price", purchaseOrder.getTotalAmount());

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
/*
IJG
 */
    @GetMapping("/transfer/findAll")
    public List<Transfer> findAll(){
     return transferService.findAll();
    }

    @RequestMapping(value="/transfer/findAllByDestination",method=RequestMethod.GET)
//    @GetMapping("/transfer/findAllByDestination")
    public Page<Transfer> findAll(Pageable pageable){
        return transferService.listAllByPage(PageRequest.of(2,2));
    }

/*
fin IJG
 */

/*
    @PostMapping("/transfer/exclusive/roundTrip")
    public ResponseEntity<?> generateCustomerPurchaseOrderRoundTrip(@RequestBody CustomerRequest customerRequest) {
        return null;
    }

    */

    /*
    @GetMapping("/mail")
    public void mail() {
        mailService.sendMail("Hello World");
    }
        */
}
