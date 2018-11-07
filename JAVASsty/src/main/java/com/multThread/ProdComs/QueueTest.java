package com.multThread.ProdComs;

import java.util.concurrent.TimeUnit;

public class QueueTest {
	/*
	 * 生产者测试实现
	 */
	static class ProducerMock extends Producer {

		final int seconds;

		public ProducerMock(Queue queue, int seconds) {
			super(queue);
			this.seconds = seconds;
		}

		@Override
		public Product produce() {
			try {
				TimeUnit.SECONDS.sleep(seconds);
			} catch (InterruptedException ex) {
			}
			return new Product() {
			};
		}
	}

	/*
	 * 消费者测试实现
	 */
	static class ConsumerMock extends Consumer {

		final int seconds;

		public ConsumerMock(Queue queue, int seconds) {
			super(queue);
			this.seconds = seconds;
		}

		@Override
		public void consume(Product p) {
			try {
				TimeUnit.SECONDS.sleep(seconds);
			} catch (InterruptedException ex) {
			}
		}
	}

	/**
	 * 1 对 1
	 */
	public static void testOneToOne() {
		Queue queue = new Queue(1);
		new Thread(new ProducerMock(queue, 1)).start();
		new Thread(new ConsumerMock(queue, 1)).start();
	}

	/**
	 * 多对多
	 */
	public static void testManyToMany() {
		Queue queue = new Queue(10);
		for (int i = 0; i < 100; i++) {
			new Thread(new ProducerMock(queue, 2)).start();
		}
		for (int i = 0; i < 100; i++) {
			new Thread(new ConsumerMock(queue, 2)).start();
		}
	}

	/**
	 * 生产者多，注意队列要大小要大
	 */
	public static void testManyToSome() {
		Queue queue = new Queue(50);
		for (int i = 0; i < 10; i++) {
			new Thread(new ProducerMock(queue, 3)).start();
		}
		for (int i = 0; i < 5; i++) {
			new Thread(new ConsumerMock(queue, 1)).start();
		}
	}

	public static void main(String[] args) {
//		testOneToOne();
//		testManyToMany();
		testManyToSome();
	}
}