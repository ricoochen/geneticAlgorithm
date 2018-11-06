package ga.aps.controller.entity;

   /**
    * APS_ConstraintRule  µÃÂ¿‡
    * Fri Oct 26 14:37:19 CST 2018 CHENRK
    */ 


public class APS_ConstraintRule{
	private String SiteCode;
	private String ConstraintRuleCode;
	private String ConstraintRuleText;
	private String Category;
	
	public APS_ConstraintRule() {}
	
	public APS_ConstraintRule(String siteCode, String constraintRuleCode, String constraintRuleText, String category) {
		super();
		SiteCode = siteCode;
		ConstraintRuleCode = constraintRuleCode;
		ConstraintRuleText = constraintRuleText;
		Category = category;
	}
	
	public void setSiteCode(String SiteCode){
	this.SiteCode=SiteCode;
	}
	public String getSiteCode(){
		return SiteCode;
	}
	public void setConstraintRuleCode(String ConstraintRuleCode){
	this.ConstraintRuleCode=ConstraintRuleCode;
	}
	public String getConstraintRuleCode(){
		return ConstraintRuleCode;
	}
	public void setConstraintRuleText(String ConstraintRuleText){
	this.ConstraintRuleText=ConstraintRuleText;
	}
	public String getConstraintRuleText(){
		return ConstraintRuleText;
	}
	public void setCategory(String Category){
	this.Category=Category;
	}
	public String getCategory(){
		return Category;
	}
}

