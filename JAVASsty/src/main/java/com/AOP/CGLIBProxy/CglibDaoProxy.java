package com.AOP.CGLIBProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
/**
 * ***************************************************************************
 * Description  :使用CGLIB解决了JDK的Proxy无法针对类做代理的问题，
 * 但是这里要专门说明一个问题：使用装饰器模式可以说是对使用原生代码的一种改进，使用Java代理可以说是对于使用装饰器模式的一种改进，
 * 但是使用CGLIB并不是对于使用Java代理的一种改进。
 * Author       : cxx
 * Creation date: 2017/10/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public class CglibDaoProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        String methodName = method.getName();
        if ("insert".equals(methodName) || "update".equals(methodName)) {
            System.out.println("CglibDaoProxy -> " + object.getClass().getName() + "-> Before insert()");
            Object result = proxy.invokeSuper(object, args);
            System.out.println("CglibDaoProxy -> " + object.getClass().getName() + "-> After insert()");
            return result;
        }
        Object result = proxy.invokeSuper(object, args);
        return result;
    }
}
