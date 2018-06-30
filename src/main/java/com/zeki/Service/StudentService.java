package com.zeki.Service;

import com.zeki.DAO.StudentDao;
import com.zeki.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    @Qualifier("postgresql")
    private StudentDao studentDao;
    public Collection<Student> getAllStudents() throws SQLException, ClassNotFoundException {
        return studentDao.getAllStudents();
    }
    public Student getStudentByID(int id) throws SQLException, ClassNotFoundException {
        return this.studentDao.getStudentByID(id);
    }
    public void removeStudentById(int id) throws SQLException, ClassNotFoundException {
         this.studentDao.removeStudentById(id);
    }
    public void updateStudent(Student student) throws SQLException, ClassNotFoundException {
        this.studentDao.updateStudent(student);

    }
    public void insertStudent(Student student) throws SQLException, ClassNotFoundException {
        this.studentDao.insertStudentDao(student);
    }
}
