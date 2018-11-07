package com.AOP;

import com.AOP.CGLIBProxy.CglibDaoProxy;
import com.AOP.Decorator.DAODecorator;
import com.AOP.JDKProxy.DaoInvocationHandler;
import com.AOP.impl.UserDAOImpl;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2017/10/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public class UseDAOTest {
    public static void main(String[] args) {
        //装饰器模式 实现调用
        DAO dao = new DAODecorator(new UserDAOImpl());
        dao.insert();
        dao.update();
        dao.delete();
        System.out.println("执行类：" + dao.getClass().getName());
        System.out.println();

        //jdk动态代理模式实现调用
        DAO dao1 = new UserDAOImpl();
        //数组中参数DAO.class即为需要实现增加业务的类，如其它实现了DAO的类也需要增加业务则数组中增加那个实现类
        DAO proxyDao = (DAO) Proxy.newProxyInstance(DaoInvocationHandler.class.getClassLoader(),
                new Class<?>[]{DAO.class}, new DaoInvocationHandler(dao1));
        proxyDao.insert();
        proxyDao.update();
        proxyDao.delete();
        System.out.println("执行类：" + proxyDao.getClass().getName());
        System.out.println();

        //CGLIB代理模式实现调用
        CglibDaoProxy daoProxy = new CglibDaoProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDAOImpl.class);
        enhancer.setCallback(daoProxy);
        DAO dao2 = (UserDAOImpl) enhancer.create();
        dao2.insert();
        boolean flag = dao2.update();
        dao2.delete();
        System.out.println("执行类：" + dao2.getClass().getName());

    }

}
