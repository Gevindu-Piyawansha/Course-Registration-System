/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.crs.view;

/**
 *
 * @author Admin
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.ijse.crs.service.EnrollmentService;
import com.ijse.crs.model.Course;
import com.ijse.crs.model.Student;
import java.util.List;
import com.ijse.crs.service.ReportService;


public class MainFrame extends JFrame {
    private JComboBox<Course> courseComboBox;
    private JComboBox<Student> studentComboBox;
    private JButton registerButton;
    private JButton generateCourseReportButton;
    private JButton generateStudentReportButton;
    private JLabel prerequisitesLabel;
    private EnrollmentService enrollmentService;
    private ReportService reportService;

    public MainFrame() {
        enrollmentService = new EnrollmentService();
        reportService = new ReportService();

        setTitle("Course Registration");
        setLayout(new FlowLayout());

        // Load courses
        List<Course> courses = enrollmentService.getAvailableCourses();
        courseComboBox = new JComboBox<>(courses.toArray(new Course[0]));
        prerequisitesLabel = new JLabel("Prerequisites: None");

        // Load students
        List<Student> students = enrollmentService.getAllStudents();
        studentComboBox = new JComboBox<>(students.toArray(new Student[0]));

        // Update prerequisites when course is selected
        courseComboBox.addActionListener(e -> {
            Course selectedCourse = (Course) courseComboBox.getSelectedItem();
            if (selectedCourse != null) {
                prerequisitesLabel.setText("Prerequisites: " + selectedCourse.getPrerequisites());
            }
        });

        registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student selectedStudent = (Student) studentComboBox.getSelectedItem();
                Course selectedCourse = (Course) courseComboBox.getSelectedItem();
                
                if (selectedStudent != null && selectedCourse != null) {
                    boolean registered = enrollmentService.registerStudentForCourse(selectedStudent.getStudentId(), selectedCourse.getCourseId());
                    if (registered) {
                        JOptionPane.showMessageDialog(null, "Successfully registered for " + selectedCourse.getTitle());
                    } else {
                        JOptionPane.showMessageDialog(null, "Registration failed for " + selectedCourse.getTitle());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a student and a course.");
                }
            }
        });

        // Generate reports
        generateCourseReportButton = new JButton("Generate Course Enrollment Report");
        generateCourseReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reportService.generateCourseEnrollmentReport();
            }
        });

        generateStudentReportButton = new JButton("Generate Student Schedule Report");
        generateStudentReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reportService.generateStudentScheduleReport();
            }
        });

        add(new JLabel("Select Student:"));
        add(studentComboBox);
        add(new JLabel("Select Course:"));
        add(courseComboBox);
        add(prerequisitesLabel);
        add(registerButton);
        add(generateCourseReportButton);
        add(generateStudentReportButton);

        setSize(350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
