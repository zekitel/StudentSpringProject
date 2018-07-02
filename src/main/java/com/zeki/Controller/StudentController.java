package com.zeki.Controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zeki.DTO.StudentDTO;
import com.zeki.Entity.Student;
import com.zeki.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.print.attribute.standard.Media;
import javax.xml.ws.RequestWrapper;
import java.awt.*;
import java.sql.SQLException;
import java.util.Collection;

@RestController
@ResponseStatus(HttpStatus.OK)
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @CrossOrigin
    @RequestMapping(value = "/sorgula", method = RequestMethod.GET)
    public Collection<Student> getAllStudents() throws SQLException, ClassNotFoundException {
        return studentService.getAllStudents();
    }
    @RequestMapping(value = "/getirById",method = RequestMethod.GET)
    public Student getStudentById(@RequestParam(value = "id") int id) throws SQLException, ClassNotFoundException {
        return studentService.getStudentByID(id);
    }
    //studentController
    @RequestMapping(value = "/sil",method = RequestMethod.DELETE)
    public void deleteStudentById(@RequestParam(value="id") int id) throws SQLException, ClassNotFoundException {
        studentService.removeStudentById(id);
    }
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public void updateStudent(@RequestBody Student student) throws SQLException, ClassNotFoundException {
        studentService.updateStudent(student);
    }



    @RequestMapping(value = "/ekle", method = RequestMethod.POST)
    public void insertStudent(@RequestBody Student student) throws SQLException, ClassNotFoundException {
        studentService.insertStudent(student);



    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/students/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");


            }
        };
    }

}
