package com.next4f.vemmebuscar.domain;



import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate date;

    @Column
    private LocalTime hour;

    @Column
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;
}
