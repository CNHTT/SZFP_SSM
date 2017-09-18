package com.extra.utils;

import com.extra.model.Message;
import com.extra.model.OrderInfo;
import com.extra.model.OrderItemInfo;
import org.java_websocket.WebSocket;

import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 * Created by Extra on 2017/8/17.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class ServerThread extends Thread {
    public Socket s;

    public boolean is=true;
    public ServerThread(Socket socket) {
        this.s = socket;
    }

    public void run() {
        PrintWriter pw = null;
        Calendar c;

        is =true;
        try {
            byte[] recData = null;
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            while(is) {
                recData = new byte[1024];
                int r = in.read(recData);
                //int r = in.read(recData);
                if (r > -1) {
                    String data = new String(recData);
                    if (data.trim().equals("[OVER]")) {  //正常断开
                        s.close();
                        //socket断开之后移除本地保存的socket
                        SocketPool.removeUser(s);
                    }
                    System.out.println("读取到POS发送的来数据：" + data);

                    WebSocket webSocket = WsPool.getWsByUser("console");
                    if (webSocket!=null) WsPool.sendMessageToUser(webSocket,data.trim());

                    if (data.length()>6){

                        try {
                            Map<String,String> map = DataUtils.toMap(data.trim());
                            switch (map.get("type")){
                                case "/printer/printer":
                                    if (map.get("ak").equals("Accepted"))
                                    {
                                        Message message = new Message();
                                        message.setType("6");
                                        message.setData(map.get("m"));
                                        WebSocket socket = WsPool.getWsByUser(map.get("o"));
                                        WsPool.sendMessageToUser(socket, new GsonUtils().toJson(message));
                                    }

                                    if (map.get("ak").equals("Rejected"))
                                    {
                                        Message message = new Message();
                                        message.setType("4");
                                        message.setData(map.get("m"));
                                        WebSocket socket = WsPool.getWsByUser(map.get("o"));
                                        WsPool.sendMessageToUser(socket, new GsonUtils().toJson(message));
                                    }
                                    out.write("DONE".getBytes());
                                    break;
                                case  "/printer/verify":
                                    String sn = map.get("sn"); //正常使用时判断
                                    SocketPool.addUser(sn,s);
//                                    out.write("[NOORDER /]".getBytes());
                                    break;
                                case  "/printer/getOrder":
//                                    out.write("[NOORDER /]".getByt/es());
                                    break;
                                case  "/printer/test":
                                    //
//                                    OrderInfo
//                                            orderInfo = new OrderInfo();
//                                    orderInfo.setOrderType("2");
//                                    orderInfo.setOrderNo("000000000000001");
//                                    orderInfo.setDeliveryChg("0");
//                                    orderInfo.setCCHandelingFees("0");
//                                    orderInfo.setTotal("52RMB");
//                                    orderInfo.setCustomerType("5");
//                                    orderInfo.setCustomerName("SZFP");
//                                    orderInfo.setCustomerAddress("SHEN ZHEN   TO GUANGZHOU ");
//                                    orderInfo.setPreviousNumberoforders("0");
//                                    orderInfo.setPaymentStatus("7");
//                                    orderInfo.setPaymentCardNo("8880000001");
//                                    orderInfo.setCustomerPhone("755-8659731");
//                                    orderInfo.setEquestedFor("Faster delivery");
//                                    List<OrderItemInfo> list = new ArrayList<>();
//                                    for (int i = 0; i <4 ; i++) {
//                                        OrderItemInfo orderItemInfo=  new OrderItemInfo();
//                                        orderItemInfo.setFood("Strawberry" +i);
//                                        orderItemInfo.setQuantity("1");
//                                        orderItemInfo.setAmount("10");
//                                        list.add(orderItemInfo);
//                                    }
//                                    orderInfo.setDatas(list);
//                                    orderInfo.setTime(new Date());
//                                    out.write(responsePostResult(orderInfo).getBytes());
//                                    out.write("[NOORDER /]".getBytes());
                                    break;
                            }
                        }catch (Exception e){
                            out.write("[NOORDER /]".getBytes());
                        }

                    }else {
                        s.close();
                    }
//                    out.write("[NOORDER /]".getBytes());
                    } else {
                    //读取的数据为空
                    is=false;
                    System.out.println("数据读取完毕！");
                    s.close();
                    //socket断开之后移除本地保存的socket
                    SocketPool.removeUser(s);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {

        }
    }
    private String responsePostResult(OrderInfo orderInfo) {
        String str = "[END] \n" +
                "[ORDERNO]"+orderInfo.getOrderNo()+"[/ORDERNO]  \n" +
                "[SURNAME]"+orderInfo.getOrderNo()+"[/SURNAME]   \n" +
                "[MESSAGE]"+new GsonUtils().toJson(orderInfo)+"[/MESSAGE]  \n" +
                "[COPY]1[/COPY]";

        return  str;

    }
}