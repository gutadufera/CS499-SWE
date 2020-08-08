package com.phuong.lab9.eregistrar.service;

import com.phuong.lab9.eregistrar.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    void deleteStudentById(Long studentId);
    List<Student> searchStudents(String searchString);
    Student getStudentById(Long studentId);
}
