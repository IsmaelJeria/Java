package com.next4f.vemmebuscar.service;

import com.next4f.vemmebuscar.domain.*;
import com.next4f.vemmebuscar.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public Destination findFirstDestinationByRangeOfAmountOfHumansAndVanTypeAndComuneAndArrivalAndTripEnum(Integer peopleRange, VanType vanType, Comune comune, Arrival arrival, TripEnum tripEnum) {
        List<Destination> destinationList = destinationRepository.findAllByVanTypeAndComuneAndArrivalAndTripEnumOrderByPeopleRangeAsc(vanType, comune, arrival, tripEnum);
        Destination destination = null;
        if (peopleRange > 16)
            peopleRange = 16;
        for (int i = 0; i < destinationList.size(); i++) {
            if (destinationList.get(i).getPeopleRange().intValue() >= peopleRange.intValue()) {
                destination = destinationList.get(i);
                break;
            }
        }
        return destination;
    }

    public Destination findFirstDestinationByRangeOfAmountOfHumansAndVanTypeAndSkiCenterAndArrivalAndTripEnum(Integer peopleRange, VanType vanType, SkiCenter skiCenter, Arrival arrival, TripEnum tripEnum){
        List<Destination> destinationList = destinationRepository.findAllByVanTypeAndSkiCenterAndArrivalAndTripEnumOrderByPeopleRangeAsc(vanType, skiCenter, arrival,tripEnum);

        if(peopleRange.intValue()>25)
            throw new RuntimeException("amount of people must be minor as 26");
        Destination destination = null;

        for (int i = 0; i < destinationList.size(); i++) {
            if (destinationList.get(i).getPeopleRange().intValue() >= peopleRange.intValue()) {
                destination = destinationList.get(i);
                break;
            }
        }
        return destination;
    }


    public Destination findFirstDestinationByRangeOfAmountOfHumansAndVanTypeAndOtherPlaceAndArrivalAndTripEnum(Integer peopleRange, VanType vanType, OtherPlace otherPlace, Arrival arrival, TripEnum tripEnum){
        List<Destination> destinationList = destinationRepository.findAllByVanTypeAndOtherPlaceAndArrivalAndTripEnumOrderByPeopleRangeAsc(vanType, otherPlace, arrival,tripEnum);

        if(peopleRange.intValue()>25)
            throw new RuntimeException("amount of people must be minor as 26");
        Destination destination = null;

        for (int i = 0; i < destinationList.size(); i++) {
            if (destinationList.get(i).getPeopleRange().intValue() >= peopleRange.intValue()) {
                destination = destinationList.get(i);
                break;
            }
        }
        return destination;
    }


}
