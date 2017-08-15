package com.extra.controller;

import com.extra.model.Message;
import com.extra.utils.GsonUtils;
import com.extra.utils.WsPool;
import org.java_websocket.WebSocket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Extra on 2017/8/15.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

    @RequestMapping("/submit")
    @ResponseBody
    public String submitOrder(String data){
        Message message = new Message();
        try {
            String da ="http://www.cnblogs.com/roy-blog/p/7211761.html";
            message = new  GsonUtils().toBean(data,Message.class);
            WebSocket socket ;
            switch (message.getMsgType()){
                case "1":   //数据提交
                    socket = WsPool.getWsByUser(message.getAdminID());
                if (socket ==null)
                    return  responseFail("商家不在线");
                WsPool.sendMessageToUser(socket,"你有新订单，注意查收");
                return responseSuccess("订单提交成功");
                default:    //admin注册
                    return responseFail("请输入正确的参数");
            }

        }catch (Exception e){
            return  responseFail(e.toString());
        }


    }
}
