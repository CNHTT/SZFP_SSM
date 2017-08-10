package com.extra.controller;

import com.extra.model.Operator;
import com.extra.model.User;
import com.extra.model.response.ResponseObj;
import com.extra.model.response.ResponsePage;
import com.extra.service.OperatorService;
import com.extra.utils.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.List;

import static com.extra.utils.DataUtils.isNullString;

/**
 * Created by Extra on 2017/8/10.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
@RequestMapping("/operator")
public class OperatorController extends BaseController {
    private Logger log = Logger.getLogger(UserController.class);

    @Resource
    private OperatorService operatorService;


    /**
     * 设备登录获取账号信息
     * @param nameOrEmail
     * @param password
     * @return
     */
    @RequestMapping(value = "login.mp",method = RequestMethod.POST)
    @ResponseBody
    public String operatorLoginDevice(String nameOrEmail,String password){
        Operator operator = new Operator();
        ResponseObj<Operator> responseObj = new ResponseObj<Operator>();
        if (isNullString(nameOrEmail)||isNullString(password)){
            return  responseFail("Please Input parameter");
        }

        operator.setOperatorName(nameOrEmail);
        operator.setOperatorPwd(MD5Util.string2MD5(password));

        try {
            operator = operatorService.loginMP(operator);
            if (operator == null){
                return  responseFail("Accounts do not exist or are disabled");
            }else {
                return responseResult(operator);
            }
        }catch (Exception e){
            return  responseFail(e.toString());
        }
    }


    @RequestMapping(value = "getAllOperator",method = RequestMethod.POST)
    @ResponseBody
    public  String   getALlOperator(Long adminID,Integer pageNumber, Integer pageSize, ){
        log.info("分页查询Operator信息"+pageNumber +" , "+pageSize);
        try {
            ResponsePage<Operator> responsePage = operatorService.queryByPage(pageNumber,pageSize,adminID);
            return responseResult(responsePage);
        }catch (Exception e){
            responseFail(e.toString());
        }

    };



}
