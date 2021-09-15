package com.bj.drj.design01.factory.impl;

import com.alibaba.fastjson.JSON;
import com.bj.drj.design01.dto.PayBusiness;
import com.bj.drj.design01.dto.Result;
import com.bj.drj.design01.factory.IPayStrategy;
import com.bj.drj.design01.req.QqPayRequest;
import com.bj.drj.design01.resp.QqPayResponse;


/**
 * @ClassName QQPay
 * @Description: TODO
 * @Author drj
 * @Date 2021/8/11
 * @Version V1.0
 **/
public class QqPay implements IPayStrategy<Object> {
    @Override
    public Result<QqPayResponse> pay(PayBusiness<Object> payBusiness) throws Exception {
        QqPayRequest qqPayRequest = new QqPayRequest();
        qqPayRequest.setQq("qq");
        payBusiness.setBody(qqPayRequest);
        IPayStrategy.logger.info("QPay 请求参数: " + JSON.toJSONString(payBusiness));
        IPayStrategy.logger.info("调用qq支付");
        Result<QqPayResponse> responseResult = new Result<>();
        responseResult.setResultCode(200);
        responseResult.setResultMsg("调用成功!");
        QqPayResponse qqPayResponse = new QqPayResponse();
        qqPayResponse.setQqPayResult("qqPay 接口调用成功 等待回调");
        responseResult.setResultData(qqPayResponse);
        return responseResult;
    }
}
