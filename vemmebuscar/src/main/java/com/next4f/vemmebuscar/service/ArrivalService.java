package com.next4f.vemmebuscar.service;

import com.next4f.vemmebuscar.domain.Arrival;
import com.next4f.vemmebuscar.domain.ArrivalEnum;
import com.next4f.vemmebuscar.repository.ArrivalRepository;
import com.next4f.vemmebuscar.util.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class ArrivalService {

    @Autowired
    public ArrivalRepository arrivalRepository;

    public Arrival findByName(ArrivalEnum name) {
        Optional<Arrival> arrival = arrivalRepository.findByName(name);

        if (!arrival.isPresent())
            throw new RuntimeException("Arrival is not present");

        return arrival.get();
    }

    public ArrivalEnum findArrivalEnum(String name) {

        if (!EnumUtils.isPresent(ArrivalEnum.values(), name))
            throw new EnumConstantNotPresentException(ArrivalEnum.class,"Arrival value must be 'FROM_AIRPORT' or 'TO_AIRPORT' ");

        return ArrivalEnum.valueOf(name);
    }

}
