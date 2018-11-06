package ga.aps.controller.impl;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import ga.aps.controller.dao.*;
import ga.aps.controller.entity.*;

public class ConstaintTemplateImpl implements ConstaintTemplateDao {
	private Connection conn;
	private PreparedStatement stat = null;

	public ConstaintTemplateImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean doCreate(APS_ConstaintTemplate ConstaintTemplate) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ConstaintTemplateImpl-doCreate");
		String sql = "insert into APS_ConstaintTemplate(SiteCode,TemplateCode,TemplateText,Category,CreateUser,CreateDateTime,ModifyUser,ModifyDateTime)";
		sql = sql + "values(?,?,?,?,?,?,?,?)";
		
		stat = conn.prepareStatement(sql);
		stat.setString(1, ConstaintTemplate.getSiteCode());
		stat.setString(2, ConstaintTemplate.getTemplateCode());
		stat.setString(3, ConstaintTemplate.getTemplateText());
		stat.setString(4, ConstaintTemplate.getCategory());
		stat.setString(5, ConstaintTemplate.getCreateUser());
		stat.setDate(6, ConstaintTemplate.getCreateDateTime());
		stat.setString(7, ConstaintTemplate.getModifyUser());
		stat.setDate(8, ConstaintTemplate.getModifyDateTime());
		
		int result = stat.executeUpdate();
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<APS_ConstaintTemplate> findAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ConstaintTemplateImpl-findAll");
		String sql = "select * from APS_ConstaintTemplate";
		stat = conn.prepareStatement(sql);
		ResultSet rs = stat.executeQuery();
		APS_ConstaintTemplate ConstaintTemplate = null;
		List<APS_ConstaintTemplate> list = new ArrayList<APS_ConstaintTemplate>();
		while(rs.next()) {
			ConstaintTemplate = new APS_ConstaintTemplate();
			ConstaintTemplate.setSiteCode(rs.getString(1));
			ConstaintTemplate.setTemplateCode(rs.getString(2));
			ConstaintTemplate.setTemplateText(rs.getString(3));
			ConstaintTemplate.setCategory(rs.getString(4));
			ConstaintTemplate.setCreateUser(rs.getString(5));
			ConstaintTemplate.setCreateDateTime(rs.getDate(6));
			ConstaintTemplate.setModifyUser(rs.getString(7));
			ConstaintTemplate.setModifyDateTime(rs.getDate(8));
			list.add(ConstaintTemplate);
		}
		return list;
	}

	@Override
	public APS_ConstaintTemplate findById(String SiteCode ,String TemplateCode ) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ConstaintTemplateImpl-findById");
		String sql = "select * from APS_ConstaintTemplate where SiteCode = ? and TemplateCode = ?";
		stat = conn.prepareStatement(sql);
		stat.setString(1, SiteCode);
		stat.setString(2, TemplateCode);
		ResultSet rs = stat.executeQuery();
		APS_ConstaintTemplate ConstaintTemplate = null;
		if(rs.next()) {
			ConstaintTemplate = new APS_ConstaintTemplate();
			ConstaintTemplate.setSiteCode(rs.getString(1));
			ConstaintTemplate.setTemplateCode(rs.getString(2));
			ConstaintTemplate.setTemplateText(rs.getString(3));
			ConstaintTemplate.setCategory(rs.getString(4));
			ConstaintTemplate.setCreateUser(rs.getString(5));
			ConstaintTemplate.setCreateDateTime(rs.getDate(6));
			ConstaintTemplate.setModifyUser(rs.getString(7));
			ConstaintTemplate.setModifyDateTime(rs.getDate(8));
		}		
		return ConstaintTemplate;
	}

}
