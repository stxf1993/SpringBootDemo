package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaofenShentu on 2019/12/25 19:10
 * 注意：1.相关的类必须和主程序类同一个包下，或者为主程序包的子包下
 * 2. @RestController相当与 @Controller + @ResponseBody 一起使用，表示整个Controller的方法返回值都是json或json对象
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "helloController中的hello方法,恭喜部署成功了你的第一个Spring服务！！";
    }
}
