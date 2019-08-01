package com.next4f.vemmebuscar.domain;



import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String passport;

    @Column
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    @Column
    private Long successfulTrips;

}
