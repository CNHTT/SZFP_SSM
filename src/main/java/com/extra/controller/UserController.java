package com.extra.controller;

import com.extra.model.User;
import com.extra.model.response.ResponsePage;
import com.extra.service.UserService;
import com.extra.utils.DataUtils;
import com.extra.utils.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.extra.utils.DataUtils.isNullString;

/**
 * Created by 戴尔 on 2017/7/12.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    private Logger log = Logger.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("All the user information query ");
        List<User> userList  =userService.getAllUser();
        List<Integer> a=new ArrayList<Integer>();
        for (int i = 0; i <1000 ; i++) {
            a.add(i);
        }
        model.addAttribute("userList",userList);
        model.addAttribute("aaaa",a);
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
    @RequestMapping(value = "/list.do",method = RequestMethod.GET)
    @ResponseBody
    public String list(Integer pageNumber,Integer pageSize){
//
        log.info("分页查询用户信息"+pageNumber +" , "+pageSize);
        try {
            ResponsePage<User> responsePage = userService.queryByPage(pageNumber,pageSize);
            return responseResult(responsePage);
        } catch (Exception e) {
            return responseFail(e.toString());
        }
    }


    /**
     * 用户注册
     * @param request
     * @return
     */
    @RequestMapping(value = "register" ,method = RequestMethod.POST)
    @ResponseBody
    public  String userRegister(HttpServletRequest request){
        log.info("用户信息注册      ip:" + request.getRemoteAddr());
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pwd  = request.getParameter("pwd");
        log.info("name："+name+"          email: "+email+"        passWord: "+pwd);

        if (isNullString(name)||isNullString(email)||isNullString(pwd)){
            return  responseFail("信息不能为空");
        }
        System.out.println("原始：" + pwd);
        System.out.println("MD5后：" + MD5Util.string2MD5(pwd).length());
        System.out.println("加密的：" + MD5Util.convertMD5(pwd));
        System.out.println("解密的：" + MD5Util.convertMD5(MD5Util.convertMD5(pwd)));

        HashMap<String ,String> users = new HashMap<String, String>();
        users.put("username",name);
        users.put("email",email);
        users.put("pwd", MD5Util.string2MD5(pwd));

        userService.insertUsers(users);

        return responseFail("name");
    }

}
