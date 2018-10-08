package logic;

public class Manager extends FullTime{

	// TODO - constructor for Manager
	public Manager(String name, double salaryPerHour) {
		super(name, salaryPerHour, "Manager");
	}

	@Override
	public String toString() {
		return StoreManagement.StringFormat.managerString(getName(), getWorkHours(), getSalaryPerHour(), super.calculateBonus());
	}

	
	
}
