package designModel.Singleton;

/**
 * ***************************************************************************
 * Description  : 枚举语法糖特性实现的单例模式，非懒加载但不能被类构造器Constructor构造多实例
 * Author       : cxx
 * Creation date: 2017/12/11.
 * Version      : 1.0
 * ***************************************************************************
 */
public enum EnumSingleton {
    INSTANCE;

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
