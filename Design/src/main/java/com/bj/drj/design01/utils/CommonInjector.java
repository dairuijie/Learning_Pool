package com.bj.drj.design01.utils;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * 初始化guice注入context信息（单例）
 *
 * @author drj
 */
public class CommonInjector {

    private static Injector injector = Guice.createInjector();

    public static Injector getInjector() {
        return injector;
    }
}
