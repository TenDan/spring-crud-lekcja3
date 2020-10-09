package com.example.demo.controllers;

import com.example.demo.model.entities.Student;
import com.example.demo.services.StudentsService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @PostMapping(value = "/add-grade")
    public void addNewGradeToStudent(
            @RequestParam(value = "grade") String grade,
            @RequestParam(value = "studentId") Long studentId,
            @RequestParam(value = "subject") String subject) {
        this.studentsService.addGradeToStudent(new NewGradeDto(grade, studentId, subject));
    }

    @PostMapping(value = "/update-grade")
    public void updateStudentGrade(
            @RequestParam(value = "grade") String grade,
            @RequestParam(value = "gradeId") Long gradeId,
            @RequestParam(value = "subject") String subject) {
        this.studentsService.updateStudentGrade(new GradeToEditDto(gradeId, grade, subject));
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class NewGradeDto {
        String grade;
        Long studentId;
        String subject;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class GradeToEditDto {
        Long gradeId;
        String grade;
        String subject;
    }
}
