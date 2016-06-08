package com.synchronizer;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	private static final int MAX_THREADS = 5;

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(MAX_THREADS, new Runnable() {
			private int count = 1;

			public void run() {
				System.out.printf("Cyclic Barrier Finished %d\n", count++);
			}
		});

		//System.out.println("Spawning Threads");
		for(int i=0;i<MAX_THREADS;i++) {
			Thread t = new Thread(new WorkerThread(cyclicBarrier, String.format("Thread-%d", i)));
			t.start();
		}
		//System.out.println("Spawning Finished");
	}
}