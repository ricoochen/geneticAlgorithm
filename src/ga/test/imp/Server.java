package ga.test.imp;

import ga.test.dao.CSCallBack;

/** @author Jeff Lee 
 * @since 2015-10-21 21:24:15 
 * 回调模式-模拟服务端类 
*/ 
public class Server {      
	public void getClientMsg(CSCallBack csCallBack , String msg) {         
		System.out.println("服务端：服务端接收到客户端发送的消息为:" + msg);          
		// 模拟服务端需要对数据处理         
		try {             
			//Thread.sleep(5 * 1000);
			System.out.println("服务端:执行Thread");    
		} catch (Exception e) {             //InterruptedException 
			e.printStackTrace();         
		}         
		System.out.println("服务端:数据处理成功，返回成功状态 200");         
		String status = "200";         
		csCallBack.process(status);     
	}
}
