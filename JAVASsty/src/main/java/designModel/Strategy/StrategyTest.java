package designModel.Strategy;

/**
 * ***************************************************************************
 * Description  :Strategy模式也叫策略模式是行为模式之一，它对一系列的算法加以封装，
 * 为所有算法定义一个抽象的算法接口，并通过继承该抽象算法接口对所有的算法加以封装和实现，
 * 具体的算法选择交由客户端决定（策略）。Strategy模式主要用来平滑地处理算法的切换 。
 * Author       : cxx
 * Creation date: 2018/6/4.
 * Version      : 1.0
 * ***************************************************************************
 */
public class StrategyTest {
    public static void main(String[] args) {
        Strategy strategy38 = new Strategy38();
        Strategy strategy51 = new Strategy51();
        Context context = new Context(strategy38);
        double price = 300;
        System.out.println(context.cost(price));
        context = new Context(strategy51);
        System.out.println(context.cost(price));
    }
}
