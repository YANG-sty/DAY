package com.sys.ioTest.BIO.BIOPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author yangLongFei 2021-03-14-15:40
 */
public class ReaderClientRunnable implements Runnable {
    private Socket socket;
    public ReaderClientRunnable(Socket accept) {
        this.socket = accept;
    }

    @Override
    public void run() {
        try {
            //读取一行数据
            InputStream inputStream = socket.getInputStream();
            //转换成 字符流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //读取数据
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(socket.getInetAddress() + ":" + socket.getPort() + " server accept msg : " + line);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(socket.getInetAddress() + ":" + socket.getPort() + " 下线");
        }

    }
}
