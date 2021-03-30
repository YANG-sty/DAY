package com.sys.ioTest.BIO.BIOFiles;

import java.io.*;
import java.net.Socket;

/**
 * @author yangLongFei 2021-03-14-16:02
 */
public class BIOFilesClient {
    public static void main(String[] args) {
        try{
            File file = new File("day-common/yang_zzu.txt");
            InputStream inputStream = new FileInputStream(file);
            //与服务器连接
            Socket socket = new Socket("127.0.0.1", 9000);
            //字节输出流，包装成，数据输出流
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            //发送后缀名称
            dataOutputStream.writeUTF(".txt");
            //发送文件数据
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) > 0) {
                dataOutputStream.write(bytes, 0, len);
            }
            dataOutputStream.flush();
            //通知服务端，数据传输完毕
            socket.shutdownOutput();

            inputStream.close();
            dataOutputStream.close();

        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
