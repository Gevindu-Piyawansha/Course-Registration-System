/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.crs.model;

/**
 *
 * @author Admin
 */

public class Course {
    private int courseId;
    private String title;
    private int creditHours;
    private String department;
    private int maxEnrollment;

    public Course(int courseId, String title, int creditHours, String department, int maxEnrollment) {
        this.courseId = courseId;
        this.title = title;
        this.creditHours = creditHours;
        this.department = department;
        this.maxEnrollment = maxEnrollment;
    }

    public int getCourseId() { return courseId; }
    public String getTitle() { return title; }
    public int getCreditHours() { return creditHours; }
    public String getDepartment() { return department; }
    public int getMaxEnrollment() { return maxEnrollment; }

    @Override
    public String toString() { return title + " (" + creditHours + " credits)"; }
}

