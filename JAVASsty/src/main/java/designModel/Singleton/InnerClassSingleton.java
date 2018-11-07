package designModel.Singleton;

/**
 * ***************************************************************************
 * Description  :  内部类实现懒加载的单例模式，但是能被类构造器Constructor构造多实例
 * Author       : cxx
 * Creation date: 2017/12/11.
 * Version      : 1.0
 * ***************************************************************************
 */
public class InnerClassSingleton {

    private InnerClassSingleton() {
    }

    private static class LazyLoadSingleton {
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return LazyLoadSingleton.instance;
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
