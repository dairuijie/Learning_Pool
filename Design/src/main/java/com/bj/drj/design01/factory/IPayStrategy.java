package com.bj.drj.design01.factory;



import com.bj.drj.design01.dto.PayBusiness;
import com.bj.drj.design01.dto.Result;

import java.util.logging.Logger;

/**
 * @ClassName IPay
 * @Description 支付接口
 * @Author drj
 * @Date 2021/8/10 6:02 下午
 */
public interface IPayStrategy<T> {

    /**
     *  支付
     * @param payBusiness
     * @return
     * @throws Exception
     */

    Result pay(PayBusiness<T> payBusiness) throws Exception;

    Logger logger = Logger.getLogger(IPayStrategy.class.getName());

}
