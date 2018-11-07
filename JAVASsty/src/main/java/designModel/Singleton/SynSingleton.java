package designModel.Singleton;

/**
 * ***************************************************************************
 * Description  : 双重检测同步锁实现懒加载的单例模式，但是能被类构造器Constructor构造多实例
 * Author       : cxx
 * Creation date: 2017/12/11.
 * Version      : 1.0
 * ***************************************************************************
 */
public class SynSingleton {
    private SynSingleton() {
    }

    //防止变量访问前后指令重排
    private volatile static SynSingleton instance = null;

    //静态工厂
    public static SynSingleton getInstance() {
        if (instance == null) {
            synchronized (SynSingleton.class) { //同步锁
                if (instance == null)   //双重检测机制
                    instance = new SynSingleton();
            }
        }
        return instance;
    }

    //测试静态变量
    private String str;

    //测试方法
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

}
