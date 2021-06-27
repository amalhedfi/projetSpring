package com.example.ecommercejee.dao;


import com.example.ecommercejee.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface PaiementRepository extends JpaRepository<Paiement, Long> {

}
