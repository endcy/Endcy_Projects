package com.AOP.SpringAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * ***************************************************************************
 * Description  :ProceedingJoinPoint继承了JoinPoint，支持环绕通知即around切面
 * Author       : cxx
 * Creation date: 2017/10/28.
 * Version      : 1.0
 * ***************************************************************************
 */
public class PrintTipsBySpringAOP {
    public Object printItTips(ProceedingJoinPoint pjp) {
        Signature signature = pjp.getSignature();
        Object result = null;
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            Object[] args = pjp.getArgs();
            System.out.println("PrintTipsBySpringAOP -> " + "Before Method:" + method.getName() + "with args " + Arrays.asList(args));
            try {
                result = pjp.proceed();
                System.out.println("PrintTipsBySpringAOP -> " + "After Method return result:" + result);
            } catch (Throwable e) {
                //@Around切入点中的异常拦截内容执行，则@AfterThrowing切入点里面的内容将不会执行
                System.out.println("PrintTipsBySpringAOP -> " + "Method Exception " + e);
                e.printStackTrace();
            }
            System.out.println("PrintTipsBySpringAOP -> " + "After Method");
        }
        return result;
    }

}
