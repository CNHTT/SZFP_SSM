package com.extra.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CT on 2017/7/23.
 */
@Controller
@RequestMapping("/home")
public class MainController {
    private Logger log = Logger.getLogger(UserController.class);


    @RequestMapping(method = RequestMethod.GET)
    public String Home()
    {
        return "main";
    }

    @RequestMapping("/showALlList")
    public String showMainData(){
        return "main_data";
    }




}
