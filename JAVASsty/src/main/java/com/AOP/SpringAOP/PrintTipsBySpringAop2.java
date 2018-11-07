package com.AOP.SpringAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2017/10/28.
 * Version      : 1.0
 * ***************************************************************************
 */
public class PrintTipsBySpringAop2 {
    //前置通知
    public void printTipsBefore(JoinPoint joinpoint) {
        Object obj = joinpoint.getTarget();
        Signature signature = joinpoint.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature ms = (MethodSignature) signature;
            Method method = ms.getMethod();
            String methodName = method.getName();
            Object[] args = joinpoint.getArgs();
            System.out.println("PrintTipsBySpringAop2 -> " + "Before Method:" + methodName + " with Args " + Arrays.asList(args));
        }
    }

    //后置通知
    public void printTipsAfter(JoinPoint joinpoint) {
        Object obj = joinpoint.getTarget();
        Signature signature = joinpoint.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature ms = (MethodSignature) signature;
            Method method = ms.getMethod();
            String methodName = method.getName();
            Object[] args = joinpoint.getArgs();
            System.out.println("PrintTipsBySpringAop2 -> " + "After Method:" + methodName + " with Args " + Arrays.asList(args));
        }
    }

    //返回通知
    public void printTipsAfterReturning(JoinPoint joinpoint, Object result) {
        Object obj = joinpoint.getTarget();
        Signature signature = joinpoint.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature ms = (MethodSignature) signature;
            Method method = ms.getMethod();
            String methodName = method.getName();
            Object[] args = joinpoint.getArgs();
            System.out.println("PrintTipsBySpringAop2 -> " + "Method:" + methodName + " with Args " + Arrays.asList(args) + " return:" + result);
        }
    }

    //异常通知
    public void printTipsThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("PrintTipsBySpringAop2 -> " + "Method:" + methodName + " occurs exception: " + ex);
    }

}
