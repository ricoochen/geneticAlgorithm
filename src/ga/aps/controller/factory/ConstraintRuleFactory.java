package ga.aps.controller.factory;

import ga.aps.controller.dao.ConstraintRuleDao;
import ga.aps.controller.services.ConstraintRuleService;

public class ConstraintRuleFactory {
	  public static ConstraintRuleDao getInstance() {
		  ConstraintRuleDao dao = null;
		  try {
			  dao = new ConstraintRuleService();
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return dao;
	  }
}
