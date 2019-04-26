package com.licong.students_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UpdateController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/update")
    public String update(HttpServletRequest request){
        if(!Student.check(request))
            return "error_page";
        Object para[]=new Object[8];
        para[7]=request.getParameter("student_number");
        para[0]=request.getParameter("name");
        para[1]=request.getParameter("sex");
        para[2]=request.getParameter("remark");
        para[3]=request.getParameter("chinese");
        para[4]=request.getParameter("math");
        para[5]=request.getParameter("english");
//        para[7]=request.getParameter("grade");
        para[6]=Integer.parseInt((String)para[3])+Integer.parseInt((String)para[4])+Integer.parseInt((String)para[5]);
        String sql="UPDATE student SET name=?,sex=?,remark=?,chinese=?,math=?,english=?,grade=? WHERE student_number=?";
        jdbcTemplate.update(sql,para);
        return "redirect:./info/"+para[7];
    }
}
