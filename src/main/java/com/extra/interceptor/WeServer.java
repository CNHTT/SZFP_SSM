package com.extra.interceptor;

import com.extra.controller.BaseController;
import com.extra.model.Message;
import com.extra.utils.GsonUtils;
import com.extra.utils.WsPool;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

/**
 * Created by Extra on 2017/8/15.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class WeServer extends WebSocketServer {



    public WeServer(int port){
        super(new InetSocketAddress(port));
    }

    public WeServer(InetSocketAddress address) {
        super(address);
    }

    /**
     * ws连接的时候触发的代码，onOpen中我们不做任何操作
     * @param webSocket
     * @param clientHandshake
     */
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        webSocket.send("[END]");
    }

    /**
     * 断开连接时候触发代码
     * @param webSocket
     * @param i
     * @param s
     * @param b
     */
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        userLeave(webSocket);
        System.out.println(webSocket.getLocalSocketAddress().getAddress().getHostAddress());

    }

    /**
     *
     * @param conn
     * @param message
     */
    public void onMessage(WebSocket conn, String message) {
        System.out.println(message);
        Message msg = new Message();
        if (message==null)
        {conn.send(new BaseController().responseFail("Please send the correct data"));}
        else {
            try {
                    msg = new GsonUtils().toBean(message,Message.class);
                switch (msg.getType()) {
                    case "1":   //心跳包
                        conn.send(new BaseController().responseSuccess("OK"));
                        break;
                    case "2":// adminLogo
                        String adminID = msg.getType();
                        userJoin(conn, "console");
                        conn.send(new BaseController().responseSuccess("land successfully"));
                        break;
                    case "3":
                        String operatorUUID = (String) msg.getData();
                        userJoin(conn, operatorUUID);
                        conn.send("[OK]");
                        break;
                    case "5":
                        userLeave(conn);
                        System.out.print(msg.getData() + "     :   close");
                        break;
                }
            }catch (Exception e){
                conn.send(new BaseController().responseFail("Please send the correct data"));
            }
        }
    }


    public void onError(WebSocket webSocket, Exception e) {
        System.out.println("ON ERROR");
    }

    /**
     * 去除掉失效的websocket链接
     * @param conn
     */
    private void userLeave(WebSocket conn){
        WsPool.removeUser(conn);
    }
    /**
     * 将websocket加入用户池
     * @param conn
     * @param adminID
     */
    private void userJoin(WebSocket conn,String adminID){
        WsPool.addUser(adminID, conn);
    }
}
