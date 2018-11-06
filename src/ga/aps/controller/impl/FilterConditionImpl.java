package ga.aps.controller.impl;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import ga.aps.controller.dao.FilterConditionDao;
import ga.aps.controller.entity.*;

public class FilterConditionImpl implements FilterConditionDao{
	private Connection conn;
	private static String cond = null;
	private PreparedStatement stat = null;

	public FilterConditionImpl(Connection conn) {
		this.conn = conn;
	}
	
//	@Override
//	public boolean doCreate(APS_FilterCondition FilterCondition) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("FilterConditionImpl-doCreate");
//		String sql = "insert into APS_FilterCondition(SiteCode,TemplateCode,TemplateText,Category,CreateUser,CreateDateTime,ModifyUser,ModifyDateTime)";
//		sql = sql + "values(?,?,?,?,?,?,?,?)";
//		
//		stat = conn.prepareStatement(sql);
//		stat.setString(1, FilterCondition.getSiteCode());
//		stat.setString(2, FilterCondition.getTemplateCode());
//		stat.setString(3, FilterCondition.getTemplateText());
//		stat.setString(4, FilterCondition.getCategory());
//		stat.setString(5, FilterCondition.getCreateUser());
//		stat.setDate(6, FilterCondition.getCreateDateTime());
//		stat.setString(7, FilterCondition.getModifyUser());
//		stat.setDate(8, FilterCondition.getModifyDateTime());
//		
//		int result = stat.executeUpdate();
//		if(result>0) {
//			return true;
//		}else {
//			return false;
//		}
//	}

	@Override
	public List<APS_FilterCondition> findFccodeAll(String SiteCode ,String FilterConditionCode) throws Exception {
		// TODO Auto-generated method stub
		String statu = null;
		System.out.println("FilterConditionImpl-findFccodeAll");
		if (SiteCode.equals("") && FilterConditionCode.equals("")) {
			statu = "0";
			cond = "";			
		}else if(SiteCode != null && FilterConditionCode.equals("")) {
			statu = "1";
			cond = " where SiteCode = ?";
		}else {
			statu = "2";
			cond = " where SiteCode = ? and FilterConditionCode = ?";
		}
		
		String sql = "SELECT * FROM APS_FilterCondition " + cond;
		
		stat = conn.prepareStatement(sql);
		if (statu.equals("0")){				
		}else if (statu.equals("1")){
			stat.setString(1, SiteCode);
		}else if(statu.equals("2")){
			stat.setString(1, SiteCode);
			stat.setString(2, FilterConditionCode);	
		}

		ResultSet rs = stat.executeQuery();
		APS_FilterCondition FilterCondition = null;
		List<APS_FilterCondition> list = new ArrayList<APS_FilterCondition>();
		while(rs.next()) {
			FilterCondition = new APS_FilterCondition();
			FilterCondition.setSiteCode(rs.getString(1));
			FilterCondition.setFilterConditionCode(rs.getString(2));
			FilterCondition.setFilterConditionText(rs.getString(3));
			FilterCondition.setExpression(rs.getString(4));
			FilterCondition.setLockFlag(rs.getBoolean(5));
			FilterCondition.setGroupId(rs.getString(6));
			FilterCondition.setATBEZ(rs.getString(7));
			FilterCondition.setATNAM(rs.getString(8));
			FilterCondition.setATWRT(rs.getString(9));
			FilterCondition.setATWTB(rs.getString(10));
			FilterCondition.setCreateUser(rs.getString(11));
			FilterCondition.setCreateDateTime(rs.getDate(12));
			FilterCondition.setModifyUser(rs.getString(13));
			FilterCondition.setModifyDateTime(rs.getDate(14));
			list.add(FilterCondition);
		}
		return list;
	}
	
	@Override
	public List<APS_FilterCondition> findAll(String SiteCode ,String TemplateCode) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FilterConditionImpl-findAll");
		if (SiteCode == null || TemplateCode == null) {
			cond = null;
		}else {
			cond = " where c.SiteCode = ? and c.TemplateCode = ?";
		}
		
		String sql = "SELECT f.* FROM APS_FilterCondition as f INNER JOIN APS_ConstraintTemplateItem as c "
				+ " ON f.FilterConditionCode = c.FilterConditionCode AND f.SiteCode = c.SiteCode " + cond;
		
		stat = conn.prepareStatement(sql);
		if (cond != null) {
			stat.setString(1, SiteCode);
			stat.setString(2, TemplateCode);	
		}

		ResultSet rs = stat.executeQuery();
		APS_FilterCondition FilterCondition = null;
		List<APS_FilterCondition> list = new ArrayList<APS_FilterCondition>();
		while(rs.next()) {
			FilterCondition = new APS_FilterCondition();
			FilterCondition.setSiteCode(rs.getString(1));
			FilterCondition.setFilterConditionCode(rs.getString(2));
			FilterCondition.setFilterConditionText(rs.getString(3));
			FilterCondition.setExpression(rs.getString(4));
			FilterCondition.setLockFlag(rs.getBoolean(5));
			FilterCondition.setGroupId(rs.getString(6));
			FilterCondition.setATBEZ(rs.getString(7));
			FilterCondition.setATNAM(rs.getString(8));
			FilterCondition.setATWRT(rs.getString(9));
			FilterCondition.setATWTB(rs.getString(10));
			FilterCondition.setCreateUser(rs.getString(11));
			FilterCondition.setCreateDateTime(rs.getDate(12));
			FilterCondition.setModifyUser(rs.getString(13));
			FilterCondition.setModifyDateTime(rs.getDate(14));
			list.add(FilterCondition);
		}
		return list;
	}
	
	@Override
	public APS_FilterCondition findById(String SiteCode ,String FilterConditionCode) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FilterConditionImpl-findById");
		String sql = "select * from APS_FilterCondition where SiteCode = ? and FilterConditionCode = ?";
		stat = conn.prepareStatement(sql);
		stat.setString(1, SiteCode);
		stat.setString(2, FilterConditionCode);
		ResultSet rs = stat.executeQuery();
		APS_FilterCondition FilterCondition = null;
		if(rs.next()) {
			FilterCondition = new APS_FilterCondition();
			FilterCondition.setSiteCode(rs.getString(1));
			FilterCondition.setFilterConditionCode(rs.getString(2));
			FilterCondition.setFilterConditionText(rs.getString(3));
			FilterCondition.setExpression(rs.getString(4));
			FilterCondition.setLockFlag(rs.getBoolean(5));
			FilterCondition.setGroupId(rs.getString(6));
			FilterCondition.setATBEZ(rs.getString(7));
			FilterCondition.setATNAM(rs.getString(8));
			FilterCondition.setATWRT(rs.getString(9));
			FilterCondition.setATWTB(rs.getString(10));
			FilterCondition.setCreateUser(rs.getString(11));
			FilterCondition.setCreateDateTime(rs.getDate(12));
			FilterCondition.setModifyUser(rs.getString(13));
			FilterCondition.setModifyDateTime(rs.getDate(14));
		}		
		return FilterCondition;
	}

}
