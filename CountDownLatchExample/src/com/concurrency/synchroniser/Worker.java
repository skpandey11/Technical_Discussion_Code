package com.concurrency.synchroniser;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit; 

/**
 * @author Sunil
 *
 */
public class Worker implements Runnable {

	private CountDownLatch downLatch;  
    private String name;  
      
    public Worker(CountDownLatch downLatch, String name){  
        this.downLatch = downLatch;  
        this.name = name;  
    }  
      
    public void run() {  
        this.doWork();  
        try{  
            //TimeUnit.SECONDS.sleep(new Random().nextInt(10));  
            Thread.sleep(3000);
        }catch(InterruptedException ie){  
        }  
        System.out.println(this.name + "  finished the job");  
        this.downLatch.countDown();  
          
    }  
      
    private void doWork(){  
        System.out.println(this.name + " is working !");  
    }  
}
