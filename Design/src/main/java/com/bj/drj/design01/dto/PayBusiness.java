package com.bj.drj.design01.dto;

import java.math.BigDecimal;

/**
 * @ClassName PayBusiness
 * @Description: TODO
 * @Author drj
 * @Date 2021/8/10
 * @Version V1.0
 **/
public class PayBusiness<T> {

    /**
     * 支付金額
     */
    private BigDecimal payAccount;

    /**
     * 支付方式
     */
    private String payName;

    /**
     * 支付方式code
     */
    private String payCode;

    /**
     * 不同支付方式业务参数
     */
    private T body;

    public BigDecimal getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(BigDecimal payAccount) {
        this.payAccount = payAccount;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }
}
