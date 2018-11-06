package ga.aps.controller.services;

import java.util.List;
import ga.aps.controller.impl.ConstaintTemplateImpl;
import ga.aps.controller.myConnection.DBConnection;
import ga.aps.controller.dao.ConstaintTemplateDao;
import ga.aps.controller.entity.APS_ConstaintTemplate;

public class ConstanintTemplateService implements ConstaintTemplateDao {
	private DBConnection dbc;
	private ConstaintTemplateDao dao = null;
	
	//数据库连接+实现类Impl
	public ConstanintTemplateService() throws Exception{
		System.out.println("proxy-ConstanintTemplateService");
		dbc = new DBConnection();
		dao = new ConstaintTemplateImpl(dbc.getConnection());
	}
	
	//创建
	@Override
	public boolean doCreate(APS_ConstaintTemplate ConstaintTemplate) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("proxy-ConstanintTemplateService-doCreate");
		boolean flag = false;
		APS_ConstaintTemplate location = new APS_ConstaintTemplate();
		location = dao.findById(ConstaintTemplate.getSiteCode(),ConstaintTemplate.getTemplateCode());
		if (location==null) {
			flag = dao.doCreate(ConstaintTemplate);
		}
		dbc.close();
		return flag;
	}
	
	//查询所有
	@Override
	public List<APS_ConstaintTemplate> findAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("proxy-ConstanintTemplateService-findAll");
		List<APS_ConstaintTemplate>	list = dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public APS_ConstaintTemplate findById(String SiteCode,String TemplateCode) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("proxy-findById");
		APS_ConstaintTemplate location = dao.findById(SiteCode,TemplateCode);
		dbc.close();
		return location;
	}

}