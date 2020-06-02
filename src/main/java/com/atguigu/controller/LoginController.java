package com.atguigu.controller;

import com.atguigu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yinhuidong
 * @createTime 2020-05-26-21:57
 */
@Controller
public class LoginController {
    //@ResponseBody
    @RequestMapping("/login")
    public String login(@RequestBody User user){
        System.out.println("user.getName() = " + user.getName());
        if (!user.getName().equals("root")||!user.getPassword().equals("root")){
            throw  new RuntimeException("loginError");
        }
        return "EmpList";
    }
}
