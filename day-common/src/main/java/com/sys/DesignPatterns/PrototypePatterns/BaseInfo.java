package com.sys.DesignPatterns.PrototypePatterns;

import java.io.Serializable;

/**
 * Create by yang_zzu on 2020/7/8 on 19:32
 */
public class BaseInfo implements Cloneable, Serializable {
    private static final long serialVersionUID = -9149578440105162389L;
    private String companyName;

    public BaseInfo(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return super.hashCode()+"}BaseInfo{" +
                "companyName='" + companyName + '\'' +
                '}';
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return (BaseInfo) super.clone();
    }
}
