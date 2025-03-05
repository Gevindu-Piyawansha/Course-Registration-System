/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ijse.crs.model;

/**
 *
 * @author Admin
 */

public class Student {
    private int studentId;
    private String name;
    private String dob;
    private String program;
    private int year;

    public Student(int studentId, String name, String dob, String program, int year) {
        this.studentId = studentId;
        this.name = name;
        this.dob = dob;
        this.program = program;
        this.year = year;
    }

    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getDob() { return dob; }
    public String getProgram() { return program; }
    public int getYear() { return year; }
}
