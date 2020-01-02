package com.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;
/**
 * Created by xiaofenShentu on 2019/12/26 13:24
 */

public class Student {
    String name;  //姓名
    String sex;    //性别
    int number;     //学号
    String className;    //班级
    List<String> hobby;    //爱好

    public Student(){
    }
    public Student(String name,String sex,int number,
                   String className,List<String> hobby) {
        this.name = name;
        this.sex = sex;
        this.number = number;
        this.className = className;
        this.hobby = hobby;
    }
    @XmlAttribute(name="name")
    //@XmlAttribute，用于把java对象的属性映射为xml的属性,并可通过name属性为生成的xml属性指定别名
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name="sex")
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    @XmlAttribute(name="number")
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    @XmlElement(name="className")
    //@XmlElement，指定一个字段或get/set方法映射到xml的节点。通过name属性定义这个根节点的名称
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    @XmlElementWrapper(name="hobbys")
    //@XmlElementWrapper，为数组或集合定义一个父节点。通过name属性定义这个父节点的名称。
    @XmlElement(name = "hobby")
    public List<String> getHobby() {
        return hobby;
    }
    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }




}
