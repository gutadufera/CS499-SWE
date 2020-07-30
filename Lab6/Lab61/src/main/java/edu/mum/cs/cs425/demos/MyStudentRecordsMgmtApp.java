package edu.mum.cs.cs425.demos;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MyStudentRecordsMgmtApp.java
 * @author PhuongNguyen
 * @since 072920
 */

public class MyStudentRecordsMgmtApp{
    public static void main( String[] args )
    {
        MyStudentRecordsMgmtApp app= new MyStudentRecordsMgmtApp();
        System.out.println( "Hello World!" );
        Student[] students = {
                new Student(110001, "Dave", LocalDate.of(1951,11,18)),
                new Student(110002, "Anna", LocalDate.of(1990,12,07)),
                new Student(110003, "Erica", LocalDate.of(1974,01,31)),
                new Student(110004, "Carlos", LocalDate.of(2009,8,22)),
                new Student(110005, "Bob", LocalDate.of(1990,03,05)),
        };

        //print before sorting
        System.out.println("Print before sorting");
        Arrays.stream(students).forEach(System.out::println);
        //print after sorting
        System.out.println("Print after sorting");
        app.printListOfStudents(students);
        System.out.println("Print list of Platinum Alumni Students in descending order");
        app.getListOfPlatinumAlumniStudents(students).forEach(System.out::println);
    }
    private void printListOfStudents(Student[] students){
        Arrays.stream(students)
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }
    private List<Student> getListOfPlatinumAlumniStudents(Student[] students){
        return Arrays.stream(students)
                .filter(Student::isPlatinumAlumniStudents)
                .sorted(Comparator.comparing(Student::getDateOfAdmission).reversed())
                .collect(Collectors.toList());
    }
}
