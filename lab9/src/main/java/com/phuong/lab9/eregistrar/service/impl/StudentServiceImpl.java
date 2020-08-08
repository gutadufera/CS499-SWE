package com.phuong.lab9.eregistrar.service.impl;

import com.phuong.lab9.eregistrar.model.Student;
import com.phuong.lab9.eregistrar.repository.StudentRepository;
import com.phuong.lab9.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> searchStudents(String searchString) {
        if (containsDecimalPoint(searchString) && isCGPA(searchString)) {
            return studentRepository.findAllByCgpaEquals(Double.parseDouble(searchString));

        } else if (isDate(searchString)) {
            return studentRepository.findAllByEnrollmentDateEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
        } else {
            return studentRepository.
                    findAllByFirstNameContainingOrMiddleNameContainingOrLastNameContainingOrIsInternationalContainingOrStudentNumberContaining(searchString, searchString, searchString, searchString, searchString);
        }
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    private boolean isCGPA(String searchString) {
        boolean isParseableAsCGPA = false;
        try {
            Double.parseDouble(searchString);
            isParseableAsCGPA = true;
        } catch (Exception ex) {
            if (ex instanceof ParseException) {
                isParseableAsCGPA = false;
            }
        }
        return isParseableAsCGPA;
    }

    private boolean containsDecimalPoint(String searchString) {
        return searchString.contains(".");
    }

    private boolean isDate(String searchString) {
        boolean isParseableAsDate = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        } catch (Exception ex) {
            if (ex instanceof DateTimeException) {
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }

}
