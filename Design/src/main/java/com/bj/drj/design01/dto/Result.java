package com.bj.drj.design01.dto;

/**
 * @ClassName Result
 * @Description: TODO
 * @Author drj
 * @Date 2021/8/10
 * @Version V1.0
 **/
public class Result<E> {

    private Integer resultCode;

    private String resultMsg;

    private E resultData;

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public E getResultData() {
        return resultData;
    }

    public void setResultData(E resultData) {
        this.resultData = resultData;
    }
}
