package org.example.ems.custom.service.pagination;

import org.example.ems.custom.model.Department;
import org.example.ems.custom.service.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    public List<Department> findDepartmentWithSortingDesc(String name) {
        return  departmentRepo.findAll(Sort.by(Sort.Direction.DESC, name));
    }

    public  List<Department> findDepartmentWithSorting(String name) {
         return departmentRepo.findAll(Sort.by(Sort.Direction.ASC, name));
    }

    public  Page<Department> findDepartmentWithPagination(int offset , int pageSize) {
        Page<Department> page =  departmentRepo.findAll(PageRequest.of(offset,pageSize));
        return  page;
    }


}
