package ga.aps.controller.services;

import java.util.List;

import ga.aps.controller.dao.ConstraintTemplateItemDao;
import ga.aps.controller.entity.APS_ConstraintTemplateItem;
import ga.aps.controller.impl.ConstraintTemplateItemImpl;
import ga.aps.controller.myConnection.DBConnection;

public class ConstraintTemplateItemService implements ConstraintTemplateItemDao {
	private DBConnection dbc;
	private ConstraintTemplateItemImpl dao = null;
	
	//数据库连接+实现类Impl
	public ConstraintTemplateItemService() throws Exception{
		dbc = new DBConnection();
		dao = new ConstraintTemplateItemImpl(dbc.getConnection());
	}
	
	//创建
//	@Override
//	public boolean doCreate(APS_ConstraintTemplateItem ConstraintTemplateItem) throws Exception {
//		// TODO Auto-generated method stub
//		boolean flag = false;
//		APS_ConstraintTemplateItem location = new APS_ConstraintTemplateItem();
//		location = dao.findById(ConstraintTemplateItem.getSiteCode(),ConstraintTemplateItem.getTemplateCode());
//		if (location==null) {
//			flag = dao.doCreate(ConstraintTemplateItem);
//		}
//		dbc.close();
//		return flag;
//	}
//	
	//查询所有
	@Override
	public List<APS_ConstraintTemplateItem> findAll(String SiteCode,String ConstraintTemplateItem) throws Exception {
		// TODO Auto-generated method stub
		List<APS_ConstraintTemplateItem>	list = dao.findAll(SiteCode,ConstraintTemplateItem);
		dbc.close();
		return list;
	}

	@Override
	public APS_ConstraintTemplateItem findById(String SiteCode,String TemplateCode) throws Exception {
		// TODO Auto-generated method stub
		APS_ConstraintTemplateItem location = dao.findById(SiteCode,TemplateCode);
		dbc.close();
		return location;
	}
}
