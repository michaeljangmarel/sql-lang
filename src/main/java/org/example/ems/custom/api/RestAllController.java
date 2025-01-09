package org.example.ems.custom.api;

import org.example.ems.custom.cq.CriteriaQueryTest;
import org.example.ems.custom.cq.ResultDto;
import org.example.ems.custom.model.Staff;
import org.example.ems.custom.service.StaffRepo;
import org.example.ems.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
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
    @GetMapping("/getAll")
    public  List<Employee> findAll() {
        return cqt.getAllEmployee();
    }
    @GetMapping("id")
    public Employee findById(@RequestParam(name = "id") Long id) {
        return cqt.findById(id);
    }
    @DeleteMapping("/one/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {
        return  cqt.deleteById(id);
    }

}
