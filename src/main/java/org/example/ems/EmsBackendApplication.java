package org.example.ems;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.ems.jpa.model.Address;
import org.example.ems.jpa.model.Department;
import org.example.ems.jpa.model.EmployeeRole;
import org.example.ems.jpa.model.Staff;
import org.example.ems.jpa.service.AddressRepo;
import org.example.ems.jpa.service.DepartmentRepo;
import org.example.ems.jpa.service.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class EmsBackendApplication {
    @Autowired
    private    AddressRepo addressRepo;
    @Autowired
    private    DepartmentRepo departmentRepo;
    @Autowired
    private    StaffRepo staffRepo;

    @Bean
    @Profile("dev")
     public ApplicationRunner applicationRunner () {

         return args -> {
             Address address = new Address("Yan Nyein Lane 3"  ,  "Yankin" , "Yangon" , "04444");
             addressRepo.save(address);

             Department department = new Department("IT");
             departmentRepo.save(department);

             Staff staff = new Staff("Ko" , "Doi" , "mj@gmail.com" , EmployeeRole.DEVELOPER,address , department );
             staffRepo.save(staff);
         };
     }
    public static void main(String[] args) {
        SpringApplication.run(EmsBackendApplication.class, args);
    }

}
