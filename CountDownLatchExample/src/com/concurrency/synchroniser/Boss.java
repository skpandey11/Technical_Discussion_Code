package com.concurrency.synchroniser;

import java.util.concurrent.CountDownLatch;

/**
 * @author Sunil
 *
 */
public class Boss implements Runnable{

	private CountDownLatch downLatch;  
    
    public Boss(CountDownLatch downLatch){  
        this.downLatch = downLatch;  
    }  
      
    public void run() {  
       
        try {  
            this.downLatch.await();  
        } catch (InterruptedException e) {  
        }  
        System.out.println("workers are finished the assigned work, the boss began to check out! ");  
    }  
}
