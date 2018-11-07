package designModel.FactoryMethod;

/**
 * ***************************************************************************
 * Description  : 工厂方法模式同样属于类的创建型模式又被称为多态工厂模式。
 * 工厂方法模式的意义是定义一个创建产品对象的工厂接口，将实际创建工作推迟到子类当中。
 * 核心工厂类不再负责产品的创建，这样核心类成为一个抽象工厂角色，仅负责具体工厂子类必须实现的接口，
 * 这样进一步抽象化的好处是使得工厂方法模式可以使系统在不修改具体工厂角色的情况下引进新的产品。
 * Author       : cxx
 * Creation date: 2018/4/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        ColorFactory colorFactory;
        colorFactory = new BlueColorFactory();
        Color blue = colorFactory.getColor();

        colorFactory = new BlackColorFactory();
        Color black = colorFactory.getColor();

        System.out.println(blue.getInfo());
        System.out.println(black.getInfo());
    }
}
