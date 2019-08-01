package com.next4f.vemmebuscar.repository;

import com.next4f.vemmebuscar.domain.Arrival;
import com.next4f.vemmebuscar.domain.ArrivalEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArrivalRepository extends JpaRepository<Arrival, Long> {

    Optional<Arrival> findByName(ArrivalEnum arrivalEnum);
}
