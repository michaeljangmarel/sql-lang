package org.example.ems.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ems.jpa.model.IdClass;

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
