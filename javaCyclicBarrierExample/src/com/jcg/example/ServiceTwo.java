package com.jcg.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * @author Sunil
 *
 */
public class ServiceTwo implements Runnable {
	
	private final CyclicBarrier cyclicBarrier;

	public ServiceTwo(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		System.out.println("Starting service Two....");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Service Two has finished its work.. waiting for others...");
		try {
			/*If the current thread is not the last to arrive then it is disabled for thread scheduling purposes and lies dormant until one of the following things happens: 

				The last thread arrives; or 
				Some other thread interrupts the current thread; or 
				Some other thread interrupts one of the other waiting threads; or 
				Some other thread times out while waiting for barrier; or 
				Some other thread invokes reset on this barrier. */

			cyclicBarrier.await();
		} catch (InterruptedException e) {
			System.out.println("Service one interrupted!");
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			System.out.println("Service one interrupted!");
			e.printStackTrace();
		}
		System.out.println("The wait is over, lets complete Service two!");

	}

}
