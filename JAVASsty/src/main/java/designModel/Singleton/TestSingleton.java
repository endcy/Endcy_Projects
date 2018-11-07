package designModel.Singleton;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2017/12/11.
 * Version      : 1.0
 * ***************************************************************************
 */
public class TestSingleton {
    public static void main(String[] args) {
        SynSingleton synSingleton = SynSingleton.getInstance();
        System.out.println(SynSingleton.class.getName() + " " + synSingleton);
        synSingleton.setStr("Hello SynSingleton");
        System.out.println(synSingleton.getStr());

        InnerClassSingleton innerClassSingleton = InnerClassSingleton.getInstance();
        System.out.println(InnerClassSingleton.class.getName() + " " + innerClassSingleton);
        innerClassSingleton.setStr("Hello InnerClassSingleton");
        System.out.println(innerClassSingleton.getStr());

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        System.out.println(EnumSingleton.class.getName() + " " + enumSingleton);
        enumSingleton.setStr("Hello EnumSingleton");
        System.out.println(enumSingleton.getStr());

    }
}
