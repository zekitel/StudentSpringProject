package com.zeki.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;



@Entity
@Table(name="Students")
public class Student implements Serializable{
    @Column(name="ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name="COURSE")
    private String course;

    public Student(int id, String name, String course)   {
        this.id = id;
        this.name = name;
        this.course = course;
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
