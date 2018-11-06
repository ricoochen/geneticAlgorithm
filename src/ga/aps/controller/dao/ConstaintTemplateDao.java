package ga.aps.controller.dao;

import java.util.List;
import ga.aps.controller.entity.*;

public interface ConstaintTemplateDao {
	//创建
	public boolean doCreate(APS_ConstaintTemplate ConstaintTemplate) throws Exception;
	//查询所有
	public List<APS_ConstaintTemplate> findAll() throws Exception;
	//查询单条
	public APS_ConstaintTemplate findById(String SiteCode,String TemplateCode) throws Exception;
}
