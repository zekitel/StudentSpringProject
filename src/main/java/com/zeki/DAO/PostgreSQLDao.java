package com.zeki.DAO;

import com.zeki.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import java.sql.*;
import java.util.*;

@Repository
@Qualifier("postgresql")
public class PostgreSQLDao implements StudentDao {
    private static Map<Integer,Student> students;
    static {
        students=new HashMap<Integer, Student>(){
            {
                put(1,new Student(1,"Zeki","Computer Science"));
                put(2,new Student(2,"Furkan","Java"));
                put(3,new Student(3,"ŞENAY","C++"));
            }

        };
    }





    @Override
    public Collection<Student> getAllStudents() throws SQLException, ClassNotFoundException {
        Connection conn=Student.connection();
        //PostgreSQL
        //PreparedStatement preparedStatement=conn.prepareStatement("SELECT * from public.\"students\"");
        //MySQL
        PreparedStatement preparedStatement=conn.prepareStatement("SELECT * from students");

        ResultSet rst=preparedStatement.executeQuery();
        ArrayList<Student> listStudent=new ArrayList<Student>();
        int studentId = 0;
        String studentName="";
        String studentCourse="";
        while(rst.next()){
            studentId=rst.getInt("id");
            studentName=rst.getString("name");
            studentCourse=rst.getString("course");
            Student temp=new Student(studentId,studentName,studentCourse);
            listStudent.add(temp);
        }

        return listStudent;
    }




    @Override
    public Student getStudentByID(int id) throws SQLException, ClassNotFoundException {
        Connection conn=Student.connection();
        //PostgreSQL
        //PreparedStatement preparedStatement=conn.prepareStatement("SELECT * from public.\"students\" where id="+id);
        //MySQL
        PreparedStatement preparedStatement=conn.prepareStatement("SELECT * from students where id="+id);


        ResultSet rst=preparedStatement.executeQuery();
        int studentId = 0;
        String studentName="";
        String studentCourse="";
        if(rst.next()){
            studentId=rst.getInt("id");
            studentName=rst.getString("name");
            studentCourse=rst.getString("course");
        }
        Student student=new Student(studentId,studentName,studentCourse);
        return student;
    }


    @Override
    public void removeStudentById(int id) throws SQLException, ClassNotFoundException {
        Connection conn=Student.connection();
        //PostgreSQL
        //PreparedStatement preparedStatement=conn.prepareStatement("DELETE from public.\"students\" where id="+id);
        PreparedStatement preparedStatement=conn.prepareStatement("DELETE from students where id="+id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateStudent(Student student) throws SQLException, ClassNotFoundException {

        System.out.println(student.getId()+"    "+student.getName()+"  "+student.getCourse());
        Connection conn=Student.connection();
        //PostgreSQL
        //PreparedStatement preparedStatement=conn.prepareStatement("UPDATE public.\"students\" SET id=?,name=?,course=? where id="+student.getId());
        //MySQL
        PreparedStatement preparedStatement=conn.prepareStatement("UPDATE students SET id=?,name=?,course=? where id="+student.getId());
        preparedStatement.setInt(1,student.getId());
        preparedStatement.setString(2,student.getName());
        preparedStatement.setString(3,student.getCourse());
        preparedStatement.executeUpdate();
    }

    @Override
    public void insertStudentDao(Student student) throws SQLException, ClassNotFoundException {
        Connection conn=Student.connection();
        //PostgreSQL
        //PreparedStatement preparedStatement2=conn.prepareStatement("SELECT * from public.\"students\" where id="+student.getId());
        //MySQL
        PreparedStatement preparedStatement2=conn.prepareStatement("SELECT * from students where id="+student.getId());
        ResultSet resultSet=preparedStatement2.executeQuery();
        if(resultSet.next()){
            System.out.println("Boş Değil");
        }
        else {
            //PostgreSQL
            //PreparedStatement preparedStatement=conn.prepareStatement("INSERT into  public.\"students\" values(?,?,?)");
            //MYSSQL
            PreparedStatement preparedStatement=conn.prepareStatement("INSERT into  students values(?,?,?)");
            preparedStatement.setInt(1,student.getId());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setString(3,student.getCourse());

            preparedStatement.executeUpdate();


        }


    }
}
