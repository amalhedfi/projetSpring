package com.example.ecommercejee.controller;

import com.example.ecommercejee.dao.ClientRepository;
import com.example.ecommercejee.dao.ElementRepository;
import com.example.ecommercejee.dao.ProductRepository;
import com.example.ecommercejee.dao.CommandeRepository;
import com.example.ecommercejee.entities.Client;
import com.example.ecommercejee.entities.Commande;
import com.example.ecommercejee.entities.Element;
import com.example.ecommercejee.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

public class CommandeController<OrderForm> {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CommandeRepository CommandeRepository;
    @Autowired
    private ElementRepository ElementRepository;
    @PostMapping("/orders")
    public Commande saveOrder(@RequestBody CommandeForm commandeForm){
        Client client=new Client();
        client.setName(commandeForm.getClient().getName());
        client.setEmail(commandeForm.getClient().getEmail());
        client.setAddress(commandeForm.getClient().getAddress());
        client.setPhoneNumber(commandeForm.getClient().getPhoneNumber());
        client=clientRepository.save(client);
        System.out.println(client.getId());

        Commande order=new Commande();
        order.setClient(client);
        order.setDate(new Date());
        order=CommandeRepository.save(order);
        double total=0;
        for(OrderProduct p:commandeForm.getProduit()){
            Element orderItem=new Element();
            orderItem.setCommande(order);
            Product product= productRepository.findById(p.getId()).get();
            orderItem.setProduct(product);
            orderItem.setPrice(product.getCurrentPrice());
            orderItem.setQuantity(p.getQuantity());
            ElementRepository.save(orderItem);
            total+=p.getQuantity()*product.getCurrentPrice();
        }
        order.setTotalAmount(total);
        return CommandeRepository.save(order);
    }

}