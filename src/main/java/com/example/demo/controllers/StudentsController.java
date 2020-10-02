package com.example.demo.controllers;

import com.example.demo.model.entities.Student;
import com.example.demo.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping
    public List<Student> allStudents() {
        return this.studentsService.findAll();
    }

    @GetMapping("/{id}")
    public Student getSingleStudent(@PathVariable Long id) {
        return this.studentsService.findOne(id).orElse(null);
    }

    @PostMapping("/create-student")
    public void createRandomStudent(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName
    ) {
        this.studentsService.createNewUser(firstName, lastName);
    }

    @PostMapping("/add-grade")
    public void addNewGradeToStudent(@RequestParam(value = "grade") String grade, @RequestParam(value = "studentId") Long id) {
        this.studentsService.addGradeToStudent(id, grade);
    }
}
