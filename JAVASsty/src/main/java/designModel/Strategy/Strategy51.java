package designModel.Strategy;

/**
 * ***************************************************************************
 * Description  : 51优惠为超过100块就打九折否者无折扣
 * Author       : cxx
 * Creation date: 2018/6/4.
 * Version      : 1.0
 * ***************************************************************************
 */
public class Strategy51 implements Strategy {
    @Override
    public double discount(double price) {
        return price * 0.9;
    }

    @Override
    public boolean ableDiscount(double price) {
        return price > 100;
    }
}
