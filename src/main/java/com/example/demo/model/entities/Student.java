package com.example.demo.model.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany
    private List<Grade> grades = new ArrayList<>();
}
