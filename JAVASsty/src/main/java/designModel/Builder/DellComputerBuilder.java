package designModel.Builder;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/5/30.
 * Version      : 1.0
 * ***************************************************************************
 */
public class DellComputerBuilder implements IComputerBuilder {
    Computer computer = new Computer();

    @Override
    public Computer getComputer() {
        return computer;
    }

    @Override
    public void createOem() {
        computer.setOem("DELL");
    }

    @Override
    public void createMouse() {
        computer.setMouse("DELL:ADD Mouse");
    }

    @Override
    public void createScreen() {
        computer.setScreen("DELL:ADD Screen");
    }

    @Override
    public void createID() {
        computer.setId(100);
    }

}
