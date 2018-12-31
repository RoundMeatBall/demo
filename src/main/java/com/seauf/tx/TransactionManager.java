package com.seauf.tx;

import com.seauf.util.LogUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: Mr.lynn
 * @create: 2018-12-31 21:14
 **/
@Component
@Aspect
public class TransactionManager {

//
    @Pointcut("execution(* com.seauf..service..*(..))")
    public void txPoint(){

    }

    @Before("txPoint()")
    public void begin(JoinPoint joinPoint){
        LogUtil.writeLog("事务开始");
        System.out.println("代理对象"+joinPoint.getThis().getClass());
        System.out.println("目标对象"+joinPoint.getTarget().getClass());
        System.out.println("代理对象参数"+joinPoint.getArgs());
        System.out.println("连接点方法的签名"+joinPoint.getSignature());
        System.out.println("连接点类型" +joinPoint.getKind());

    };

    @AfterReturning("txPoint()")
    public void commit(JoinPoint joinPoint){
        LogUtil.writeLog("事务提交");
    };

    @AfterThrowing(value = "txPoint()",throwing = "ex")
    public void rollback(JoinPoint joinPoint,Throwable ex){
        LogUtil.writeLog("事务回滚");
    };

//    @Around("txPoint()")
    public void around(ProceedingJoinPoint pjp){
        Object object = null;
        //前置增强
        System.out.println("开启事务");
        try{
            pjp.proceed();
            //后置增强
            System.out.println("提交事务事务");
        }catch (Throwable throwable){
            //异常增强
            System.out.println(throwable);
            System.out.println("异常增强");
        }finally {
            //最终增强
            System.out.println("最终增强");
        }
    };
}
