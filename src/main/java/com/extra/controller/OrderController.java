package com.extra.controller;

import com.extra.interceptor.SocketService;
import com.extra.interceptor.WeServer;
import com.extra.model.*;
import com.extra.model.response.ResponsePage;
import com.extra.service.OrderService;
import com.extra.utils.*;
import com.google.gson.reflect.TypeToken;
import org.java_websocket.WebSocket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Extra on 2017/8/15.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
   @Resource
    private OrderService orderService;

    private static final int PORT = 7781;
    Socket sk ;
    private static final int BUFFER_SIZE = 1024;
   @RequestMapping("order")
   @ResponseBody
   public  String order(){
       try {
               ServerSocket ss = new ServerSocket(PORT);
           System.out.println("这是服务端，监听本机"+PORT+"端口");
           while(true)     //服务器端一直监听这个端口，等待客户端的连接
           {
               sk = ss.accept();  //当有客户端连接时，产生阻塞
               System.out.println("get a socket object...");
               new ServerThread(sk).start();//新建一个socketThread处理这个客户端的socket连接
           }

//
//               System.out.println("这是服务端，监听本机"+PORT+"端口");
//               byte[] recData = null;
//               SocketPool.addUser("MMMM",s);
//               InputStream in = s.getInputStream();
//               OutputStream out = s.getOutputStream();
//               while(true) {
//                   recData = new byte[BUFFER_SIZE];
//                   int r = in.read(recData);
//                   //int r = in.read(recData);
//                   if(r>-1) {
//                       String data = new String(recData);
//                       if(data.trim().equals("over")) {
//                           s.close();
//                       }
//                       System.out.println("读取到客户端发送的来数据："+data);
//                       out.write("[NOORDER /]".getBytes());
//                   }else {
//                       System.out.println("数据读取完毕！");
//                       s.close();
//                       //ss.close();
//                   }
//               }
           } catch (IOException e) {
               e.printStackTrace();
           System.out.println("1111111111111111111111111111111111111");
           }
       return "ok";
   }

    OrderInfo orderInfo;
    @RequestMapping("/submit")
    @ResponseBody
    public String submitOrder(String datas,
                              String customerName,
                              String customerAddress,
                              String  customerPhone,
                              String remark,
                              Model  model){
//        Message message = new Message();
        try {
//            message = new  GsonUtils().toBean(data,Message.class);
//            Socket socket1 = SocketPool.getWsByUser("MMMM");
            int  socketsize =  SocketPool.getWsUserMap().size();
            WebSocket webSocket = WsPool.getWsByUser("MMMMM");
            List<OrderItemInfo> items = (List<OrderItemInfo>) new GsonUtils().fromJson(datas, new TypeToken<List<OrderItemInfo>>(){}.getType());
            List<OrderFoodGroups> foodGroupsList = new ArrayList<>();

            OrderFoodGroups orderFoodGroups;
            if (items!=null){//正常开发zhong不建议这样做
                for (int i = 0; i <items.size() ; i++) {

                    OrderItemInfo  item = items.get(i);
                    if (i==0)
                    {
                        orderFoodGroups = new OrderFoodGroups();
                        orderFoodGroups.setClassName(item.getClassName());
                        orderFoodGroups.setId(orderService.getClassNameId(item.getClassName()));
                        List<OrderItemInfo>    foodItems1=new ArrayList<>();
                        for (OrderItemInfo info:items) {
                            if (info.getClassName().equals(orderFoodGroups.getClassName()))
                                foodItems1.add(info);


                        }
                        orderFoodGroups.setItem(foodItems1);
                        foodGroupsList.add(orderFoodGroups);
                    }

                    boolean in =false;
                    for (int j = 0; j <foodGroupsList.size() ; j++) {
                        OrderFoodGroups groups =foodGroupsList.get(j);
                        if (groups.getClassName().equals(item.getClassName()))in=true;
                    }

                    if (!in){
                            orderFoodGroups = new OrderFoodGroups();
                            orderFoodGroups.setClassName(item.getClassName());
                            orderFoodGroups.setId(orderService.getClassNameId(item.getClassName()));
                            List<OrderItemInfo>     foodItems2=new ArrayList<>();
                            for (OrderItemInfo info:items) {
                                if (info.getClassName().equals(orderFoodGroups.getClassName())){
                                    foodItems2.add(info);
                                }

                            }
                            orderFoodGroups.setItem(foodItems2);
                            foodGroupsList.add(orderFoodGroups);
                    }
                }

            }
            if (socketsize>0||webSocket!=null){
                orderInfo = new OrderInfo();
                orderInfo.setOrderType("2");
                orderInfo.setOrderNo("No"+TimeUtils.generateSequenceNo());
                orderInfo.setDeliveryChg("0");
                orderInfo.setCCHandelingFees("0");
                orderInfo.setCustomerType("Not Verified");
                orderInfo.setCustomerName(customerName);
                orderInfo.setCustomerAddress(customerAddress);
                orderInfo.setPreviousNumberoforders("0");
                orderInfo.setPaymentStatus("Order paid");
                orderInfo.setPaymentMethod("Cash On");
                orderInfo.setCustomerPhone(customerPhone);
                orderInfo.setRemark(remark);
                orderInfo.setRequestedfor(new Date());

                orderInfo.setTime(new Date());
                int total =0 ;

//                orderInfo.setDatas(foodGroupsList);

                List<MeunItems> meunItemsList= new ArrayList<>();
                MeunItems meunItems1 = new MeunItems();
                 meunItems1.setId(1);
                 meunItems1.setItemName("Chicken Pizza");
                 meunItems1.setDescription("Large");
                 meunItems1.setQuantity("2");
                 meunItems1.setPrice("30");
                 List<Choices> choicesList =  new ArrayList<>();

                Choices choices1 = new Choices();
                choices1.setId(1);
                choices1.setName("Extra Cheese(2)");
                choicesList.add(choices1);
                Choices choices2 = new Choices();
                choices2.setId(2);
                choices2.setName("Onions");
                choicesList.add(choices2);
                Choices choices3 = new Choices();
                choices3.setId(3);
                choices3.setName("Pepsi(2)");
                choicesList.add(choices3);
                Choices choices4 = new Choices();
                choices4.setId(4);
                choices4.setName("Coke(2)");
                choicesList.add(choices4);
                meunItems1.setChoices(choicesList);

                meunItemsList.add(meunItems1);
                MeunItems meunItems2= new MeunItems();
                meunItems2.setId(2);
                meunItems2.setItemName("Chicken Roast");
                meunItems2.setDescription("Full Chicken");
                meunItems2.setQuantity("1");
                meunItems2.setPrice("10");
                List<Choices> choicesList2 =  new ArrayList<>();

                Choices choices5 = new Choices();
                choices5.setId(1);
                choices5.setName("Extra Cheese(1)");
                choicesList2.add(choices5);
                Choices choice6 = new Choices();
                choice6.setId(2);
                choice6.setName("MayoSauce");
                choicesList2.add(choice6);
                Choices choices7 = new Choices();
                choices7.setId(3);
                choices7.setName("Pepsi(2)");
                choicesList2.add(choices7);
                Choices choices8= new Choices();
                choices8.setId(4);
                choices8.setName("Coke(2)");
                choicesList2.add(choices8);
                meunItems2.setChoices(choicesList);
                meunItemsList.add(meunItems2);

                MeunItems meunItems3= new MeunItems();
                meunItems3.setId(2);
                meunItems3.setItemName("age");
                meunItems3.setDescription("chicken");
                meunItems3.setQuantity("1");
                meunItems3.setPrice("10");
                meunItems3.setChoices(new ArrayList<Choices>());
                meunItemsList.add(meunItems3);

                orderInfo.setMeun_items(meunItemsList);









//                for (int i = 0; i <items.size() ; i++) {
//                    int aa =Integer.valueOf(items.get(i).getQuantity())*Integer.valueOf(items.get(i).getAmount());
//                    items.get(i).setAmount(String.valueOf(aa));
//                    total=+Integer.valueOf(items.get(i).getAmount());
//                }
                orderInfo.setTotal(String.valueOf(50));
                if (socketsize>0)SocketPool.sendMessageToAll(responsePostResult(orderInfo));
//                if (webSocket!=null)WsPool.sendMessageToUser(webSocket,responseResult(orderInfo));
                return responseSuccess(orderInfo.getOrderNo());
            }else {
                return  responseFail("Businesses are not online");
            }
//            switch (message.getType()){
//                case "1":   //数据提交
//                    socket = WsPool.getWsByUser("MMMMM");
//                if (socket ==null)
//                    return  responseFail("商家不在线");
//                    orderInfo = new OrderInfo();
//                    orderInfo.setOrderType("2");
//                    orderInfo.setOrderNo("000000000000001");
//                    orderInfo.setDeliveryChg("10RMB");
//                    orderInfo.setCCHandelingFees("12RMB");
//                    orderInfo.setTotal("52RMB");
//                    orderInfo.setCustomerType("5");
//                    orderInfo.setCustomerName("SZFP");
//                    orderInfo.setCustomerAddress("SHEN ZHEN   TO GUANGZHOU ");
//                    orderInfo.setPreviousNumberoforders("0");
//                    orderInfo.setPaymentStatus("7");
//                    orderInfo.setPaymentCardNo("8880000001");
//                    orderInfo.setCustomerPhone("755-8659731");
//                    orderInfo.setCustomerComments("GOOD NICE ");
//                    orderInfo.setEquestedFor("Faster delivery");
//                    List<OrderItemInfo> list = new ArrayList<>();
//                     for (int i = 0; i <4 ; i++) {
//                        OrderItemInfo orderItemInfo=  new OrderItemInfo();
//                        orderItemInfo.setFood("Strawberry" +i);
//                        orderItemInfo.setQuantity("AAA");
//                        orderItemInfo.setAmount("10");
//                        list.add(orderItemInfo);
//                    }
//                    orderInfo.setDatas(list);
//
//
//
//                WsPool.sendMessageToUser(socket,responseResult(orderInfo));
//                if (socket!=null) SocketPool.sendMessageToAll(responsePostResult(orderInfo));
//                return responseSuccess(responseResult(orderInfo));
//                default:    //admin注册
//                    return responseFail("请输入正确的参数");
//            }

        }catch (Exception e){
            return  responseFail("Please enter correct data");
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

    @RequestMapping("success")
    public String success(String no,Model model){
        model.addAttribute("no",orderInfo.getOrderNo());
        return "order_success";
    }
    @RequestMapping("error")
    public String errot(String error,Model model){
        model.addAttribute("error",error);
        return  "order_error";
    }

    @RequestMapping("/getOrder")
    @ResponseBody
    public String getOrder(){
        try {
            if (orderInfo==null){
                return "[END]";
            }

            String data = responseResult(orderInfo);
            orderInfo=null;
            return data ;
        }catch (Exception e){
            return responseFail(e.toString());
        }
    }
    @RequestMapping("/allShop")
    @ResponseBody
    public String getAllFood(Long adminID){
        try {
            return responseResult(orderService.getAllFood(adminID));
        }catch (Exception e){
            return responseFail(e.toString());
        }
    }
    @RequestMapping("/allShopClass")
    @ResponseBody
    public String getAllFoodGroups(Long adminID){
        try {
            return responseResult(orderService.getAllFoodGroups(adminID));
        }catch (Exception e){
            return responseFail(e.toString());
        }
    }
    @RequestMapping("/allShopItem")
    @ResponseBody
    public String getFoodItemForGroups(Long id){
        try {
            return responseResult(orderService.getFoodItemForGroups(id));
        }catch (Exception e){
            return responseFail(e.toString());
        }
    }
    @RequestMapping("/shopItem")
    @ResponseBody
    public String getShopItem(Long adminID,Integer pageNumber, Integer pageSize){
        try {
            ResponsePage<FoodItem> responsePage = orderService.queryByPage(pageNumber,pageSize,adminID);
            return responseResult(responsePage);
        }catch (Exception e){
            return responseFail(e.toString());
        }
    }
    @RequestMapping("/shopping")
    public String shopping(Long adminID,Integer pageNumber, Integer pageSize){
        return "order";
    }
}
