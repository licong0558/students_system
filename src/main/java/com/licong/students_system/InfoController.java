package com.licong.students_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

@Controller
public class InfoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/info/{student_number}")
    public String GetInfo(ModelMap mmap, @PathVariable int student_number){
//        return (String)student_number;
        String sql="select * from student where student_number=?";
        List<Map<String, Object>> list= jdbcTemplate.queryForList(sql, new Object[]{student_number});
        if(list.size()==0)
            return "not_exist";
        Map<String,Object> map=list.get(0);
        Student student=new Student(map);
//        student.student_number=(Integer) map.get("student_number");
//        student.name=(String)map.get("name");
//        student.sex=(Integer) map.get("sex");
//        student.remark=(String)map.get("remark");
//        student.chinese=(Integer)map.get("chinese");
//        student.math=(Integer)map.get("math");
//        student.english=(Integer)map.get("english");
//        student.grade=(Integer)map.get("grade");
        mmap.addAttribute("student",student);
        return "info";
    }
}
