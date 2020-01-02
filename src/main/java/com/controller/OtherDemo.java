package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaofenShentu on 2019/12/25 22:53
 */
@RestController
@RequestMapping("/test")
public class OtherDemo {

   /* @RequestMapping(value = "/id",method = RequestMethod.POST)
    public String test1(@RequestParam(value = "id") String personId){
        System.out.println("ID is"+personId);
        return "Get ID from query string of URL with value element";
    }*/

    @RequestMapping(value = "/personId",method = RequestMethod.POST)
    public String test1(@RequestParam String personId){
        System.out.println("ID is"+personId);
        return "Get ID from query string of URL with value element";
    }

}
