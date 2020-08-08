package com.phuong.lab9.eregistrar.repository;

import com.phuong.lab9.eregistrar.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
List<Student> findAllByFirstNameContainingOrMiddleNameContainingOrLastNameContainingOrIsInternationalContainingOrStudentNumberContaining(
        String firstName, String middleName, String lastName, String isInternational, String studentNumber);
    List<Student> findAllByEnrollmentDateEquals(LocalDate enrollmentdate);
    List<Student> findAllByCgpaEquals(Double cGpa);
}
