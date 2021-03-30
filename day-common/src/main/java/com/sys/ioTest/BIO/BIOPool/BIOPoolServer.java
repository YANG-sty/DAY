package com.sys.ioTest.BIO.BIOPool;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yangLongFei 2021-03-14-15:35
 */
public class BIOPoolServer {
    public static void main(String[] args) throws Exception {
        System.out.println("server ok");
        ServerSocket serverSocket = new ServerSocket(9000);
        //创建线程池
        BIOThreadPool bioThreadPool = new BIOThreadPool(3, 1000);
        //客户端多个
        while (true) {
            //阻塞式
            Socket accept = serverSocket.accept();
            System.out.println(accept.getInetAddress() + ":" + accept.getPort()  + " 上线了！");
            bioThreadPool.execute(new ReaderClientRunnable(accept));

        }
    }
}
