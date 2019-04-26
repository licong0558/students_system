package com.licong.students_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class ShowController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/show")
    public String Show(ModelMap mmap, HttpServletRequest request){
        List<Map<String,Object>> list;
        if(request.getParameter("query_type").equals("1")){
            String sql="select * from student where name=?";
            list=jdbcTemplate.queryForList(sql,new Object[] {request.getParameter("student_name")});
        }else{
            Set<String> se=new HashSet<>();
            se.add("chinese");
            se.add("math");
            se.add("english");
            se.add("grade");

            String w1=request.getParameter("w1");
            String w2=request.getParameter("w2");
            String w3=request.getParameter("w3");
            se.remove(request.getParameter("w1"));
            se.remove(request.getParameter("w2"));
            se.remove(request.getParameter("w3"));
            String w4=se.iterator().next();
            System.out.println(w1+" "+w2+" "+w3+" "+w4);
            String sql="select * from student order by "+w1+" desc,"+w2+" desc,"+w3+" desc,"+w4+" desc";
//            list=jdbcTemplate.queryForList(sql,new Object[]{w1,w2,w3,w4});
//            String sql="select * from student order by "+w1+" desc";
            list=jdbcTemplate.queryForList(sql);
//            String sql="select * from student order by ? desc";
//            list=jdbcTemplate.queryForList(sql,new Object[]{w1});
        }
        ArrayList<Student> students_list=new ArrayList<>();
        for(Map<String,Object> map:list){
            students_list.add(new Student(map));
            System.out.println(map.get("grade"));
            System.out.println(map.get("name"));
        }
        mmap.addAttribute("students_list",students_list);
        return "show";
    }
}
