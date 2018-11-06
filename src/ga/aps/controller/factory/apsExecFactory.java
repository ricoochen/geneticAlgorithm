package ga.aps.controller.factory;

import ga.aps.controller.dao.apsExecDao;
import ga.aps.controller.services.apsExecService;
import ga.aps.controller.entity.*;

public class apsExecFactory {
	  public static apsExecDao getInstance(APScs_Thread_parameters ThreadPara) {
		  apsExecDao dao = null;
		  try {
			  System.out.println("apsExecDao-Factory");
			  if (ThreadPara == null) {
				  dao = new apsExecService();
			  }else {
				  dao = new apsExecService(ThreadPara);  
			  }			  
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return dao;
	  }
}
