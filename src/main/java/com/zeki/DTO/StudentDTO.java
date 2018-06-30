package com.zeki.DTO;

import com.zeki.Entity.Student;

import java.io.Serializable;

public class StudentDTO implements Serializable {
    public int id;
    public String name;
    public String course;
    public StudentDTO(){

    }

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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
