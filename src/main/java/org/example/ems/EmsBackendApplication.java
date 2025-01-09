package org.example.ems;

import org.example.ems.custom.model.Address;
import org.example.ems.custom.model.Department;
import org.example.ems.custom.model.EmployeeRole;
import org.example.ems.custom.model.Staff;
import org.example.ems.custom.service.AddressRepo;
import org.example.ems.custom.service.DepartmentRepo;
import org.example.ems.custom.service.StaffRepo;
import org.example.ems.model.Product;
import org.example.ems.model.User;
import org.example.ems.repo.ProductRepo;
import org.example.ems.repo.UserRepo;
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
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;

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

             Product product = new Product("Coca Cola" , 1500.00);
             Product product2 = new Product("Pepsi" , 2000.00);

             productRepo.save(product2);
             productRepo.save(product);

             User user = new User("Ko Region" , "region@gmail.com");
             userRepo.save(user);

         };
     }
    public static void main(String[] args) {
        SpringApplication.run(EmsBackendApplication.class, args);
    }

}
