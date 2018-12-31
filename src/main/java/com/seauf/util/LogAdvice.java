package com.seauf.util;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: Mr.lynn
 * @create: 2018-12-31 16:37
 **/
@SuppressWarnings("all")
@Component
@Deprecated
public class LogAdvice implements MethodInterceptor {

    private Object target;

    public <T> T getProxyInstance(Object target){
        this.target = target;
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(target.getClass());
//        enhancer.setCallback(this);
//        return (T) enhancer.create();
        return (T) Enhancer.create(target.getClass(),this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        LogUtil.writeLog(method.getName());
        return null;
    }
}
