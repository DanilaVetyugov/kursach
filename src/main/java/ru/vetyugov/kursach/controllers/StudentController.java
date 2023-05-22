package ru.vetyugov.kursach.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vetyugov.kursach.entities.Student;
import ru.vetyugov.kursach.services.StudentService;

import java.sql.SQLException;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService = new StudentService();

    @GetMapping("/{studentName}&{studentSurName}")
    public Student getStudent(@PathVariable String studentName, @PathVariable String studentSurName) throws SQLException {
        return studentService.getStudentByName(studentName,studentSurName);
    }
}