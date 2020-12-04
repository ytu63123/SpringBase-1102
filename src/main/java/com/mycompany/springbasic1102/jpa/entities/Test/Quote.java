package com.mycompany.springbasic1102.jpa.entities.Test;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quote")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private Double change;

    @Column
    private Double price;

    @Column
    private Double changeInPercent;

    @Column
    private Date tradeTime;

}
