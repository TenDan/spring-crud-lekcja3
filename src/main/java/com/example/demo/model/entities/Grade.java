package com.example.demo.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Grade {
    public Grade(String value) {
        this.value = value;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String value;
}
