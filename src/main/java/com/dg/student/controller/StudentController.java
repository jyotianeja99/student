package com.dg.student.controller;

import com.dg.student.dto.Student;
import com.dg.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student s){
        Student student = studentService.addStudent(s);
        return ResponseEntity.ok(student);
    }

}
