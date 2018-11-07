package com.AOP;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/9/7.
 * Version      : 1.0
 * ***************************************************************************
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "AopTest.xml")
public class UserDAOAOPTest {

    @Resource(name = "userDaoImpl")
    DAO dao;

    @Test
    @SuppressWarnings("resource")
    public void testSpringAop() {
        dao.insert();
        dao.update();
        dao.delete();
    }

}
