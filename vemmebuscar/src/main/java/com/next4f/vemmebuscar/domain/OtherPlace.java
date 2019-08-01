package com.next4f.vemmebuscar.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class OtherPlace {

    @Id
    private Long id;

    @Column
    private String name;
}
