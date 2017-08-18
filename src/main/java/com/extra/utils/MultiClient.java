package com.extra.utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Extra on 2017/8/18.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public   class MultiClient {

    private static final int PORT = 1234;

    private static final int BUFFER_SIZE = 1024;


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            ServerSocket ss = new ServerSocket(PORT);
            Socket s = ss.accept();
            System.out.println("这是服务端，监听本机"+PORT+"端口");
            byte[] recData = null;
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            while(true) {
                recData = new byte[BUFFER_SIZE];
                int r = in.read(recData);
                //int r = in.read(recData);
                if(r>-1) {
                    String data = new String(recData);
                    if(data.trim().equals("over")) {
                        s.close();
                    }
                    System.out.println("读取到客户端发送的来数据："+data);
                    out.write("这是服务端发给客户端的数据：".getBytes());
                    out.write(recData);
                }else {
                    System.out.println("数据读取完毕！");
                    s.close();
                    //ss.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void  startAction(){
            ServerSocket serverSocket=null;
            try {
                serverSocket=new ServerSocket(7747);  //端口号
                //通过死循环开启长连接，开启线程去处理消息
                while(true){
                    Socket socket=serverSocket.accept();
                    new Thread(new MyRuns(socket)).start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (serverSocket!=null) {
                        serverSocket.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        class MyRuns implements Runnable{

            Socket socket;
            BufferedReader reader;
            BufferedWriter writer;

            public MyRuns(Socket socket) {
                super();
                this.socket = socket;
            }

            public void run() {
                try {
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//读取客户端消息
                    writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//向客户端写消息
                    String lineString="";

                    while(!(lineString=reader.readLine()).equals("bye")){
                        writer.write("服务器返回："+lineString+"\n");
                        writer.flush();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (reader!=null) {
                            reader.close();
                        }
                        if (writer!=null) {
                            writer.close();
                        }
                        if (socket!=null) {
                            socket.close();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }

        }
    }
