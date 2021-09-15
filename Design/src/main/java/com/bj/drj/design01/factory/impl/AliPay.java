package com.bj.drj.design01.factory.impl;

import com.alibaba.fastjson.JSON;
import com.bj.drj.design01.dto.PayBusiness;
import com.bj.drj.design01.dto.Result;
import com.bj.drj.design01.factory.IPayStrategy;
import com.bj.drj.design01.req.AliPayRequest;
import com.bj.drj.design01.resp.AliPayResponse;


/**
 * @ClassName AliPay
 * @Description: TODO
 * @Author drj
 * @Date 2021/8/10
 * @Version V1.0
 **/
public class AliPay implements IPayStrategy<AliPayRequest> {
    /**
     * @param payBusiness
     * @return
     * @throws Exception
     */
    @Override
    public Result<AliPayResponse> pay(PayBusiness<AliPayRequest> payBusiness) throws Exception {
        AliPayRequest aliPayRequest = new AliPayRequest();
        aliPayRequest.setAli("阿里云");
        payBusiness.setBody(aliPayRequest);
        IPayStrategy.logger.info("Ali Pay 请求参数: " + JSON.toJSONString(payBusiness));
        Result<AliPayResponse> responseResult = new Result<>();
        responseResult.setResultCode(200);
        responseResult.setResultMsg("调用成功!");
        AliPayResponse aliPayResponse = new AliPayResponse();
        aliPayResponse.setAliPayResult("aliPay 接口调用成功 等待回调");
        responseResult.setResultData(aliPayResponse);
        return responseResult;
    }
}
