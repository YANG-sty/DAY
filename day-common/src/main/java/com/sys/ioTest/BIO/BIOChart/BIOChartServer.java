package com.sys.ioTest.BIO.BIOChart;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangLongFei 2021-03-14-16:45
 */
public class BIOChartServer {
    public static Map<Socket, String> onLineSockets = new HashMap<>();

    public static void main(String[] args) {
        try{
            //服务端端口
            ServerSocket serverSocket = new ServerSocket(9000);
            while (true) {
                Socket accept = serverSocket.accept();
                //将客户端的请求，分配一个线程进程进行处理
                new ServerReader(accept).start();
            }

        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }



}
