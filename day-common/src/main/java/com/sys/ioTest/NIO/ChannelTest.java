package com.sys.ioTest.NIO;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO 通道测试类
 * @author yangLongFei 2021-03-13-20:50
 */
public class ChannelTest {

    /**
     * 写数据，到文件
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {

        //字节输出流通向目标文件
        FileOutputStream outputStream = new FileOutputStream("yang_zzu.txt");
        //字节输出流对应的通道 channel
        FileChannel channel = outputStream.getChannel();
        //缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("yang_zzu博客地址： https://blog.csdn.net/yang_zzu/".getBytes());
        //缓冲区切换成写出模式，设置缓冲区界限
        buffer.flip();
        channel.write(buffer);
        channel.close();
        System.out.println("ok");

    }

    /**
     * 从文件读出数据
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        //字节文件 输入流
        FileInputStream fileInputStream = new FileInputStream("yang_zzu.txt");
        //获得通道
        FileChannel channel = fileInputStream.getChannel();
        //缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //读取数据到缓冲区
        channel.read(buffer);
        //设置缓冲区界限
        buffer.flip();
        //获取缓冲区的数据
        String s = new String(buffer.array(), 0, buffer.remaining());
        System.out.println(s);

    }

    /**
     * 文件复制
     */
    @Test
    public void test3() throws Exception {
        File file = new File("yang_zzu.txt");
        File newFile = new File("yang_zzu_new.txt");
        //字节输入流
        FileInputStream fileInputStream = new FileInputStream(file);
        //字节输出流
        FileOutputStream outputStream = new FileOutputStream(newFile);
        //输入流文件通道
        FileChannel inputStreamChannel = fileInputStream.getChannel();
        //输出流文件通道
        FileChannel outputStreamChannel = outputStream.getChannel();
        //缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            //清空缓冲区
            buffer.clear();
            //从输入流读取数据到缓冲区
            int read = inputStreamChannel.read(buffer);
            if (read == -1) {
                break;
            }
            //设置缓冲区界限
            buffer.flip();
            //数据写入到输出通道
            outputStreamChannel.write(buffer);
        }
        fileInputStream.close();
        outputStream.close();
        System.out.println("ok");
    }


    /**
     * 分散， 聚集
     * 分散读取（Scatter ）:是指把Channel通道的数据读入到多个缓冲区中去
     * 聚集写入（Gathering ）是指将多个 Buffer 中的数据“聚集”到 Channel
     */
    @Test
    public void test4() throws Exception {
        RandomAccessFile rw = new RandomAccessFile("yang_zzu.txt", "rw");
        //通道
        FileChannel channel = rw.getChannel();
        //分配缓冲区的大小
        ByteBuffer buffer1 = ByteBuffer.allocate(5);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);
        //分散读取
        ByteBuffer[] buffers = {buffer1, buffer2};
        channel.read(buffers);
        for (ByteBuffer buffer : buffers) {
            //设置缓冲区界限
            buffer.flip();
        }
        //输出，分散读出的数据
        System.out.println(new String(buffers[0].array(),0,buffers[0].remaining()));
        System.out.println("----------------------------");
        System.out.println(new String(buffers[1].array(),0,buffers[1].remaining()));

        //聚集写入
        RandomAccessFile accessFile = new RandomAccessFile("yang_zzu_write.txt", "rw");
        //通道
        FileChannel accessFileChannel = accessFile.getChannel();
        //聚集写入，缓冲区的数据写入到通道
        accessFileChannel.write(buffers);

        rw.close();
        accessFile.close();

        System.out.println("ok");
    }

    /**
     * 数据复制
     */
    @Test
    public void test5() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("yang_zzu.txt");
        //获得管道
        FileChannel channel = fileInputStream.getChannel();
        FileOutputStream outputStream = new FileOutputStream("yang_zzu0314.txt");
        //获得管道
        FileChannel outputStreamChannel = outputStream.getChannel();
        //复制,方式一
//        outputStreamChannel.transferFrom(channel, channel.position(), channel.size());

        //复制，方式二
        channel.transferTo(channel.position(), channel.size(), outputStreamChannel);

        fileInputStream.close();
        outputStream.close();

        System.out.println("ok");

    }

}
