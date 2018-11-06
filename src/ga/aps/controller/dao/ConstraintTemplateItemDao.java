package ga.aps.controller.dao;

import java.util.List;

import ga.aps.controller.entity.APS_ConstraintTemplateItem;;

public interface ConstraintTemplateItemDao {
	//创建
	//public boolean doCreate(APS_FilterCondition filterCondition) throws Exception;
	//查询所有
	public List<APS_ConstraintTemplateItem> findAll(String SiteCode,String TemplateCode) throws Exception;
	//条件查询
	public APS_ConstraintTemplateItem findById(String SiteCode,String TemplateCode) throws Exception;
}
