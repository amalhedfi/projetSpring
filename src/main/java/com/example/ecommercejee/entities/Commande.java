package com.example.ecommercejee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @OneToMany(mappedBy = "commande", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Collection<Element> elements;
    @ManyToOne( fetch = FetchType.LAZY)
    private Client client;
    private double totalAmount;
    @OneToOne
    private Paiement paiement;


}