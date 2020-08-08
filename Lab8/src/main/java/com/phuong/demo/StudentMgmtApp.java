package com.phuong.demo;

import com.phuong.demo.model.Classroom;
import com.phuong.demo.model.Student;
import com.phuong.demo.model.Transcript;
import com.phuong.demo.repository.ClassroomRepository;
import com.phuong.demo.repository.StudentRepository;
import com.phuong.demo.repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassroomRepository classroomRepository;
    @Autowired
    TranscriptRepository transcriptRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentMgmtApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Classroom c1 = new Classroom("McLaughlin building", "M105", 1L);
//        Classroom savedC1 = saveClassroom(c1);
        Classroom classroom = classroomRepository.findById(1L).orElse(null);
        Transcript t1 = new Transcript("BS Computer Science");
        Student s1 = new Student("000-61-0001", "Anna", "Lynn",
                "Smith", 3.45, LocalDate.of(2019, 5, 24), t1, classroom);
        t1.setStudent(s1);
        Transcript savedT1 = saveTranscript(t1);
        //return data we just enter manually in sql
//        Student savedS1 = saveStudent(s1);
        System.out.println(savedT1);
//        System.out.println(savedC1);
//        System.out.println(savedS1);
    }
//    public Student saveStudent(Student student) {
//        return studentRepository.save(student);
//    }
    public Transcript saveTranscript(Transcript transcript){
        return transcriptRepository.save(transcript);
    }
//    public Classroom saveClassroom(Classroom classroom){
//        return classroomRepository.save(classroom);
//    }
    }
