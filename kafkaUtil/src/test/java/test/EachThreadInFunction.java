package test;

import com.paic.kafka.ConsumerDemo;
import com.paic.kafka.ProducerDemo;

public class EachThreadInFunction {

    public static void main(String[] args) {
        //消费1
        new ThreadRunning(){
            @Override
            void startFunction() {
                ConsumerDemo.consume();
            }
        };
        //生产
        new ThreadRunning(){
            @Override
            void startFunction() {
                ProducerDemo.produce();
            }
        };

    }

    abstract static class ThreadRunning {
        ThreadRunning() {
            new Thread() {
                @Override
                public void run() {
                    startFunction();
                }
            }.start();
        }

        abstract void startFunction();
    }
}
