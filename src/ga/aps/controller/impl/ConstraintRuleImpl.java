package ga.aps.controller.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ga.aps.controller.dao.ConstraintRuleDao;
import ga.aps.controller.entity.APS_ConstraintRule;

public class ConstraintRuleImpl implements ConstraintRuleDao {
	private Connection conn;
	private static String cond = null;
	private PreparedStatement stat = null;

	public ConstraintRuleImpl(Connection conn) {
		this.conn = conn;
	}
	
//	@Override
//	public boolean doCreate(APS_ConstraintRule ConstraintRule) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("ConstraintRuleImpl-doCreate");
//		String sql = "insert into APS_ConstraintRule(SiteCode,TemplateCode,TemplateText,Category,CreateUser,CreateDateTime,ModifyUser,ModifyDateTime)";
//		sql = sql + "values(?,?,?,?,?,?,?,?)";
//		
//		stat = conn.prepareStatement(sql);
//		stat.setString(1, ConstraintRule.getSiteCode());
//		stat.setString(2, ConstraintRule.getTemplateCode());
//		stat.setString(3, ConstraintRule.getTemplateText());
//		stat.setString(4, ConstraintRule.getCategory());
//		stat.setString(5, ConstraintRule.getCreateUser());
//		stat.setDate(6, ConstraintRule.getCreateDateTime());
//		stat.setString(7, ConstraintRule.getModifyUser());
//		stat.setDate(8, ConstraintRule.getModifyDateTime());
//		
//		int result = stat.executeUpdate();
//		if(result>0) {
//			return true;
//		}else {
//			return false;
//		}
//	}
	

	@Override
	public List<APS_ConstraintRule> findAll(String SiteCode ,String ConstraintRuleCode) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ConstraintRuleImpl-findAll");
		if (SiteCode == null || ConstraintRuleCode == null) {
			cond = null;
		}else {
			cond = " where c.SiteCode = ? and c.TemplateCode = ?";
		}
		
		String sql = "SELECT f.* FROM APS_ConstraintRule as f INNER JOIN APS_ConstraintTemplateItem as c "
				+ " ON f.ConstraintRuleCode = c.ConstraintRuleCode AND f.SiteCode = c.SiteCode " + cond;
		
		stat = conn.prepareStatement(sql);
		if (cond != null) {
			stat.setString(1, SiteCode);
			stat.setString(2, ConstraintRuleCode);	
		}

		ResultSet rs = stat.executeQuery();
		APS_ConstraintRule ConstraintRule = null;
		List<APS_ConstraintRule> list = new ArrayList<APS_ConstraintRule>();
		while(rs.next()) {
			ConstraintRule = new APS_ConstraintRule();
			ConstraintRule.setSiteCode(rs.getString(1));
			ConstraintRule.setConstraintRuleCode(rs.getString(2));
			ConstraintRule.setConstraintRuleText(rs.getString(3));
			ConstraintRule.setCategory(rs.getString(4));
			list.add(ConstraintRule);
		}
		return list;
	}

	@Override
	public APS_ConstraintRule findById(String SiteCode ,String ConstraintRuleCode) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ConstraintRuleImpl-findById");
		String sql = "select * from APS_ConstraintRule where SiteCode = ? and ConstraintRuleCode = ?";
		stat = conn.prepareStatement(sql);
		stat.setString(1, SiteCode);
		stat.setString(2, ConstraintRuleCode);
		ResultSet rs = stat.executeQuery();
		APS_ConstraintRule ConstraintRule = null;
		if(rs.next()) {
			ConstraintRule = new APS_ConstraintRule();
			ConstraintRule.setSiteCode(rs.getString(1));
			ConstraintRule.setConstraintRuleCode(rs.getString(2));
			ConstraintRule.setConstraintRuleText(rs.getString(3));
			ConstraintRule.setCategory(rs.getString(4));
		}		
		return ConstraintRule;
	}

}
