package com.seauf.proxy;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: Mr.lynn
 * @create: 2018-12-29 21:16
 **/
@SuppressWarnings("all")
@Component
@Deprecated
public class MyInvocationHandler implements InvocationHandler {

    //real object
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public <T> T getProxyObject(Object target){
        this.setTarget(target);
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Long beginTime =System.currentTimeMillis();
        Object object = method.invoke(target,args);
        System.out.println(method.getName() +"执行花费"+(System.currentTimeMillis()-beginTime)+"ms");
        return object;
    }

}
