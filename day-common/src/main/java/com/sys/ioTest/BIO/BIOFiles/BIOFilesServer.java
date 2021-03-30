package com.sys.ioTest.BIO.BIOFiles;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yangLongFei 2021-03-14-16:02
 */
public class BIOFilesServer {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(9000);
            while (true) {
                Socket accept = serverSocket.accept();
                new ServerReaderThread(accept).start();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
