package com.extra.controller;

/**
 * Created by CT on 2017/8/20.
 */

import com.extra.model.Print;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
@RequestMapping("/printer")
public class PrintController {

    @RequestMapping("/printer")
    @ResponseBody
    public String printer(Print print){

        return "[RUB]";
    }

}
