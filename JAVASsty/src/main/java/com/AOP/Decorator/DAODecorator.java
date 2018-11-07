package com.AOP.Decorator;

import com.AOP.DAO;

/**
 * ***************************************************************************
 * Description  : 装饰器模式 核心就是实现Dao接口并持有Dao接口的引用（实例化时传入已实现该接口的实现类，再调用方法）
 * Author       : cxx
 * Creation date: 2017/10/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public class DAODecorator implements DAO {
    private DAO dao;
    public DAODecorator(DAO dao){
        this.dao = dao;
    }
    @Override
    public boolean insert() {
        System.out.println("DAODecorator -> " + dao.getClass().getName() + "-> Before insert()" );
        boolean flag = dao.insert();
        System.out.println("DAODecorator -> " + dao.getClass().getName() + "-> After insert()" );
        return flag;
    }

    @Override
    public boolean update() {
        System.out.println("DAODecorator -> " + dao.getClass().getName() + "-> Before update()" );
        boolean flag = dao.update();
        System.out.println("DAODecorator -> " + dao.getClass().getName() + "-> After update()" );
        return flag;
    }

    @Override
    public boolean delete() {
        return dao.delete();
    }
}
