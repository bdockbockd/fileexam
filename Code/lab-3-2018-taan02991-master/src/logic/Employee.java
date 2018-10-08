package logic;

public abstract class Employee implements Cloneable{
	
	private String name;
    private double workHours;
    private double salaryPerHour;
    
    // TODO - constructor for Employee
    public Employee(String name, double workHours,double salaryPerHour){
    	this.setName(name);
    	this.setWorkHours(workHours);
    	this.setSalaryPerHour(salaryPerHour);
    }
    
    // TODO - addSalaryPerHour method
	public void addSalaryPerHour(double amount) {
		this.setSalaryPerHour(this.getSalaryPerHour() + amount);
	}
	
	// TODO - getSalary method
	public double getSalary() {
		return this.workHours * this.salaryPerHour + calculateBonus();
	}
    
    // TODO - declare abstract method
	public abstract double calculateBonus();

	public abstract String toString();
	
	// TODO - getter setter for Employee
	   public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public double getWorkHours() {
			return workHours;
		}
		
		public void setWorkHours(double workHours) {
			if(workHours < 0) workHours = 0;
			this.workHours = workHours;
		}
		
		public double getSalaryPerHour() {
			return salaryPerHour;
		}
		
		public void setSalaryPerHour(double salaryPerHour) {
			if(salaryPerHour < 0) salaryPerHour = 0;
			this.salaryPerHour = salaryPerHour;
		}
		
		
    
}
