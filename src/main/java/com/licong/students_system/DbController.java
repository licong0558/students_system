package com.licong.students_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DbController {


    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/testconnect")
//    public String index(){
//        String sql="select * from student";
//        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
//        for(Map<String,Object> map:list){
//            for(Map.Entry<String,Object> entry : map.entrySet()){
//                System.out.println(entry.getKey()+":"+entry.getValue());
//            }
//        }
//        return "databasecon";
//    }
    public Map<String,Object> index(){
        String sql="select * from student";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        for(Map<String,Object> map:list){
            for(Map.Entry<String,Object> entry : map.entrySet()){
                System.out.println(entry.getKey()+":"+entry.getValue());
            }
        }
        return list.get(0);
    }
}
