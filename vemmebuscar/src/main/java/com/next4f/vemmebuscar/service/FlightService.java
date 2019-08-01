package com.next4f.vemmebuscar.service;

import com.next4f.vemmebuscar.domain.Flight;
import com.next4f.vemmebuscar.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight save(Flight flight){
        return flightRepository.save(flight);
    }

}
