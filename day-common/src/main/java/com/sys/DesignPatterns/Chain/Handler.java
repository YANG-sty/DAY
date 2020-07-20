package com.sys.DesignPatterns.Chain;

/**
 * 责任链， 抽象接口，每一个链节点，都要继承该类
 * Create by yang_zzu on 2020/7/19 on 19:55
 */
abstract class Handler {
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract boolean process(Request request);
}
