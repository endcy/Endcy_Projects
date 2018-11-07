package com.AOP.impl;

import com.AOP.DAO;

/**
 * ***************************************************************************
 * Description  : DAO的具体实现类 纯业务
 * Author       : cxx
 * Creation date: 2017/10/26.
 * Version      : 1.0
 * ***************************************************************************
 */

public class UserDAOImpl implements DAO {
    @Override
    public boolean insert() {
        System.out.println("UserDAOImpl.insert()");
        return false;
    }

    @Override
    public boolean update() {
        System.out.println("UserDAOImpl.update()");
        return false;
    }

    @Override
    public boolean delete() {
        System.out.println("UserDAOImpl.delete()");
        return false;
    }
}
