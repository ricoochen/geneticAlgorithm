package ga.aps.controller.services;

import java.util.List;

import ga.aps.controller.entity.*;
import ga.aps.controller.impl.*;
import ga.aps.controller.dao.*;
import ga.aps.controller.myConnection.DBConnection;

public class ConstraintRuleService implements ConstraintRuleDao{
	private DBConnection dbc;
	private ConstraintRuleImpl dao = null;
	
	//数据库连接+实现类Impl
	public ConstraintRuleService() throws Exception{
		dbc = new DBConnection();
		dao = new ConstraintRuleImpl(dbc.getConnection());
	}
	
	//创建
//	@Override
//	public boolean doCreate(APS_ConstraintRule ConstraintRule) throws Exception {
//		// TODO Auto-generated method stub
//		boolean flag = false;
//		APS_ConstraintRule location = new APS_ConstraintRule();
//		location = dao.findById(ConstraintRule.getSiteCode(),ConstraintRule.getTemplateCode());
//		if (location==null) {
//			flag = dao.doCreate(ConstraintRule);
//		}
//		dbc.close();
//		return flag;
//	}
//	
	//查询所有
	public List<APS_ConstraintRule> findAll(String SiteCode,String ConstraintRule) throws Exception {
		// TODO Auto-generated method stub
		List<APS_ConstraintRule>	list = dao.findAll(SiteCode,ConstraintRule);
		dbc.close();
		return list;
	}

	public APS_ConstraintRule findById(String SiteCode,String TemplateCode) throws Exception {
		// TODO Auto-generated method stub
		APS_ConstraintRule location = dao.findById(SiteCode,TemplateCode);
		dbc.close();
		return location;
	}
}
