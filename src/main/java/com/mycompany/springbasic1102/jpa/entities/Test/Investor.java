package com.mycompany.springbasic1102.jpa.entities.Test;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "investor")
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @OneToMany(mappedBy = "investor",cascade = CascadeType.PERSIST)    
    private Set<Portfolio> portfolios;

}
