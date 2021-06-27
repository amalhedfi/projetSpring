package com.example.ecommercejee.controller;

import com.example.ecommercejee.dao.ProductRepository;
import com.example.ecommercejee.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProduitController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/products",method = RequestMethod.POST)
    public Product save(@RequestBody Product p)
    {
        return productRepository.save(p);
    }

    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public List<Product> getProduct(){
        return productRepository.findAll();
    }
}
