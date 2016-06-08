package com.synchronizer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CyclicBarrier;

public class WorkerThread implements Runnable {

	 private CyclicBarrier cyclicBarrier;
     
     private String name;
     
     public WorkerThread(CyclicBarrier cyclicBarrier, String name) {
         this.name = name;
         this.cyclicBarrier = cyclicBarrier;
     }
     
     public void run() {
         try {
             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");                
             System.out.printf("%s : Doing Step 1 Work on %s\n", getFormattedDate(sdf), name);
             Thread.sleep(getRandomWaitTime());
            /* System.out.printf("%s : Doing Step 1 more work on %s\n", getFormattedDate(sdf), name);
             Thread.sleep(getRandomWaitTime());*/
             System.out.printf("%s : Finished Step 1 work on %s\n", getFormattedDate(sdf), name);
             int count = cyclicBarrier.await(); // Await returns an int which is the arrival index 1 means first 0 means last
             System.out.printf("%s : Cyclic Barrier count on %s is %d\n", getFormattedDate(sdf), name, count);
             if(count == 0) {
                 cyclicBarrier.reset();
             }
             System.out.printf("%s : Doing Step 2 Batch of Work on %s\n", getFormattedDate(sdf), name);
             Thread.sleep(getRandomWaitTime());
            /* System.out.printf("%s : Doing Some more Step 2 Batch of work on %s\n", getFormattedDate(sdf), name);
             Thread.sleep(getRandomWaitTime());*/
             System.out.printf("%s : Finished Step 2 Batch of work on %s\n", getFormattedDate(sdf), name);
             count = cyclicBarrier.await();
             System.out.printf("%s : Cyclic Barrier count end of Step 2 Batch of work on %s is %d\n", getFormattedDate(sdf), name, count);
         } catch(Exception e) {
             e.printStackTrace();
         }
     }
     
     private String getFormattedDate(SimpleDateFormat sdf) {
         return sdf.format(new Date());
     }
     
     private int getRandomWaitTime() {
         return (int) ((Math.random() + 1) * 1000);
     }
     
 }

