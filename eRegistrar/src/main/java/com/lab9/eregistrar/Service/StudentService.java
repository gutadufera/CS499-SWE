package com.lab9.eregistrar.Service;

import com.lab9.eregistrar.Model.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentService {
public abstract List<Student> getAllStudents();
public abstract Student saveStudent(Student student);
public abstract Optional<Student> getStudentById(Long studentId);
public abstract void deleteStudentById(Long studentId);
public abstract List<Student> searchStudents(String searchString);
public abstract Page<Student> getAllDataPaged(int pageNo);
public abstract Page<Student> searchDataPaged(String searchString, int pageNo);
}
