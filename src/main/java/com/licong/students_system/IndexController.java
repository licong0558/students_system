package com.licong.students_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String index(ModelMap mmap){
        String sql="select student_number,name from student";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        ArrayList<Student> students_list=new ArrayList<>();
        for(Map<String,Object> map : list){
            String name=(String)map.get("name");
            int student_number=(Integer)map.get("student_number");
            Student ele=new Student(name,student_number);
            students_list.add(ele);
        }
        mmap.addAttribute("students_list",students_list);
        return "index";
    }
}
