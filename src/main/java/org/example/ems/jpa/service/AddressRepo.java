package org.example.ems.jpa.service;

import org.example.ems.jpa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
