package com.bj.drj.design01.sevice;

import com.bj.drj.design01.dto.PayBusiness;
import com.bj.drj.design01.dto.Result;
import com.bj.drj.design01.factory.ContextStrategy;
import com.bj.drj.design01.factory.PayStrategyFactory;

/**
 * @ClassName PayController
 * @Description: TODO
 * @Author drj
 * @Date 2021/8/11
 * @Version V1.0
 **/
public class PayService {



    public Result pay(PayBusiness payBusiness) throws Exception {
       ContextStrategy contextHandler = new ContextStrategy(PayStrategyFactory.getInstance().getPayService(payBusiness.getPayCode()));
       return contextHandler.payProcess(payBusiness);
    }



}
