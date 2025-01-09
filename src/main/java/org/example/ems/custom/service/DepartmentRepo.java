package org.example.ems.custom.service;

import org.example.ems.custom.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepo  extends JpaRepository<Department, Long> {
    @Query(value =  "select * from Department ", nativeQuery = true)
    List<Department> getAllName();

}
