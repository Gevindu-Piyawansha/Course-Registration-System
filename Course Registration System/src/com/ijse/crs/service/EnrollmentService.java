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
import com.ijse.crs.model.Course;
import java.util.List;

public class EnrollmentService {
    private CourseDAO courseDAO;

    public EnrollmentService() {
        this.courseDAO = new CourseDAO();
    }

    public List<Course> getAvailableCourses() {
        return courseDAO.getAllCourses();
    }
}
