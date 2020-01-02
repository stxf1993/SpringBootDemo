package com.controller;

import com.bean.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xiaofenShentu on 2019/12/25 19:59
 */
@RestController
@RequestMapping("/V1")
public class FormMethod {
    //用此变量来装我们的cookie信息
    private static Cookie cookie;


    /**
     * login 是一个post请求接口，接收两个form表单参数
     *如果登陆成功，返回String字符串，提示恭喜登陆成功
     * 登陆成功，给respon添加一个cookie，cookie名是login，值是success
     */

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //swagger注释，用户登陆成功获取到Cookie，再访问其他接口获取到列表
    @ApiOperation(value = "登陆接口，登陆后获取Cookie", httpMethod = "POST")
    //需要给返回结果增加cookie,所以传入HttpServletResponse；另外单独设置请求参数
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String username,
                        @RequestParam(value = "password", required = true) String password) {
        if (username.equals("stxf") && password.equals("123456")) {
            cookie = new Cookie("login", "success");
            response.addCookie(cookie);
            return "恭喜登陆成功";
        }
        return "账号密码错误";

    }


    /**
     *POST接口
     * 接收一个json，json的实体类是User
     * 并判断请求中的cookie是否正确
     * 返回String响应结果
     */

    ////需要获取请求的cookie，所以传入HttpServletRequest；另外请求体用了自定义的类User
    @RequestMapping(value = "/get/user/list", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User u) {
        com.bean.User user;
        Cookie[] cookies = request.getCookies();

        //遍历所有的cookie,找到login的那个判断是否符合条件
        //符合则判断传参是否正确，正确则返回string，，错误则返回参数错误；遍历完所有cookie都没找到则返回cookie错误
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("success")) {
                if (u.getUsername().equals("toly") && u.getPassword().equals("123456")) {
                    user = new com.bean.User();
                    user.setUsername("TUTU");
                    user.setAge("3");
                    user.setSex("BOY");
                    return user.toString();
                } else {
                    return "cookie正确，参数错误！";
                }
            }

        } return "cookie错误！";

    }


    //调试用的方法
    @RequestMapping(value = "/getString",method = RequestMethod.GET)
    public String getString(){

        return "getStringSuccess";
    }


}
