/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.crs.service;

/**
 *
 * @author Admin
 */

import com.ijse.crs.dao.CourseDAO;
import com.ijse.crs.dao.StudentDAO;
import com.ijse.crs.model.Course;
import com.ijse.crs.model.Student;
import java.util.List;
import java.util.*;

public class EnrollmentService {
    private CourseDAO courseDAO;
    private StudentDAO studentDAO;

    public EnrollmentService() {
        this.courseDAO = new CourseDAO();
        this.studentDAO = new StudentDAO();
    }

    // Get list of available courses
    public List<Course> getAvailableCourses() {
        return courseDAO.getAllCourses();
    }

    // Get list of all students
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    // Register a student for a course (check prerequisites, capacity, etc.)
    public boolean registerStudentForCourse(int studentId, int courseId) {
        // Get course from the list
        Course course = courseDAO.getAllCourses().stream()
            .filter(c -> c.getCourseId() == courseId)
            .findFirst()
            .orElse(null);

        if (course != null && course.getMaxEnrollment() > 0) {
            // Check if student has completed all prerequisites
            if (checkPrerequisites(studentId, course.getPrerequisites())) {
                // Proceed with registration (e.g., enroll student, update course enrollment)
                System.out.println("Student " + studentId + " successfully registered for " + course.getTitle());
                return true; // Placeholder registration logic
            } else {
                System.out.println("Student " + studentId + " has not completed prerequisites for " + course.getTitle());
                return false;
            }
        }

        return false; // Registration failed (e.g., course is full)
    }

    // Check if a student has completed all the prerequisites for a course
    private boolean checkPrerequisites(int studentId, List<Integer> prerequisites) {
        // For simplicity, assume we have a method `getCompletedCoursesForStudent` that fetches completed courses
        List<Integer> completedCourses = getCompletedCoursesForStudent(studentId);

        for (int prerequisiteCourseId : prerequisites) {
            if (!completedCourses.contains(prerequisiteCourseId)) {
                return false; // Student hasn't completed one of the prerequisites
            }
        }
        return true; // Student has completed all prerequisites
    }

    // Mock method to get completed courses for a student (this should query the database in a real system)
    private List<Integer> getCompletedCoursesForStudent(int studentId) {
        // Example completed courses - In real implementation, it will check the database for student records
        return Arrays.asList(101, 102); // Assuming student has completed courses 101 and 102
    }
}
