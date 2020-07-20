package com.sys.DesignPatterns.Chain;


/**
 * 访问频率控制
 *
 * Create by yang_zzu on 2020/7/19 on 19:57
 */
public class RequestFrequentHandler extends Handler {

    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("访问频率控制。。。。。。。");
        if (request.isFrequentOk()) {
            Handler next = getNext();
            if (next == null) {
                return true;
            }
            /**
             * 进入到下一个 process 的方法，( 下一个链节点的，实现方法 )
             */
            if (!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
