package com.sys.DesignPatterns.Chain;

/**
 * 登录验证
 *
 * Create by yang_zzu on 2020/7/20 on 11:35
 */
public class LoggingHandler extends Handler {

    public LoggingHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {

        System.out.println("登录验证。。。。。。。");
        if (request.isLoggedOn()) {
            Handler next = getNext();
            if (next == null) {
                return true;
            }
            if (!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

}
