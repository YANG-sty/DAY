package com.sys.ioTest.BIO.BIOPool;

import java.io.*;
import java.net.Socket;

/**
 * @author yangLongFei 2021-03-14-15:27
 */
public class BIOPoolClint {

    public static void main(String[] args) throws Exception {
        //与服务端，建立连接，套接字
        Socket socket = new Socket("127.0.0.1", 9000);
        //从 socket管道中获取一个输出流，写数据到服务端
        OutputStream outputStream = socket.getOutputStream();
        //输出流包装成，打印流
        PrintWriter printWriter = new PrintWriter(outputStream);
        //多次接收用户的输入信息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            printWriter.println(line);
            printWriter.flush();
        }
    }
}
