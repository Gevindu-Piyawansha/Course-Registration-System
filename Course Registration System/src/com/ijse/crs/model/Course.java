/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.crs.model;
import java.util.List;

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
    private List<Integer> prerequisites; // List of course IDs that are prerequisites

    public Course(int courseId, String title, int creditHours, String department, int maxEnrollment, List<Integer> prerequisites) {
        this.courseId = courseId;
        this.title = title;
        this.creditHours = creditHours;
        this.department = department;
        this.maxEnrollment = maxEnrollment;
        this.prerequisites = prerequisites;
    }

    public int getCourseId() { return courseId; }
    public String getTitle() { return title; }
    public int getCreditHours() { return creditHours; }
    public String getDepartment() { return department; }
    public int getMaxEnrollment() { return maxEnrollment; }
    public List<Integer> getPrerequisites() { return prerequisites; }

    @Override
    public String toString() {
        return title + " (" + creditHours + " credits)";
    }
}

