package com.lab9.eregistrar.Service.impl;

import com.lab9.eregistrar.Model.Student;
import com.lab9.eregistrar.Repository.StudentRepository;
import com.lab9.eregistrar.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @Override
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }


    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> searchStudents(String searchString) {
        if (searchString instanceof String){
searchString = searchString.toLowerCase();
        }
        return studentRepository.findAllByStudentNumberContainingOrFirstNameContainingOrMiddleNameContainingOrLastNameContaining(
searchString, searchString, searchString, searchString);
    }

    public Page<Student> searchDataPaged(String searchString, int pageNo) {
        return studentRepository.findAllByStudentNumberContainingOrFirstNameContainingOrMiddleNameContainingOrLastNameContaining(searchString, searchString, searchString, searchString, PageRequest.of(pageNo, 3, Sort.by("studentNumber")));
    }

    @Override
    public Page<Student> getAllDataPaged(int pageNo) {
        return studentRepository.findAll(PageRequest.of(pageNo, 3, Sort.by("studentNumber")));
    }

}
