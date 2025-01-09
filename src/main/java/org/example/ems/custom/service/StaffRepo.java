package org.example.ems.custom.service;

import org.example.ems.custom.cq.ResultDto;
import org.example.ems.custom.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRepo  extends JpaRepository<Staff, Long> {

    List<Staff> findAllByFirstName(String firstName);

    @Query("""
SELECT new org.example.ems.custom.cq.ResultDto(s.id ,s.firstName ,s.lastName ,  a.city ,d.name)  FROM Staff s join s.address a join s.department d
""")
    List<ResultDto> getAllWithQuery();
}
