package org.example.ems;

import jakarta.annotation.PostConstruct;
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

import java.util.List;
import java.util.stream.Stream;

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

             Department department = new Department("Information Technology");
              Department department1 = new Department("HR");
              Department department2 = new Department("Finance");
              Department department3 = new Department("Head Office");
              Department department4= new Department("Sale and Marketing");

             List<Department> departments = List.of(department,department1, department2, department3 ,department4);
             departmentRepo.saveAll(departments);

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
