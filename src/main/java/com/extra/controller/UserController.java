package com.extra.controller;

import com.extra.model.Operator;
import com.extra.model.User;
import com.extra.model.response.ResponsePage;
import com.extra.service.OperatorService;
import com.extra.service.UserService;
import com.extra.utils.MD5Util;
import com.extra.utils.TimeUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    @Resource
    private OperatorService operatorService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("All the user information query ");
        List<User> userList  =userService.getAllUser();
        log.info(userList.toString());
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
        log.info("sing in---0011--------");
        return "login";
    }
    @RequestMapping(value = "/list.do",method = RequestMethod.GET)
    @ResponseBody
    public String list(Integer pageNumber, Integer pageSize, HttpSession session){
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
        String  site = request.getParameter("site");
        log.info("name："+name+"          email: "+email+"        passWord: "+pwd);

        if (isNullString(name)||isNullString(email)||isNullString(pwd)||isNullString(site)){
            return  responseFail("Information cannot be empty");
        }



        int  uID = userService.getUid();
        String uniqueNumber  = TimeUtils.getUniqueNumber(uID);
        User  user = new User();
        user.setUserName(name);
        user.setUserEmail(email);
        user.setUserPwd(MD5Util.string2MD5(pwd));
        user.setSite(site);
        user.setUniqueNumber(uniqueNumber);

        try {
            if (userService.insertUsers(user)){

                int opNum = operatorService.getOpNum(user.getId());
                Operator operator = new Operator();
                operator.setAdminID(user.getId());
                operator.setOperatorEmail(user.getUserEmail());
                operator.setOperatorName(user.getUserName());
                operator.setOperatorPwd(user.getUserPwd());
                operator.setOperatorNumber(TimeUtils.getOperatorNumber(user.getUniqueNumber(),opNum));

                if (operatorService.insertOperator(operator)){
                    return  responseSuccess("registered successfully");
                }else {
                    return  responseFail("Admin registered successfully But Operator   registration failed");
                }
            }else {
                return  responseFail("registration failed");
            }
        }catch (Exception e){
            return responseFail(e.toString());
        }

    }

}
