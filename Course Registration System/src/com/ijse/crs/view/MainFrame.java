/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.crs.view;

/**
 *
 * @author Admin
 */

import com.ijse.crs.model.Course;
import com.ijse.crs.service.EnrollmentService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MainFrame extends JFrame {
    private JComboBox<Course> courseComboBox;
    private JButton registerButton;
    private EnrollmentService enrollmentService;

    public MainFrame() {
        enrollmentService = new EnrollmentService();

        setTitle("Course Registration");
        setLayout(new FlowLayout());

        // Load courses
        List<Course> courses = enrollmentService.getAvailableCourses();
        courseComboBox = new JComboBox<>(courses.toArray(new Course[0]));

        registerButton = new JButton("Register");
        registerButton.addActionListener(e -> JOptionPane.showMessageDialog(
            this, "You registered for " + ((Course) courseComboBox.getSelectedItem()).getTitle()
        ));

        add(courseComboBox);
        add(registerButton);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}

