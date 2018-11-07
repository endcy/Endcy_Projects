package designModel.FactoryMethod;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/4/26.
 * Version      : 1.0
 * ***************************************************************************
 */
public class BlueColorFactory implements ColorFactory {
    @Override
    public Color getColor() {
        return new BlueColor();
    }
}
