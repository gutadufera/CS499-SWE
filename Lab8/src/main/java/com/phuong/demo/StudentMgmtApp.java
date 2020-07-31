package com.phuong.demo;

import com.phuong.demo.model.Student;
import com.phuong.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentMgmtApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Student data: s1: { studentId:1, studentNumber: 000-61-0001, firstName:Anna, middleName: Lynn,
//                LastName: Smith, cgpa:3.45, dateOfEnrollment:2019/5/24 }
        Student s1 = new Student(1L, "000-61-0001", "Anna", "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24));
        Student savedS1 = saveStudent(s1);
        System.out.println("s1");
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
