package com.licong.students_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AddController {

    @Autowired
    JdbcTemplate jdbcTemplate;
// http://localhost:8080/add?name=cc&students_number=7&sex=0&remark=good&chinese=3&math=5&english=2&grade=10
    @RequestMapping("/add")
    public String add(HttpServletRequest request){
        if(!Student.check(request))
            return "error_page";
        Object para[]=new Object[8];
        para[0]=request.getParameter("student_number");
        para[1]=request.getParameter("name");
        para[2]=request.getParameter("sex");
        para[3]=request.getParameter("remark");
        para[4]=request.getParameter("chinese");
        para[5]=request.getParameter("math");
        para[6]=request.getParameter("english");
//        para[7]=request.getParameter("grade");
        para[7]=Integer.parseInt((String)para[4])+Integer.parseInt((String)para[5])+Integer.parseInt((String)para[6]);
        String sql="INSERT INTO student (student_number, name, sex, remark, chinese, math, english, grade) VALUES (?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(sql,para);
        return "redirect:./";
    }
}
