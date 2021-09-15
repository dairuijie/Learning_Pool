package com.bj.drj.design01.factory;

import com.bj.drj.design01.dto.PayBusiness;
import com.bj.drj.design01.dto.Result;


/**
 *
 * @ClassName ContextHandler
 * @Description: 策略控制
 * @Author drj
 * @Date 2021/8/10
 * @Version V1.0
 **/
public class ContextStrategy<T> {

    private IPayStrategy<T> pay;

    public ContextStrategy(IPayStrategy<T> pay) {
        this.pay = pay;
    }

    public Result payProcess(PayBusiness<T> t) throws Exception {
        return pay.pay(t);
    }
}
