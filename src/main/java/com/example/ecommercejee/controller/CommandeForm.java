package com.example.ecommercejee.controller;

import lombok.Data;
import com.example.ecommercejee.entities.Client;
import java.util.ArrayList;
import java.util.List;
@Data
public class CommandeForm {
    private Client client=new Client();
    private List<OrderProduct> produit=new ArrayList<>();
}
@Data
class OrderProduct{
    private Long id;
    private int quantity;

}