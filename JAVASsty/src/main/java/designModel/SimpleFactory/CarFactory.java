package designModel.SimpleFactory;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/4/25.
 * Version      : 1.0
 * ***************************************************************************
 */
public class CarFactory {
    public static Car getCar(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        AxCar axCar = new AxCar();
        BxCar bxCar = new BxCar();
        if (type != null && type.equalsIgnoreCase("AxCar")) {
            //反射获取类必须使用原始类的引用全名
            type = "designModel.SimpleFactory.AxCar";
        } else if (type != null && type.equalsIgnoreCase("BxCar")) {
            type = "designModel.SimpleFactory.BxCar";
        } else {
            System.out.println("No this Type Class");
            return null;
        }
        Class car = Class.forName(type);
        return (Car) car.newInstance();
    }
}
