package com.example.ecommercejee.dao;

import com.example.ecommercejee.entities.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ElementRepository extends JpaRepository<Element, Long> {

}