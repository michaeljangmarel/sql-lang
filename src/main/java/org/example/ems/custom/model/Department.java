package org.example.ems.custom.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Department extends  IdClass{

    private String name;
    @OneToMany(mappedBy = "department" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Staff> employees;

    public  Department(){

    }

    public Department(String name) {
        this.name = name;
    }


}
