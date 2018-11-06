package ga.aps.controller.dao;

import java.util.List;
import ga.aps.controller.entity.*;

public interface FilterConditionDao {
	//创建
	//public boolean doCreate(APS_FilterCondition filterCondition) throws Exception;
	//根据工厂/条件编号查询
	public List<APS_FilterCondition> findFccodeAll(String SiteCode,String FilterConditionCode) throws Exception;
	//根据工厂/模板编号查询所有
	public List<APS_FilterCondition> findAll(String SiteCode,String TemplateCode) throws Exception;
	//条件查询
	public APS_FilterCondition findById(String SiteCode,String FilterConditionCode) throws Exception;
}
