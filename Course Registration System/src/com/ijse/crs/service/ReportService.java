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
import java.util.*;
import java.util.List;


public class ReportService {
    private CourseDAO courseDAO;
    private StudentDAO studentDAO;

    public ReportService() {
        this.courseDAO = new CourseDAO();
        this.studentDAO = new StudentDAO();
    }

    // Generate Course Enrollment Report
    public void generateCourseEnrollmentReport() {
        List<Course> courses = courseDAO.getAllCourses();
        System.out.println("Course Enrollment Report");
        System.out.println("---------------------------");
        for (Course course : courses) {
            int enrolledCount = getEnrolledCountForCourse(course.getCourseId());
            System.out.println(course.getTitle() + " - " + enrolledCount + " students enrolled");
        }
    }

    // Generate Student Schedule Report
    public void generateStudentScheduleReport() {
        List<Student> students = studentDAO.getAllStudents();
        System.out.println("Student Schedule Report");
        System.out.println("------------------------");
        for (Student student : students) {
            List<Course> studentCourses = getCoursesForStudent(student.getStudentId());
            System.out.println("Student " + student.getName() + ":");
            for (Course course : studentCourses) {
                System.out.println("\t" + course.getTitle());
            }
            System.out.println();
        }
    }

    // Helper method to get the number of students enrolled in a course
    private int getEnrolledCountForCourse(int courseId) {
        // For simplicity, assume each student is enrolled in one course. 
        // This should be updated to reflect the real enrollment data.
        return 10; // Placeholder logic, needs database integration for real data
    }

    // Helper method to get the list of courses a student is enrolled in
    private List<Course> getCoursesForStudent(int studentId) {
        // For simplicity, assume each student is enrolled in 3 courses. 
        // This should be updated to reflect the real data.
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(101, "Math 101", 3, "Mathematics", 30, new ArrayList<>()));
        courses.add(new Course(102, "Physics 101", 3, "Physics", 30, new ArrayList<>()));
        courses.add(new Course(103, "Computer Science 101", 3, "Computer Science", 30, new ArrayList<>()));
        return courses; // Placeholder logic, needs database integration for real data
    }
}
