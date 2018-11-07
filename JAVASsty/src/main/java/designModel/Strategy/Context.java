package designModel.Strategy;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/6/4.
 * Version      : 1.0
 * ***************************************************************************
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double cost(double price) {
        String discName = strategy.getClass().getSimpleName();
        if (strategy.ableDiscount(price)){
            System.out.println(discName + " discount OK!");
            return strategy.discount(price);}
        System.out.println(discName + " can't discount for this price!");
        return price;
    }
}
