package ga.aps.controller.dao;

import java.util.List;
import ga.aps.controller.entity.APS_ConstraintRule;

public interface ConstraintRuleDao {
	//创建
	//public boolean doCreate(APS_FilterCondition filterCondition) throws Exception;
	//查询所有
	public List<APS_ConstraintRule> findAll(String SiteCode,String TemplateCode) throws Exception;
	//条件查询
	public APS_ConstraintRule findById(String SiteCode,String TemplateCode) throws Exception;
}
