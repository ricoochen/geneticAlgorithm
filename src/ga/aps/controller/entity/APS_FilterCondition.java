package ga.aps.controller.entity;

   /**
    * APS_FilterCondition  µÃÂ¿‡
    * Fri Oct 26 10:10:58 CST 2018 CHENRK
    */ 

import java.sql.*;

public class APS_FilterCondition{
	private String SiteCode;
	private String FilterConditionCode;
	private String FilterConditionText;
	private String Expression;
	private boolean LockFlag;
	private String GroupId;
	private String ATBEZ;
	private String ATNAM;
	private String ATWRT;
	private String ATWTB;
	private String CreateUser;
	private Date CreateDateTime;
	private String ModifyUser;
	private Date ModifyDateTime;
	
	public APS_FilterCondition() {
		
	}
	
	public APS_FilterCondition(String siteCode, String filterConditionCode, String filterConditionText,
			String expression, boolean lockFlag, String groupId, String aTBEZ, String aTNAM, String aTWRT, String aTWTB,
			String createUser, Date createDateTime, String modifyUser, Date modifyDateTime) {
		this.SiteCode = siteCode;
		this.FilterConditionCode = filterConditionCode;
		this.FilterConditionText = filterConditionText;
		this.Expression = expression;
		this.LockFlag = lockFlag;
		this.GroupId = groupId;
		this.ATBEZ = aTBEZ;
		this.ATNAM = aTNAM;
		this.ATWRT = aTWRT;
		this.ATWTB = aTWTB;
		this.CreateUser = createUser;
		this.CreateDateTime = createDateTime;
		this.ModifyUser = modifyUser;
		this.ModifyDateTime = modifyDateTime;
	}
	
	public String getSiteCode() {
		return SiteCode;
	}
	public void setSiteCode(String siteCode) {
		SiteCode = siteCode;
	}
	public String getFilterConditionCode() {
		return FilterConditionCode;
	}
	public void setFilterConditionCode(String filterConditionCode) {
		FilterConditionCode = filterConditionCode;
	}
	public String getFilterConditionText() {
		return FilterConditionText;
	}
	public void setFilterConditionText(String filterConditionText) {
		FilterConditionText = filterConditionText;
	}
	public String getExpression() {
		return Expression;
	}
	public void setExpression(String expression) {
		Expression = expression;
	}
	public boolean isLockFlag() {
		return LockFlag;
	}
	public void setLockFlag(boolean lockFlag) {
		LockFlag = lockFlag;
	}
	public String getGroupId() {
		return GroupId;
	}
	public void setGroupId(String groupId) {
		GroupId = groupId;
	}
	public String getATBEZ() {
		return ATBEZ;
	}
	public void setATBEZ(String aTBEZ) {
		ATBEZ = aTBEZ;
	}
	public String getATNAM() {
		return ATNAM;
	}
	public void setATNAM(String aTNAM) {
		ATNAM = aTNAM;
	}
	public String getATWRT() {
		return ATWRT;
	}
	public void setATWRT(String aTWRT) {
		ATWRT = aTWRT;
	}
	public String getATWTB() {
		return ATWTB;
	}
	public void setATWTB(String aTWTB) {
		ATWTB = aTWTB;
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

