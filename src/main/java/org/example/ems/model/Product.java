package org.example.ems.model;

import jakarta.persistence.Entity;
import org.example.ems.custom.model.IdClass;

@Entity
public class Product extends IdClass {

    private  String name;
    private  Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public  Product(){

    }
    public Product(String name,Double price){
        this.name=name;
        this.price=price;
    }
}
