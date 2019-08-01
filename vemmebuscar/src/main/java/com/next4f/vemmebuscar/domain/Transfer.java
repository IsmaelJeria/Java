package com.next4f.vemmebuscar.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Data
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer numberOfChildren;

    @Enumerated(EnumType.STRING)
    private PaymentEnum payment;

    @Enumerated(EnumType.STRING)
    private ServiceEnum serviceType;

    @Column
    private Integer numberOfAdults;

    @Column
    private Integer numberOfBabies;

    @Column
    private Integer numberOfSuiteCases;

    @Column
    private Boolean wheelchair;

    @Column
    private String additionalServices;

    @Column
    private LocalDate date;

    @Column
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hour;

    @Column
    private LocalDate returnDate;

    @Column
    private LocalTime returnHour;

    @Column
    private String fullAddress;

    @ManyToOne
    private Destination destination;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    private Flight flight;

}
