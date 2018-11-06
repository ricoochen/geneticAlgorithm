package ga.aps.controller.myConnection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import ga.aps.controller.entity.APScs_Thread_parameters;

public class ThreadPool {	
	private ExecutorService threadPool = null;
	
	public ThreadPool(APScs_Thread_parameters ThreadPara) {
		//阻塞队列
		BlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<Runnable>(ThreadPara.getWorkQueue());  
		//CallerRunsPolicy() 任务>(最大线程+阻塞队列)则创建新的主线程
		RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();	
		//线程池
		threadPool = new ThreadPoolExecutor(
				ThreadPara.getCorePoolSize(),     //核心线程数
				ThreadPara.getMaximumPoolSize(),  //最大线程数
				ThreadPara.getKeepAliveTime(),	  //销毁时间
				TimeUnit.MILLISECONDS,			  //单位
				workingQueue, 					  //阻塞队列
				rejectedExecutionHandler);        //Exception
		
		//获取future中返回值
		//completionService = new ExecutorCompletionService<String>(threadPool);
	}
	
	public ExecutorService getThreadPool() throws Exception{
		return threadPool;		
	}
	
	public void ThreadShutdown() throws Exception{
		threadPool.shutdown();
	}
}
