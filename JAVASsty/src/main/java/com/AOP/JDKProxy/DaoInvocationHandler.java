package com.AOP.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ***************************************************************************
 * Description  : 代理模式 jdk中提供的代理实现方法 依赖反射；在判断方法名称之后执行所需增加的业务
 * Author       : cxx
 * Creation date: 2017/10/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public class DaoInvocationHandler implements InvocationHandler {
    private Object object;

    public DaoInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if ("insert".equals(methodName) || "update".equals(methodName)) {
            System.out.println("DaoInvocationHandler -> " + object.getClass().getName() + "-> Before insert()");
            Object retObj = method.invoke(object, args);
            System.out.println("DaoInvocationHandler -> " + object.getClass() + "-> After insert()");
            return retObj;
        }
        return method.invoke(object, args);
    }
}
