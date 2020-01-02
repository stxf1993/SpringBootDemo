package com.bean;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by xiaofenShentu on 2019/12/25 20:42
 */
@Data
@XmlRootElement //说明这是xml的根节点
public class User {
    private String username;
    private String password;
    private String name;
    private String age;
    private String sex;
    //private Map<String,String> map;

    public User(String username,String name,String age,String sex,String password) {
        this.username = username;
        this.password=password;
        this.name=name;
        this.age=age;
        this.sex=sex;
       /* this.map.put("fruit","apple");
        this.map.put("color","yellow");
        this.map.put("data","20191226");*/
    }

    public User(){
       /* this.map.put("fruit","apple");
        this.map.put("color","yellow");
        this.map.put("data","20191226");*/
    }
}


