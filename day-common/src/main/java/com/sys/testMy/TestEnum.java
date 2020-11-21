package com.sys.testMy;


/**
 * @author yangLongFei 2020-11-12-10:45
 */
public enum TestEnum {

    SUCCESS("200", "succes"),
    NOPATH("404", "没有找到路径"),
    ERROR("500","error");

    private String code;
    private String msg;

    /**
     * @param code 返回编码
     * @param msg 返回信息
     */
    TestEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
