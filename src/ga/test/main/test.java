package ga.test.main;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class test {

     public static void main(String[] args) {    

         ThreadPoolExecutor executor = new ThreadPoolExecutor(
        		 //corePoolSize=10  maximumPoolSize=13 
        		 //当线程的数目到达10个的时候,下一个线程就会进入到缓存队列中
                 //此缓存队列中默认有5个线程,当缓存队列中的线程超过默认值的时候就会重新创建线程,
                 //并且线程数目最多为13+默认缓存队列的值''
        		 10,   
        		 13,  
        		 200, 
        		 TimeUnit.MILLISECONDS, 
                 new ArrayBlockingQueue<Runnable>(5)  
                 );

          

         for(int i=0;i<25;i++){
        	 int x = 0;
        	 int y = 0;
        	 
             MyTask myTask = new MyTask(i);
             
             y = executor.getPoolSize() + executor.getQueue().size();
             
             while(y > 17) {
            	 y = executor.getPoolSize() + executor.getQueue().size();
             }
             executor.execute(myTask);

             System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+

             executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());

         }

         executor.shutdown();

     } 

}

 

 

class MyTask implements Runnable {

    private int taskNum;

     

    public MyTask(int num) {

        this.taskNum = num;

    }

     

    @Override

    public void run() {

        System.out.println("正在执行task "+taskNum);

        try {

            Thread.currentThread();
			Thread.sleep(4000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        System.out.println("task "+taskNum+"执行完毕");

    }

}