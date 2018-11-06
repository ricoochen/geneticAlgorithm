package ga.aps.controller.entity;

public class APScs_Initial_ProductionDay {
	private int Dayno;
	private int Amount;
	
	public APScs_Initial_ProductionDay() {
		super();
	}

	public APScs_Initial_ProductionDay(int dayno, int amount) {
		super();
		Dayno = dayno;
		Amount = amount;
	}
	
	public int getDayno() {
		return Dayno;
	}
	public void setDayno(int dayno) {
		Dayno = dayno;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	
	
}
