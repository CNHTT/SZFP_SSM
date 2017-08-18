package com.extra.utils;

import java.io.*;
import java.net.Socket;
import java.util.Calendar;

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

    String sssss="[END] \n" +
            "[ORDERNO]000000000000001[/ORDERNO]  \n" +
            "[SURNAME]000000000000001[/SURNAME]   \n" +
            "[MESSAGE] \n" +
            "[orderType]2[orderType]\n" +
            "[ orderNo]000000000000001[ orderNo]\n" +
            "[ datas][[DATA]\n" +
            "[Quantity]AAA[Quantity]\n" +
            "[food]Strawberry0[food]\n" +
            "[amount]10[amount]\n" +
            "[DATA], [DATA]\n" +
            "[Quantity]AAA[Quantity]\n" +
            "[food]Strawberry1[food]\n" +
            "[amount]10[amount]\n" +
            "[DATA], [DATA]\n" +
            "[Quantity]AAA[Quantity]\n" +
            "[food]Strawberry2[food]\n" +
            "[amount]10[amount]\n" +
            "[DATA], [DATA]\n" +
            "[Quantity]AAA[Quantity]\n" +
            "[food]Strawberry3[food]\n" +
            "[amount]10[amount]\n" +
            "[DATA]][ datas]\n" +
            "[ deliveryChg]10RMB[ deliveryChg]\n" +
            "[ CCHandelingFees]12RMB[ CCHandelingFees]\n" +
            "[ total]52RMB[ total]\n" +
            "[ customerType]5[ customerType]\n" +
            "[ CustomerName]SZFP[ CustomerName]\n" +
            "[ CustomerAddress]SHEN ZHEN   TO GUANGZHOU [ CustomerAddress]\n" +
            "[ equestedFor]Faster delivery[ equestedFor]\n" +
            "[ previousNumberoforders]0[ previousNumberoforders]\n" +
            "[ paymentStatus]7[ paymentStatus]\n" +
            "[ paymentCardNo]8880000001\n" +
            "[ customerPhone]755-8659731[ customerPhone]\n" +
            "[ customerComments]GOOD NICE [ customerComments]\n" +
            "[/MESSAGE]  \n" +
            "[COPY]1[/COPY]";

    public void run() {
        PrintWriter pw = null;
        Calendar c;

        is =true;
        try {
            byte[] recData = null;
            SocketPool.addUser("MMMM",s);
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            while(is) {
                recData = new byte[1024];
                int r = in.read(recData);
                //int r = in.read(recData);
                if (r > -1) {
                    String data = new String(recData);
                    if (data.trim().equals("over")) {
                        s.close();
                    }
                    System.out.println("读取到客户端发送的来数据：" + data);
                    out.write(sssss.getBytes());
                } else {
                    is=false;
                    System.out.println("数据读取完毕！");
                    s.close();
                    //ss.close();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {

        }
    }

}