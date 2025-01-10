package org.example.ems.api;

import org.example.ems.custom.model.Department;
import org.example.ems.custom.service.pagination.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dep")
@CrossOrigin("*")
public class DepartmentApi {

    @Autowired
    private DepartmentService depService;

    @GetMapping("/asc/{name}")
    public List<Department> getDepartmentBySortAsc(@PathVariable(name = "name") String name){
        return depService.findDepartmentWithSorting(name);
    }
    @GetMapping("/desc/{name}")
    public List<Department> getDepartmentBySortDesc(@PathVariable(name = "name") String name){
        return depService.findDepartmentWithSortingDesc(name);
    }

    @GetMapping("/all/{name}/{pageSize}")
    public ResponseEntity<Page<Department>> getDepartmentByPaginate( @PathVariable(name = "name") int name ,@PathVariable(name = "pageSize") int pageSize){
        Page<Department> departments = depService.findDepartmentWithPagination(name,pageSize);
        return ResponseEntity.ok(departments);
    }
}
