/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.crs.dao;

/**
 *
 * @author Admin
 */

import com.ijse.crs.model.Course;
import com.ijse.crs.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    // Get all courses from the database
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";

        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int courseId = rs.getInt("course_id");
                String title = rs.getString("title");
                int creditHours = rs.getInt("credit_hours");
                String department = rs.getString("department");
                int maxEnrollment = rs.getInt("max_enrollment");

                // Fetch prerequisites for the course
                List<Integer> prerequisites = getPrerequisitesForCourse(courseId);

                courses.add(new Course(courseId, title, creditHours, department, maxEnrollment, prerequisites));
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Keep original behavior here for error printing
        }
        return courses;
    }

    // Fetch prerequisites for a specific course
    private List<Integer> getPrerequisitesForCourse(int courseId) {
        List<Integer> prerequisites = new ArrayList<>();
        String query = "SELECT prerequisite_course_id FROM course_prerequisites WHERE course_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                prerequisites.add(rs.getInt("prerequisite_course_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Keep original behavior here for error printing
        }
        return prerequisites;
    }
}
