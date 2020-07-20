package com.sys.DesignPatterns.Chain;

/**
 * 责任链模式
 * Create by yang_zzu on 2020/7/19 on 19:48
 */
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {

        Request build = new Request.RequestBuilder().frequentOk(true).loggedOn(true).build();
        /**
         * 这个是责任链的实现，相当于一个栈，
         * 先对最内层的 进行初始化，然后依次像外层扩展
         * 最内层的初始化完，放到栈底，最外层初始化完，放到栈顶
         * 最先拿出的是栈顶的元素，
         * 依次向内层进行遍历
         */
        RequestFrequentHandler requestFrequentHandler = new RequestFrequentHandler(new LoggingHandler(null));
        /**
         * 责任链 和 装饰器 很像
         * 不同的是，责任链已经规定了链的长度，( 已经定义了天花板的高度 )
         * 装饰器，则可以通过添加类的形式动态的 新增功能点，（可以无限的增加）
         */
        if (requestFrequentHandler.process(build)) {
            System.out.println("正常业务处理。。。。。");
        } else {
            System.out.println("访问异常！！！！");
        }

    }
}
