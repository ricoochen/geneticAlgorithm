package ga.aps.controller.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ga.aps.controller.dao.*;
import ga.aps.controller.entity.APS_ConstraintTemplateItem;

public class ConstraintTemplateItemImpl implements ConstraintTemplateItemDao{
	private Connection conn;
	private static String cond = null;
	private PreparedStatement stat = null;

	public ConstraintTemplateItemImpl(Connection conn) {
		this.conn = conn;
	}
	
//	@Override
//	public boolean doCreate(APS_ConstraintTemplateItem ConstraintTemplateItem) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("ConstraintTemplateItemImpl-doCreate");
//		String sql = "insert into APS_ConstraintTemplateItem(SiteCode,TemplateCode,TemplateText,Category,CreateUser,CreateDateTime,ModifyUser,ModifyDateTime)";
//		sql = sql + "values(?,?,?,?,?,?,?,?)";
//		
//		stat = conn.prepareStatement(sql);
//		stat.setString(1, ConstraintTemplateItem.getSiteCode());
//		stat.setString(2, ConstraintTemplateItem.getTemplateCode());
//		stat.setString(3, ConstraintTemplateItem.getTemplateText());
//		stat.setString(4, ConstraintTemplateItem.getCategory());
//		stat.setString(5, ConstraintTemplateItem.getCreateUser());
//		stat.setDate(6, ConstraintTemplateItem.getCreateDateTime());
//		stat.setString(7, ConstraintTemplateItem.getModifyUser());
//		stat.setDate(8, ConstraintTemplateItem.getModifyDateTime());
//		
//		int result = stat.executeUpdate();
//		if(result>0) {
//			return true;
//		}else {
//			return false;
//		}
//	}

	@Override
	public List<APS_ConstraintTemplateItem> findAll(String SiteCode ,String ConstraintTemplateItemCode) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ConstraintTemplateItemImpl-findAll");
	
		String sql = "SELECT * FROM APS_ConstraintTemplateItem where SiteCode = ? and TemplateCode = ?";
		
		stat = conn.prepareStatement(sql);
		stat.setString(1, SiteCode);
		stat.setString(2, ConstraintTemplateItemCode);	
		ResultSet rs = stat.executeQuery();
		APS_ConstraintTemplateItem ConstraintTemplateItem = null;
		List<APS_ConstraintTemplateItem> list = new ArrayList<APS_ConstraintTemplateItem>();
		while(rs.next()) {
			ConstraintTemplateItem = new APS_ConstraintTemplateItem();
			ConstraintTemplateItem.setSiteCode(rs.getString(1));
			ConstraintTemplateItem.setTemplateCode(rs.getString(2));
			ConstraintTemplateItem.setOrdinal(rs.getInt(3));
			ConstraintTemplateItem.setFilterConditionCode(rs.getString(4));
			ConstraintTemplateItem.setConstraintRuleCode(rs.getString(5));
			ConstraintTemplateItem.setFromDay(rs.getInt(6));
			ConstraintTemplateItem.setToDay(rs.getInt(7));
			ConstraintTemplateItem.setMinValue(rs.getInt(8));
			ConstraintTemplateItem.setMaxValue(rs.getInt(9));
			ConstraintTemplateItem.setGroupSize(rs.getInt(10));
			ConstraintTemplateItem.setPrevConditionCode(rs.getString(11));
			ConstraintTemplateItem.setNextConditionCode(rs.getString(12));
			ConstraintTemplateItem.setWeight(rs.getInt(13));
			ConstraintTemplateItem.setHardFlag(rs.getBoolean(14));
			list.add(ConstraintTemplateItem);
		}
		return list;
	}
	
	
	@Override
	public APS_ConstraintTemplateItem findById(String SiteCode ,String ConstraintTemplateItemCode) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ConstraintTemplateItemImpl-findById");
		String sql = "select * from APS_ConstraintTemplateItem where SiteCode = ? and TemplateCode = ?";
		stat = conn.prepareStatement(sql);
		stat.setString(1, SiteCode);
		stat.setString(2, ConstraintTemplateItemCode);
		ResultSet rs = stat.executeQuery();
		APS_ConstraintTemplateItem ConstraintTemplateItem = null;
		if(rs.next()) {
			ConstraintTemplateItem = new APS_ConstraintTemplateItem();
			ConstraintTemplateItem.setSiteCode(rs.getString(1));
			ConstraintTemplateItem.setTemplateCode(rs.getString(2));
			ConstraintTemplateItem.setOrdinal(rs.getInt(3));
			ConstraintTemplateItem.setFilterConditionCode(rs.getString(4));
			ConstraintTemplateItem.setConstraintRuleCode(rs.getString(5));
			ConstraintTemplateItem.setFromDay(rs.getInt(6));
			ConstraintTemplateItem.setToDay(rs.getInt(7));
			ConstraintTemplateItem.setMinValue(rs.getInt(8));
			ConstraintTemplateItem.setMaxValue(rs.getInt(9));
			ConstraintTemplateItem.setGroupSize(rs.getInt(10));
			ConstraintTemplateItem.setPrevConditionCode(rs.getString(11));
			ConstraintTemplateItem.setNextConditionCode(rs.getString(12));
			ConstraintTemplateItem.setWeight(rs.getInt(13));
			ConstraintTemplateItem.setHardFlag(rs.getBoolean(14));
		}		
		return ConstraintTemplateItem;
	}

}
