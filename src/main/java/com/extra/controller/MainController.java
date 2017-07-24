package com.extra.controller;

import com.extra.utils.SessionUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by CT on 2017/7/23.
 */
@Controller
@RequestMapping("/admin")
public class MainController {
    private Logger log = Logger.getLogger(UserController.class);


    @RequestMapping("/main")
    public String Home()
    {
        return "main";
    }

    @RequestMapping("/option")
    public String showOption(int option, Model model){
        model.addAttribute(SessionUtils.OPTION_ID,option);
        return  "main_option";
    }

    @RequestMapping("/showALlList")
    public String showMainData(){
        return "main_data";
    }

}
