package org.example.ems.api;

import lombok.RequiredArgsConstructor;
import org.example.ems.dto.EmployeeDto;
import org.example.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v3")
@CrossOrigin("*")
public class EmployeeApi {
    @Autowired
    private  EmployeeService employeeService;

    @GetMapping("all")
    public List<EmployeeDto> getAllEmployees() {
        return  employeeService.findAll();
    }
    @PostMapping("/save")
    public  ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeDto1 = employeeService.save(employeeDto);
        return  new ResponseEntity<>(employeeDto1 , HttpStatus.CREATED);
    }

    @GetMapping("/all/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        return  employeeService.findOne(id);
    }

}
