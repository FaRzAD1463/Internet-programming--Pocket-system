package com.project.model;

public class Material {
    private int id;
    private int courseId;
    private String title;
    private String content; // This could be a URL or a file path to the content

    // Constructors
    public Material() {}

    public Material(int id, int courseId, String title, String content) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
