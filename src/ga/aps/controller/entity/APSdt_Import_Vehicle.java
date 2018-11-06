package ga.aps.controller.entity;

   /**
    * APSdt_Import_Vehicle  µÃÂ¿‡
    * Tue Oct 30 16:52:48 CST 2018 CHENRK
    */ 

import java.sql.*;

public class APSdt_Import_Vehicle{
	private String VersionNo;
	private int orderNo;
	private String SiteCode;
	private String Material;
	private String PoNumber;
	private long amount;
	private Date CreatDate;
	private String CreatUser;
	
	public APSdt_Import_Vehicle() {
		
	}
	
	public APSdt_Import_Vehicle(String versionNo, int orderNo, String siteCode, String material, String poNumber,
			long amount, Date creatDate, String creatUser) {
		super();
		VersionNo = versionNo;
		this.orderNo = orderNo;
		SiteCode = siteCode;
		Material = material;
		PoNumber = poNumber;
		this.amount = amount;
		CreatDate = creatDate;
		CreatUser = creatUser;
	}

	public String getVersionNo() {
		return VersionNo;
	}

	public void setVersionNo(String versionNo) {
		VersionNo = versionNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getSiteCode() {
		return SiteCode;
	}

	public void setSiteCode(String siteCode) {
		SiteCode = siteCode;
	}

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public String getPoNumber() {
		return PoNumber;
	}

	public void setPoNumber(String poNumber) {
		PoNumber = poNumber;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getCreatDate() {
		return CreatDate;
	}

	public void setCreatDate(Date creatDate) {
		CreatDate = creatDate;
	}

	public String getCreatUser() {
		return CreatUser;
	}

	public void setCreatUser(String creatUser) {
		CreatUser = creatUser;
	}

}

