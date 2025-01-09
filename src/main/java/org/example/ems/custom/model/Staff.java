package org.example.ems.custom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
 public class Staff extends IdClass {

    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private  EmployeeRole employeeRole ;
    @OneToOne
    private Address address;
    @ManyToOne
    private Department department;
    @ManyToMany
    @JoinTable(name =  "staff_mission" ,
            joinColumns = @JoinColumn(name = "staff_id"),
            inverseJoinColumns = @JoinColumn(name = "mission_id")
    )
    private List<Mission> missions;

    public Staff(String firstName, String lastName, String email, EmployeeRole employeeRole, Address address, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.employeeRole = employeeRole;
        this.address = address;
        this.department = department;
    }
}
