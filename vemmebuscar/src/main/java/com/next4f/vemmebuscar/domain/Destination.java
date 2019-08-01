package com.next4f.vemmebuscar.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double fixedPrice;

    @Column
    private Double variablePrice;

    @Column
    private double percentageDiscount;

    @Column
    @JsonIgnore
    private Integer peopleRange;

    @Column
    private String description;

    @ManyToOne
    private Comune comune;

    @ManyToOne
    private SkiCenter skiCenter;

    @ManyToOne
    private OtherPlace otherPlace;

    @ManyToOne
    private Arrival arrival;

    @ManyToOne
    private VanType vanType;

    @Enumerated(EnumType.STRING)
    private TripEnum tripEnum;

}
