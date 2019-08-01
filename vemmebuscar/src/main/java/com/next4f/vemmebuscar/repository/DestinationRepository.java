package com.next4f.vemmebuscar.repository;

import com.next4f.vemmebuscar.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

    List<Destination> findAllByVanTypeAndComuneAndArrivalAndTripEnumOrderByPeopleRangeAsc(VanType vanType, Comune comune, Arrival arrival, TripEnum tripEnum);

    List<Destination> findAllByVanTypeAndSkiCenterAndArrivalAndTripEnumOrderByPeopleRangeAsc(VanType vanType, SkiCenter skiCenter, Arrival arrival, TripEnum tripEnum);

    List<Destination> findAllByVanTypeAndOtherPlaceAndArrivalAndTripEnumOrderByPeopleRangeAsc(VanType vanType, OtherPlace otherPlace, Arrival arrival, TripEnum tripEnum);


}
