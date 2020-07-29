package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.time.LocalDate;

public class Student {
    private Integer studentID;
    private String name;
    private LocalDate dateOfAdmission;

    public Student(Integer studentID, String name, LocalDate dateOfAdmission) {
        super();
        this.studentID = studentID;
        this.name = name;
        this.dateOfAdmission = dateOfAdmission;
    }
//this is default constructor
    public Student() {
        this(null,null,null);
    }

    public Student(String name, LocalDate dateOfAdmission) {
        this.name = name;
        this.dateOfAdmission = dateOfAdmission;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", dateOfAdmission=" + dateOfAdmission +
                '}';
    }
}
