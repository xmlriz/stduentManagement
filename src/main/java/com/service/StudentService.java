package com.service;

import com.model.Student;

import java.util.List;

public interface StudentService
{
    public int saveStudentRecords(Student student);
    public int removeStudentById(String sid);
    public List<Student> getAllStudents();

}
