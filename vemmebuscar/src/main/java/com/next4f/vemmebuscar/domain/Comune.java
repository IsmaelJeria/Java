package com.next4f.vemmebuscar.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

}
