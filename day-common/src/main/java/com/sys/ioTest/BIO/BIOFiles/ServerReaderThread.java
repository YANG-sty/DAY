package com.sys.ioTest.BIO.BIOFiles;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author yangLongFei 2021-03-14-16:09
 */
public class ServerReaderThread extends Thread {
    private Socket socket;

    public ServerReaderThread(Socket accept) {
        this.socket = accept;
    }

    @Override
    public void run() {
        try{
            //获得输入流，读取客户端穿过来的数据
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //文件类型
            String suffix = dataInputStream.readUTF();
            System.out.println(socket.getInetAddress() + ":" + socket.getPort() + " 文件类型: " + suffix);
            File file = new File("yang_zzu_file" + suffix);
            //字节输出流，用于保存读取的文件数据
            OutputStream outputStream = new FileOutputStream(file);
            //
            byte[] bytes = new byte[1024];
            int len;
            while ((len = dataInputStream.read(bytes)) > 0) {
                outputStream.write(bytes, 0, len);
            }
            outputStream.close();
            dataInputStream.close();
            System.out.println("ok");

        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
