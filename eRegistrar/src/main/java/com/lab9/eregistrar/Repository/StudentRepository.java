package com.lab9.eregistrar.Repository;

import com.lab9.eregistrar.Model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
List<Student> findAllByStudentNumberContainingOrFirstNameContainingOrMiddleNameContainingOrLastNameContaining(
String studentNumber,String fName, String mName, String lName);
Page<Student> findAllByStudentNumberContainingOrFirstNameContainingOrMiddleNameContainingOrLastNameContaining
        (String studentNumber, String fName, String mName, String lName, PageRequest pageRequest);
}
