package org.example.ems.model;

import jakarta.persistence.Entity;
import org.example.ems.custom.model.IdClass;

@Entity
public class Item  extends IdClass {

    private String title;
    private  String image;

    public  Item(){

    }
    public Item(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
