package com.example.demo.services;

import com.example.demo.controllers.StudentsController;
import com.example.demo.model.entities.Grade;
import com.example.demo.model.entities.Student;
import com.example.demo.model.repositories.GradeRepository;
import com.example.demo.model.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;
    @Autowired
    private GradeRepository gradeRepository;

    public void createNewUser(String firstName, String lastName) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        //student.setGrades("ABC");
        studentsRepository.save(student);
    }

    public List<Student> findAll() {
        return this.studentsRepository.findAll();
    }

    public Optional<Student> findOne(Long id) {
        return this.studentsRepository.findById(id);
    }

    public void addGradeToStudent(StudentsController.NewGradeDto grade) {
        try {
            Student student = studentsRepository.findById(grade.getStudentId()).orElse(null);
            List<Grade> gradeList = student.getGrades();
            Grade grade1 = new Grade(grade.getGrade());
            grade1.setSubject(grade.getSubject());
            gradeList.add(grade1);
            student.setGrades(gradeList);
            this.gradeRepository.save(grade1);
            this.studentsRepository.save(student);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    public void updateStudentGrade(StudentsController.GradeToEditDto newGrade) {
        try {
            Grade grade = gradeRepository.findById(newGrade.getGradeId()).orElse(null);
            grade.setSubject(newGrade.getSubject() == null ? grade.getSubject() : newGrade.getSubject());
            grade.setGrade(newGrade.getGrade() == null ? grade.getGrade() : newGrade.getGrade());
            this.gradeRepository.save(grade);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}
