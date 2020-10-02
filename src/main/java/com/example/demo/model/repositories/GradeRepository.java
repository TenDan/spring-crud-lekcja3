package com.example.demo.model.repositories;

import com.example.demo.model.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> { }
