package com.next4f.vemmebuscar.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SkiCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

}
