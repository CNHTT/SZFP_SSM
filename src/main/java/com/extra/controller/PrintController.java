package com.extra.controller;

/**
 * Created by CT on 2017/8/20.
 */

import com.extra.model.Message;
import com.extra.model.Print;
import com.extra.utils.GsonUtils;
import com.extra.utils.WsPool;
import org.java_websocket.WebSocket;
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

        if (print.getAk().equals("Accepted"))
        {
            Message message = new Message();
            message.setType("6");
            message.setData(print.getM());
            WebSocket  socket = WsPool.getWsByUser(print.getO());
            WsPool.sendMessageToUser(socket, new GsonUtils().toJson(message));
        }

        if (print.getAk().equals("Rejected"))
        {
            Message message = new Message();
            message.setType("4");
            message.setData(print.getM());
            WebSocket  socket = WsPool.getWsByUser(print.getO());
            WsPool.sendMessageToUser(socket, new GsonUtils().toJson(message));
        }

        return "[OK]";
    }

}
