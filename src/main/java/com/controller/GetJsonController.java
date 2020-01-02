package com.controller;

import com.bean.Student;
import com.bean.StudentList;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaofenShentu on 2019/12/26 17:30
 */
@RestController
@RequestMapping("/getJsonValue")
public class GetJsonController {


    /**
     *post请求
     * 接收一个json格式的请求参数
     * 返回一个json格式的请求结果
     */

    @RequestMapping(value = "/getJson",consumes="application/json", produces="application/json",method = RequestMethod.POST)
    public StudentList getJsonValue(@RequestBody Student student){
        List<Student> students=new LinkedList<Student>();
        List<String> sunnyhobby=new LinkedList<String>();
        sunnyhobby.add("看书");
        sunnyhobby.add("跳舞");
        List<String> xiaolihobby=new LinkedList<String>();
        xiaolihobby.add("篮球");
        xiaolihobby.add("数学");
        //String name,String sex,int number,
        // String className,List<String> hobby
        students.add(new Student("sunny","girl",18,"一班",sunnyhobby));
        students.add(new Student("xiaoLi","boy",19,"三班",xiaolihobby));
        students.add(student);

        StudentList list=new StudentList();
        list.setStudents(students);

        return list;  //要return一个实体类，不能直接return students

    }


    /**
     * get接口，不需要传任何参数，直接返回一个json格式的响应结果
     */

    @RequestMapping(value = "/getJson2", produces="application/json",method = RequestMethod.GET)
    public StudentList getJson2(){
        List<Student> students=new LinkedList<Student>();
        List<String> sunnyhobby=new LinkedList<String>();
        sunnyhobby.add("看书");
        sunnyhobby.add("跳舞");
        List<String> xiaolihobby=new LinkedList<String>();
        xiaolihobby.add("篮球");
        xiaolihobby.add("数学");
        //String name,String sex,int number,
        // String className,List<String> hobby
        students.add(new Student("sunny","girl",18,"一班",sunnyhobby));
        students.add(new Student("xiaoLi","boy",19,"三班",xiaolihobby));

        StudentList list=new StudentList();
        list.setStudents(students);

        return list;  //要return一个实体类，不能直接return students

    }

    //调试用的方法
    @RequestMapping(value = "/getString",method = RequestMethod.GET)
    public String getString(){

        return "getStringSuccess";
    }
}
