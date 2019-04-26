package com.licong.students_system;

import com.sun.org.apache.xml.internal.utils.ObjectVector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class IsExistController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/isexist")
    public boolean isexist(HttpServletRequest request){
        Object para[]=new Object[1];
        para[0]=request.getParameter("student_number");
        String sql="select * from student where student_number=?";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql,para);
        if(list.size()>0)
            return true;
        else return false;
    }
}
