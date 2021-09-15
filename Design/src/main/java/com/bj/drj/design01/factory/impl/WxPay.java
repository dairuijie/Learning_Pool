package com.bj.drj.design01.factory.impl;

import com.alibaba.fastjson.JSON;
import com.bj.drj.design01.dto.PayBusiness;
import com.bj.drj.design01.dto.Result;
import com.bj.drj.design01.factory.IPayStrategy;
import com.bj.drj.design01.req.WxPayRequest;
import com.bj.drj.design01.resp.WxPayResponse;

/**
 * @ClassName WxPay
 * @Description: TODO
 * @Author drj
 * @Date 2021/8/10
 * @Version V1.0
 **/
public class WxPay implements IPayStrategy<WxPayRequest> {


    /**
     * @param payBusiness
     * @return
     * @throws Exception
     */
    public Result<WxPayResponse> pay(PayBusiness<WxPayRequest> payBusiness) throws Exception {
        WxPayRequest wxPayRequest = new WxPayRequest();
        wxPayRequest.setWx("微信");
        payBusiness.setBody(wxPayRequest);
        IPayStrategy.logger.info("Wx Pay 请求参数: " + JSON.toJSONString(payBusiness));
        Result<WxPayResponse> responseResult = new Result<>();
        responseResult.setResultCode(200);
        responseResult.setResultMsg("调用成功!");
        WxPayResponse aliPayResponse = new WxPayResponse();
        aliPayResponse.setWxPayResult("wx Pay 接口调用成功， 等待回调");
        responseResult.setResultData(aliPayResponse);
        return responseResult;
    }

}
