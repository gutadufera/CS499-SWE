package com.phuong.demo.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

//studentNumber : (required) (e.g. Data values: 000-61-0001, 000-61-0002, etc.)
//        firstName : (required) (e.g.  Data values: "Anna", "Bob" etc.)
//        middleName : (is optional) (e.g.  Data values: "Lynn", "" etc.)
//        lastName: (required) (e.g.  Data values: "Smith", "Galverston" etc.)
//        cgpa : (is optional) (e.g. Data values: 3.45, 2.87, etc)
//        dateOfEnrollment (This field contains date values; representing the date of enrollment of the student)

@Entity
@Table(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentID;

    @Column(name = "student_number", unique = true, nullable = false)
    private String studentNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private String middleName;
    private double cgpa;

    private LocalDate dateOfEnrollment;

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Student() {
        super();
    }

    public Student(Long studentId, String studentNumber, String firstName, String middleName, String lastName,
                   Double cgpa, LocalDate dateOfEnrollment) {
        this.studentID = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "Student Number: " + studentNumber +
                "First Name: " + firstName + "Midlle Name: " + middleName +
                "Last Name: " + lastName + "CGPA: " + cgpa +
                "Date pf Enrollment: " + dateOfEnrollment
                ;
    }
}
