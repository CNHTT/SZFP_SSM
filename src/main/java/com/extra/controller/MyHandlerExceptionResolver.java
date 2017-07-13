package com.extra.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Extra on 2017/7/13.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
@RequestMapping("/error")
public class MyHandlerExceptionResolver  {

    private Logger log = Logger.getLogger(MyHandlerExceptionResolver.class);

    @RequestMapping("404")
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String uri = httpServletRequest.getRequestURI();
        log.error("异常的url是：" + uri, new Exception());
        return new ModelAndView("/static/view/404.jsp");
    }
}
