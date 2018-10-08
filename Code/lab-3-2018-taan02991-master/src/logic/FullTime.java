package logic;

public abstract class FullTime extends Employee{

	private String position;

	// TODO - constructor for fullTime
	public FullTime (String name, double salaryPerHour, String position) {
		super(name, 200, salaryPerHour);
		this.setPosition(position);
		
	}
	
	// TODO - getter setter for fullTime
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		if(position.toLowerCase().equals("manager")) {
			this.position = "Manager";
		}
		else {
			this.position = "SalesAssociate";
		}
	}

	// TODO - decrease WorkHours for fullTime
	public void takeTimeOff (double hours) {
		if(hours < 0) return;
		this.setWorkHours(this.getWorkHours() - hours);
	}

	// TODO - bonus for fullTime
	@Override
	public double calculateBonus() {
		 return (this.getSalaryPerHour() * 0.01) * this.getWorkHours();
	}
	
	public abstract String toString();


}
