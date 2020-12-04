package com.mycompany.springbasic1102.jpa.entities.many2many;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cstock")
public class Cstock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column
    private String symbol;
    
    @ManyToMany(mappedBy = "cstocks",cascade = CascadeType.PERSIST)
    private Set<Fund> funds=new LinkedHashSet<>();

    public Cstock() {
    }

    public Cstock(String symbol) {
        this.symbol = symbol;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Set<Fund> getFunds() {
        return funds;
    }

    public void setFunds(Set<Fund> funds) {
        this.funds = funds;
    }
    
}
