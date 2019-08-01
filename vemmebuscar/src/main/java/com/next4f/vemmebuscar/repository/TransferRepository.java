package com.next4f.vemmebuscar.repository;

import com.next4f.vemmebuscar.domain.Destination;
import com.next4f.vemmebuscar.domain.ServiceEnum;
import com.next4f.vemmebuscar.domain.Transfer;
import com.next4f.vemmebuscar.domain.VanType;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    /*IJG*/
    List<Transfer> findAllByDestinationIsNotNull();

    Page<Transfer> findAll(Pageable pageable);
    /*IJG*/
}

