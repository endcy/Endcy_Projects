package cn.endcy.logutils;

import cn.endcy.strutils.DateUtils;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2017/7/14.
 * Version      : 1.0
 * ***************************************************************************
 */
public class LogDemo {
    public static void main(String[] args) {
        while (true) {
            Thread test = new newTest();
            test.setName("87DFDS134");
            LogUtil.info(LogDemo.class.toString(), "right");
            try {
                Class.forName("com.ghj.ErrorClassName");
            } catch (ClassNotFoundException e) {
                LogUtil.debug(LogDemo.class.toString(), e.getMessage(), e);//详细日报信息
                LogUtil.info(e.getMessage());//详细日报信息
                LogUtil.warn(e.getMessage());//简单日报信息
                LogUtil.error(e.getMessage());//简单日报信息
                LogUtil.info(DateUtils.getCurrentDateTime());
            }
            try {
                new Thread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class newTest extends Thread {
    public newTest() {
        LogUtil.info(newTest.class, "test");
    }
}
