package com.extra.controller;

import com.extra.model.ItemGames;
import com.extra.model.Operator;
import com.extra.model.ReportHistory;
import com.extra.model.User;
import com.extra.model.response.ResponseObj;
import com.extra.model.response.ResponsePage;
import com.extra.service.OperatorService;
import com.extra.utils.GsonUtils;
import com.extra.utils.MD5Util;
import javafx.geometry.Pos;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import static com.extra.utils.DataUtils.isEmpty;
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


    /**
     *
     * @param adminID
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "getOperatorList.mp",method = RequestMethod.GET)
    @ResponseBody
    public  String   getALlOperator(Long adminID,Integer pageNumber, Integer pageSize){
        log.info("分页查询Operator信息"+pageNumber +" , "+pageSize);
        try {
            ResponsePage<Operator> responsePage = operatorService.queryByPage(pageNumber,pageSize,adminID);
            return responseResult(responsePage);
        }catch (Exception e){
           return   responseFail(e.toString());
        }
    }

    @ResponseBody
    @RequestMapping(value = "postHistory.mp",method = RequestMethod.POST)
    public String   putReportHistory(String data,HttpServletRequest request){
        if (isNullString(data))return  responseFail("Request data cannot be empty");
        log.info("postReportData: "+data);
        ReportHistory reportHistory = new GsonUtils().toBean(data,ReportHistory.class);


        try {
            if (operatorService.insertReport(reportHistory))
            {
                List<ItemGames> gamesList = reportHistory.getItemGames();
                for (ItemGames item:gamesList) {
                    item.setAdminID(reportHistory.getAdminID());
                    item.setOperatorID(reportHistory.getOperatorID());
                    item.setReportHistoryID(reportHistory.getId());
                }
                if (operatorService.insertItemGames(gamesList))
                    return responseSuccess("success");
            }
            else {
                return responseFail("submit failure");
            }

            String da = "{\"adminID\":17,\"operatorID\":5,\"AWARD_TIME\":\"12H\",\"terminalID\":\"0001\",\"ticketID\":\"010101401\",\"total\":\"0.75\",\"itemGames\":[{\"adminID\":17,\"operatorID\":5,\"itemGame\":\"A\",\"secoValue\":\"1\",\"gameKey\":\"1\",\"itemGameValue\":\"0.25\"},{\"adminID\":17,\"operatorID\":5,\"itemGame\":\"B\",\"secoValue\":\"1/5\",\"gameKey\":\"2\",\"itemGameValue\":\"0.25\"},{\"adminID\":17,\"operatorID\":5,\"itemGame\":\"C\",\"secoValue\":\"1/10\",\"gameKey\":\"3\",\"itemGameValue\":\"0.25\"}]}";
            return responseResult(reportHistory);
        }catch (
                Exception e
                ){
            return responseFail("error");
        }
    }


    /**
     *
     * @param adminID
     * @param pageNumber
     * @param pageSize
     * @return
     */

    @RequestMapping(value = "reportList.mp",method = RequestMethod.POST)
    @ResponseBody
    public String getReportList(Long adminID,Integer pageNumber, Integer pageSize){
        log.info("分页查询Report信息"+adminID+","+pageNumber +" , "+pageSize);

        try {
            ResponsePage<ReportHistory> responsePage = operatorService.queryByReportPage(pageNumber,pageSize,adminID);
            return responseResult(responsePage);
        }catch (Exception e){
            return   responseFail(e.toString());
        }
    }

    /**
     *
     * @param adminID
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value ="reportLl.mp",method = RequestMethod.POST)
    @ResponseBody
    public String getReportItemList(Long adminID,Integer pageNumber, Integer pageSize){
        log.info("分页查询Report信息"+adminID+","+pageNumber +" , "+pageSize);

        try {
            ResponsePage<ReportHistory> responsePage = operatorService.queryByReportLiPage(pageNumber,pageSize,adminID);
            return responseResult(responsePage);
        }catch (Exception e){
            return   responseFail(e.toString());
        }
    }


    @RequestMapping(value = "itemGameList.mp",method = RequestMethod.POST)
    @ResponseBody
    public String getItemGameList(Long adminID,String type,Integer pageNumber, Integer pageSize){
        log.info("分页查询Report信息"+pageNumber +" , "+pageSize);
        try {
            ResponsePage<ItemGames> responsePage = operatorService.queryByItemGameList(pageNumber,pageSize,adminID,type);
            return responseResult(responsePage);
        }catch (Exception e){
            return   responseFail(e.toString());
        }
    }
}

