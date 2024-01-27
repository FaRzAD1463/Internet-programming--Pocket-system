package com.project.model;
import java.io.Serializable;
public class Course implements Serializable{
    private int id;
    private String name;
    private String description;
    private String teacherName;
    
    private int teacherId;

    public int
 
getTeacherId()
 
{
        return teacherId;
    }

    public void
 
setTeacherId(int teacherId)
 
{
        this.teacherId = teacherId;
    }

    // Constructors
    public Course() {}

    public Course(int id, String name, String description, String teacherName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teacherName = teacherName;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
