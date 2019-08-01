package com.next4f.vemmebuscar.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate date;

    @Column
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hour;

    @Column
    private String companyName;

    @Column
    private String flightNumber;


}
