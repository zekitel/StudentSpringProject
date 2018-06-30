package com.zeki.Controller;

import com.zeki.DAO.StudentDao;
import com.zeki.Entity.Student;
import com.zeki.Service.StudentService;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@RestController

public class MainController {

    @RequestMapping(value = "/welcome2" ,method = RequestMethod.GET)
    public  void func1(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/students");
        requestDispatcher.forward(request,response);
    }

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String function1(){



        return "hello";


    }
    @RequestMapping("/")
    public ModelAndView home(ModelAndView modelAndView){
        modelAndView.setViewName("hello");
        modelAndView.getModel().put("name","Zeki");
        return modelAndView;
    }
}
