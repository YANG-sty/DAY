package com.sys.ioTest.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * 群聊系统，服务端
 * @author yangLongFei 2021-03-14-10:59
 */
public class NIOServer {
    //定义属性
    //选择器
    private Selector selector;
    //通道
    private ServerSocketChannel serverSocketChannel;
    private static final int PORT = 9000;

    //构造器，初始化工作
    public NIOServer() throws Exception {
        //获取选择器
        selector = Selector.open();
        //获取通道
        serverSocketChannel = ServerSocketChannel.open();
        //非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress(PORT));
        //通道注册到选择器，指定事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    //监听
    public void listen() throws Exception {
        System.out.println("监听线程：" + Thread.currentThread().getId() + " : " + Thread.currentThread().getName());
        while (selector.select() > 0) {
            System.out.println("开始");
            //获取选择器中，注册的事件
            Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
            //遍历注册的事件
            while (selectionKeyIterator.hasNext()) {
                //获取就绪的事件
                SelectionKey selectionKey = selectionKeyIterator.next();
                //判断事件种类，进行相应的处理
                if (selectionKey.isAcceptable()) {
                    //时间为注册事件
                    //通道
                    SocketChannel channel = serverSocketChannel.accept();
                    //非阻塞模式
                    channel.configureBlocking(false);
                    //注册到选择器
                    channel.register(selector, SelectionKey.OP_READ);
                    System.out.println(channel.getRemoteAddress() + " 上线 ");
                } else if (selectionKey.isReadable()) {
                    //事件为，读事件
                    readData(selectionKey);
                }

                //删除遍历过的事件
                selectionKeyIterator.remove();
            }

        }

    }

    private void readData(SelectionKey selectionKey) throws IOException {
        //通道
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) selectionKey.channel();
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
            System.out.println("readMessage: "+stringBuilder.toString());
            //转发消息
            sendInforAll(stringBuilder.toString(), channel);

        } catch (Exception e) {
            try{
                System.out.println(channel.getRemoteAddress() + " 离线！");
                e.printStackTrace();
                //取消注册
                selectionKey.cancel();
                //关闭通道
                channel.close();
            }catch(Exception e2){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * 转发消息
     */
    private void sendInforAll(String msg, SocketChannel channel) throws Exception {
        System.out.println("转发线程： " + Thread.currentThread().getName());
        //遍历所有的通道
        for (SelectionKey key : selector.keys()) {
            //获得通道
            Channel targetChannel = key.channel();
            if (targetChannel instanceof SocketChannel && targetChannel != channel) {
                SocketChannel socketChannel = (SocketChannel) targetChannel;
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                //将buffer 写入通道
                socketChannel.write(buffer);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //创建服务对象
        NIOServer nioServer = new NIOServer();
        nioServer.listen();

    }
}
