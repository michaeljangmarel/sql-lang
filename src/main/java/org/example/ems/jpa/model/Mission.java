package org.example.ems.jpa.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mission  extends IdClass{
    private String name;
    private String description;
    private LocalDateTime startDate ;
    private LocalDateTime endDate ;

}
