package com.multThread.ProdComs;

public abstract class Consumer implements Runnable{
    protected  Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    public abstract void consume(Product p);

    public void run() {
        while (true) {
            Product p =queue.get();
            consume(p);
        }
    }
}
