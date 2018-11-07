package com.Sysclass;

/**
 * Created by Administrator on 2016/10/12.
 * 单例模式 同步锁判断
 */
public class Singleton {
    private static Singleton instance;
    private static final Object sylock =new Object();
    private Singleton(){}
    public static Singleton getInstance(){
        synchronized (sylock){
            if(instance == null){
                instance = new Singleton();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton instancc = new Singleton();   //类外部不可访问因为该实例方法设置为private
        Singleton instance = Singleton.getInstance();   //任何位置可以访问并能实现单例
    }
}
