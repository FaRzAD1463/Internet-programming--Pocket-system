package com.project.model;

public class Announcement {
    private int id;
    private int courseId;
    private String title;
    private String message;

    // Constructors
    public Announcement() {}

    public Announcement(int id, int courseId, String title, String message) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.message = message;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
