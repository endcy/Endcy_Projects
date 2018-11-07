package designModel.Builder;

/**
 * ***************************************************************************
 * Description  : Builder模式是一种对象创建型模式之一，用来隐藏复合对象的创建过程，
 * 它把复合对象的创建过程加以抽象，通过子类继承和重载的方式，动态地创建具有复合属性的对象
 * Author       : cxx
 * Creation date: 2018/5/30.
 * Version      : 1.0
 * ***************************************************************************
 */
public class BuilderTest {
    public static void main(String[] args) {
        //建造者
        ComputerDirector computerDirector = new ComputerDirector();
        //设计者
        IComputerBuilder computerBuilder = new DellComputerBuilder();

        computerDirector.prodComputer(computerBuilder);
        Computer dellComputer = computerBuilder.getComputer();
        System.out.println(dellComputer);

        computerBuilder = new XiaomiComputerBuilder();
        computerDirector.prodComputer(computerBuilder);
        Computer xiaomiComputer = computerBuilder.getComputer();
        System.out.println(xiaomiComputer);
    }

}
