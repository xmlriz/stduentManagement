package com.service;

import com.database.util.DatabaseConnection;
import com.database.util.Helper;
import com.model.Student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService{

    @Override
    public int saveStudentRecords(Student student)
    {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "insert into Student values(?,?,?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql))
        {
                ps.setString(1,student.getSid());
                ps.setString(2,student.getSname());
                ps.setString(3,student.getSemail());
                ps.setInt(4,student.getCid());
                ps.setDate(5, Helper.javaDateToSqlDate(student.getDob()));
                ps.setDate(6,Helper.javaDateToSqlDate(LocalDate.now()));
                int rows = ps.executeUpdate();
             return rows;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int removeStudentById(String sid)
    {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "delete from student where sid = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1,sid);
            int rows = ps.executeUpdate();
            return rows;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Student> getAllStudents()
    {
        Connection connection = DatabaseConnection.getConnection();
        List<Student> students= new ArrayList<>();
        String sql = "select * from student";
        try(PreparedStatement ps = connection.prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Student student = new Student(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5).toLocalDate(),
                        rs.getObject(6, LocalDateTime.class)
                        );
                students.add(student);
            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return students;
    }
}
