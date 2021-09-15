import com.alibaba.fastjson.JSON;

import com.bj.drj.design01.dto.PayBusiness;
import com.bj.drj.design01.dto.Result;
import com.bj.drj.design01.resp.AliPayResponse;
import com.bj.drj.design01.resp.WxPayResponse;
import com.bj.drj.design01.sevice.PayService;
import com.bj.drj.design01.utils.CommonInjector;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @ClassName PayTest
 * @Description: TODO
 * @Author drj
 * @Date 2021/8/11
 * @Version V1.0
 **/
public class PayTest {

    @Inject
    private PayService payService;

    @Inject
    private PayDemo payDemo;

    @Before
    public void init() {
        CommonInjector.getInjector().injectMembers(this);
    }

    @Test
    public void testWxPay() throws Exception {
        PayBusiness payBusiness = new PayBusiness();
        payBusiness.setPayAccount(new BigDecimal(200));
        payBusiness.setPayCode("wx");
        payBusiness.setPayName("微信");
        Result pay = payService.pay(payBusiness);
        System.out.printf("支付接口返回参数：" + JSON.toJSONString(pay));
    }


    @Test
    public void testAliPay() throws Exception {
        PayBusiness payBusiness = new PayBusiness();
        payBusiness.setPayAccount(new BigDecimal(200));
        payBusiness.setPayCode("ali");
        payBusiness.setPayName("阿里");
        Result pay = payService.pay(payBusiness);
        System.out.printf("支付接口返回参数：" + JSON.toJSONString(pay));
    }


    @Test
    public void testPay() throws Exception {
        PayBusiness payBusiness = new PayBusiness();
        payBusiness.setPayAccount(new BigDecimal(200));
        payBusiness.setPayCode("qq");
        payBusiness.setPayName("qq 钱包");
        Result payQq = payService.pay(payBusiness);
        System.out.println("支付接口返回参数：" + JSON.toJSONString(payQq));
        payBusiness.setPayCode("wx");
        payBusiness.setPayName("wx 支付");
        Result<WxPayResponse> payWx = payService.pay(payBusiness);
        System.out.println("支付接口返回参数：" + JSON.toJSONString(payWx));
        payBusiness.setPayCode("ali");
        payBusiness.setPayName("ali 支付");
        Result<AliPayResponse> payAli = payService.pay(payBusiness);
        System.out.println("支付接口返回参数：" + JSON.toJSONString(payAli));
    }


    @Test
    public void testPayDemo() {
        PayBusiness payBusiness = new PayBusiness();
        payBusiness.setPayAccount(new BigDecimal(200));
        payBusiness.setPayCode("wx");
        payBusiness.setPayName("qq 钱包");
        Result<Object> pay = payDemo.pay(payBusiness);
        System.out.println("支付接口返回参数:" + JSON.toJSONString(pay));
    }
}
