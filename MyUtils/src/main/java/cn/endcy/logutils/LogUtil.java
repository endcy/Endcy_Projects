package cn.endcy.logutils;

import cn.endcy.strutils.DateUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2017/7/14.
 * Version      : 1.0
 * ***************************************************************************
 */
public class LogUtil {

    private Long time = System.currentTimeMillis();
    public static synchronized void logExCheck(){
        long now = System.currentTimeMillis();

    }
    public static synchronized void info(String msg) {
        Logger logger = LoggerFactory.getLogger("DefaultLogPrint");
        logger.info(msg);
    }

    public static synchronized void info(String className, String msg) {
        Logger logger = LoggerFactory.getLogger(className);
        logger.info(msg);
    }

    public static synchronized void info(String className, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(className);
        logger.info(msg, t);
    }

    public static void info(Class clazz, String msg) {
        info(clazz.toString(), msg);
    }

    public static void info(Class clazz, String msg, Throwable t) {
        info(clazz, msg, t);
    }

    public static synchronized void debug(String msg) {
        Logger logger = LoggerFactory.getLogger("DefaultLogPrint");
        logger.debug(msg);
    }

    public static synchronized void debug(String className, String msg) {
        Logger logger = LoggerFactory.getLogger(className);
        logger.debug(msg);
    }

    public static synchronized void debug(String className, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(className);
        logger.debug(msg, t);
    }

    public static void debug(Class clazz, String msg) {
        debug(clazz.toString(), msg);
    }

    public static void debug(Class clazz, String msg, Throwable t) {
        debug(clazz, msg, t);
    }

    public static synchronized void warn(String msg) {
        Logger logger = LoggerFactory.getLogger("DefaultLogPrint");
        logger.warn(msg);
    }

    public static synchronized void warn(String className, String msg) {
        Logger logger = LoggerFactory.getLogger(className);
        logger.warn(msg);
    }

    public static synchronized void warn(String className, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(className);
        logger.warn(msg, t);
    }

    public static void warn(Class clazz, String msg) {
        warn(clazz.toString(), msg);
    }

    public static void warn(Class clazz, String msg, Throwable t) {
        warn(clazz, msg, t);
    }

    public static synchronized void error(String msg) {
        Logger logger = LoggerFactory.getLogger("DefaultLogPrint");
        logger.error(msg);
    }

    public static synchronized void error(String className, String msg) {
        Logger logger = LoggerFactory.getLogger(className);
        logger.error(msg);
    }

    public static synchronized void error(String className, String msg, Throwable t) {
        Logger logger = LoggerFactory.getLogger(className);
        logger.error(msg, t);
    }

    public static void error(Class clazz, String msg) {
        error(clazz.toString(), msg);
    }

    public static void error(Class clazz, String msg, Throwable t) {
        error(clazz, msg, t);
    }

    /**
     * 通过Appender设置默认的日志打印文件路径
     *
     * @param path 日志生成的文件夹路径
     */
    public static void setLogFilePath(String path) {
        Appender appender = LogManager.getLoggerRepository().getRootLogger().getAppender("File");
        if (appender instanceof FileAppender) {
            FileAppender fileAppender = (FileAppender) appender;
            String origPath = fileAppender.getFile();
            if (!new File(origPath).delete()) {
                fileAppender.setFile(path + File.separator + DateUtils.getCurrentDate() + ".log");
                fileAppender.activateOptions();
                warn(LogUtil.class, "重新设置日志路径及名称成功！");
            } else
                warn(LogUtil.class, "重新设置日志路径及名称失败！");
        }
    }

}
