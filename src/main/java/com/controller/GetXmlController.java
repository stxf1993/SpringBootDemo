package com.controller;

import com.bean.Student;
import com.bean.StudentList;
import com.bean.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaofenShentu on 2019/12/26 12:42
 * /getXml2 路径返回一个比较复杂的xml
 */
@RestController
@RequestMapping("/getXmlValue")   //路径之前不要忘记加斜杠啊！！
public class GetXmlController {


    //get请求，返回一个简单的xml
    @RequestMapping(value = "/getXml",produces = {"application/xml;charset=UTF-8"},method = RequestMethod.GET)
    public User getXml(){

        User user=new User();
        user.setAge("18");
        user.setSex("boy");
        user.setUsername("stxf");
        user.setPassword("123456");

        return user;
    }


    //get请求，无需传入参数，返回一个较复杂的xml
    @RequestMapping(value = "/getXml2",produces = {"application/xml;charset=UTF-8"},method = RequestMethod.GET)
    public StudentList getXml2(){


        List<Student> studentList=new LinkedList<Student>();
        List<String> sunnyhobby=new LinkedList<String>();
        sunnyhobby.add("看书");
        sunnyhobby.add("跳舞");
        List<String> xiaolihobby=new LinkedList<String>();
        xiaolihobby.add("篮球");
        xiaolihobby.add("数学");
        //String name,String sex,int number,
        // String className,List<String> hobby
        studentList.add(new Student("sunny","girl",18,"一班",sunnyhobby));
        studentList.add(new Student("xiaoLi","boy",19,"三班",xiaolihobby));

        StudentList list=new StudentList();
        list.setStudents(studentList);

            return list;  //要return一个实体类，不能直接return students
    }


    /**
     *在getXmls2的基础上做变更
     * 接收一个xml传参，实体类是student
     * 添加到studentlist后返回一个xml
     * produces响应结果格式
     * consumes请求参数格式
     */

      @RequestMapping(value = "/getXml3",produces ={"application/xml;charset=UTF-8"},consumes = { MediaType.APPLICATION_XML_VALUE },method = RequestMethod.POST)
      public StudentList getXml3(@RequestBody Student student){

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

    //调试用的方法
    @RequestMapping(value = "/getString",method = RequestMethod.GET)
    public String getString(){

        return "getStringSuccess";
    }

}
