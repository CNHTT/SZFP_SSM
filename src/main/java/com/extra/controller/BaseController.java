package com.extra.controller;

import com.extra.model.response.ResponseObj;
import com.extra.utils.DataUtils;
import com.extra.utils.GsonUtils;
import org.apache.log4j.Logger;

/**
 * Created by CT on 2017/7/15.
 */
public class BaseController {

    protected Logger log = Logger.getLogger(UserController.class);

    protected final static String DATE_FORMATE = "yyyy-MM-dd";


    /**
     * 返回数据
     * @param obj
     * @return json
     */
    public String responseResult(Object obj){
        ResponseObj<Object>  resp = new ResponseObj<Object>();
        if (DataUtils.isEmpty(obj)){
            resp.setCode(ResponseObj.EMPUTY);
            resp.setMsg(ResponseObj.EMPUTY_STR);
        }else {
            resp.setCode(ResponseObj.OK);
            resp.setMsg(ResponseObj.OK_STR);
            resp.setData(obj);
        }
        log.info("system.out: "+new GsonUtils().toJson(resp));
        return new GsonUtils().toJson(resp);
    }


    public String responseFail(String error){
        ResponseObj<String> resp = new ResponseObj<String>();
        resp.setMsg(error);
        resp.setCode(ResponseObj.FAILED);
        log.info("system.out: "+new GsonUtils().toJson(resp));
        return new GsonUtils().toJson(resp);
    }




}
