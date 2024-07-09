package com.dg.student.service;

import com.dg.student.dto.Student;
import com.dg.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepo;

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public Student addStudent(Student student){
        return studentRepo.save(student);
    }

}
