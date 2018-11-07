package com.multThread.ProdComs;

public abstract class Producer implements Runnable{
    protected  Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    abstract public Product produce();

    public void run() {
        while (true) {
            Product p =produce();
           queue.add(p);
        }
    }
}
