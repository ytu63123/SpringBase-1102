package com.mycompany.springbasic1102.jpa.entities.Test;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "investor_id",referencedColumnName = "id")
    private Investor investor;
    
    
    
    
}
