package com.licong.students_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DelController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/del")
    public String del(HttpServletRequest request){
        int student_number=Integer.parseInt(request.getParameter("student_number"));
        String sql="delete from student where student_number=?";
        jdbcTemplate.update(sql,new Object[]{student_number});
        return "redirect:./";
    }
}
