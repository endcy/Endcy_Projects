package designModel.FactoryMethod;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/4/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public class BlackColorFactory implements ColorFactory {
    @Override
    public Color getColor() {
        return new BlackColor();
    }
}
