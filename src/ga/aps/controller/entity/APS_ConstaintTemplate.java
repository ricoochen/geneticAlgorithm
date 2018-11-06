package ga.aps.controller.entity;

//import java.util.*;

import java.sql.*;
   /**
    * APS_ConstaintTemplate  µÃÂ¿‡
    * Wed Oct 24 12:38:55 CST 2018 CHENRK
    */ 

public class APS_ConstaintTemplate{
	private String SiteCode;
	private String TemplateCode;
	private String TemplateText;
	private String Category;
	private String CreateUser;
	private Date   CreateDateTime;
	private String ModifyUser;
	private Date   ModifyDateTime;
	
	public APS_ConstaintTemplate() {
		
	}

	public APS_ConstaintTemplate(String SiteCode,String TemplateCode,String TemplateText,String Category,
			String CreateUser,Date CreateDateTime,String ModifyUser,Date ModifyDateTime) {
		this.SiteCode 		= SiteCode;
		this.TemplateCode 	= TemplateCode;
		this.TemplateText 	= TemplateText;
		this.Category 		= Category;
		this.CreateUser 	= CreateUser;
		this.CreateDateTime = CreateDateTime;
		this.ModifyUser 	= ModifyUser;
		this.ModifyDateTime = ModifyDateTime;		
	}
	
	public String getSiteCode() {
		return SiteCode;
	}
	public void setSiteCode(String siteCode) {
		SiteCode = siteCode;
	}
	public String getTemplateCode() {
		return TemplateCode;
	}
	public void setTemplateCode(String templateCode) {
		TemplateCode = templateCode;
	}
	public String getTemplateText() {
		return TemplateText;
	}
	public void setTemplateText(String templateText) {
		TemplateText = templateText;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getCreateUser() {
		return CreateUser;
	}
	public void setCreateUser(String createUser) {
		CreateUser = createUser;
	}
	public Date getCreateDateTime() {
		return CreateDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		CreateDateTime = createDateTime;
	}
	public String getModifyUser() {
		return ModifyUser;
	}
	public void setModifyUser(String modifyUser) {
		ModifyUser = modifyUser;
	}
	public Date getModifyDateTime() {
		return ModifyDateTime;
	}
	public void setModifyDateTime(Date modifyDateTime) {
		ModifyDateTime = modifyDateTime;
	}
	
}

