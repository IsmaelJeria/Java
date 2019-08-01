package com.next4f.vemmebuscar.domain;



import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class VanType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VanEnum type;

    /*
    @Column
    private Double cost;
    */

}
