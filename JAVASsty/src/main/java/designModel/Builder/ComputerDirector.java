package designModel.Builder;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/5/30.
 * Version      : 1.0
 * ***************************************************************************
 */
public class ComputerDirector {
    public void prodComputer(IComputerBuilder computerBuilder){
        computerBuilder.createOem();
        computerBuilder.createScreen();
        computerBuilder.createMouse();
        computerBuilder.createID();
    }
}
