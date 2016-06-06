package com.concurrency.synchroniser.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.concurrency.synchroniser.Boss;
import com.concurrency.synchroniser.Worker;



public class CountDownLatchDemo {

	public CountDownLatchDemo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		CountDownLatch latch = new CountDownLatch(3);

		Worker w1 = new Worker(latch, "Worker1");
		Worker w2 = new Worker(latch, "Worker2");
		Worker w3 = new Worker(latch, "Worker3");
		Boss boss = new Boss(latch);
		 System.out.println("The boss is waiting for all the workers finished work ...... ");  
		executor.execute(w3);
		executor.execute(w2);
		executor.execute(w1);
		executor.execute(boss);

		executor.shutdown();
	}

}
