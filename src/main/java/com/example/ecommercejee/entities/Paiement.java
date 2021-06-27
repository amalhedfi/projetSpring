package com.example.ecommercejee.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Paiement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datePayment;
    private long cardNumber;
    private String cardType;
    @OneToOne(mappedBy = "paiement", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Commande commande;

}