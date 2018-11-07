package designModel.Strategy;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/6/4.
 * Version      : 1.0
 * ***************************************************************************
 */
public interface Strategy {
    double discount(double price);

    boolean ableDiscount(double price);
}
