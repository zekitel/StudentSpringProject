package com.zeki.DAO;

import com.zeki.Entity.Student;

import java.sql.SQLException;
import java.util.Collection;

public interface StudentDao {
    Collection<Student> getAllStudents() throws SQLException, ClassNotFoundException;

    Student getStudentByID(int id) throws SQLException, ClassNotFoundException;

    void removeStudentById(int id) throws SQLException, ClassNotFoundException;

    void updateStudent(Student student) throws SQLException, ClassNotFoundException;

    void insertStudentDao(Student student) throws SQLException, ClassNotFoundException;
}
