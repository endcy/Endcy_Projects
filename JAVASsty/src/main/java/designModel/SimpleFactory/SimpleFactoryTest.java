package designModel.SimpleFactory;
/**
 * ***************************************************************************
 * Description  : 简单工厂模式属于类的创建型模式,又叫做静态工厂方法模式。
 * 通过专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类
 *
 * Author       : cxx
 * Creation date: 2018/4/25.
 * Version      : 1.0
 * ***************************************************************************
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        String aCar = "AxCar";
        String bCar = "BxCar";
        Car axCar, bxCar = null;
        try {
            axCar = CarFactory.getCar(aCar);
            bxCar = CarFactory.getCar(bCar);
            System.out.println(axCar.getInfo());
            System.out.println(bxCar.getInfo());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
