package com.controller;

import com.database.util.Helper;
import com.model.Student;
import com.service.StudentService;
import com.service.StudentServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class StudentController
{
    Scanner sc = new Scanner(System.in);
    StudentService studentservice = new StudentServiceImpl();

    public void insertEmployeeRecord()
    {
        System.out.print("Enter the stduent id: ");
        String sid = sc.next();
        sc.nextLine();

        System.out.print("Enter the stduent name : ");
        String name = sc.nextLine();

        System.out.print("Enter the stduent email : ");
        String email = sc.next();

        System.out.print("Enter the course ID: ");
        Integer cid = sc.nextInt();

        System.out.print("Enter the dob (yyyy/MM/dd) : " );
        String dob = sc.next();

        Student student = new Student(sid,name,email,cid, Helper.stringDateToJavaDate(dob), LocalDateTime.now());

        int row = studentservice.saveStudentRecords(student);
        if(row>0)
            System.out.println("=== Record Inserted ======");
        else
            System.err.println("====Record Not insererd====");

    }

    public void studentRemovebyId()
    {
        System.out.print("Enter the student id  to remove  : ");
        String sid = sc.next();
        int row  = studentservice.removeStudentById(sid);

        if(row>0)
            System.out.println("=== Record Deleted ======");
        else
            System.err.println("====Record Not Deleted====");
    }

    public void getAllStudents() {

        List<Student> allStudents = studentservice.getAllStudents();

        allStudents.stream()
                .forEach(System.out::println);


    }
}
