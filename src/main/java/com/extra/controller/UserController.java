package com.extra.controller;

import com.extra.model.User;
import com.extra.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 戴尔 on 2017/7/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("All the user information query ");
        List<User> userList  =userService.getAllUser();
        model.addAttribute("userList",userList);
        return "showUser";
    }

    @RequestMapping(value = "/json",produces ="text/html;charset=UTF-8" )
    @ResponseBody
    public  String getJson(  String  name){
         name +="有空一起写代码啊";
        return name;
    }

    @RequestMapping("/login")
    public String toIndex(){
        System.out.println("wangshuo....show_template");
        log.info("sing in---0011--------");
        return "login";
    }


}
