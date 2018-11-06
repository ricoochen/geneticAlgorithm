package ga.aps.controller.entity;

   /**
    * APSdt_Import_Vehicle_Attribute  µÃÂ¿‡
    * Tue Oct 30 16:53:16 CST 2018 CHENRK
    */ 


public class APSdt_Import_Vehicle_Attribute{
	private String VersionNO;
	private String AttriNo;
	private String SiteCode;
	private String Material;
	private String ATBEZ;
	private String ATWRT;
	
	public APSdt_Import_Vehicle_Attribute() {
		
	}
	
	public APSdt_Import_Vehicle_Attribute(String versionNO, String attriNo, String siteCode, String material,
			String aTBEZ, String aTWRT) {
		super();
		VersionNO = versionNO;
		AttriNo = attriNo;
		SiteCode = siteCode;
		Material = material;
		ATBEZ = aTBEZ;
		ATWRT = aTWRT;
	}

	public String getVersionNO() {
		return VersionNO;
	}

	public void setVersionNO(String versionNO) {
		VersionNO = versionNO;
	}

	public String getAttriNo() {
		return AttriNo;
	}

	public void setAttriNo(String attriNo) {
		AttriNo = attriNo;
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

	public String getATBEZ() {
		return ATBEZ;
	}

	public void setATBEZ(String aTBEZ) {
		ATBEZ = aTBEZ;
	}

	public String getATWRT() {
		return ATWRT;
	}

	public void setATWRT(String aTWRT) {
		ATWRT = aTWRT;
	}

}

