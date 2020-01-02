package com.bean;

/*

*/

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by xiaofenShentu on 2019/12/26 13:25
 */

@XmlRootElement(name = "Studentlist")
//@XmlRootElement，用于类级别的注解，对应xml的跟元素。通过name属性定义这个根节点的名称。
public class StudentList {
    private List<Student> students;    //所有学生信息的集合




    public void setStudents(List<Student> students) {
        this.students = students;
    }

    //@XmlElement，指定一个字段或get/set方法映射到xml的节点。通过name属性定义这个根节点的名称
    @XmlElement(name = "student")
    public List<Student> getStudents() {
        return students;
    }
}
