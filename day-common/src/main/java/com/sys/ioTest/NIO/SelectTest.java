package com.sys.ioTest.NIO;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @author yangLongFei 2021-03-14-10:50
 */
public class SelectTest {

    @Test
    public void test1() throws Exception {
        //获取选择器
        Selector selector = Selector.open();
        //获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //切换非阻塞模式
        ssChannel.configureBlocking(false);
        //绑定连接
        ssChannel.bind(new InetSocketAddress(9898));
        /**
         * 将通道注册到选择器上, 并且指定“监听接收事件”
         * 读 : SelectionKey.OP_READ （1）
         * 写 : SelectionKey.OP_WRITE （4）
         * 连接 : SelectionKey.OP_CONNECT （8）
         * 接收 : SelectionKey.OP_ACCEPT （16）
         * 若注册时不止监听一个事件，则可以使用“位或”操作符连接。
         * int interestSet = SelectionKey.OP_READ|SelectionKey.OP_WRITE
         */
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

}
