package org.example.ems.repo;

import org.example.ems.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo  extends JpaRepository<Item, Long> {
}
