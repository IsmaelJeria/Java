package com.next4f.vemmebuscar.service;

import com.next4f.vemmebuscar.domain.*;
import com.next4f.vemmebuscar.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class InitDataBaseService {
    /*
     * 1) El cliente escoje si va desde el aeropuerto o hacia el aeropuerto (Arrival)

     * 2) El cliente escoje el destino (Destination)
     *
     * 3) El cliente Escoje si el viaje es de ida o ida y vuelta.
     *    En caso de que el viaje sea sólo ida se generará un unico registro en la tabla "Transfer".
     *    En caso de que el viaje sea ida y vuelta se generarán 2 registros en la tabla "Transfer" y ambos registros
     *    estarán asociados a la misma orden de compra.
     *
     * 4) El cliente escoje la cantidad de adultos, niños y bebés "Transfer".
     *
     * 5) El cliente escojerá la cantidad de maletas extras "Transfer".
     *
     * 5) El cliente indicará la hora de ida y vuelta del viaje "Transfer"
     *
     * 6) El cliente ingresará sus datos personales "Customer"
     *
     * 15) Se generara la orden de compra "PurchaseOrder" y se asociara al/los registros de transfer creados
     *
     * */


    @Autowired
    private ArrivalRepository arrivalRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private VanTypeRepository vanTypeRepository;

    @Autowired
    private ComuneRepository comuneRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private SkiCenterRepository skiCenterRepository;

    @Autowired
    private OtherPlaceRepository otherPlaceRepository;

  //  @PostConstruct
  //  @Transactional
    public void postConstruct() {
        Arrival arrival1 = new Arrival();
        arrival1.setName(ArrivalEnum.FROM_AIRPORT);

        Arrival arrival2 = new Arrival();
        arrival2.setName(ArrivalEnum.TO_AIRPORT);

        arrival1 = arrivalRepository.save(arrival1);
        arrival2 = arrivalRepository.save(arrival2);

        VanType vanType1 = new VanType();
        vanType1.setType(VanEnum.EXCLUSIVE);

        VanType vanType2 = new VanType();
        vanType2.setType(VanEnum.SHARED);

        vanType1 = vanTypeRepository.save(vanType1);
        vanType2 = vanTypeRepository.save(vanType2);

        Comune comune1 = new Comune();
        comune1.setName("SANTIAGO");

        Comune comune2 = new Comune();
        comune2.setName("PROVIDENCIA");

        Comune comune3 = new Comune();
        comune3.setName("LAS CONDES");

        Comune comune4 = new Comune();
        comune4.setName("VITACURA");

        Comune comune5 = new Comune();
        comune5.setName("ÑUÑOA");

        Comune comune6 = new Comune();
        comune6.setName("MACUL");

        Comune comune7 = new Comune();
        comune7.setName("ESTACION CENTRAL");

        Comune comune8 = new Comune();
        comune8.setName("LA DEHESA");

        Comune comune9 = new Comune();
        comune9.setName("LA REINA");

        comune1 = comuneRepository.save(comune1);
        comune2 = comuneRepository.save(comune2);
        comune3 = comuneRepository.save(comune3);
        comune4 = comuneRepository.save(comune4);
        comune5 = comuneRepository.save(comune5);
        comune6 = comuneRepository.save(comune6);
        comune7 = comuneRepository.save(comune7);
        comune8 = comuneRepository.save(comune8);
        comune9 = comuneRepository.save(comune9);

        Destination centro1In = new Destination();
        centro1In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        centro1In.setPeopleRange(3);
        centro1In.setComune(comune1);
        centro1In.setFixedPrice(23990D);
        centro1In.setArrival(arrival1);
        centro1In.setVanType(vanType1);
        centro1In.setDescription("1 to 3 humans fixed price");

        Destination centro2In = new Destination();
        centro2In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        centro2In.setPeopleRange(6);
        centro2In.setComune(comune1);
        centro2In.setFixedPrice(26990D);
        centro2In.setArrival(arrival1);
        centro2In.setVanType(vanType1);
        centro2In.setDescription("4 to 6 humans fixed price");

        Destination centro3In = new Destination();
        centro3In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        centro3In.setPeopleRange(15);
        centro3In.setComune(comune1);
        centro3In.setFixedPrice(null);
        centro3In.setVariablePrice(4500D);
        centro3In.setArrival(arrival1);
        centro3In.setVanType(vanType1);
        centro3In.setDescription("7 to 15 humans variable price CLP 4500 P/P");

        Destination centro4In = new Destination();
        centro4In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        centro4In.setPeopleRange(16);
        centro4In.setComune(comune1);
        centro4In.setFixedPrice(null);
        centro4In.setVariablePrice(5000D);
        centro4In.setArrival(arrival1);
        centro4In.setVanType(vanType1);
        centro4In.setDescription("16+ humans variable price CLP 5000 P/P");

        centro1In = destinationRepository.save(centro1In);
        centro2In = destinationRepository.save(centro2In);
        centro3In = destinationRepository.save(centro3In);
        centro4In = destinationRepository.save(centro4In);

        Destination providencia1In = new Destination();
        providencia1In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        providencia1In.setPeopleRange(3);
        providencia1In.setComune(comune2);
        providencia1In.setFixedPrice(24990D);
        providencia1In.setArrival(arrival1);
        providencia1In.setVanType(vanType1);
        providencia1In.setDescription("1 to 3 humans fixed price");

        Destination providencia2In = new Destination();
        providencia2In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        providencia2In.setPeopleRange(6);
        providencia2In.setComune(comune2);
        providencia2In.setFixedPrice(28990D);
        providencia2In.setArrival(arrival1);
        providencia2In.setVanType(vanType1);
        providencia2In.setDescription("4 to 6 humans fixed price");

        Destination providencia3In = new Destination();
        providencia3In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        providencia3In.setPeopleRange(15);
        providencia3In.setComune(comune2);
        providencia3In.setFixedPrice(null);
        providencia3In.setVariablePrice(5000D);
        providencia3In.setArrival(arrival1);
        providencia3In.setVanType(vanType1);
        providencia3In.setDescription("7 to 15 humans variable price CLP 5000 P/P");

        Destination providencia4In = new Destination();
        providencia4In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        providencia4In.setPeopleRange(16);
        providencia4In.setComune(comune2);
        providencia4In.setFixedPrice(null);
        providencia4In.setVariablePrice(5500D);
        providencia4In.setArrival(arrival1);
        providencia4In.setVanType(vanType1);
        providencia4In.setDescription("16+ humans variable price CLP 5500 P/P");


        providencia1In = destinationRepository.save(providencia1In);
        providencia2In = destinationRepository.save(providencia2In);
        providencia3In = destinationRepository.save(providencia3In);
        providencia4In = destinationRepository.save(providencia4In);


        Destination lasCondes1In = new Destination();
        lasCondes1In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        lasCondes1In.setPeopleRange(3);
        lasCondes1In.setComune(comune3);
        lasCondes1In.setFixedPrice(28990D);
        lasCondes1In.setArrival(arrival1);
        lasCondes1In.setVanType(vanType1);
        lasCondes1In.setDescription("1 to 3 humans fixed price");

        Destination lasCondes2In = new Destination();
        lasCondes2In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        lasCondes2In.setPeopleRange(6);
        lasCondes2In.setComune(comune3);
        lasCondes2In.setFixedPrice(32990D);
        lasCondes2In.setArrival(arrival1);
        lasCondes2In.setVanType(vanType1);
        lasCondes2In.setDescription("4 to 6 humans fixed price");

        Destination lasCondes3In = new Destination();
        lasCondes3In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        lasCondes3In.setPeopleRange(15);
        lasCondes3In.setComune(comune3);
        lasCondes3In.setFixedPrice(null);
        lasCondes3In.setVariablePrice(6000D);
        lasCondes3In.setArrival(arrival1);
        lasCondes3In.setVanType(vanType1);
        lasCondes3In.setDescription("7 to 15 humans variable price CLP 6000 P/P");

        Destination lasCondes4In = new Destination();
        lasCondes4In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        lasCondes4In.setPeopleRange(16);
        lasCondes4In.setComune(comune3);
        lasCondes4In.setFixedPrice(null);
        lasCondes4In.setVariablePrice(6500D);
        lasCondes4In.setArrival(arrival1);
        lasCondes4In.setVanType(vanType1);
        lasCondes4In.setDescription("16+ humans variable price CLP 6500 P/P");


        lasCondes1In = destinationRepository.save(lasCondes1In);
        lasCondes2In = destinationRepository.save(lasCondes2In);
        lasCondes3In = destinationRepository.save(lasCondes3In);
        lasCondes4In = destinationRepository.save(lasCondes4In);


        Destination vitacura1In = new Destination();
        vitacura1In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vitacura1In.setPeopleRange(3);
        vitacura1In.setComune(comune4);
        vitacura1In.setFixedPrice(28990D);
        vitacura1In.setArrival(arrival1);
        vitacura1In.setVanType(vanType1);
        vitacura1In.setDescription("1 to 3 humans fixed price");

        Destination vitacura2In = new Destination();
        vitacura2In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vitacura2In.setPeopleRange(6);
        vitacura2In.setComune(comune4);
        vitacura2In.setFixedPrice(32990D);
        vitacura2In.setArrival(arrival1);
        vitacura2In.setVanType(vanType1);
        vitacura2In.setDescription("4 to 6 humans fixed price");

        Destination vitacura3In = new Destination();
        vitacura3In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vitacura3In.setPeopleRange(15);
        vitacura3In.setComune(comune4);
        vitacura3In.setFixedPrice(null);
        vitacura3In.setVariablePrice(6000D);
        vitacura3In.setArrival(arrival1);
        vitacura3In.setVanType(vanType1);
        vitacura3In.setDescription("7 to 15 humans variable price CLP 6000 P/P");

        Destination vitacura4In = new Destination();
        vitacura4In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vitacura4In.setPeopleRange(16);
        vitacura4In.setComune(comune4);
        vitacura4In.setFixedPrice(null);
        vitacura4In.setVariablePrice(6500D);
        vitacura4In.setArrival(arrival1);
        vitacura4In.setVanType(vanType1);
        vitacura4In.setDescription("16+ humans variable price CLP 6500 P/P");

        vitacura1In = destinationRepository.save(vitacura1In);
        vitacura2In = destinationRepository.save(vitacura2In);
        vitacura3In = destinationRepository.save(vitacura3In);
        vitacura4In = destinationRepository.save(vitacura4In);


        Destination nunoaI1n = new Destination();
        nunoaI1n.setTripEnum(TripEnum.ONE_WAY_TRIP);
        nunoaI1n.setPeopleRange(3);
        nunoaI1n.setComune(comune5);
        nunoaI1n.setFixedPrice(28990D);
        nunoaI1n.setVariablePrice(null);
        nunoaI1n.setArrival(arrival1);
        nunoaI1n.setVanType(vanType1);
        nunoaI1n.setDescription("1 to 3 humans fixed price CLP 28990D");

        Destination nunoaI2n = new Destination();
        nunoaI2n.setTripEnum(TripEnum.ONE_WAY_TRIP);
        nunoaI2n.setPeopleRange(6);
        nunoaI2n.setComune(comune5);
        nunoaI2n.setFixedPrice(32990D);
        nunoaI2n.setVariablePrice(null);
        nunoaI2n.setArrival(arrival1);
        nunoaI2n.setVanType(vanType1);
        nunoaI2n.setDescription("4 to 3 humans fixed price CLP 32990D ");

        Destination nunoaI3n = new Destination();
        nunoaI3n.setTripEnum(TripEnum.ONE_WAY_TRIP);
        nunoaI3n.setPeopleRange(15);
        nunoaI3n.setComune(comune5);
        nunoaI3n.setFixedPrice(null);
        nunoaI3n.setVariablePrice(6000D);
        nunoaI3n.setArrival(arrival1);
        nunoaI3n.setVanType(vanType1);
        nunoaI3n.setDescription("7 to 15 humans variable price CLP 6000D P/P");

        Destination nunoaI4n = new Destination();
        nunoaI4n.setTripEnum(TripEnum.ONE_WAY_TRIP);
        nunoaI4n.setPeopleRange(16);
        nunoaI4n.setComune(comune5);
        nunoaI4n.setFixedPrice(null);
        nunoaI4n.setVariablePrice(6500D);
        nunoaI4n.setArrival(arrival1);
        nunoaI4n.setVanType(vanType1);
        nunoaI4n.setDescription("16+ humans variable price CLP 6500D P/P");

        nunoaI1n = destinationRepository.save(nunoaI1n);
        nunoaI2n = destinationRepository.save(nunoaI2n);
        nunoaI3n = destinationRepository.save(nunoaI3n);
        nunoaI4n = destinationRepository.save(nunoaI4n);


        Destination maculIn = new Destination();
        maculIn.setTripEnum(TripEnum.ONE_WAY_TRIP);
        maculIn.setPeopleRange(3);
        maculIn.setComune(comune6);
        maculIn.setFixedPrice(28990D);
        maculIn.setVariablePrice(null);
        maculIn.setArrival(arrival1);
        maculIn.setVanType(vanType1);
        maculIn.setDescription("1 to 3 humans fixed price CLP 28990D");

        Destination macul2In = new Destination();
        macul2In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        macul2In.setPeopleRange(6);
        macul2In.setComune(comune6);
        macul2In.setFixedPrice(32990D);
        macul2In.setVariablePrice(null);
        macul2In.setArrival(arrival1);
        macul2In.setVanType(vanType1);
        macul2In.setDescription("4 to 3 humans fixed price CLP 32990D ");

        Destination macul3In = new Destination();
        macul3In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        macul3In.setPeopleRange(15);
        macul3In.setComune(comune6);
        macul3In.setFixedPrice(null);
        macul3In.setVariablePrice(6000D);
        macul3In.setArrival(arrival1);
        macul3In.setVanType(vanType1);
        macul3In.setDescription("7 to 15 humans variable price CLP 6000D P/P");

        Destination macul4In = new Destination();
        macul4In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        macul4In.setPeopleRange(16);
        macul4In.setComune(comune6);
        macul4In.setFixedPrice(null);
        macul4In.setVariablePrice(6500D);
        macul4In.setArrival(arrival1);
        macul4In.setVanType(vanType1);
        macul4In.setDescription("16+ humans variable price CLP 6500D P/P");


        maculIn = destinationRepository.save(maculIn);
        macul2In = destinationRepository.save(macul2In);
        macul3In = destinationRepository.save(macul3In);
        macul4In = destinationRepository.save(macul4In);

        Destination estacionCentral1In = new Destination();
        estacionCentral1In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        estacionCentral1In.setPeopleRange(3);
        estacionCentral1In.setComune(comune7);
        estacionCentral1In.setFixedPrice(23990D);
        estacionCentral1In.setVariablePrice(null);
        estacionCentral1In.setArrival(arrival1);
        estacionCentral1In.setVanType(vanType1);

        Destination estacionCentral2In = new Destination();
        estacionCentral2In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        estacionCentral2In.setPeopleRange(6);
        estacionCentral2In.setComune(comune7);
        estacionCentral2In.setFixedPrice(26990D);
        estacionCentral2In.setVariablePrice(null);
        estacionCentral2In.setArrival(arrival1);
        estacionCentral2In.setVanType(vanType1);


        Destination estacionCentral3In = new Destination();
        estacionCentral3In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        estacionCentral3In.setPeopleRange(15);
        estacionCentral3In.setComune(comune7);
        estacionCentral3In.setFixedPrice(null);
        estacionCentral3In.setVariablePrice(4500D);
        estacionCentral3In.setArrival(arrival1);
        estacionCentral3In.setVanType(vanType1);


        Destination estacionCentral4In = new Destination();
        estacionCentral1In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        estacionCentral4In.setPeopleRange(16);
        estacionCentral4In.setComune(comune7);
        estacionCentral4In.setFixedPrice(null);
        estacionCentral4In.setVariablePrice(5000D);
        estacionCentral4In.setArrival(arrival1);
        estacionCentral4In.setVanType(vanType1);

        estacionCentral1In = destinationRepository.save(estacionCentral1In);
        estacionCentral2In = destinationRepository.save(estacionCentral2In);
        estacionCentral3In = destinationRepository.save(estacionCentral3In);
        estacionCentral4In = destinationRepository.save(estacionCentral4In);

        Destination laDeHesa1In = new Destination();
        laDeHesa1In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laDeHesa1In.setPeopleRange(3);
        laDeHesa1In.setComune(comune8);
        laDeHesa1In.setFixedPrice(29990D);
        laDeHesa1In.setVariablePrice(null);
        laDeHesa1In.setArrival(arrival1);
        laDeHesa1In.setVanType(vanType1);

        Destination laDeHesa2In = new Destination();
        laDeHesa2In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laDeHesa2In.setPeopleRange(6);
        laDeHesa2In.setComune(comune8);
        laDeHesa2In.setFixedPrice(34990D);
        laDeHesa2In.setVariablePrice(null);
        laDeHesa2In.setArrival(arrival1);
        laDeHesa2In.setVanType(vanType1);

        Destination laDeHesa3In = new Destination();
        laDeHesa3In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laDeHesa3In.setPeopleRange(15);
        laDeHesa3In.setComune(comune8);
        laDeHesa3In.setFixedPrice(null);
        laDeHesa3In.setVariablePrice(7000D);
        laDeHesa3In.setArrival(arrival1);
        laDeHesa3In.setVanType(vanType1);

        Destination laDeHesa4In = new Destination();
        laDeHesa4In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laDeHesa4In.setPeopleRange(16);
        laDeHesa4In.setComune(comune8);
        laDeHesa4In.setFixedPrice(null);
        laDeHesa4In.setVariablePrice(7500D);
        laDeHesa4In.setArrival(arrival1);
        laDeHesa4In.setVanType(vanType1);

        laDeHesa1In = destinationRepository.save(laDeHesa1In);
        laDeHesa2In = destinationRepository.save(laDeHesa2In);
        laDeHesa3In = destinationRepository.save(laDeHesa3In);
        laDeHesa4In = destinationRepository.save(laDeHesa4In);


        Destination laReina1In = new Destination();
        laReina1In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laReina1In.setPeopleRange(3);
        laReina1In.setComune(comune9);
        laReina1In.setFixedPrice(29990D);
        laReina1In.setVariablePrice(null);
        laReina1In.setArrival(arrival1);
        laReina1In.setVanType(vanType1);

        Destination laReina2In = new Destination();
        laReina2In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laReina2In.setPeopleRange(6);
        laReina2In.setComune(comune9);
        laReina2In.setFixedPrice(34990D);
        laReina2In.setVariablePrice(null);
        laReina2In.setArrival(arrival1);
        laReina2In.setVanType(vanType1);

        Destination laReina3In = new Destination();
        laReina3In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laReina3In.setPeopleRange(15);
        laReina3In.setComune(comune9);
        laReina3In.setFixedPrice(null);
        laReina3In.setVariablePrice(7000D);
        laReina3In.setArrival(arrival1);
        laReina3In.setVanType(vanType1);

        Destination laReina4In = new Destination();
        laReina4In.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laReina4In.setPeopleRange(16);
        laReina4In.setComune(comune9);
        laReina4In.setFixedPrice(null);
        laReina4In.setVariablePrice(7500D);
        laReina4In.setArrival(arrival1);
        laReina4In.setVanType(vanType1);

        laReina1In = destinationRepository.save(laReina1In);
        laReina2In = destinationRepository.save(laReina2In);
        laReina3In = destinationRepository.save(laReina3In);
        laReina4In = destinationRepository.save(laReina4In);


        Destination centro1Out = new Destination();
        centro1Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        centro1Out.setPeopleRange(3);
        centro1Out.setComune(comune1);
        centro1Out.setFixedPrice(22000D);
        centro1Out.setArrival(arrival2);
        centro1Out.setVanType(vanType1);
        centro1Out.setDescription("1 to 3 humans fixed price");

        Destination centro2Out = new Destination();
        centro2Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        centro2Out.setPeopleRange(6);
        centro2Out.setComune(comune1);
        centro2Out.setFixedPrice(25000D);
        centro2Out.setArrival(arrival2);
        centro2Out.setVanType(vanType1);
        centro2Out.setDescription("4 to 6 humans fixed price");

        Destination centro3Out = new Destination();
        centro3Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        centro3Out.setPeopleRange(15);
        centro3Out.setComune(comune1);
        centro3Out.setFixedPrice(null);
        centro3Out.setVariablePrice(4000D);
        centro3Out.setArrival(arrival2);
        centro3Out.setVanType(vanType1);
        centro3Out.setDescription("7 to 15 humans variable price CLP 4500 P/P");

        Destination centro4Out = new Destination();
        centro4Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        centro4Out.setPeopleRange(16);
        centro4Out.setComune(comune1);
        centro4Out.setFixedPrice(null);
        centro4Out.setVariablePrice(4500D);
        centro4Out.setArrival(arrival2);
        centro4Out.setVanType(vanType1);
        centro4Out.setDescription("16+ humans variable price CLP 5000 P/P");

        centro1Out = destinationRepository.save(centro1Out);
        centro2Out = destinationRepository.save(centro2Out);
        centro3Out = destinationRepository.save(centro3Out);
        centro4Out = destinationRepository.save(centro4Out);


        Destination providencia1Out = new Destination();
        providencia1Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        providencia1Out.setPeopleRange(3);
        providencia1Out.setComune(comune2);
        providencia1Out.setFixedPrice(23000D);
        providencia1Out.setArrival(arrival2);
        providencia1Out.setVanType(vanType1);
        providencia1Out.setDescription("1 to 3 humans fixed price");

        Destination providencia2Out = new Destination();
        providencia2Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        providencia2Out.setPeopleRange(6);
        providencia2Out.setComune(comune2);
        providencia2Out.setFixedPrice(27000D);
        providencia2Out.setArrival(arrival2);
        providencia2Out.setVanType(vanType1);
        providencia2Out.setDescription("4 to 6 humans fixed price");

        Destination providencia3Out = new Destination();
        providencia3Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        providencia3Out.setPeopleRange(15);
        providencia3Out.setComune(comune2);
        providencia3Out.setFixedPrice(null);
        providencia3Out.setVariablePrice(4500D);
        providencia3Out.setArrival(arrival2);
        providencia3Out.setVanType(vanType1);
        providencia3Out.setDescription("7 to 15 humans variable price CLP 5000 P/P");

        Destination providencia4Out = new Destination();
        providencia4Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        providencia4Out.setPeopleRange(16);
        providencia4Out.setComune(comune2);
        providencia4Out.setFixedPrice(null);
        providencia4Out.setVariablePrice(5000D);
        providencia4Out.setArrival(arrival2);
        providencia4Out.setVanType(vanType1);
        providencia4Out.setDescription("16+ humans variable price CLP 5500 P/P");


        providencia1Out = destinationRepository.save(providencia1Out);
        providencia2Out = destinationRepository.save(providencia2Out);
        providencia3Out = destinationRepository.save(providencia3Out);
        providencia4Out = destinationRepository.save(providencia4Out);


        Destination lasCondes1Out = new Destination();
        lasCondes1Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        lasCondes1Out.setPeopleRange(3);
        lasCondes1Out.setComune(comune3);
        lasCondes1Out.setFixedPrice(25000D);
        lasCondes1Out.setArrival(arrival2);
        lasCondes1Out.setVanType(vanType1);
        lasCondes1Out.setDescription("1 to 3 humans fixed price");

        Destination lasCondes2Out = new Destination();
        lasCondes2Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        lasCondes2Out.setPeopleRange(6);
        lasCondes2Out.setComune(comune3);
        lasCondes2Out.setFixedPrice(30000D);
        lasCondes2Out.setArrival(arrival2);
        lasCondes2Out.setVanType(vanType1);
        lasCondes2Out.setDescription("4 to 6 humans fixed price");

        Destination lasCondes3Out = new Destination();
        lasCondes3Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        lasCondes3Out.setPeopleRange(15);
        lasCondes3Out.setComune(comune3);
        lasCondes3Out.setFixedPrice(null);
        lasCondes3Out.setVariablePrice(5500D);
        lasCondes3Out.setArrival(arrival2);
        lasCondes3Out.setVanType(vanType1);
        lasCondes3Out.setDescription("7 to 15 humans variable price CLP 6000 P/P");

        Destination lasCondes4Out = new Destination();
        lasCondes4Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        lasCondes4Out.setPeopleRange(16);
        lasCondes4Out.setComune(comune3);
        lasCondes4Out.setFixedPrice(null);
        lasCondes4Out.setVariablePrice(6000D);
        lasCondes4Out.setArrival(arrival2);
        lasCondes4Out.setVanType(vanType1);
        lasCondes4Out.setDescription("16+ humans variable price CLP 6500 P/P");


        lasCondes1Out = destinationRepository.save(lasCondes1Out);
        lasCondes2Out = destinationRepository.save(lasCondes2Out);
        lasCondes3Out = destinationRepository.save(lasCondes3Out);
        lasCondes4Out = destinationRepository.save(lasCondes4Out);


        Destination vitacura1Out = new Destination();
        vitacura1Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vitacura1Out.setPeopleRange(3);
        vitacura1Out.setComune(comune4);
        vitacura1Out.setFixedPrice(25000D);
        vitacura1Out.setArrival(arrival2);
        vitacura1Out.setVanType(vanType1);
        vitacura1Out.setDescription("1 to 3 humans fixed price");

        Destination vitacura2Out = new Destination();
        vitacura2Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vitacura2Out.setPeopleRange(6);
        vitacura2Out.setComune(comune4);
        vitacura2Out.setFixedPrice(30000D);
        vitacura2Out.setArrival(arrival2);
        vitacura2Out.setVanType(vanType1);
        vitacura2Out.setDescription("4 to 6 humans fixed price");

        Destination vitacura3Out = new Destination();
        vitacura3Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vitacura3Out.setPeopleRange(15);
        vitacura3Out.setComune(comune4);
        vitacura3Out.setFixedPrice(null);
        vitacura3Out.setVariablePrice(5500D);
        vitacura3Out.setArrival(arrival2);
        vitacura3Out.setVanType(vanType1);
        vitacura3Out.setDescription("7 to 15 humans variable price CLP 6000 P/P");

        Destination vitacura4Out = new Destination();
        vitacura4Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vitacura4Out.setPeopleRange(16);
        vitacura4Out.setComune(comune4);
        vitacura4Out.setFixedPrice(null);
        vitacura4Out.setVariablePrice(6000D);
        vitacura4Out.setArrival(arrival2);
        vitacura4Out.setVanType(vanType1);
        vitacura4Out.setDescription("16+ humans variable price CLP 6500 P/P");

        vitacura1Out = destinationRepository.save(vitacura1Out);
        vitacura2Out = destinationRepository.save(vitacura2Out);
        vitacura3Out = destinationRepository.save(vitacura3Out);
        vitacura4Out = destinationRepository.save(vitacura4Out);


        Destination nunoa1Out = new Destination();
        nunoa1Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        nunoa1Out.setPeopleRange(3);
        nunoa1Out.setComune(comune5);
        nunoa1Out.setFixedPrice(25000D);
        nunoa1Out.setArrival(arrival2);
        nunoa1Out.setVanType(vanType1);
        nunoa1Out.setDescription("1 to 3 humans fixed price");

        Destination nunoa2Out = new Destination();
        nunoa2Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        nunoa2Out.setPeopleRange(6);
        nunoa2Out.setComune(comune5);
        nunoa2Out.setFixedPrice(30000D);
        nunoa2Out.setArrival(arrival2);
        nunoa2Out.setVanType(vanType1);
        nunoa2Out.setDescription("4 to 6 humans fixed price");

        Destination nunoa3Out = new Destination();
        nunoa3Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        nunoa3Out.setPeopleRange(15);
        nunoa3Out.setComune(comune5);
        nunoa3Out.setFixedPrice(null);
        nunoa3Out.setVariablePrice(5500D);
        nunoa3Out.setArrival(arrival2);
        nunoa3Out.setVanType(vanType1);
        nunoa3Out.setDescription("7 to 15 humans variable price CLP 6000 P/P");

        Destination nunoa4Out = new Destination();
        nunoa4Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        nunoa4Out.setPeopleRange(16);
        nunoa4Out.setComune(comune5);
        nunoa4Out.setFixedPrice(null);
        nunoa4Out.setVariablePrice(6000D);
        nunoa4Out.setArrival(arrival2);
        nunoa4Out.setVanType(vanType1);
        nunoa4Out.setDescription("16+ humans variable price CLP 6500 P/P");

        nunoa1Out = destinationRepository.save(nunoa1Out);
        nunoa2Out = destinationRepository.save(nunoa2Out);
        nunoa3Out = destinationRepository.save(nunoa3Out);
        nunoa4Out = destinationRepository.save(nunoa4Out);


        Destination macul1Out = new Destination();
        macul1Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        macul1Out.setPeopleRange(3);
        macul1Out.setComune(comune6);
        macul1Out.setFixedPrice(25000D);
        macul1Out.setArrival(arrival2);
        macul1Out.setVanType(vanType1);
        macul1Out.setDescription("1 to 3 humans fixed price");

        Destination macul2Out = new Destination();
        macul2Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        macul2Out.setPeopleRange(6);
        macul2Out.setComune(comune6);
        macul2Out.setFixedPrice(30000D);
        macul2Out.setArrival(arrival2);
        macul2Out.setVanType(vanType1);
        macul2Out.setDescription("4 to 6 humans fixed price");

        Destination macul3Out = new Destination();
        macul3Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        macul3Out.setPeopleRange(15);
        macul3Out.setComune(comune6);
        macul3Out.setFixedPrice(null);
        macul3Out.setVariablePrice(5500D);
        macul3Out.setArrival(arrival2);
        macul3Out.setVanType(vanType1);
        macul3Out.setDescription("7 to 15 humans variable price CLP 6000 P/P");

        Destination macul4Out = new Destination();
        macul4Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        macul4Out.setPeopleRange(16);
        macul4Out.setComune(comune6);
        macul4Out.setFixedPrice(null);
        macul4Out.setVariablePrice(6000D);
        macul4Out.setArrival(arrival2);
        macul4Out.setVanType(vanType1);
        macul4Out.setDescription("16+ humans variable price CLP 6500 P/P");

        macul1Out = destinationRepository.save(macul1Out);
        macul2Out = destinationRepository.save(macul2Out);
        macul3Out = destinationRepository.save(macul3Out);
        macul4Out = destinationRepository.save(macul4Out);


        Destination estacionCentra11Out = new Destination();
        estacionCentra11Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        estacionCentra11Out.setPeopleRange(3);
        estacionCentra11Out.setComune(comune7);
        estacionCentra11Out.setFixedPrice(22000D);
        estacionCentra11Out.setArrival(arrival2);
        estacionCentra11Out.setVanType(vanType1);
        estacionCentra11Out.setDescription("1 to 3 humans fixed price");

        Destination estacionCentra12Out = new Destination();
        estacionCentra12Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        estacionCentra12Out.setPeopleRange(6);
        estacionCentra12Out.setComune(comune7);
        estacionCentra12Out.setFixedPrice(25000D);
        estacionCentra12Out.setArrival(arrival2);
        estacionCentra12Out.setVanType(vanType1);
        estacionCentra12Out.setDescription("4 to 6 humans fixed price");

        Destination estacionCentra13Out = new Destination();
        estacionCentra13Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        estacionCentra13Out.setPeopleRange(15);
        estacionCentra13Out.setComune(comune7);
        estacionCentra13Out.setFixedPrice(null);
        estacionCentra13Out.setVariablePrice(4000D);
        estacionCentra13Out.setArrival(arrival2);
        estacionCentra13Out.setVanType(vanType1);
        estacionCentra13Out.setDescription("7 to 15 humans variable price CLP 6000 P/P");

        Destination estacionCentra14Out = new Destination();
        estacionCentra14Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        estacionCentra14Out.setPeopleRange(16);
        estacionCentra14Out.setComune(comune7);
        estacionCentra14Out.setFixedPrice(null);
        estacionCentra14Out.setVariablePrice(4500D);
        estacionCentra14Out.setArrival(arrival2);
        estacionCentra14Out.setVanType(vanType1);
        estacionCentra14Out.setDescription("16+ humans variable price CLP 6500 P/P");

        estacionCentra11Out = destinationRepository.save(estacionCentra11Out);
        estacionCentra12Out = destinationRepository.save(estacionCentra12Out);
        estacionCentra13Out = destinationRepository.save(estacionCentra13Out);
        estacionCentra14Out = destinationRepository.save(estacionCentra14Out);


        Destination laDehesa1Out = new Destination();
        laDehesa1Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laDehesa1Out.setPeopleRange(3);
        laDehesa1Out.setComune(comune8);
        laDehesa1Out.setFixedPrice(27000D);
        laDehesa1Out.setArrival(arrival2);
        laDehesa1Out.setVanType(vanType1);
        laDehesa1Out.setDescription("1 to 3 humans fixed price");

        Destination laDehesa2Out = new Destination();
        laDehesa2Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laDehesa2Out.setPeopleRange(6);
        laDehesa2Out.setComune(comune8);
        laDehesa2Out.setFixedPrice(32000D);
        laDehesa2Out.setArrival(arrival2);
        laDehesa2Out.setVanType(vanType1);
        laDehesa2Out.setDescription("4 to 6 humans fixed price");

        Destination laDehesa3Out = new Destination();
        laDehesa3Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laDehesa3Out.setPeopleRange(15);
        laDehesa3Out.setComune(comune8);
        laDehesa3Out.setFixedPrice(null);
        laDehesa3Out.setVariablePrice(6500D);
        laDehesa3Out.setArrival(arrival2);
        laDehesa3Out.setVanType(vanType1);
        laDehesa3Out.setDescription("7 to 15 humans variable price CLP 6000 P/P");

        Destination laDehesa4Out = new Destination();
        laDehesa4Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laDehesa4Out.setPeopleRange(16);
        laDehesa4Out.setComune(comune8);
        laDehesa4Out.setFixedPrice(null);
        laDehesa4Out.setVariablePrice(7000D);
        laDehesa4Out.setArrival(arrival2);
        laDehesa4Out.setVanType(vanType1);
        laDehesa4Out.setDescription("16+ humans variable price CLP 6500 P/P");

        laDehesa1Out = destinationRepository.save(laDehesa1Out);
        laDehesa2Out = destinationRepository.save(laDehesa2Out);
        laDehesa3Out = destinationRepository.save(laDehesa3Out);
        laDehesa4Out = destinationRepository.save(laDehesa4Out);


        Destination laReina1Out = new Destination();
        laReina1Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laReina1Out.setPeopleRange(3);
        laReina1Out.setComune(comune9);
        laReina1Out.setFixedPrice(27000D);
        laReina1Out.setArrival(arrival2);
        laReina1Out.setVanType(vanType1);
        laReina1Out.setDescription("1 to 3 humans fixed price");

        Destination laReina2Out = new Destination();
        laReina2Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laReina2Out.setPeopleRange(6);
        laReina2Out.setComune(comune9);
        laReina2Out.setFixedPrice(32000D);
        laReina2Out.setArrival(arrival2);
        laReina2Out.setVanType(vanType1);
        laReina2Out.setDescription("4 to 6 humans fixed price");

        Destination laReina3Out = new Destination();
        laReina3Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laReina3Out.setPeopleRange(15);
        laReina3Out.setComune(comune9);
        laReina3Out.setFixedPrice(null);
        laReina3Out.setVariablePrice(6500D);
        laReina3Out.setArrival(arrival2);
        laReina3Out.setVanType(vanType1);
        laReina3Out.setDescription("7 to 15 humans variable price CLP 6000 P/P");

        Destination laReina4Out = new Destination();
        laReina4Out.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laReina4Out.setPeopleRange(16);
        laReina4Out.setComune(comune9);
        laReina4Out.setFixedPrice(null);
        laReina4Out.setVariablePrice(7000D);
        laReina4Out.setArrival(arrival2);
        laReina4Out.setVanType(vanType1);
        laReina4Out.setDescription("16+ humans variable price CLP 6500 P/P");

        laReina1Out = destinationRepository.save(laReina1Out);
        laReina2Out = destinationRepository.save(laReina2Out);
        laReina3Out = destinationRepository.save(laReina3Out);
        laReina4Out = destinationRepository.save(laReina4Out);

        Company company1 = new Company();
        company1.setName("Aerolíneas Argentinas");

        Company company2 = new Company();
        company2.setName("Air France");

        Company company3 = new Company();
        company3.setName("Avianca");

        Company company4 = new Company();
        company4.setName("Iberia");

        Company company5 = new Company();
        company5.setName("Lan Airlines");

        Company company6 = new Company();
        company6.setName("Sky Airline");

        Company company7 = new Company();
        company7.setName("Latam Airlines");

        Company company8 = new Company();
        company8.setName("Jetsmart");

        Company company9 = new Company();
        company9.setName("Sky Airline");

        Company company10 = new Company();
        company10.setName("DAP");

        Company company11 = new Company();
        company11.setName("Air Europa");

        Company company12 = new Company();
        company12.setName("AeroMéxico");

        Company company13 = new Company();
        company13.setName("Air Canada");

        Company company14 = new Company();
        company14.setName("Air France");

        Company company15 = new Company();
        company15.setName("American Airlines");

        Company company16 = new Company();
        company16.setName("Avianca");

        Company company17 = new Company();
        company17.setName("British Airways");

        Company company18 = new Company();
        company18.setName("Copa Airlines");

        Company company19 = new Company();
        company19.setName("Cubana");

        Company company20 = new Company();
        company20.setName("Delta Air Lines");

        Company company21 = new Company();
        company21.setName("GOL");

        Company company22 = new Company();
        company22.setName("JetBlue Airways");

        Company company23 = new Company();
        company23.setName("Japan Airlines");

        Company company24 = new Company();
        company24.setName("Jet Airways");

        Company company25 = new Company();
        company25.setName("JetBlue Airways");

        Company company26 = new Company();
        company26.setName("Kenya Airways");

        Company company27 = new Company();
        company27.setName("Kenya Airways");

        Company company28 = new Company();
        company28.setName("KLM");

        Company company29 = new Company();
        company29.setName("Korean Air");

        Company company30 = new Company();
        company30.setName("Liat");

        Company company31 = new Company();
        company31.setName("LOT Polish Airlines");

        Company company32 = new Company();
        company32.setName("Lufthansa");

        Company company33 = new Company();
        company33.setName("Malaysia Airlines");

        Company company34 = new Company();
        company34.setName("Qatar Airways");

        Company company35 = new Company();
        company35.setName("Quantas");

        Company company36 = new Company();
        company36.setName("Royal Air Maroc");

        Company company37 = new Company();
        company37.setName("Royal Jordanian Airlines");

        Company company38 = new Company();
        company38.setName("Ryanair");

        Company company39 = new Company();
        company39.setName("SAS Scandinavian Airlines");

        Company company40 = new Company();
        company40.setName("Saudi Arabian Airlines");

        Company company41 = new Company();
        company41.setName("Singapore Airlines");

        Company company42 = new Company();
        company42.setName("Sky Airline");

        Company company43 = new Company();
        company43.setName("SkyWest Airlines");

        Company company44 = new Company();
        company44.setName("South African Airways");

        Company company45 = new Company();
        company45.setName("Southwest Airlines");

        Company company46 = new Company();
        company46.setName("Swiss International Air Lines");

        Company company47 = new Company();
        company47.setName("Syrian Air");

        Company company48 = new Company();
        company48.setName("TAP Portugal");

        Company company49 = new Company();
        company49.setName("Thai Airways");

        Company company50 = new Company();
        company50.setName("Tunis Air");

        Company company51 = new Company();
        company51.setName("Turkish Airlines");

        Company company52 = new Company();
        company52.setName("United Airlines");

        Company company53 = new Company();
        company53.setName("Vietnam Airlines");

        Company company54 = new Company();
        company54.setName("Virgin Airlines");

        Company company55 = new Company();
        company55.setName("Wizz Air");

        Company company56 = new Company();
        company56.setName("Aer Lingus");

        Company company57 = new Company();
        company57.setName("Aeroflot Russian Airlines");

        Company company59 = new Company();
        company59.setName("Air India");

        Company company60 = new Company();
        company60.setName("Air Italy");

        Company company61 = new Company();
        company61.setName("Air Malta");

        Company company62 = new Company();
        company62.setName("Air New Zealand");

        Company company63 = new Company();
        company63.setName("Alitalia");

        Company company64 = new Company();
        company64.setName("Amaszonas");

        Company company65 = new Company();
        company65.setName("ANA");

        Company company66 = new Company();
        company66.setName("Andes Líneas Aéreas");


        Company company68 = new Company();
        company68.setName("Avior Airlines");

        Company company69 = new Company();
        company69.setName("Boliviana de Aviación");


        Company company71 = new Company();
        company71.setName("Bulgaria Air");

        Company company72 = new Company();
        company72.setName("Caribbean Airlines");

        Company company73 = new Company();
        company73.setName("Cathay Pacific Airways");

        Company company74 = new Company();
        company74.setName("China Airlines");

        Company company75 = new Company();
        company75.setName("China Eastern Airlines");

        Company company76 = new Company();
        company76.setName("China Southern Airlines");


        Company company78 = new Company();
        company78.setName("CSA Czech Airlines");


        Company company79 = new Company();
        company79.setName("Cubana de Aviación");

        Company company81 = new Company();
        company81.setName("easyJet");

        Company company82 = new Company();
        company82.setName("Egypt Air");

        Company company83 = new Company();
        company83.setName("EL AL Airlines");

        Company company84 = new Company();
        company84.setName("Emirates");

        Company company85 = new Company();
        company85.setName("Etihad Airways");

        Company company86 = new Company();
        company86.setName("EVA Airways");

        Company company87 = new Company();
        company87.setName("ExpressJet");

        Company company88 = new Company();
        company88.setName("Fly Jamaica Airways");


        companyRepository.save(company7);
        companyRepository.save(company21);
        companyRepository.save(company6);
        companyRepository.save(company84);
        companyRepository.save(company1);


        companyRepository.save(company2);
        companyRepository.save(company3);
        companyRepository.save(company4);
        companyRepository.save(company5);

        companyRepository.save(company8);
        companyRepository.save(company9);
        companyRepository.save(company10);
        companyRepository.save(company11);
        companyRepository.save(company12);
        companyRepository.save(company13);
        companyRepository.save(company14);
        companyRepository.save(company15);
        companyRepository.save(company16);
        companyRepository.save(company17);
        companyRepository.save(company18);
        companyRepository.save(company19);
        companyRepository.save(company20);

        companyRepository.save(company22);
        companyRepository.save(company23);
        companyRepository.save(company24);
        companyRepository.save(company25);
        companyRepository.save(company26);
        companyRepository.save(company27);
        companyRepository.save(company28);
        companyRepository.save(company29);
        companyRepository.save(company30);
        companyRepository.save(company31);
        companyRepository.save(company32);
        companyRepository.save(company33);
        companyRepository.save(company34);
        companyRepository.save(company35);
        companyRepository.save(company36);
        companyRepository.save(company37);
        companyRepository.save(company38);
        companyRepository.save(company39);
        companyRepository.save(company40);
        companyRepository.save(company41);
        companyRepository.save(company43);
        companyRepository.save(company44);
        companyRepository.save(company45);
        companyRepository.save(company46);
        companyRepository.save(company47);
        companyRepository.save(company48);
        companyRepository.save(company49);
        companyRepository.save(company50);
        companyRepository.save(company51);
        companyRepository.save(company52);

        companyRepository.save(company53);
        companyRepository.save(company54);
        companyRepository.save(company55);
        companyRepository.save(company56);
        companyRepository.save(company57);
        companyRepository.save(company59);
        companyRepository.save(company60);
        companyRepository.save(company61);
        companyRepository.save(company62);
        companyRepository.save(company63);
        companyRepository.save(company64);
        companyRepository.save(company65);
        companyRepository.save(company66);
        companyRepository.save(company68);
        companyRepository.save(company69);

        companyRepository.save(company71);
        companyRepository.save(company72);
        companyRepository.save(company73);
        companyRepository.save(company74);
        companyRepository.save(company75);
        companyRepository.save(company76);
        companyRepository.save(company78);
        companyRepository.save(company79);
        companyRepository.save(company81);
        companyRepository.save(company82);
        companyRepository.save(company83);

        companyRepository.save(company85);
        companyRepository.save(company86);
        companyRepository.save(company87);
        companyRepository.save(company88);


        Destination centro1InOut = new Destination();
        centro1InOut.setTripEnum(TripEnum.ROUND_TRIP);
        centro1InOut.setPeopleRange(3);
        centro1InOut.setComune(comune1);
        centro1InOut.setFixedPrice(44000D);
        centro1InOut.setArrival(arrival1);
        centro1InOut.setVanType(vanType1);

        Destination centro2InOut = new Destination();
        centro2InOut.setTripEnum(TripEnum.ROUND_TRIP);
        centro2InOut.setPeopleRange(6);
        centro2InOut.setComune(comune1);
        centro2InOut.setFixedPrice(48990D);
        centro2InOut.setArrival(arrival1);
        centro2InOut.setVanType(vanType1);


        Destination centro3InOut = new Destination();
        centro3InOut.setTripEnum(TripEnum.ROUND_TRIP);
        centro3InOut.setPeopleRange(15);
        centro3InOut.setComune(comune1);
        centro3InOut.setVariablePrice(7500D);
        centro3InOut.setArrival(arrival1);
        centro3InOut.setVanType(vanType1);


        Destination centro4InOut = new Destination();
        centro4InOut.setTripEnum(TripEnum.ROUND_TRIP);
        centro4InOut.setPeopleRange(16);
        centro4InOut.setComune(comune1);
        centro4InOut.setVariablePrice(8500D);
        centro4InOut.setArrival(arrival1);
        centro4InOut.setVanType(vanType1);

        destinationRepository.save(centro1InOut).setId(null);
        destinationRepository.save(centro2InOut).setId(null);
        destinationRepository.save(centro3InOut).setId(null);
        destinationRepository.save(centro4InOut).setId(null);
        centro1InOut.setArrival(arrival2);
        centro2InOut.setArrival(arrival2);
        centro3InOut.setArrival(arrival2);
        centro4InOut.setArrival(arrival2);
        destinationRepository.save(centro1InOut).setId(null);
        destinationRepository.save(centro2InOut).setId(null);
        destinationRepository.save(centro3InOut).setId(null);
        destinationRepository.save(centro4InOut).setId(null);


        Destination providencia1InOut = new Destination();
        providencia1InOut.setTripEnum(TripEnum.ROUND_TRIP);
        providencia1InOut.setPeopleRange(3);
        providencia1InOut.setComune(comune2);
        providencia1InOut.setFixedPrice(46000D);
        providencia1InOut.setArrival(arrival1);
        providencia1InOut.setVanType(vanType1);

        Destination providencia2InOut = new Destination();
        providencia2InOut.setTripEnum(TripEnum.ROUND_TRIP);
        providencia2InOut.setPeopleRange(6);
        providencia2InOut.setComune(comune2);
        providencia2InOut.setFixedPrice(56000D);
        providencia2InOut.setArrival(arrival1);
        providencia2InOut.setVanType(vanType1);


        Destination providencia3InOut = new Destination();
        providencia3InOut.setTripEnum(TripEnum.ROUND_TRIP);
        providencia3InOut.setPeopleRange(15);
        providencia3InOut.setComune(comune2);
        providencia3InOut.setVariablePrice(8500D);
        providencia3InOut.setArrival(arrival1);
        providencia3InOut.setVanType(vanType1);


        Destination providencia4InOut = new Destination();
        providencia4InOut.setTripEnum(TripEnum.ROUND_TRIP);
        providencia4InOut.setPeopleRange(16);
        providencia4InOut.setComune(comune2);
        providencia4InOut.setVariablePrice(9500D);
        providencia4InOut.setArrival(arrival1);
        providencia4InOut.setVanType(vanType1);

        destinationRepository.save(providencia1InOut).setId(null);
        destinationRepository.save(providencia2InOut).setId(null);
        destinationRepository.save(providencia3InOut).setId(null);
        destinationRepository.save(providencia4InOut).setId(null);

        providencia1InOut.setArrival(arrival2);
        providencia2InOut.setArrival(arrival2);
        providencia3InOut.setArrival(arrival2);
        providencia4InOut.setArrival(arrival2);

        destinationRepository.save(providencia1InOut).setId(null);
        destinationRepository.save(providencia2InOut).setId(null);
        destinationRepository.save(providencia3InOut).setId(null);
        destinationRepository.save(providencia4InOut).setId(null);


        Destination lasCondes1InOut = new Destination();
        lasCondes1InOut.setTripEnum(TripEnum.ROUND_TRIP);
        lasCondes1InOut.setPeopleRange(3);
        lasCondes1InOut.setComune(comune3);
        lasCondes1InOut.setFixedPrice(52000D);
        lasCondes1InOut.setArrival(arrival1);
        lasCondes1InOut.setVanType(vanType1);

        Destination lasCondes2InOut = new Destination();
        lasCondes2InOut.setTripEnum(TripEnum.ROUND_TRIP);
        lasCondes2InOut.setPeopleRange(6);
        lasCondes2InOut.setComune(comune3);
        lasCondes2InOut.setFixedPrice(60000D);
        lasCondes2InOut.setArrival(arrival1);
        lasCondes2InOut.setVanType(vanType1);


        Destination lasCondes3InOut = new Destination();
        lasCondes3InOut.setTripEnum(TripEnum.ROUND_TRIP);
        lasCondes3InOut.setPeopleRange(15);
        lasCondes3InOut.setComune(comune3);
        lasCondes3InOut.setVariablePrice(10000D);
        lasCondes3InOut.setArrival(arrival1);
        lasCondes3InOut.setVanType(vanType1);

        Destination lasCondes4InOut = new Destination();
        lasCondes4InOut.setTripEnum(TripEnum.ROUND_TRIP);
        lasCondes4InOut.setPeopleRange(16);
        lasCondes4InOut.setComune(comune3);
        lasCondes4InOut.setVariablePrice(11000D);
        lasCondes4InOut.setArrival(arrival1);
        lasCondes4InOut.setVanType(vanType1);


        destinationRepository.save(lasCondes1InOut).setId(null);
        destinationRepository.save(lasCondes2InOut).setId(null);
        destinationRepository.save(lasCondes3InOut).setId(null);
        destinationRepository.save(lasCondes4InOut).setId(null);

        lasCondes1InOut.setArrival(arrival2);
        lasCondes2InOut.setArrival(arrival2);
        lasCondes3InOut.setArrival(arrival2);
        lasCondes4InOut.setArrival(arrival2);

        destinationRepository.save(lasCondes1InOut).setId(null);
        destinationRepository.save(lasCondes2InOut).setId(null);
        destinationRepository.save(lasCondes3InOut).setId(null);
        destinationRepository.save(lasCondes4InOut).setId(null);


        Destination vitacura1InOut = new Destination();
        vitacura1InOut.setTripEnum(TripEnum.ROUND_TRIP);
        vitacura1InOut.setPeopleRange(3);
        vitacura1InOut.setComune(comune4);
        vitacura1InOut.setFixedPrice(52000D);
        vitacura1InOut.setArrival(arrival1);
        vitacura1InOut.setVanType(vanType1);

        Destination vitacura2InOut = new Destination();
        vitacura2InOut.setTripEnum(TripEnum.ROUND_TRIP);
        vitacura2InOut.setPeopleRange(6);
        vitacura2InOut.setComune(comune4);
        vitacura2InOut.setFixedPrice(60000D);
        vitacura2InOut.setArrival(arrival1);
        vitacura2InOut.setVanType(vanType1);


        Destination vitacura3InOut = new Destination();
        vitacura3InOut.setTripEnum(TripEnum.ROUND_TRIP);
        vitacura3InOut.setPeopleRange(15);
        vitacura3InOut.setComune(comune4);
        vitacura3InOut.setVariablePrice(10000D);
        vitacura3InOut.setArrival(arrival1);
        vitacura3InOut.setVanType(vanType1);

        Destination vitacura4InOut = new Destination();
        vitacura4InOut.setTripEnum(TripEnum.ROUND_TRIP);
        vitacura4InOut.setPeopleRange(16);
        vitacura4InOut.setComune(comune4);
        vitacura4InOut.setVariablePrice(11000D);
        vitacura4InOut.setArrival(arrival1);
        vitacura4InOut.setVanType(vanType1);

        destinationRepository.save(vitacura1InOut).setId(null);
        destinationRepository.save(vitacura2InOut).setId(null);
        destinationRepository.save(vitacura3InOut).setId(null);
        destinationRepository.save(vitacura4InOut).setId(null);
        vitacura1InOut.setArrival(arrival2);
        vitacura2InOut.setArrival(arrival2);
        vitacura3InOut.setArrival(arrival2);
        vitacura4InOut.setArrival(arrival2);
        destinationRepository.save(vitacura1InOut).setId(null);
        destinationRepository.save(vitacura2InOut).setId(null);
        destinationRepository.save(vitacura3InOut).setId(null);
        destinationRepository.save(vitacura4InOut).setId(null);
        destinationRepository.save(vitacura4InOut).setId(null);


        Destination nunoa1InOut = new Destination();
        nunoa1InOut.setTripEnum(TripEnum.ROUND_TRIP);
        nunoa1InOut.setPeopleRange(3);
        nunoa1InOut.setComune(comune5);
        nunoa1InOut.setFixedPrice(52000D);
        nunoa1InOut.setArrival(arrival1);
        nunoa1InOut.setVanType(vanType1);

        Destination nunoa2InOut = new Destination();
        nunoa2InOut.setTripEnum(TripEnum.ROUND_TRIP);
        nunoa2InOut.setPeopleRange(6);
        nunoa2InOut.setComune(comune5);
        nunoa2InOut.setFixedPrice(60000D);
        nunoa2InOut.setArrival(arrival1);
        nunoa2InOut.setVanType(vanType1);


        Destination nunoa3InOut = new Destination();
        nunoa3InOut.setTripEnum(TripEnum.ROUND_TRIP);
        nunoa3InOut.setPeopleRange(15);
        nunoa3InOut.setComune(comune5);
        nunoa3InOut.setVariablePrice(10000D);
        nunoa3InOut.setArrival(arrival1);
        nunoa3InOut.setVanType(vanType1);

        Destination nunoa4InOut = new Destination();
        nunoa4InOut.setTripEnum(TripEnum.ROUND_TRIP);
        nunoa4InOut.setPeopleRange(16);
        nunoa4InOut.setComune(comune5);
        nunoa4InOut.setVariablePrice(11000D);
        nunoa4InOut.setArrival(arrival1);
        nunoa4InOut.setVanType(vanType1);

        destinationRepository.save(nunoa1InOut).setId(null);
        destinationRepository.save(nunoa2InOut).setId(null);
        destinationRepository.save(nunoa3InOut).setId(null);
        destinationRepository.save(nunoa4InOut).setId(null);
        nunoa1InOut.setArrival(arrival2);
        nunoa2InOut.setArrival(arrival2);
        nunoa3InOut.setArrival(arrival2);
        nunoa4InOut.setArrival(arrival2);
        destinationRepository.save(nunoa1InOut).setId(null);
        destinationRepository.save(nunoa2InOut).setId(null);
        destinationRepository.save(nunoa3InOut).setId(null);
        destinationRepository.save(nunoa4InOut).setId(null);


        Destination macul1InOut = new Destination();
        macul1InOut.setTripEnum(TripEnum.ROUND_TRIP);
        macul1InOut.setPeopleRange(3);
        macul1InOut.setComune(comune6);
        macul1InOut.setFixedPrice(52000D);
        macul1InOut.setArrival(arrival1);
        macul1InOut.setVanType(vanType1);

        Destination macul2InOut = new Destination();
        macul2InOut.setTripEnum(TripEnum.ROUND_TRIP);
        macul2InOut.setPeopleRange(6);
        macul2InOut.setComune(comune6);
        macul2InOut.setFixedPrice(60000D);
        macul2InOut.setArrival(arrival1);
        macul2InOut.setVanType(vanType1);


        Destination macul3InOut = new Destination();
        macul3InOut.setTripEnum(TripEnum.ROUND_TRIP);
        macul3InOut.setPeopleRange(15);
        macul3InOut.setComune(comune6);
        macul3InOut.setVariablePrice(10000D);
        macul3InOut.setArrival(arrival1);
        macul3InOut.setVanType(vanType1);

        Destination macul4InOut = new Destination();
        macul4InOut.setTripEnum(TripEnum.ROUND_TRIP);
        macul4InOut.setPeopleRange(16);
        macul4InOut.setComune(comune6);
        macul4InOut.setVariablePrice(11000D);
        macul4InOut.setArrival(arrival1);
        macul4InOut.setVanType(vanType1);

        destinationRepository.save(macul1InOut).setId(null);
        destinationRepository.save(macul2InOut).setId(null);
        destinationRepository.save(macul3InOut).setId(null);
        destinationRepository.save(macul4InOut).setId(null);
        macul1InOut.setArrival(arrival2);
        macul2InOut.setArrival(arrival2);
        macul3InOut.setArrival(arrival2);
        macul4InOut.setArrival(arrival2);

        destinationRepository.save(macul1InOut).setId(null);
        destinationRepository.save(macul2InOut).setId(null);
        destinationRepository.save(macul3InOut).setId(null);
        destinationRepository.save(macul4InOut).setId(null);


        Destination estacionCentral1InOut = new Destination();
        estacionCentral1InOut.setTripEnum(TripEnum.ROUND_TRIP);
        estacionCentral1InOut.setPeopleRange(3);
        estacionCentral1InOut.setComune(comune7);
        estacionCentral1InOut.setFixedPrice(44000D);
        estacionCentral1InOut.setArrival(arrival1);
        estacionCentral1InOut.setVanType(vanType1);

        Destination estacionCentral2InOut = new Destination();
        estacionCentral2InOut.setTripEnum(TripEnum.ROUND_TRIP);
        estacionCentral2InOut.setPeopleRange(6);
        estacionCentral2InOut.setComune(comune7);
        estacionCentral2InOut.setFixedPrice(48990D);
        estacionCentral2InOut.setArrival(arrival1);
        estacionCentral2InOut.setVanType(vanType1);


        Destination estacionCentral3InOut = new Destination();
        estacionCentral3InOut.setTripEnum(TripEnum.ROUND_TRIP);
        estacionCentral3InOut.setPeopleRange(15);
        estacionCentral3InOut.setComune(comune7);
        estacionCentral3InOut.setVariablePrice(7500D);
        estacionCentral3InOut.setArrival(arrival1);
        estacionCentral3InOut.setVanType(vanType1);

        Destination estacionCentral4InOut = new Destination();
        estacionCentral4InOut.setTripEnum(TripEnum.ROUND_TRIP);
        estacionCentral4InOut.setPeopleRange(16);
        estacionCentral4InOut.setComune(comune7);
        estacionCentral4InOut.setVariablePrice(8500D);
        estacionCentral4InOut.setArrival(arrival1);
        estacionCentral4InOut.setVanType(vanType1);

        destinationRepository.save(estacionCentral1InOut).setId(null);
        destinationRepository.save(estacionCentral2InOut).setId(null);
        destinationRepository.save(estacionCentral3InOut).setId(null);
        destinationRepository.save(estacionCentral4InOut).setId(null);
        estacionCentral1InOut.setArrival(arrival2);
        estacionCentral2InOut.setArrival(arrival2);
        estacionCentral3InOut.setArrival(arrival2);
        estacionCentral4InOut.setArrival(arrival2);
        destinationRepository.save(estacionCentral1InOut).setId(null);
        destinationRepository.save(estacionCentral2InOut).setId(null);
        destinationRepository.save(estacionCentral3InOut).setId(null);
        destinationRepository.save(estacionCentral4InOut).setId(null);


        Destination ladehesa1InOut = new Destination();
        ladehesa1InOut.setTripEnum(TripEnum.ROUND_TRIP);
        ladehesa1InOut.setPeopleRange(3);
        ladehesa1InOut.setComune(comune8);
        ladehesa1InOut.setFixedPrice(55000D);
        ladehesa1InOut.setArrival(arrival1);
        ladehesa1InOut.setVanType(vanType1);

        Destination ladehesa2InOut = new Destination();
        ladehesa2InOut.setTripEnum(TripEnum.ROUND_TRIP);
        ladehesa2InOut.setPeopleRange(6);
        ladehesa2InOut.setComune(comune8);
        ladehesa2InOut.setFixedPrice(62000D);
        ladehesa2InOut.setArrival(arrival1);
        ladehesa2InOut.setVanType(vanType1);


        Destination ladehesa3InOut = new Destination();
        ladehesa3InOut.setTripEnum(TripEnum.ROUND_TRIP);
        ladehesa3InOut.setPeopleRange(15);
        ladehesa3InOut.setComune(comune8);
        ladehesa3InOut.setVariablePrice(11500D);
        ladehesa3InOut.setArrival(arrival1);
        ladehesa3InOut.setVanType(vanType1);

        Destination ladehesa4InOut = new Destination();
        ladehesa4InOut.setTripEnum(TripEnum.ROUND_TRIP);
        ladehesa4InOut.setPeopleRange(16);
        ladehesa4InOut.setComune(comune8);
        ladehesa4InOut.setVariablePrice(12500D);
        ladehesa4InOut.setArrival(arrival1);
        ladehesa4InOut.setVanType(vanType1);

        destinationRepository.save(ladehesa1InOut).setId(null);
        destinationRepository.save(ladehesa2InOut).setId(null);
        destinationRepository.save(ladehesa3InOut).setId(null);
        destinationRepository.save(ladehesa4InOut).setId(null);
        ladehesa1InOut.setArrival(arrival2);
        ladehesa2InOut.setArrival(arrival2);
        ladehesa3InOut.setArrival(arrival2);
        ladehesa4InOut.setArrival(arrival2);
        destinationRepository.save(ladehesa1InOut).setId(null);
        destinationRepository.save(ladehesa2InOut).setId(null);
        destinationRepository.save(ladehesa3InOut).setId(null);
        destinationRepository.save(ladehesa4InOut).setId(null);


        Destination lareina1InOut = new Destination();
        lareina1InOut.setTripEnum(TripEnum.ROUND_TRIP);
        lareina1InOut.setPeopleRange(3);
        lareina1InOut.setComune(comune9);
        lareina1InOut.setFixedPrice(55000D);
        lareina1InOut.setArrival(arrival1);
        lareina1InOut.setVanType(vanType1);

        Destination lareina2InOut = new Destination();
        lareina2InOut.setTripEnum(TripEnum.ROUND_TRIP);
        lareina2InOut.setPeopleRange(6);
        lareina2InOut.setComune(comune9);
        lareina2InOut.setFixedPrice(62000D);
        lareina2InOut.setArrival(arrival1);
        lareina2InOut.setVanType(vanType1);


        Destination lareina3InOut = new Destination();
        lareina3InOut.setTripEnum(TripEnum.ROUND_TRIP);
        lareina3InOut.setPeopleRange(15);
        lareina3InOut.setComune(comune9);
        lareina3InOut.setVariablePrice(11500D);
        lareina3InOut.setArrival(arrival1);
        lareina3InOut.setVanType(vanType1);

        Destination lareina4InOut = new Destination();
        lareina4InOut.setTripEnum(TripEnum.ROUND_TRIP);
        lareina4InOut.setPeopleRange(16);
        lareina4InOut.setComune(comune9);
        lareina4InOut.setVariablePrice(12500D);
        lareina4InOut.setArrival(arrival1);
        lareina4InOut.setVanType(vanType1);

        destinationRepository.save(lareina1InOut).setId(null);
        destinationRepository.save(lareina2InOut).setId(null);
        destinationRepository.save(lareina3InOut).setId(null);
        destinationRepository.save(lareina4InOut).setId(null);
        lareina1InOut.setArrival(arrival2);
        lareina2InOut.setArrival(arrival2);
        lareina3InOut.setArrival(arrival2);
        lareina4InOut.setArrival(arrival2);

        destinationRepository.save(lareina1InOut).setId(null);
        destinationRepository.save(lareina2InOut).setId(null);
        destinationRepository.save(lareina3InOut).setId(null);
        destinationRepository.save(lareina4InOut).setId(null);

        SkiCenter farellones = new SkiCenter();
        farellones.setId(1L);
        farellones.setName("Farellones");
        farellones = skiCenterRepository.save(farellones);

        SkiCenter colorado = new SkiCenter();
        colorado.setId(2L);
        colorado.setName("Colorado");
        colorado = skiCenterRepository.save(colorado);

        SkiCenter laParva = new SkiCenter();
        laParva.setId(3L);
        laParva.setName("La parva");
        laParva = skiCenterRepository.save(laParva);

        SkiCenter valle = new SkiCenter();
        valle.setId(4L);
        valle.setName("Valle nevado");
        valle = skiCenterRepository.save(valle);

        SkiCenter portillo = new SkiCenter();
        portillo.setId(5L);
        portillo.setName("Portillo");
        portillo = skiCenterRepository.save(portillo);

        SkiCenter chillan = new SkiCenter();
        chillan.setId(6L);
        chillan.setName("Chillan");
        chillan = skiCenterRepository.save(chillan);

        Destination farellonesDestination = new Destination();
        farellonesDestination.setArrival(arrival1);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(120000D);
        farellonesDestination.setPeopleRange(3);
        farellonesDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival2);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(120000D);
        farellonesDestination.setPeopleRange(3);
        farellonesDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival1);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(120000D * 2);
        farellonesDestination.setPercentageDiscount(20D);
        farellonesDestination.setPeopleRange(3);
        farellonesDestination.setTripEnum(TripEnum.ROUND_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival2);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(120000D * 2);
        farellonesDestination.setPercentageDiscount(20D);
        farellonesDestination.setPeopleRange(3);
        farellonesDestination.setTripEnum(TripEnum.ROUND_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        farellonesDestination = destinationRepository.save(farellonesDestination);
        farellonesDestination.setId(null);
        farellonesDestination.setPercentageDiscount(0);

        farellonesDestination.setArrival(arrival1);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(190000D);
        farellonesDestination.setPeopleRange(6);
        farellonesDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival2);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(190000D);
        farellonesDestination.setPeopleRange(6);
        farellonesDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival1);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(190000D * 2);
        farellonesDestination.setPercentageDiscount(20D);
        farellonesDestination.setPeopleRange(6);
        farellonesDestination.setTripEnum(TripEnum.ROUND_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival2);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(190000D * 2);
        farellonesDestination.setPercentageDiscount(20D);
        farellonesDestination.setPeopleRange(6);
        farellonesDestination.setTripEnum(TripEnum.ROUND_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        farellonesDestination = destinationRepository.save(farellonesDestination);
        farellonesDestination.setId(null);
        farellonesDestination.setPercentageDiscount(0);

        farellonesDestination.setArrival(arrival1);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(250000D);
        farellonesDestination.setPeopleRange(9);
        farellonesDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival2);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(250000D);
        farellonesDestination.setPeopleRange(9);
        farellonesDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival1);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(250000D * 2);
        farellonesDestination.setPercentageDiscount(20D);
        farellonesDestination.setPeopleRange(9);
        farellonesDestination.setTripEnum(TripEnum.ROUND_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival2);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(250000D * 2);
        farellonesDestination.setPercentageDiscount(20D);
        farellonesDestination.setPeopleRange(9);
        farellonesDestination.setTripEnum(TripEnum.ROUND_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        farellonesDestination = destinationRepository.save(farellonesDestination);
        farellonesDestination.setId(null);
        farellonesDestination.setPercentageDiscount(0);

        farellonesDestination.setArrival(arrival1);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(300000D);
        farellonesDestination.setPeopleRange(13);
        farellonesDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival2);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(300000D);
        farellonesDestination.setPeopleRange(13);
        farellonesDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival1);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(300000D * 2);
        farellonesDestination.setPercentageDiscount(20D);
        farellonesDestination.setPeopleRange(13);
        farellonesDestination.setTripEnum(TripEnum.ROUND_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival2);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(300000D * 2);
        farellonesDestination.setPercentageDiscount(20D);
        farellonesDestination.setPeopleRange(13);
        farellonesDestination.setTripEnum(TripEnum.ROUND_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        farellonesDestination = destinationRepository.save(farellonesDestination);
        farellonesDestination.setId(null);
        farellonesDestination.setPercentageDiscount(0);

        farellonesDestination.setArrival(arrival1);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(380000D);
        farellonesDestination.setPeopleRange(16);
        farellonesDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival2);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(380000D);
        farellonesDestination.setPeopleRange(16);
        farellonesDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival1);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(380000D * 2);
        farellonesDestination.setPercentageDiscount(20D);
        farellonesDestination.setPeopleRange(16);
        farellonesDestination.setTripEnum(TripEnum.ROUND_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival2);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(380000D * 2);
        farellonesDestination.setPercentageDiscount(20D);
        farellonesDestination.setPeopleRange(16);
        farellonesDestination.setTripEnum(TripEnum.ROUND_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        farellonesDestination = destinationRepository.save(farellonesDestination);
        farellonesDestination.setId(null);
        farellonesDestination.setPercentageDiscount(0);

        farellonesDestination.setArrival(arrival1);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(480000D);
        farellonesDestination.setPeopleRange(25);
        farellonesDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival2);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(480000D);
        farellonesDestination.setPeopleRange(25);
        farellonesDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival1);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(480000D * 2);
        farellonesDestination.setPercentageDiscount(20D);
        farellonesDestination.setPeopleRange(25);
        farellonesDestination.setTripEnum(TripEnum.ROUND_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        destinationRepository.save(farellonesDestination).setId(null);

        farellonesDestination.setArrival(arrival2);
        farellonesDestination.setVanType(vanType1);
        farellonesDestination.setFixedPrice(480000D * 2);
        farellonesDestination.setPercentageDiscount(20D);
        farellonesDestination.setPeopleRange(25);
        farellonesDestination.setTripEnum(TripEnum.ROUND_TRIP);
        farellonesDestination.setSkiCenter(farellones);
        farellonesDestination = destinationRepository.save(farellonesDestination);
        farellonesDestination.setId(null);
        farellonesDestination.setPercentageDiscount(0);


        Destination coloradoDestination = new Destination();
        coloradoDestination.setArrival(arrival1);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(120000D);
        coloradoDestination.setPeopleRange(3);
        coloradoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival2);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(120000D);
        coloradoDestination.setPeopleRange(3);
        coloradoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival1);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(120000D * 2);
        coloradoDestination.setPercentageDiscount(20D);
        coloradoDestination.setPeopleRange(3);
        coloradoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival2);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(120000D * 2);
        coloradoDestination.setPercentageDiscount(20D);
        coloradoDestination.setPeopleRange(3);
        coloradoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        coloradoDestination = destinationRepository.save(coloradoDestination);
        coloradoDestination.setId(null);
        coloradoDestination.setPercentageDiscount(0);

        coloradoDestination.setArrival(arrival1);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(190000D);
        coloradoDestination.setPeopleRange(6);
        coloradoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival2);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(190000D);
        coloradoDestination.setPeopleRange(6);
        coloradoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival1);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(190000D * 2);
        coloradoDestination.setPercentageDiscount(20D);
        coloradoDestination.setPeopleRange(6);
        coloradoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival2);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(190000D * 2);
        coloradoDestination.setPercentageDiscount(20D);
        coloradoDestination.setPeopleRange(6);
        coloradoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        coloradoDestination = destinationRepository.save(coloradoDestination);
        coloradoDestination.setId(null);
        coloradoDestination.setPercentageDiscount(0);

        coloradoDestination.setArrival(arrival1);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(250000D);
        coloradoDestination.setPeopleRange(9);
        coloradoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival2);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(250000D);
        coloradoDestination.setPeopleRange(9);
        coloradoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival1);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(250000D * 2);
        coloradoDestination.setPercentageDiscount(20D);
        coloradoDestination.setPeopleRange(9);
        coloradoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival2);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(250000D * 2);
        coloradoDestination.setPercentageDiscount(20D);
        coloradoDestination.setPeopleRange(9);
        coloradoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        coloradoDestination = destinationRepository.save(coloradoDestination);
        coloradoDestination.setId(null);
        coloradoDestination.setPercentageDiscount(0);

        coloradoDestination.setArrival(arrival1);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(300000D);
        coloradoDestination.setPeopleRange(13);
        coloradoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival2);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(300000D);
        coloradoDestination.setPeopleRange(13);
        coloradoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival1);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(300000D * 2);
        coloradoDestination.setPercentageDiscount(20D);
        coloradoDestination.setPeopleRange(13);
        coloradoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival2);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(300000D * 2);
        coloradoDestination.setPercentageDiscount(20D);
        coloradoDestination.setPeopleRange(13);
        coloradoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        coloradoDestination = destinationRepository.save(coloradoDestination);
        coloradoDestination.setId(null);
        coloradoDestination.setPercentageDiscount(0);

        coloradoDestination.setArrival(arrival1);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(380000D);
        coloradoDestination.setPeopleRange(16);
        coloradoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival2);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(380000D);
        coloradoDestination.setPeopleRange(16);
        coloradoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival1);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(380000D * 2);
        coloradoDestination.setPercentageDiscount(20D);
        coloradoDestination.setPeopleRange(16);
        coloradoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival2);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(380000D * 2);
        coloradoDestination.setPercentageDiscount(20D);
        coloradoDestination.setPeopleRange(16);
        coloradoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        coloradoDestination = destinationRepository.save(coloradoDestination);
        coloradoDestination.setId(null);
        coloradoDestination.setPercentageDiscount(0);

        coloradoDestination.setArrival(arrival1);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(480000D);
        coloradoDestination.setPeopleRange(25);
        coloradoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival2);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(480000D);
        coloradoDestination.setPeopleRange(25);
        coloradoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival1);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(480000D * 2);
        coloradoDestination.setPercentageDiscount(20D);
        coloradoDestination.setPeopleRange(25);
        coloradoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        destinationRepository.save(coloradoDestination).setId(null);

        coloradoDestination.setArrival(arrival2);
        coloradoDestination.setVanType(vanType1);
        coloradoDestination.setFixedPrice(480000D * 2);
        coloradoDestination.setPercentageDiscount(20D);
        coloradoDestination.setPeopleRange(25);
        coloradoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        coloradoDestination.setSkiCenter(colorado);
        coloradoDestination = destinationRepository.save(coloradoDestination);
        coloradoDestination.setId(null);
        coloradoDestination.setPercentageDiscount(0);


        Destination laParvaDestination = new Destination();
        laParvaDestination.setArrival(arrival1);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(120000D);
        laParvaDestination.setPeopleRange(3);
        laParvaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival2);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(120000D);
        laParvaDestination.setPeopleRange(3);
        laParvaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival1);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(120000D * 2);
        laParvaDestination.setPercentageDiscount(20D);
        laParvaDestination.setPeopleRange(3);
        laParvaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival2);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(120000D * 2);
        laParvaDestination.setPercentageDiscount(20D);
        laParvaDestination.setPeopleRange(3);
        laParvaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        laParvaDestination = destinationRepository.save(laParvaDestination);
        laParvaDestination.setId(null);
        laParvaDestination.setPercentageDiscount(0);

        laParvaDestination.setArrival(arrival1);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(190000D);
        laParvaDestination.setPeopleRange(6);
        laParvaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival2);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(190000D);
        laParvaDestination.setPeopleRange(6);
        laParvaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival1);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(190000D * 2);
        laParvaDestination.setPercentageDiscount(20D);
        laParvaDestination.setPeopleRange(6);
        laParvaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival2);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(190000D * 2);
        laParvaDestination.setPercentageDiscount(20D);
        laParvaDestination.setPeopleRange(6);
        laParvaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        laParvaDestination = destinationRepository.save(laParvaDestination);
        laParvaDestination.setId(null);
        laParvaDestination.setPercentageDiscount(0);

        laParvaDestination.setArrival(arrival1);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(250000D);
        laParvaDestination.setPeopleRange(9);
        laParvaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival2);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(250000D);
        laParvaDestination.setPeopleRange(9);
        laParvaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival1);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(250000D * 2);
        laParvaDestination.setPercentageDiscount(20D);
        laParvaDestination.setPeopleRange(9);
        laParvaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival2);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(250000D * 2);
        laParvaDestination.setPercentageDiscount(20D);
        laParvaDestination.setPeopleRange(9);
        laParvaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        laParvaDestination = destinationRepository.save(laParvaDestination);
        laParvaDestination.setId(null);
        laParvaDestination.setPercentageDiscount(0);

        laParvaDestination.setArrival(arrival1);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(300000D);
        laParvaDestination.setPeopleRange(13);
        laParvaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival2);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(300000D);
        laParvaDestination.setPeopleRange(13);
        laParvaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival1);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(300000D * 2);
        laParvaDestination.setPercentageDiscount(20D);
        laParvaDestination.setPeopleRange(13);
        laParvaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival2);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(300000D * 2);
        laParvaDestination.setPercentageDiscount(20D);
        laParvaDestination.setPeopleRange(13);
        laParvaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        laParvaDestination = destinationRepository.save(laParvaDestination);
        laParvaDestination.setId(null);
        laParvaDestination.setPercentageDiscount(0);

        laParvaDestination.setArrival(arrival1);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(380000D);
        laParvaDestination.setPeopleRange(16);
        laParvaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival2);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(380000D);
        laParvaDestination.setPeopleRange(16);
        laParvaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival1);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(380000D * 2);
        laParvaDestination.setPercentageDiscount(20D);
        laParvaDestination.setPeopleRange(16);
        laParvaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival2);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(380000D * 2);
        laParvaDestination.setPercentageDiscount(20D);
        laParvaDestination.setPeopleRange(16);
        laParvaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        laParvaDestination = destinationRepository.save(laParvaDestination);
        laParvaDestination.setId(null);
        laParvaDestination.setPercentageDiscount(0);

        laParvaDestination.setArrival(arrival1);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(480000D);
        laParvaDestination.setPeopleRange(25);
        laParvaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival2);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(480000D);
        laParvaDestination.setPeopleRange(25);
        laParvaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival1);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(480000D * 2);
        laParvaDestination.setPercentageDiscount(20D);
        laParvaDestination.setPeopleRange(25);
        laParvaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        destinationRepository.save(laParvaDestination).setId(null);

        laParvaDestination.setArrival(arrival2);
        laParvaDestination.setVanType(vanType1);
        laParvaDestination.setFixedPrice(480000D * 2);
        laParvaDestination.setPercentageDiscount(20D);
        laParvaDestination.setPeopleRange(25);
        laParvaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        laParvaDestination.setSkiCenter(laParva);
        laParvaDestination = destinationRepository.save(laParvaDestination);
        laParvaDestination.setId(null);
        laParvaDestination.setPercentageDiscount(0);


        Destination valleDestination = new Destination();
        valleDestination.setArrival(arrival1);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(123000D);
        valleDestination.setPeopleRange(3);
        valleDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival2);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(123000D);
        valleDestination.setPeopleRange(3);
        valleDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival1);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(123000D * 2);
        valleDestination.setPercentageDiscount(20D);
        valleDestination.setPeopleRange(3);
        valleDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival2);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(123000D * 2);
        valleDestination.setPercentageDiscount(20D);
        valleDestination.setPeopleRange(3);
        valleDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valleDestination.setSkiCenter(valle);
        valleDestination = destinationRepository.save(valleDestination);
        valleDestination.setId(null);
        valleDestination.setPercentageDiscount(0);

        valleDestination.setArrival(arrival1);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(200000D);
        valleDestination.setPeopleRange(6);
        valleDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival2);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(200000D);
        valleDestination.setPeopleRange(6);
        valleDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival1);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(200000D * 2);
        valleDestination.setPercentageDiscount(20D);
        valleDestination.setPeopleRange(6);
        valleDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival2);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(200000D * 2);
        valleDestination.setPercentageDiscount(20D);
        valleDestination.setPeopleRange(6);
        valleDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valleDestination.setSkiCenter(valle);
        valleDestination = destinationRepository.save(valleDestination);
        valleDestination.setId(null);
        valleDestination.setPercentageDiscount(0);

        valleDestination.setArrival(arrival1);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(260000D);
        valleDestination.setPeopleRange(9);
        valleDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival2);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(260000D);
        valleDestination.setPeopleRange(9);
        valleDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival1);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(260000D * 2);
        valleDestination.setPercentageDiscount(20D);
        valleDestination.setPeopleRange(9);
        valleDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival2);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(260000D * 2);
        valleDestination.setPercentageDiscount(20D);
        valleDestination.setPeopleRange(9);
        valleDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valleDestination.setSkiCenter(valle);
        valleDestination = destinationRepository.save(valleDestination);
        valleDestination.setId(null);
        valleDestination.setPercentageDiscount(0);


        valleDestination.setArrival(arrival1);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(310000D);
        valleDestination.setPeopleRange(13);
        valleDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival2);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(310000D);
        valleDestination.setPeopleRange(13);
        valleDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival1);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(310000D * 2);
        valleDestination.setPercentageDiscount(20D);
        valleDestination.setPeopleRange(13);
        valleDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival2);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(310000D * 2);
        valleDestination.setPercentageDiscount(20D);
        valleDestination.setPeopleRange(13);
        valleDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valleDestination.setSkiCenter(valle);
        valleDestination = destinationRepository.save(valleDestination);
        valleDestination.setId(null);
        valleDestination.setPercentageDiscount(0);

        valleDestination.setArrival(arrival1);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(390000D);
        valleDestination.setPeopleRange(16);
        valleDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival2);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(390000D);
        valleDestination.setPeopleRange(16);
        valleDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival1);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(390000D * 2);
        valleDestination.setPercentageDiscount(20D);
        valleDestination.setPeopleRange(16);
        valleDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival2);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(390000D * 2);
        valleDestination.setPercentageDiscount(20D);
        valleDestination.setPeopleRange(16);
        valleDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valleDestination.setSkiCenter(valle);
        valleDestination = destinationRepository.save(valleDestination);
        valleDestination.setId(null);
        valleDestination.setPercentageDiscount(0);

        valleDestination.setArrival(arrival1);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(490000D);
        valleDestination.setPeopleRange(25);
        valleDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival2);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(490000D);
        valleDestination.setPeopleRange(25);
        valleDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival1);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(490000D * 2);
        valleDestination.setPercentageDiscount(20D);
        valleDestination.setPeopleRange(25);
        valleDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valleDestination.setSkiCenter(valle);
        destinationRepository.save(valleDestination).setId(null);

        valleDestination.setArrival(arrival2);
        valleDestination.setVanType(vanType1);
        valleDestination.setFixedPrice(490000D * 2);
        valleDestination.setPercentageDiscount(20D);
        valleDestination.setPeopleRange(25);
        valleDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valleDestination.setSkiCenter(valle);
        valleDestination = destinationRepository.save(valleDestination);
        valleDestination.setId(null);
        valleDestination.setPercentageDiscount(0);

        Destination portilloDestination = new Destination();
        portilloDestination.setArrival(arrival1);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(160000D);
        portilloDestination.setPeopleRange(3);
        portilloDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival2);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(160000D);
        portilloDestination.setPeopleRange(3);
        portilloDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival1);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(160000D * 2);
        portilloDestination.setPercentageDiscount(20D);
        portilloDestination.setPeopleRange(3);
        portilloDestination.setTripEnum(TripEnum.ROUND_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival2);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(160000D * 2);
        portilloDestination.setPercentageDiscount(20D);
        portilloDestination.setPeopleRange(3);
        portilloDestination.setTripEnum(TripEnum.ROUND_TRIP);
        portilloDestination.setSkiCenter(portillo);
        portilloDestination = destinationRepository.save(portilloDestination);
        portilloDestination.setId(null);
        portilloDestination.setPercentageDiscount(0);

        portilloDestination.setArrival(arrival1);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(210000D);
        portilloDestination.setPeopleRange(6);
        portilloDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival2);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(210000D);
        portilloDestination.setPeopleRange(6);
        portilloDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival1);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(210000D * 2);
        portilloDestination.setPercentageDiscount(20D);
        portilloDestination.setPeopleRange(6);
        portilloDestination.setTripEnum(TripEnum.ROUND_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival2);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(210000D * 2);
        portilloDestination.setPercentageDiscount(20D);
        portilloDestination.setPeopleRange(6);
        portilloDestination.setTripEnum(TripEnum.ROUND_TRIP);
        portilloDestination.setSkiCenter(portillo);
        portilloDestination = destinationRepository.save(portilloDestination);
        portilloDestination.setId(null);
        portilloDestination.setPercentageDiscount(0);


        portilloDestination.setArrival(arrival1);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(280000D);
        portilloDestination.setPeopleRange(9);
        portilloDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival2);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(280000D);
        portilloDestination.setPeopleRange(9);
        portilloDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival1);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(280000D * 2);
        portilloDestination.setPercentageDiscount(20D);
        portilloDestination.setPeopleRange(9);
        portilloDestination.setTripEnum(TripEnum.ROUND_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival2);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(280000D * 2);
        portilloDestination.setPercentageDiscount(20D);
        portilloDestination.setPeopleRange(9);
        portilloDestination.setTripEnum(TripEnum.ROUND_TRIP);
        portilloDestination.setSkiCenter(portillo);
        portilloDestination = destinationRepository.save(portilloDestination);
        portilloDestination.setId(null);
        portilloDestination.setPercentageDiscount(0);


        portilloDestination.setArrival(arrival1);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(330000D);
        portilloDestination.setPeopleRange(13);
        portilloDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival2);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(330000D);
        portilloDestination.setPeopleRange(13);
        portilloDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival1);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(330000D * 2);
        portilloDestination.setPercentageDiscount(20D);
        portilloDestination.setPeopleRange(13);
        portilloDestination.setTripEnum(TripEnum.ROUND_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival2);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(330000D * 2);
        portilloDestination.setPercentageDiscount(20D);
        portilloDestination.setPeopleRange(13);
        portilloDestination.setTripEnum(TripEnum.ROUND_TRIP);
        portilloDestination.setSkiCenter(portillo);
        portilloDestination = destinationRepository.save(portilloDestination);
        portilloDestination.setId(null);
        portilloDestination.setPercentageDiscount(0);


        portilloDestination.setArrival(arrival1);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(420000D);
        portilloDestination.setPeopleRange(16);
        portilloDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival2);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(420000D);
        portilloDestination.setPeopleRange(16);
        portilloDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival1);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(420000D * 2);
        portilloDestination.setPercentageDiscount(20D);
        portilloDestination.setPeopleRange(16);
        portilloDestination.setTripEnum(TripEnum.ROUND_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival2);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(420000D * 2);
        portilloDestination.setPercentageDiscount(20D);
        portilloDestination.setPeopleRange(16);
        portilloDestination.setTripEnum(TripEnum.ROUND_TRIP);
        portilloDestination.setSkiCenter(portillo);
        portilloDestination = destinationRepository.save(portilloDestination);
        portilloDestination.setId(null);
        portilloDestination.setPercentageDiscount(0);


        portilloDestination.setArrival(arrival1);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(520000D);
        portilloDestination.setPeopleRange(25);
        portilloDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival2);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(520000D);
        portilloDestination.setPeopleRange(25);
        portilloDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival1);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(520000D * 2);
        portilloDestination.setPercentageDiscount(20D);
        portilloDestination.setPeopleRange(25);
        portilloDestination.setTripEnum(TripEnum.ROUND_TRIP);
        portilloDestination.setSkiCenter(portillo);
        destinationRepository.save(portilloDestination).setId(null);

        portilloDestination.setArrival(arrival2);
        portilloDestination.setVanType(vanType1);
        portilloDestination.setFixedPrice(520000D * 2);
        portilloDestination.setPercentageDiscount(20D);
        portilloDestination.setPeopleRange(25);
        portilloDestination.setTripEnum(TripEnum.ROUND_TRIP);
        portilloDestination.setSkiCenter(portillo);
        portilloDestination = destinationRepository.save(portilloDestination);
        portilloDestination.setId(null);
        portilloDestination.setPercentageDiscount(0);

        Destination chillanDestination = new Destination();
        chillanDestination.setArrival(arrival1);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(320000D);
        chillanDestination.setPeopleRange(3);
        chillanDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival2);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(320000D);
        chillanDestination.setPeopleRange(3);
        chillanDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival1);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(320000D * 2);
        chillanDestination.setPercentageDiscount(20D);
        chillanDestination.setPeopleRange(3);
        chillanDestination.setTripEnum(TripEnum.ROUND_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival2);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(320000D * 2);
        chillanDestination.setPercentageDiscount(20D);
        chillanDestination.setPeopleRange(3);
        chillanDestination.setTripEnum(TripEnum.ROUND_TRIP);
        chillanDestination.setSkiCenter(chillan);
        chillanDestination = destinationRepository.save(chillanDestination);
        chillanDestination.setId(null);
        chillanDestination.setPercentageDiscount(0);

        chillanDestination.setArrival(arrival1);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(420000D);
        chillanDestination.setPeopleRange(6);
        chillanDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival2);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(420000D);
        chillanDestination.setPeopleRange(6);
        chillanDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival1);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(420000D * 2);
        chillanDestination.setPercentageDiscount(20D);
        chillanDestination.setPeopleRange(6);
        chillanDestination.setTripEnum(TripEnum.ROUND_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival2);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(420000D * 2);
        chillanDestination.setPercentageDiscount(20D);
        chillanDestination.setPeopleRange(6);
        chillanDestination.setTripEnum(TripEnum.ROUND_TRIP);
        chillanDestination.setSkiCenter(chillan);
        chillanDestination = destinationRepository.save(chillanDestination);
        chillanDestination.setId(null);
        chillanDestination.setPercentageDiscount(0);

        chillanDestination.setArrival(arrival1);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(480000D);
        chillanDestination.setPeopleRange(9);
        chillanDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival2);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(480000D);
        chillanDestination.setPeopleRange(9);
        chillanDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival1);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(480000D * 2);
        chillanDestination.setPercentageDiscount(20D);
        chillanDestination.setPeopleRange(9);
        chillanDestination.setTripEnum(TripEnum.ROUND_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival2);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(480000D * 2);
        chillanDestination.setPercentageDiscount(20D);
        chillanDestination.setPeopleRange(9);
        chillanDestination.setTripEnum(TripEnum.ROUND_TRIP);
        chillanDestination.setSkiCenter(chillan);
        chillanDestination = destinationRepository.save(chillanDestination);
        chillanDestination.setId(null);
        chillanDestination.setPercentageDiscount(0);

        chillanDestination.setArrival(arrival1);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(510000D);
        chillanDestination.setPeopleRange(13);
        chillanDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival2);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(510000D);
        chillanDestination.setPeopleRange(13);
        chillanDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival1);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(510000D * 2);
        chillanDestination.setPercentageDiscount(20D);
        chillanDestination.setPeopleRange(13);
        chillanDestination.setTripEnum(TripEnum.ROUND_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival2);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(510000D * 2);
        chillanDestination.setPercentageDiscount(20D);
        chillanDestination.setPeopleRange(13);
        chillanDestination.setTripEnum(TripEnum.ROUND_TRIP);
        chillanDestination.setSkiCenter(chillan);
        chillanDestination = destinationRepository.save(chillanDestination);
        chillanDestination.setId(null);
        chillanDestination.setPercentageDiscount(0);

        chillanDestination.setArrival(arrival1);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(580000D);
        chillanDestination.setPeopleRange(16);
        chillanDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival2);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(580000D);
        chillanDestination.setPeopleRange(16);
        chillanDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival1);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(580000D * 2);
        chillanDestination.setPercentageDiscount(20D);
        chillanDestination.setPeopleRange(16);
        chillanDestination.setTripEnum(TripEnum.ROUND_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival2);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(580000D * 2);
        chillanDestination.setPercentageDiscount(20D);
        chillanDestination.setPeopleRange(16);
        chillanDestination.setTripEnum(TripEnum.ROUND_TRIP);
        chillanDestination.setSkiCenter(chillan);
        chillanDestination = destinationRepository.save(chillanDestination);
        chillanDestination.setId(null);
        chillanDestination.setPercentageDiscount(0);

        chillanDestination.setArrival(arrival1);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(600000D);
        chillanDestination.setPeopleRange(25);
        chillanDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival2);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(600000D);
        chillanDestination.setPeopleRange(25);
        chillanDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival1);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(600000D * 2);
        chillanDestination.setPercentageDiscount(20D);
        chillanDestination.setPeopleRange(25);
        chillanDestination.setTripEnum(TripEnum.ROUND_TRIP);
        chillanDestination.setSkiCenter(chillan);
        destinationRepository.save(chillanDestination).setId(null);

        chillanDestination.setArrival(arrival2);
        chillanDestination.setVanType(vanType1);
        chillanDestination.setFixedPrice(600000D * 2);
        chillanDestination.setPercentageDiscount(20D);
        chillanDestination.setPeopleRange(25);
        chillanDestination.setTripEnum(TripEnum.ROUND_TRIP);
        chillanDestination.setSkiCenter(chillan);
        chillanDestination = destinationRepository.save(chillanDestination);
        chillanDestination.setId(null);
        chillanDestination.setPercentageDiscount(0);

        OtherPlace valparaiso = new OtherPlace();
        valparaiso.setId(1L);
        valparaiso.setName("Valparaiso");
        valparaiso = otherPlaceRepository.save(valparaiso);

        OtherPlace vina = new OtherPlace();
        vina.setId(2L);
        vina.setName("Viña del mar");
        vina =  otherPlaceRepository.save(vina);

        OtherPlace mendoza = new OtherPlace();
        mendoza.setId(3L);
        mendoza.setName("Mendoza");
        mendoza = otherPlaceRepository.save(mendoza);


        Destination valparaisoDestination = new Destination();
        valparaisoDestination.setArrival(arrival1);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(185000D);
        valparaisoDestination.setPeopleRange(3);
        valparaisoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival2);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(185000D);
        valparaisoDestination.setPeopleRange(3);
        valparaisoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival1);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(185000D * 2);
        valparaisoDestination.setPercentageDiscount(20D);
        valparaisoDestination.setPeopleRange(3);
        valparaisoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival2);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(185000D * 2);
        valparaisoDestination.setPercentageDiscount(20D);
        valparaisoDestination.setPeopleRange(3);
        valparaisoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        valparaisoDestination = destinationRepository.save(valparaisoDestination);
        valparaisoDestination.setId(null);
        valparaisoDestination.setPercentageDiscount(0);


        valparaisoDestination.setArrival(arrival1);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(215000D);
        valparaisoDestination.setPeopleRange(6);
        valparaisoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival2);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(215000D);
        valparaisoDestination.setPeopleRange(6);
        valparaisoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival1);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(215000D * 2);
        valparaisoDestination.setPercentageDiscount(20D);
        valparaisoDestination.setPeopleRange(6);
        valparaisoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival2);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(215000D * 2);
        valparaisoDestination.setPercentageDiscount(20D);
        valparaisoDestination.setPeopleRange(6);
        valparaisoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        valparaisoDestination = destinationRepository.save(valparaisoDestination);
        valparaisoDestination.setId(null);
        valparaisoDestination.setPercentageDiscount(0);



        valparaisoDestination.setArrival(arrival1);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(250000D);
        valparaisoDestination.setPeopleRange(9);
        valparaisoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival2);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(250000D);
        valparaisoDestination.setPeopleRange(9);
        valparaisoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival1);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(250000D * 2);
        valparaisoDestination.setPercentageDiscount(20D);
        valparaisoDestination.setPeopleRange(9);
        valparaisoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival2);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(250000D * 2);
        valparaisoDestination.setPercentageDiscount(20D);
        valparaisoDestination.setPeopleRange(9);
        valparaisoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        valparaisoDestination = destinationRepository.save(valparaisoDestination);
        valparaisoDestination.setId(null);
        valparaisoDestination.setPercentageDiscount(0);


        valparaisoDestination.setArrival(arrival1);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(300000D);
        valparaisoDestination.setPeopleRange(13);
        valparaisoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival2);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(300000D);
        valparaisoDestination.setPeopleRange(13);
        valparaisoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival1);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(300000D * 2);
        valparaisoDestination.setPercentageDiscount(20D);
        valparaisoDestination.setPeopleRange(13);
        valparaisoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival2);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(300000D * 2);
        valparaisoDestination.setPercentageDiscount(20D);
        valparaisoDestination.setPeopleRange(13);
        valparaisoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        valparaisoDestination = destinationRepository.save(valparaisoDestination);
        valparaisoDestination.setId(null);
        valparaisoDestination.setPercentageDiscount(0);


        valparaisoDestination.setArrival(arrival1);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(380000D);
        valparaisoDestination.setPeopleRange(16);
        valparaisoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival2);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(380000D);
        valparaisoDestination.setPeopleRange(16);
        valparaisoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival1);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(380000D * 2);
        valparaisoDestination.setPercentageDiscount(20D);
        valparaisoDestination.setPeopleRange(16);
        valparaisoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival2);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(380000D * 2);
        valparaisoDestination.setPercentageDiscount(20D);
        valparaisoDestination.setPeopleRange(16);
        valparaisoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        valparaisoDestination = destinationRepository.save(valparaisoDestination);
        valparaisoDestination.setId(null);
        valparaisoDestination.setPercentageDiscount(0);



        valparaisoDestination.setArrival(arrival1);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(480000D);
        valparaisoDestination.setPeopleRange(25);
        valparaisoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival2);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(480000D);
        valparaisoDestination.setPeopleRange(25);
        valparaisoDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival1);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(480000D * 2);
        valparaisoDestination.setPercentageDiscount(20D);
        valparaisoDestination.setPeopleRange(25);
        valparaisoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        destinationRepository.save(valparaisoDestination).setId(null);

        valparaisoDestination.setArrival(arrival2);
        valparaisoDestination.setVanType(vanType1);
        valparaisoDestination.setFixedPrice(480000D * 2);
        valparaisoDestination.setPercentageDiscount(20D);
        valparaisoDestination.setPeopleRange(25);
        valparaisoDestination.setTripEnum(TripEnum.ROUND_TRIP);
        valparaisoDestination.setOtherPlace(valparaiso);
        valparaisoDestination = destinationRepository.save(valparaisoDestination);
        valparaisoDestination.setId(null);
        valparaisoDestination.setPercentageDiscount(0);

        Destination vinaDestination = new Destination();
        vinaDestination.setArrival(arrival1);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(185000D);
        vinaDestination.setPeopleRange(3);
        vinaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival2);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(185000D);
        vinaDestination.setPeopleRange(3);
        vinaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival1);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(185000D * 2);
        vinaDestination.setPercentageDiscount(20D);
        vinaDestination.setPeopleRange(3);
        vinaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival2);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(185000D * 2);
        vinaDestination.setPercentageDiscount(20D);
        vinaDestination.setPeopleRange(3);
        vinaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        vinaDestination.setOtherPlace(vina);
        vinaDestination = destinationRepository.save(vinaDestination);
        vinaDestination.setId(null);
        vinaDestination.setPercentageDiscount(0);


        vinaDestination.setArrival(arrival1);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(215000D);
        vinaDestination.setPeopleRange(6);
        vinaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival2);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(215000D);
        vinaDestination.setPeopleRange(6);
        vinaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival1);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(215000D * 2);
        vinaDestination.setPercentageDiscount(20D);
        vinaDestination.setPeopleRange(6);
        vinaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival2);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(215000D * 2);
        vinaDestination.setPercentageDiscount(20D);
        vinaDestination.setPeopleRange(6);
        vinaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        vinaDestination.setOtherPlace(vina);
        vinaDestination = destinationRepository.save(vinaDestination);
        vinaDestination.setId(null);
        vinaDestination.setPercentageDiscount(0);



        vinaDestination.setArrival(arrival1);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(250000D);
        vinaDestination.setPeopleRange(9);
        vinaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival2);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(250000D);
        vinaDestination.setPeopleRange(9);
        vinaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival1);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(250000D * 2);
        vinaDestination.setPercentageDiscount(20D);
        vinaDestination.setPeopleRange(9);
        vinaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival2);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(250000D * 2);
        vinaDestination.setPercentageDiscount(20D);
        vinaDestination.setPeopleRange(9);
        vinaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        vinaDestination.setOtherPlace(vina);
        vinaDestination = destinationRepository.save(vinaDestination);
        vinaDestination.setId(null);
        vinaDestination.setPercentageDiscount(0);


        vinaDestination.setArrival(arrival1);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(300000D);
        vinaDestination.setPeopleRange(13);
        vinaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival2);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(300000D);
        vinaDestination.setPeopleRange(13);
        vinaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival1);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(300000D * 2);
        vinaDestination.setPercentageDiscount(20D);
        vinaDestination.setPeopleRange(13);
        vinaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival2);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(300000D * 2);
        vinaDestination.setPercentageDiscount(20D);
        vinaDestination.setPeopleRange(13);
        vinaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        vinaDestination.setOtherPlace(vina);
        vinaDestination = destinationRepository.save(vinaDestination);
        vinaDestination.setId(null);
        vinaDestination.setPercentageDiscount(0);


        vinaDestination.setArrival(arrival1);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(380000D);
        vinaDestination.setPeopleRange(16);
        vinaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival2);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(380000D);
        vinaDestination.setPeopleRange(16);
        vinaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival1);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(380000D * 2);
        vinaDestination.setPercentageDiscount(20D);
        vinaDestination.setPeopleRange(16);
        vinaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival2);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(380000D * 2);
        vinaDestination.setPercentageDiscount(20D);
        vinaDestination.setPeopleRange(16);
        vinaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        vinaDestination.setOtherPlace(vina);
        vinaDestination = destinationRepository.save(vinaDestination);
        vinaDestination.setId(null);
        vinaDestination.setPercentageDiscount(0);



        vinaDestination.setArrival(arrival1);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(480000D);
        vinaDestination.setPeopleRange(25);
        vinaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival2);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(480000D);
        vinaDestination.setPeopleRange(25);
        vinaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival1);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(480000D * 2);
        vinaDestination.setPercentageDiscount(20D);
        vinaDestination.setPeopleRange(25);
        vinaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        vinaDestination.setOtherPlace(vina);
        destinationRepository.save(vinaDestination).setId(null);

        vinaDestination.setArrival(arrival2);
        vinaDestination.setVanType(vanType1);
        vinaDestination.setFixedPrice(480000D * 2);
        vinaDestination.setPercentageDiscount(20D);
        vinaDestination.setPeopleRange(25);
        vinaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        vinaDestination.setOtherPlace(vina);
        vinaDestination = destinationRepository.save(vinaDestination);
        vinaDestination.setId(null);
        vinaDestination.setPercentageDiscount(0);

        Destination mendozaDestination = new Destination();
        mendozaDestination.setArrival(arrival1);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(400000D);
        mendozaDestination.setPeopleRange(3);
        mendozaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival2);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(400000D);
        mendozaDestination.setPeopleRange(3);
        mendozaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival1);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(400000D * 2);
        mendozaDestination.setPercentageDiscount(20D);
        mendozaDestination.setPeopleRange(3);
        mendozaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival2);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(400000D * 2);
        mendozaDestination.setPercentageDiscount(20D);
        mendozaDestination.setPeopleRange(3);
        mendozaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        mendozaDestination = destinationRepository.save(mendozaDestination);
        mendozaDestination.setId(null);
        mendozaDestination.setPercentageDiscount(0);

        mendozaDestination.setArrival(arrival1);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(550000D);
        mendozaDestination.setPeopleRange(6);
        mendozaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival2);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(550000D);
        mendozaDestination.setPeopleRange(6);
        mendozaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival1);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(550000D * 2);
        mendozaDestination.setPercentageDiscount(20D);
        mendozaDestination.setPeopleRange(6);
        mendozaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival2);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(550000D * 2);
        mendozaDestination.setPercentageDiscount(20D);
        mendozaDestination.setPeopleRange(6);
        mendozaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        mendozaDestination = destinationRepository.save(mendozaDestination);
        mendozaDestination.setId(null);
        mendozaDestination.setPercentageDiscount(0);

        mendozaDestination.setArrival(arrival1);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(600000D);
        mendozaDestination.setPeopleRange(9);
        mendozaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival2);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(600000D);
        mendozaDestination.setPeopleRange(9);
        mendozaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival1);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(600000D * 2);
        mendozaDestination.setPercentageDiscount(20D);
        mendozaDestination.setPeopleRange(9);
        mendozaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival2);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(600000D * 2);
        mendozaDestination.setPercentageDiscount(20D);
        mendozaDestination.setPeopleRange(9);
        mendozaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        mendozaDestination = destinationRepository.save(mendozaDestination);
        mendozaDestination.setId(null);
        mendozaDestination.setPercentageDiscount(0);

        mendozaDestination.setArrival(arrival1);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(700000D);
        mendozaDestination.setPeopleRange(13);
        mendozaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival2);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(700000D);
        mendozaDestination.setPeopleRange(13);
        mendozaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival1);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(700000D * 2);
        mendozaDestination.setPercentageDiscount(20D);
        mendozaDestination.setPeopleRange(13);
        mendozaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival2);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(700000D * 2);
        mendozaDestination.setPercentageDiscount(20D);
        mendozaDestination.setPeopleRange(13);
        mendozaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        mendozaDestination = destinationRepository.save(mendozaDestination);
        mendozaDestination.setId(null);
        mendozaDestination.setPercentageDiscount(0);

        mendozaDestination.setArrival(arrival1);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(850000D);
        mendozaDestination.setPeopleRange(16);
        mendozaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival2);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(850000D);
        mendozaDestination.setPeopleRange(16);
        mendozaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival1);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(850000D * 2);
        mendozaDestination.setPercentageDiscount(20D);
        mendozaDestination.setPeopleRange(16);
        mendozaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival2);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(850000D * 2);
        mendozaDestination.setPercentageDiscount(20D);
        mendozaDestination.setPeopleRange(16);
        mendozaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        mendozaDestination = destinationRepository.save(mendozaDestination);
        mendozaDestination.setId(null);
        mendozaDestination.setPercentageDiscount(0);

        mendozaDestination.setArrival(arrival1);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(1200000D);
        mendozaDestination.setPeopleRange(25);
        mendozaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival2);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(1200000D);
        mendozaDestination.setPeopleRange(25);
        mendozaDestination.setTripEnum(TripEnum.ONE_WAY_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival1);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(1200000D * 2);
        mendozaDestination.setPercentageDiscount(20D);
        mendozaDestination.setPeopleRange(25);
        mendozaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        destinationRepository.save(mendozaDestination).setId(null);

        mendozaDestination.setArrival(arrival2);
        mendozaDestination.setVanType(vanType1);
        mendozaDestination.setFixedPrice(1200000D * 2);
        mendozaDestination.setPercentageDiscount(20D);
        mendozaDestination.setPeopleRange(25);
        mendozaDestination.setTripEnum(TripEnum.ROUND_TRIP);
        mendozaDestination.setOtherPlace(mendoza);
        mendozaDestination = destinationRepository.save(mendozaDestination);
        mendozaDestination.setId(null);
        mendozaDestination.setPercentageDiscount(0);


    }

}
