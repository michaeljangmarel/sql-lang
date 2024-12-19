package org.example.ems.jpa.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department extends  IdClass{

    private String name;
    @OneToMany(mappedBy = "department" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Staff> employees;

    public Department(String name) {
        this.name = name;
    }
}
