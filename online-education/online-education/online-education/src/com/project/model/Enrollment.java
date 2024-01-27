package com.project.model;

public class Enrollment {
    private int id;
    private String student_name;
    private String course_name;

    // Constructors
    public Enrollment() {}

    public Enrollment(int id, String student_name, String course_name) {
        this.id = id;
        this.student_name = student_name;
        this.course_name = course_name;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return student_name;
    }

    public void setStudentName(String student_name) {
        this.student_name = student_name;
    }

    public String getCourseName() {
        return course_name;
    }

    public void setCourseName(String course_name) {
        this.course_name = course_name;
    }
}