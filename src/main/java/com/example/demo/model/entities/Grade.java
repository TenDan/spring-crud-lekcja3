package com.example.demo.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Grade {
    public Grade(String grade) {
        this.grade = grade;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String grade;
    private String subject;

    @JoinColumn(name = "grades")
    private Student student;
}
