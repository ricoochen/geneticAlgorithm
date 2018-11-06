package ga.aps.controller.entity;

/**
 * @author chenruike
 *
 */
public class APScs_Thread_parameters {
	private int corePoolSize;
	private int maximumPoolSize;
	private int keepAliveTime;
	private int workQueue;
	
	public APScs_Thread_parameters() {
		super();
	}

	public APScs_Thread_parameters(int corePoolSize, int maximumPoolSize, int keepAliveTime, int workQueue) {
		super();
		this.corePoolSize = corePoolSize;
		this.maximumPoolSize = maximumPoolSize;
		this.keepAliveTime = keepAliveTime;
		this.workQueue = workQueue;
	}
	
	public int getCorePoolSize() {
		return corePoolSize;
	}
	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}
	public int getMaximumPoolSize() {
		return maximumPoolSize;
	}
	public void setMaximumPoolSize(int maximumPoolSize) {
		this.maximumPoolSize = maximumPoolSize;
	}
	public int getKeepAliveTime() {
		return keepAliveTime;
	}
	public void setKeepAliveTime(int keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}
	public int getWorkQueue() {
		return workQueue;
	}
	public void setWorkQueue(int workQueue) {
		this.workQueue = workQueue;
	}	

}
