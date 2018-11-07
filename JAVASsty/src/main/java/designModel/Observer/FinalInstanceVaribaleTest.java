package designModel.Observer;

public class FinalInstanceVaribaleTest {
    final int var1 = 1;//定义final实例变量时指定初始值。
    final int var2;
    final int var3;

    //在非静态初始化块中为final实例变量指定初始值。
    {
        var2 = 2;
    }

    // 在构造方法中为final实例变量指定初始值。
    public FinalInstanceVaribaleTest() {
        this.var3 = 3;
    }

    public static void main(String[] args) {
        FinalInstanceVaribaleTest finalInstanceVaribaleTest = new FinalInstanceVaribaleTest();
        System.out.println(finalInstanceVaribaleTest.var1);
        System.out.println(finalInstanceVaribaleTest.var2);
        System.out.println(finalInstanceVaribaleTest.var3);
    }


}
