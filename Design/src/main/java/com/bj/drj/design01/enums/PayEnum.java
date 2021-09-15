package com.bj.drj.design01.enums;

import java.util.Objects;

/**
 * @ClassName PayEnum
 * @Description 支付方式枚举
 * @Author drj
 * @Date 2021/8/11 2:14 下午
 */
public enum PayEnum {

    ALI_PAY("ali", "com.bj.drj.design01.factory.impl.AliPay"),
    QQ_PAY("qq", "com.bj.drj.design01.factory.impl.QqPay"),
    WX_PAY("wx", "com.bj.drj.design01.factory.impl.WxPay");

    private String payCode;

    private String payClassPath;

    public String getPayCode() {
        return payCode;
    }

    public String getPayClassPath() {
        return payClassPath;
    }

    PayEnum(String payCode, String payClassPath) {
        this.payCode = payCode;
        this.payClassPath = payClassPath;
    }

    public static String getClassPath(String payCode) {
        for (PayEnum payEnum : values()) {
            if (Objects.equals(payEnum.getPayCode(), payCode)) {
                return payEnum.getPayClassPath();
            }
        }
        return null;
    }

}
