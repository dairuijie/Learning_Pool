package com.bj.drj.design01.factory;

import cn.hutool.core.lang.ClassScanner;
import com.bj.drj.design01.enums.PayEnum;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName PayStrategyFactory
 * @Description: 支付策略工程类
 * @Author drj
 * @Date 2021/8/10
 * @Version V1.0
 **/
public class PayStrategyFactory {
    private Logger logger = Logger.getLogger(PayFactoryInstance.class);
    private static Map<String, IPayStrategy> registerServices = new ConcurrentHashMap<String, IPayStrategy>();

    private PayStrategyFactory() {
        init();
    }

    public static PayStrategyFactory getInstance() {
        return PayFactoryInstance.instance;
    }

    private static class PayFactoryInstance {
        private static PayStrategyFactory instance = new PayStrategyFactory();

    }

    private void init() {
        Set<Class<?>> classes = ClassScanner.scanPackage("com.bj.drj.design01.factory.impl");
        classes.stream().forEach(x -> registerService(x));
    }

    private void registerService(Class registerClass) {
        try {
            registerServices.put(registerClass.getName(), (IPayStrategy) registerClass.newInstance());
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public IPayStrategy getPayService(String payCode) {
        return registerServices.get(PayEnum.getClassPath(payCode));
    }
}
