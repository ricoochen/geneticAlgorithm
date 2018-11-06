package ga.aps.controller.factory;

import ga.aps.controller.dao.ConstraintTemplateItemDao;
import ga.aps.controller.services.ConstraintTemplateItemService;;

public class ConstraintTemplateItemFactory {
	  public static ConstraintTemplateItemDao getInstance() {
		  ConstraintTemplateItemDao dao = null;
		  try {
			  dao = new ConstraintTemplateItemService();
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return dao;
	  }
}
