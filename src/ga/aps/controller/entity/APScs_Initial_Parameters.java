package ga.aps.controller.entity;

import java.util.List;

public class APScs_Initial_Parameters {
	private String  SiteCode;
	private String	VersionNo;
	private int		Population; 
	private	String	TemplateCode;
	private List<APScs_Initial_ProductionDay> ProdDay;
	
	public APScs_Initial_Parameters() {
		super();
	}

	public APScs_Initial_Parameters(String siteCode, String versionNo, int population, String templateCode,
			List<APScs_Initial_ProductionDay> prodDay) {
		super();
		SiteCode = siteCode;
		VersionNo = versionNo;
		Population = population;
		TemplateCode = templateCode;
		ProdDay = prodDay;
	}

	public String getSiteCode() {
		return SiteCode;
	}

	public void setSiteCode(String siteCode) {
		SiteCode = siteCode;
	}

	public String getVersionNo() {
		return VersionNo;
	}
	public void setVersionNo(String versionNo) {
		VersionNo = versionNo;
	}
	public int getPopulation() {
		return Population;
	}
	public void setPopulation(int population) {
		Population = population;
	}
	public String getTemplateCode() {
		return TemplateCode;
	}
	public void setTemplateCode(String templateCode) {
		TemplateCode = templateCode;
	}

	public List<APScs_Initial_ProductionDay> getProdDay() {
		return ProdDay;
	}

	public void setProdDay(List<APScs_Initial_ProductionDay> prodDay) {
		ProdDay = prodDay;
	}

}
