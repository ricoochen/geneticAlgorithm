package ga.aps.controller.factory;

import ga.aps.controller.dao.FilterConditionDao;
import ga.aps.controller.services.FilterConditionService;

public class FilterConditionFactory {
	  public static FilterConditionDao getInstance() {
		  FilterConditionDao dao = null;
		  try {
			  dao = new FilterConditionService();
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return dao;
	  }
}