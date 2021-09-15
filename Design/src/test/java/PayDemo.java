import com.alibaba.fastjson.JSON;
import com.bj.drj.design01.dto.PayBusiness;
import com.bj.drj.design01.dto.Result;
import com.bj.drj.design01.enums.PayEnum;
import com.bj.drj.design01.factory.IPayStrategy;
import com.bj.drj.design01.req.AliPayRequest;
import com.bj.drj.design01.req.QqPayRequest;
import com.bj.drj.design01.req.WxPayRequest;
import com.bj.drj.design01.resp.AliPayResponse;
import com.bj.drj.design01.resp.QqPayResponse;
import com.bj.drj.design01.resp.WxPayResponse;


import java.util.Objects;

/**
 * @ClassName Demo
 * @Description: TODO
 * @Author drj
 * @Date 2021/8/10
 * @Version V1.0
 **/
public class PayDemo {

    public Result<Object> pay(PayBusiness payBusiness) {
        Result<Object> responseResult = new Result<>();
        if (Objects.equals(PayEnum.ALI_PAY.getPayCode(), payBusiness.getPayCode())) {
            buildAliResult(payBusiness, responseResult);
        } else if (Objects.equals(PayEnum.WX_PAY.getPayCode(), payBusiness.getPayCode())) {
            buildWxResult(payBusiness, responseResult);
        } else if (Objects.equals(PayEnum.QQ_PAY.getPayCode(), payBusiness.getPayCode())) {
            buildQqResult(payBusiness, responseResult);
        }
        return responseResult;
    }

    private void buildQqResult(PayBusiness payBusiness, Result<Object> responseResult) {
        QqPayRequest qqPayRequest = new QqPayRequest();
        qqPayRequest.setQq("qq");
        payBusiness.setBody(qqPayRequest);
        IPayStrategy.logger.info("QPay 请求参数: " + JSON.toJSONString(payBusiness));
        IPayStrategy.logger.info("调用qq支付");
        responseResult.setResultCode(200);
        responseResult.setResultMsg("调用成功!");
        QqPayResponse qqPayResponse = new QqPayResponse();
        qqPayResponse.setQqPayResult("qqPay 接口调用成功 等待回调");
        responseResult.setResultData(qqPayResponse);
    }

    private void buildWxResult(PayBusiness payBusiness, Result<Object> responseResult) {
        WxPayRequest wxPayRequest = new WxPayRequest();
        wxPayRequest.setWx("微信");
        payBusiness.setBody(wxPayRequest);
        IPayStrategy.logger.info("Wx Pay 请求参数: " + JSON.toJSONString(payBusiness));
        responseResult.setResultCode(200);
        responseResult.setResultMsg("调用成功!");
        WxPayResponse aliPayResponse = new WxPayResponse();
        aliPayResponse.setWxPayResult("wx Pay 接口调用成功， 等待回调");
        responseResult.setResultData(aliPayResponse);
    }

    private void buildAliResult(PayBusiness payBusiness, Result<Object> responseResult) {
        AliPayRequest aliPayRequest = new AliPayRequest();
        aliPayRequest.setAli("阿里云");
        payBusiness.setBody(aliPayRequest);
        IPayStrategy.logger.info("Ali Pay 请求参数: " + JSON.toJSONString(payBusiness));
        responseResult.setResultCode(200);
        responseResult.setResultMsg("调用成功!");
        AliPayResponse aliPayResponse = new AliPayResponse();
        aliPayResponse.setAliPayResult("aliPay 接口调用成功 等待回调");
        responseResult.setResultData(aliPayResponse);
    }
}
