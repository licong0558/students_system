package com.licong.students_system;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Student{
    public String name;
    public int student_number;
    public String sex;
    public String remark;
    public int chinese;
    public int math;
    public int english;
    public int grade;

    Student(String _name,int _student_number){
        name=_name;
        student_number=_student_number;
    }
    Student(Map<String,Object> map){
        student_number=(Integer) map.get("student_number");
        name=(String)map.get("name");
        sex=(Integer)map.get("sex")==0?"男":"女";
        remark=(String)map.get("remark");
        chinese=(Integer)map.get("chinese");
        math=(Integer)map.get("math");
        english=(Integer)map.get("english");
        grade=(Integer)map.get("grade");
    }
    public static boolean check(HttpServletRequest request){
        class inner{
            boolean NumInBound(String str,int min,int max){
                boolean ret=true;
                try {
                    int num = Integer.parseInt(str);
                    if(num<min || num>max)
                        ret=false;
                }catch (Exception e){
                    ret=false;
                }
                return ret;
            }
        }
        boolean ret=true;
        inner in=new inner();
        ret&=in.NumInBound(request.getParameter("student_number"),10000,99999);
        String name=request.getParameter("name");
        String reg="[\\u4e00-\\u9fa5]+";
        ret&=name.matches(reg);
        ret&=in.NumInBound(request.getParameter("sex"),0,1);
        ret&=in.NumInBound(request.getParameter("chinese"),0,100);
        ret&=in.NumInBound(request.getParameter("math"),0,100);
        ret&=in.NumInBound(request.getParameter("english"),0,100);
        return ret;
    }
}
