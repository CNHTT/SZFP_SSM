package com.extra.controller;

import com.extra.model.User;
import com.extra.model.response.ResponseObj;
import com.extra.service.LoginService;
import com.extra.utils.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Extra on 2017/7/13.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */

@Controller
@RequestMapping("/")
public class LoginController
{

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private LoginService loginService;

    @RequestMapping("login")
    private  String login(){
        return "login";
    }

    @RequestMapping(value = "singin" )
//    @ResponseBody
    private String userLogin(String username, ModelMap model, String password, HttpServletRequest req, HttpSession sessions){
        User user =null;
        ResponseObj<User> responseObj = new ResponseObj<User>();

        String cookies = req.getCookies()[0].getValue();


        log.info(cookies  +"              ");

        if (!DataUtils.isNullString(username)&& RegexUtils.isCheckPassWord(password))
            user = loginService.getUserInfo(username, MD5Util.string2MD5(password));

        else {
            responseObj.setCode(ResponseObj.FAILED);
            responseObj.setMsg(ResponseObj.FAILED_STR);
            responseObj.setMsg("Please input UserNameOrEmail  PassWord!");
//            return new GsonUtils().toJson(responseObj);
            req.setAttribute("data",new GsonUtils().toJson(responseObj));
            return "forward:login.jsp";
        }

        if (DataUtils.isEmpty(user)){
            responseObj.setCode(ResponseObj.EMPUTY);
            responseObj.setMsg("The user does not exist! Please check the");
//            return new GsonUtils().toJson(responseObj);
//            req.setAttribute("error",new GsonUtils().toJson(responseObj));
            req.setAttribute("username",username);
            req.setAttribute("pwd",password);
            req.setAttribute("error",new GsonUtils().toJson(responseObj));
            return "forward:login";
        }else {


            user.setUserPwd(req.getSession().getId());
            responseObj.setData(user);
            responseObj.setCode(ResponseObj.OK);
            responseObj.setMsg("登录成功");
            req.setAttribute("user",user.getUserName());
            model.addAttribute("data",new GsonUtils().toJson(responseObj));
            return "showAllList";
//            return new GsonUtils().toJson(responseObj);
        }
    }
}
