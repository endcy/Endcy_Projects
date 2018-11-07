package designModel.Strategy;

/**
 * ***************************************************************************
 * Description  : 38优惠为超过380块就打八折否者无折扣
 * Author       : cxx
 * Creation date: 2018/6/4.
 * Version      : 1.0
 * ***************************************************************************
 */
public class Strategy38 implements Strategy {
    @Override
    public double discount(double price) {
        return price * 0.8;
    }

    @Override
    public boolean ableDiscount(double price) {
        return price > 380;
    }
}
