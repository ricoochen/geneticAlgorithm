package ga.aps.controller.factory;

import ga.aps.controller.dao.ConstaintTemplateDao;
import ga.aps.controller.services.ConstanintTemplateService;

public class ConstaintTemplateFactory {
	  public static ConstaintTemplateDao getInstance() {
		  ConstaintTemplateDao dao = null;
		  try {
			  System.out.println("ConstaintTemplate-Factory");
			  dao = new ConstanintTemplateService();
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return dao;
	  }
}
