package logic;

public class SalesAssociate extends FullTime{
	
	private final double salesRate;

	// TODO - constructor for salesAssociate
	public SalesAssociate (String name, double salaryPerHour, double salesRate) {
		super(name, salaryPerHour, "SalesAssociate");
		this.salesRate = salesRate;
	}
	
	// TODO - getSalesRate for salesAssociate
	public double getSalesRate() {
		if(this.salesRate < 0 || this.salesRate > 1) return 0.5 * 100;
		return this.salesRate * 100;
	}
	

	// TODO - bonus for salesAssociate
	public double calculateBonus(){
		if(this.getSalesRate() > 30) return this.getSalaryPerHour() * 0.3 * this.getWorkHours();
		return this.getSalaryPerHour() * 0.01 * this.getWorkHours();
	}
	// TODO - toString for salesAssociate
	@Override
	public String toString() {
		return StoreManagement.StringFormat.salesAssociateString(getName(), getWorkHours(), getSalaryPerHour(), this.getSalesRate(), this.calculateBonus());
	}
	

}
