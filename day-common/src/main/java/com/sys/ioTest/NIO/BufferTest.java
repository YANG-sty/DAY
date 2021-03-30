package com.sys.ioTest.NIO;

import org.junit.Test;
import java.nio.ByteBuffer;

/**
 * NIO buffer缓冲区的使用
 * @author yangLongFei 2021-03-13-17:25
 */
public class BufferTest {

    /**
     * Buffer clear() 清空缓冲区并返回对缓冲区的引用，并不会真正的删除数据，只是将position的位置值为0，只有再次添加数据的时候才会将数据之前的数据覆盖
     * Buffer flip() 设置缓冲区的界限，将缓冲区的界限设置为当前位置，并将当前位置充值为 0，
     * int capacity() 返回 Buffer 的 capacity 大小
     * boolean hasRemaining() 判断缓冲区中是否还有元素
     * int limit() 返回 Buffer 的界限(limit) 的位置
     * Buffer limit(int n) 将设置缓冲区界限为 n, 并返回一个具有新 limit 的缓冲区对象
     * Buffer mark() 对缓冲区设置标记
     * int position() 返回缓冲区的当前位置 position
     * Buffer position(int n) 将设置缓冲区的当前位置为 n , 并返回修改后的 Buffer 对象
     * int remaining() 返回 position 和 limit 之间的元素个数
     * Buffer reset() 将位置 position 转到以前设置的 mark 所在的位置
     * Buffer rewind() 将位置设为为 0， 取消设置的 mark
     *
     * 取获取 Buffer中的数据
     * get() ：读取单个字节
     * get(byte[] dst)：批量读取多个字节到 dst 中
     * get(int index)：读取指定索引位置的字节(不会移动 position)
     *
     * 放到 入数据到 Buffer 中 中
     * put(byte b)：将给定单个字节写入缓冲区的当前位置
     * put(byte[] src)：将 src 中的字节写入缓冲区的当前位置
     * put(int index, byte b)：将指定字节写入缓冲区的索引位置(不会移动 position)
     *
     */


    @Test
    public void test1() {
        //分配一个缓冲区，容量为10
        ByteBuffer buffer = ByteBuffer.allocate(10);
        /**
         * 0
         * 10
         * 10
         */
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("---------------------------------");

        /**
         * 8
         * 10
         * 10
         */
        //保存数据到缓冲区
        String msg = "yang_zzu";
        buffer.put(msg.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("---------------------------------");

        /**
         * 0
         * 8
         * 10
         */
        //将缓冲区的 "界限"设置为当前位置，并将当前位置充值为 0
        //可读模式
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("---------------------------------");

        /**
         * y
         * 1
         * 8
         * 10
         */
        // 读取数据
        char b = (char) buffer.get();
        System.out.println(b);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("---------------------------------");

        /**
         * 0
         * 10
         * 10
         */
        //清除缓冲区的数据,数据没有真正的清除掉，只是position的位置发生了改变
        buffer.clear();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        //正常的获取数据
        System.out.println((char) buffer.get());

        System.out.println("---------------------------------");

    }


    @Test
    public void test2() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        String msg = "yang_zzu";
        buffer.put(msg.getBytes());

        /**
         * yang_
         * 5
         * 8
         * 10
         */
        //读模式, 设置缓冲区的界限
        buffer.flip();
        byte[] bytes = new byte[5];
        buffer.get(bytes);
        System.out.println(new String(bytes));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("---------------------------------");

        /**
         * zz
         * 7
         * 8
         * 10
         */
        //标记位置
        buffer.mark();
        byte[] b2 = new byte[2];
        buffer.get(b2);
        System.out.println(new String(b2));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("---------------------------------");

        /**
         * zzu
         * 8
         * 8
         * 10
         */
        //回到， mark() 方法标记的position的位置
        buffer.reset();
        byte[] b3 = new byte[3];
        buffer.get(b3);
        System.out.println(new String(b3));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("---------------------------------");


    }


    @Test
    public void test3() {
        // 1、创建一个直接内存的缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        //非直接内存
        //ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.isDirect());
    }

}
