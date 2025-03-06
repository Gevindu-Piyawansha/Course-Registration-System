/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.crs.dao;

/**
 *
 * @author Admin
 */

import com.ijse.crs.model.Student;
import com.ijse.crs.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class StudentDAO {

    // Get a Student by ID
    public Optional<Student> getStudentById(int studentId) {
        String query = "SELECT * FROM students WHERE student_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Student student = new Student(
                    rs.getInt("student_id"),
                    rs.getString("name"),
                    rs.getString("dob"),
                    rs.getString("program"),
                    rs.getInt("year")
                );
                return Optional.of(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Log the exception here
        }
        return Optional.empty();
    }

    // Get all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                students.add(new Student(
                    rs.getInt("student_id"),
                    rs.getString("name"),
                    rs.getString("dob"),
                    rs.getString("program"),
                    rs.getInt("year")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Log the exception here
        }
        return students;
    }
}
