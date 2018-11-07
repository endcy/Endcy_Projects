package com.multThread.ProdComs;

public class Queue {
	private Product[] products;
	private volatile int currentIndex;
	private final Object lock = new Object();

	/**
	 * @param size
	 *            队列的大小
	 */
	public Queue(int size) {
		this.products = new Product[size];
		this.currentIndex = 0;
	}

	/**
	 * 向队列里增加一个产品
	 * 
	 * @param p
	 */
	public void add(Product p) {
		synchronized (lock) {
			if (currentIndex < products.length) {
				this.products[currentIndex++] = p;
				System.out.println("生产一个产品,现有:" + (currentIndex));
				lock.notifyAll();
			} else {
				try {
					lock.wait();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * 从队列里移除一个产品
	 * 
	 * @return
	 */
	public Product get() {
		Product result = null;
		synchronized (lock) {
			if (currentIndex > 0) {
				result = this.products[--currentIndex];
				System.out.println("消费一个产品,现有:" + (currentIndex));
				lock.notifyAll();
			} else {
				try {
					lock.wait();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
		return result;
	}

	/**
	 * @deprecated
	 */
	public int size() {
		synchronized (lock) {
			return currentIndex;
		}

	}
}
