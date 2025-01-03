package org.example.ems.model;

import jakarta.persistence.Entity;
 import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
 import lombok.NoArgsConstructor;
 import org.example.ems.jpa.model.IdClass;

@Entity
@Table(name = "user_tbl")
public class User extends IdClass {

    private  String fullName ;
    private  String email ;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public  User () {

    }
    public User(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }
}
