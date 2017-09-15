package com.extra.interceptor;

import com.extra.model.OrderInfo;
import com.extra.model.OrderItemInfo;
import com.extra.utils.GsonUtils;
import com.extra.utils.SocketPool;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Extra on 2017/8/17.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class SocketService {

    public SocketService(){

    }


    public  void oneServer(){
        ServerSocket serverSocket=null;
        //定义一个容量为50的线程
        ExecutorService service = Executors.newFixedThreadPool(50);
        try {
            serverSocket = new ServerSocket(7781);
            while(true){
                System.out.println("wait receive message from client...");
                //接收客户端连接的socket对象
                Socket connection =null;
                //接收客户端传过来的数据，会阻塞
                connection=serverSocket.accept();
                service.submit(new SubThread(connection));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (serverSocket!=null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class SubThread extends Thread{
        private Socket connection;
        public SubThread(Socket conSocket){
            this.connection=conSocket;
        }

        public void run(){
            try {

                System.out.println("****received message from client******");

                //读取客户端传过来的数据
                readMessageFromClient(connection.getInputStream());
                SocketPool.addUser("MMMM",connection);

                System.out.println("****received message from client end******");
                System.out.println();
                OrderInfo orderInfo;
                orderInfo = new OrderInfo();
                orderInfo.setOrderType("2");
                orderInfo.setOrderNo("000000000000001");
                orderInfo.setDeliveryChg("10RMB");
                orderInfo.setCCHandelingFees("12RMB");
                orderInfo.setTotal("52RMB");
                orderInfo.setCustomerType("5");
                orderInfo.setCustomerName("SZFP");
                orderInfo.setCustomerAddress("SHEN ZHEM   TO GUANGZHOU ");
                orderInfo.setPreviousNumberoforders("0");
                orderInfo.setPaymentStatus("7");
                orderInfo.setPaymentCardNo("8880000001");
                orderInfo.setCustomerPhone("755-8659731");
                orderInfo.setCustomerComments("GOOD NICE ");
                orderInfo.setRequestedfor(new Date());
                List<OrderItemInfo> list = new ArrayList<>();
                for (int i = 0; i <4 ; i++) {
                    OrderItemInfo orderItemInfo=  new OrderItemInfo();
                    orderItemInfo.setFood("Strawberry" +i);
                    orderItemInfo.setFoodId(Long.valueOf(i));
                    orderItemInfo.setAmount("10");
                    list.add(orderItemInfo);
                }
//                orderInfo.setDatas(list);

                //向客户端写入数据
                writeMsgToClient(connection.getOutputStream(),"[END]");
//                writeMsgToClient(connection.getOutputStream(),"{\"code\":1,\"msg\":\"success\",\"data\":{\"orderType\":\"2\",\"orderNo\":\"000000000000001\",\"datas\":[{\"foodId\":0,\"food\":\"Strawberry0\",\"amount\":\"10\"},{\"foodId\":1,\"food\":\"Strawberry1\",\"amount\":\"10\"},{\"foodId\":2,\"food\":\"Strawberry2\",\"amount\":\"10\"},{\"foodId\":3,\"food\":\"Strawberry3\",\"amount\":\"10\"}],\"deliveryChg\":\"10RMB\",\"CCHandelingFees\":\"12RMB\",\"total\":\"52RMB\",\"customerType\":\"5\",\"CustomerName\":\"SZFP\",\"CustomerAddress\":\"SHEN ZHEM TO GUANGZHOU \",\"equestedFor\":\"Faster delivery\",\"previousNumberoforders\":\"0\",\"paymentStatus\":\"7\",\"paymentCardNo\":\"8880000001\",\"customerPhone\":\"755-8659731\",\"customerComments\":\"GOOD NICE \"}}");

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                if (connection!=null) {
                    try {
                        connection .close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /**
         * 读取客户端信息
         * @param inputStream
         */
        private  void readMessageFromClient(InputStream inputStream) throws IOException {
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(reader);
            String a = null;
            while((a=br.readLine())!=null){
                System.out.println(a);
            }
        }

        /**
         * 响应客户端信息
         * @param outputStream
         * @param string
         */
        private  void writeMsgToClient(OutputStream outputStream, String string) throws IOException {
            Writer writer = new OutputStreamWriter(outputStream);
            writer.append(string);
            writer.flush();
            writer.close();
        }
    }

}
