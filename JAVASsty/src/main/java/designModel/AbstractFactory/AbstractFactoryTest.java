package designModel.AbstractFactory;

/**
 * ***************************************************************************
 * Description  :抽象工厂模式是简单工厂、工厂方法、抽象工厂三个工厂模型里面最为抽象、最具一般性的。
 * 抽象工厂模式的用意为：给客户端提供一个接口，可以创建多个产品族中的产品对象。而且使用抽象工厂模式还要满足一下条件：
 * 1.系统中有多个产品族，而系统一次只可能消费其中一族产品
 * 2.同属于同一个产品族的产品以其使用。
 * Author       : cxx
 * Creation date: 2018/4/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        //表X数据的处理方式
        DBDaoFactory tabXDaoFactory = new TabXDaoFactory();
        DBTableDao mySqlTabx = tabXDaoFactory.getMySqlDao();
        DBTableDao oracleTabx = tabXDaoFactory.getOracleDao();

        //表Y数据的处理方式
        DBDaoFactory tabYDaoFactory = new TabYDaoFactory();
        DBTableDao mySqlTaby = tabYDaoFactory.getMySqlDao();
        DBTableDao oracleTaby = tabYDaoFactory.getOracleDao();

        System.out.println(mySqlTabx.saveInfo("-this tabXDaoFactory mySqlTabx"));
        System.out.println(oracleTabx.saveInfo("-this tabXDaoFactory oracleTabx"));

        System.out.println(mySqlTaby.saveInfo("-this tabYDaoFactory mySqlTaby"));
        System.out.println(oracleTaby.saveInfo("-this tabYDaoFactory oracleTaby"));
    }


}
