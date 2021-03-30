package com.sys.ioTest.NIO;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author yangLongFei 2021-03-14-11:45
 */
public class NIOClint {

    //定义相关属性
    private final String HOST = "127.0.0.1";
    //服务器端口
    private final int PORT = 9000;
    //选择器
    private Selector selector;
    //通道
    private SocketChannel socketChannel;
    private String userName;

    /**
     * 构造器，初始化工作
     */
    public NIOClint() throws Exception{
        //创建选择器
        selector = Selector.open();
        //连接服务器
        socketChannel = socketChannel.open(new InetSocketAddress(HOST, PORT));
        //非阻塞
        socketChannel.configureBlocking(false);
        //通道注册到 select
        socketChannel.register(selector, SelectionKey.OP_READ);
        userName = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(userName + " is ok ");

    }

    /**
     * 向服务器发送消息
     */
    public void setndInfo(String info) throws IOException {
        info = userName + "说: " + info;
        socketChannel.write(ByteBuffer.wrap(info.getBytes()));
    }

    /**
     * 读取服务器端回复的消息
     */
    public void readInfo() throws Exception {
        //获得选择器上的，通道数量
        if (selector.select() > 0) {
            Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
            while (selectionKeyIterator.hasNext()) {
                SelectionKey selectionKey = selectionKeyIterator.next();
                //如果是读通道进行，读的操作
                if (selectionKey.isReadable()) {
                    //得到相关的通道
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    //缓冲区
                    ByteBuffer byteBuffer = ByteBuffer.allocate(10);
                    StringBuilder stringBuilder = new StringBuilder();
                    int len = 0;
                    while ((len = channel.read(byteBuffer)) > 0) {
                        //设置缓冲区界限
                        byteBuffer.flip();
                        stringBuilder.append(new String(byteBuffer.array(), 0, len));
                        //清除缓冲区
                        byteBuffer.clear();
                    }
                    System.out.println(stringBuilder.toString());

                } else {
                    //其他通道不进行任何操作
                }

                //移除遍历过的事件
                selectionKeyIterator.remove();

            }

        }
    }

    public static void main(String[] args) throws Exception {
        NIOClint nioClint = new NIOClint();
        //开启从服务端拉取消息的线程
        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    nioClint.readInfo();
                    Thread.currentThread().sleep(3000);
                }
            }
        }.start();

        //录入信息
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            nioClint.setndInfo(s);
        }
    }

}
