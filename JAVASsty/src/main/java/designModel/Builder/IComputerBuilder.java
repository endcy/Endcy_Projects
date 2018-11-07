package designModel.Builder;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/5/30.
 * Version      : 1.0
 * ***************************************************************************
 */
interface IComputerBuilder {
    Computer getComputer();

    void createOem();

    void createMouse();

    void createScreen();

    void createID();


}
