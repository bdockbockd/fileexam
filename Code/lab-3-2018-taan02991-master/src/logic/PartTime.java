package logic;

public class PartTime extends Employee{
	
	private double accumulatedTips;

	// TODO - constructor for partTime
	public PartTime(String name, double salaryPerHour) {
		super(name, 0, salaryPerHour);
		this.accumulatedTips = 0;
	}
	
	// TODO - addTips for partTime
	public void addTips(double amount) {
		if(amount < 0) return;
		this.setAccumulatedTips(this.getAccumulatedTips() + amount);
	}
	
	// TODO - getter setter for partTime
	public double getAccumulatedTips() {
		return accumulatedTips;
	}
	
	public void setAccumulatedTips(double accumulatedTips) {
		if(accumulatedTips < 0) accumulatedTips = 0;
		this.accumulatedTips = accumulatedTips;
	}
	

	// TODO - toString for partTime
	public String toString() {
		return StoreManagement.StringFormat.partTimeString(this.getName(), this.getWorkHours(), this.getSalaryPerHour(), this.calculateBonus());
	}

	// TODO - onDuty (add WorkHours) for PartTime
	public void onDuty(double hours) {
		if(hours < 0) return;
		this.setWorkHours(this.getWorkHours() + hours);
	}
	
	// TODO - bonus for partTime
	@Override
	public double calculateBonus() {
		return this.getAccumulatedTips() * 0.5;
	}
	
	// TODO - declare equals method
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != this.getClass()) return false;
		if(!this.getName().equals(((PartTime) o).getName())) return false;
		if(this.getSalary() != ((PartTime) o).getSalary()) return false;
		if(this.getSalaryPerHour() != ((PartTime) o).getSalaryPerHour()) return false;
		if(this.getWorkHours() != ((PartTime) o).getWorkHours()) return false;
		return true;
	}
	
	// TODO - declare clone method
	public Object clone() {
		  try {
			  PartTime newC = (PartTime) super.clone();
			  return newC;
		  }catch(CloneNotSupportedException e) {
			  throw new InternalError(e.toString());
		  }
	}

}
