package com.sys.ioTest.BIO.BIOChart;

import sun.security.pkcs11.wrapper.Constants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Set;

/**
 * @author yangLongFei 2021-03-14-16:50
 */
public class ServerReader extends Thread{
    private Socket socket;
    public ServerReader(Socket accept) {
        this.socket = accept;
    }

    @Override
    public void run() {
        DataInputStream dataInputStream = null;
        try{
            dataInputStream = new DataInputStream(socket.getInputStream());
            while (true) {
                //读取信息类型
                /**
                 * * 1代表接收的是登陆消息
                 * * 2代表群发| @消息
                 * * 3代表了私聊消息
                 */
                int msgType = dataInputStream.readInt();
                if (msgType == 1) {
                    String name = dataInputStream.readUTF();
                    System.out.println(socket.getInetAddress() + ":" + socket.getPort() + " " + name + " ---> " + socket.getRemoteSocketAddress());
                    BIOChartServer.onLineSockets.put(socket, name);
                }
                writeMsg(msgType, dataInputStream);
            }

        }catch(Exception e){
            System.out.println(socket.getInetAddress() + ":" + socket.getPort() + " 下线");
            //从在线人数中将当前 socket 移除出去
            BIOChartServer.onLineSockets.remove(socket);
            try {
                //更新在线人数并发给所有客户端
                writeMsg(1, dataInputStream);

            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void writeMsg(int msgType, DataInputStream dataInputStream) throws Exception {

        String msg = null;
        if (msgType == 1) {
            //读取所有在线人数发给所有客户端，更新在线人数
            StringBuilder stringBuilder = new StringBuilder();
            Collection<String> onlineNames = BIOChartServer.onLineSockets.values();
            //判断是否存在在线人数
            if (onlineNames != null && onlineNames.size() > 0) {
                for (String onlineName : onlineNames) {
                    stringBuilder.append(onlineName + Constants.NEWLINE);
                }
                //去掉最后一个分隔符
                stringBuilder.substring(0, stringBuilder.lastIndexOf(Constants.NEWLINE));
                //将消息发送给所有客户端
                sendMsgToAll(msgType, stringBuilder.toString());

            } else if(msgType ==2 || msgType == 3) {
                //读到消息， 群发，或者， @某人
                String newMsg = dataInputStream.readUTF();
                //发件人
                String sendName = BIOChartServer.onLineSockets.get(socket);
                //内容
                StringBuilder msgFinal = new StringBuilder();
                //时间
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");
                //@某人
                if (msgType == 2) {
                    msgFinal.append(sendName).append(" ").append(dateFormat.format(System.currentTimeMillis())).append("\r\n");
                    msgFinal.append(" ").append(newMsg).append("\r\n");
                    sendMsgToAll(msgType, msgFinal.toString());

                } else if (msgType == 3) {
                    //私发消息
                    msgFinal.append(sendName).append(" ").append(dateFormat.format(System.currentTimeMillis())).append("对你私发\r\n");
                    msgFinal.append(" ").append(newMsg).append("\r\n");
                    //私发
                    String destName = dataInputStream.readUTF();
                    sendMsgToOne(destName, msgFinal.toString());
                }


            }

        }

    }

    /**
     * 给单个人发信息
     */
    private void sendMsgToOne(String destName, String toString) throws Exception {
        Set<Socket> allOnLineSockets = BIOChartServer.onLineSockets.keySet();
        for (Socket socket : allOnLineSockets) {
            if (BIOChartServer.onLineSockets.get(socket).trim().equals(destName)) {
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeInt(2);
                dataOutputStream.writeUTF(toString);
                dataOutputStream.flush();
            }
        }
    }

    /**
     * 给所有人发信息
     */
    private void sendMsgToAll(int msgType, String stringBuilder) throws IOException {
        //拿到所有在线 socket，
        Set<Socket> allOnlineSockets = BIOChartServer.onLineSockets.keySet();
        for (Socket allOnlineSocket : allOnlineSockets) {
            DataOutputStream dataOutputStream = new DataOutputStream(allOnlineSocket.getOutputStream());
            //消息类型
            dataOutputStream.writeInt(msgType);
            dataOutputStream.writeUTF(stringBuilder);
            dataOutputStream.flush();
        }
    }

}
