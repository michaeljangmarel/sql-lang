package org.example.ems.jpa.api;

import org.example.ems.jpa.cq.CriteriaQueryTest;
import org.example.ems.jpa.cq.ResultDto;
import org.example.ems.jpa.model.Staff;
import org.example.ems.jpa.service.StaffRepo;
import org.example.ems.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestAllController {
    @Autowired
    private StaffRepo staffRepo ;
    @Autowired
    private CriteriaQueryTest cqt ;

    @GetMapping("/all/{name}")
    public List<Staff> findByName(@PathVariable(name = "name") String name) {
        return staffRepo.findAllByFirstName(name);
    }
    @GetMapping("all")
    public  List<ResultDto> findQuery(){
        return  staffRepo.getAllWithQuery();
    }
    @GetMapping("/search")
    public  List<Employee> findWithName(@RequestParam(name = "name") String name) {
        return  cqt.getSimpleQuery(name);
    }
    @GetMapping("allemp")
    public  List<Employee> findAll() {
        return cqt.getAllEmployee();
    }
    @GetMapping("id")
    private Employee findById(@RequestParam(name = "id") Long id) {
        return cqt.findById(id);
    }
}
