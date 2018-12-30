package com.seauf.proxy;

import com.seauf.user.interfs.UserService;
import com.seauf.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MyInvocationHandler implements InvocationHandler {

    @Autowired
    private UserService userService;

    //real object
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public <T> T getProxyObject(){
        return (T) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("当前正在执行"+ proxy +"代理类");
//        System.out.println("当前正在执行"+ method +"方法");
//        System.out.println("当前正在执行"+ args +"参数");
//        return method.invoke(proxy,args);
        return null;
    }

}
