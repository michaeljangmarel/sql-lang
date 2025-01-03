package org.example.ems.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ems.jpa.model.IdClass;

@Entity
@Getter
@Setter
@Table(name = "order_tbl")
public class Order extends IdClass {

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private  User user ;
    @ManyToOne
    @JoinColumn(name =  "product_id" , nullable = false)
    private Product product ;
    private  Integer qty;

    public  Order(){

    }
    public Order(User user, Product product, Integer qty) {
        this.user = user;
        this.product = product;
        this.qty = qty;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
