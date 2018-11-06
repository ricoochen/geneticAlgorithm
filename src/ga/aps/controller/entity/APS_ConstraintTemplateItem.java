package ga.aps.controller.entity;

   /**
    * APS_ConstraintTemplateItem  µÃÂ¿‡
    * Fri Oct 26 14:39:09 CST 2018 CHENRK
    */ 


public class APS_ConstraintTemplateItem{
	private String SiteCode;
	private String TemplateCode;
	private int Ordinal;
	private String FilterConditionCode;
	private String ConstraintRuleCode;
	private int FromDay;
	private int ToDay;
	private int MinValue;
	private int MaxValue;
	private int GroupSize;
	private String PrevConditionCode;
	private String NextConditionCode;
	private int Weight;
	private boolean HardFlag;
	
	public APS_ConstraintTemplateItem() {}
	
	public APS_ConstraintTemplateItem(String siteCode, String templateCode, int ordinal, String filterConditionCode,
			String constraintRuleCode, int fromDay, int toDay, int minValue, int maxValue, int groupSize,
			String prevConditionCode, String nextConditionCode, int weight, boolean hardFlag) {
		super();
		SiteCode = siteCode;
		TemplateCode = templateCode;
		Ordinal = ordinal;
		FilterConditionCode = filterConditionCode;
		ConstraintRuleCode = constraintRuleCode;
		FromDay = fromDay;
		ToDay = toDay;
		MinValue = minValue;
		MaxValue = maxValue;
		GroupSize = groupSize;
		PrevConditionCode = prevConditionCode;
		NextConditionCode = nextConditionCode;
		Weight = weight;
		HardFlag = hardFlag;
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

	public int getOrdinal() {
		return Ordinal;
	}

	public void setOrdinal(int ordinal) {
		Ordinal = ordinal;
	}

	public String getFilterConditionCode() {
		return FilterConditionCode;
	}

	public void setFilterConditionCode(String filterConditionCode) {
		FilterConditionCode = filterConditionCode;
	}

	public String getConstraintRuleCode() {
		return ConstraintRuleCode;
	}

	public void setConstraintRuleCode(String constraintRuleCode) {
		ConstraintRuleCode = constraintRuleCode;
	}

	public int getFromDay() {
		return FromDay;
	}

	public void setFromDay(int fromDay) {
		FromDay = fromDay;
	}

	public int getToDay() {
		return ToDay;
	}

	public void setToDay(int toDay) {
		ToDay = toDay;
	}

	public int getMinValue() {
		return MinValue;
	}

	public void setMinValue(int minValue) {
		MinValue = minValue;
	}

	public int getMaxValue() {
		return MaxValue;
	}

	public void setMaxValue(int maxValue) {
		MaxValue = maxValue;
	}

	public int getGroupSize() {
		return GroupSize;
	}

	public void setGroupSize(int groupSize) {
		GroupSize = groupSize;
	}

	public String getPrevConditionCode() {
		return PrevConditionCode;
	}

	public void setPrevConditionCode(String prevConditionCode) {
		PrevConditionCode = prevConditionCode;
	}

	public String getNextConditionCode() {
		return NextConditionCode;
	}

	public void setNextConditionCode(String nextConditionCode) {
		NextConditionCode = nextConditionCode;
	}

	public int getWeight() {
		return Weight;
	}

	public void setWeight(int weight) {
		Weight = weight;
	}

	public boolean isHardFlag() {
		return HardFlag;
	}

	public void setHardFlag(boolean hardFlag) {
		HardFlag = hardFlag;
	}	
	
}

