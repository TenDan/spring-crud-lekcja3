package com.example.demo.model.repositories;

import com.example.demo.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student, Long> { }
