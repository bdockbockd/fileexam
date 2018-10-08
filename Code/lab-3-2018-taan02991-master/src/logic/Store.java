package logic;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
	public ArrayList<Employee> employeeList;
	public String storeName;
	
	// TODO - constructor for Store
	public Store (String storeName) {
		this.employeeList = new ArrayList<Employee>();
		this.storeName = storeName;
	}
	
	// TODO - add new employee to the employee list
	public void addEmployee(Employee e) {
		employeeList.add(e);
	}
	
	// TODO - print all employees by Employee's toString method
	public void showAllEmployees() {
		System.out.println("-- All Employees in the Store--");
		for(Employee e: employeeList) {
			System.out.println(e.toString());
		}
	}
	
	// TODO - print all employee's salaries and positions 
	public void showSalary() {
		System.out.println("-- All Employees's Salaries and Bonus--");
		for(Employee e: employeeList) {
			if(e instanceof PartTime) {
				StoreManagement.StringFormat.printSalary(e.getName(), e.getSalary(), "partTime");
				
			}
			else {
				StoreManagement.StringFormat.printSalary(e.getName(), e.getSalary(), ((FullTime) e).getPosition());
			}
		}
	}
	
	// TODO - promote the existing SalesAssociate to be new Manager
	public boolean handlePromoteProcess(String name) {
		for(int i = 0 ; i < employeeList.size(); i++) {
			Employee e = employeeList.get(i);
			if(e.getName().equals(name)) {
				if(e instanceof SalesAssociate) {
					Manager newM = new Manager(e.getName(), e.getSalaryPerHour());
					employeeList.set(i, newM);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean handleReceiveTips() {
		Scanner keyboard = StoreManagement.KEYBOARD;
		// accept blank input after nextInt
		String name = keyboard.nextLine();
		
		System.out.print("What's the employee name to be received tips?: ");
		name = keyboard.nextLine();
		name = name.trim();
		
		for (int i = 0; i < employeeList.size(); i++) {
			Employee e = employeeList.get(i);
			if ((e.getName().equals(name)) && (e instanceof PartTime)) {
				System.out.print("[For PartTime] How much tips to be received?: ");
				double tips = keyboard.nextDouble();
				((PartTime) e).addTips(tips);
				System.out.println("Successfully add tips for " + e.getName());
				return true;
			} else {
				continue;
			}
		}
		return false;
	}
	
	public boolean handleOnDuty() {
		Scanner keyboard = StoreManagement.KEYBOARD;
		// accept blank input after nextInt
		String name = keyboard.nextLine();
		System.out.print("What's the employee name to be on duty?: ");
		name = keyboard.nextLine();
		name = name.trim();
		for (int i = 0; i < employeeList.size(); i++) {
			Employee e = employeeList.get(i);
			if ((e.getName().equals(name)) && (e instanceof PartTime)) {
				System.out.print("[For PartTime] How many hours to be on duty?: ");
				double onDutyHours = keyboard.nextDouble();
				((PartTime) e).onDuty(onDutyHours);
				System.out.println("Successfully on duty for " + e.getName());
				return true;
			} else {
				continue;
			}
		}
		return false;
	}
	
	public boolean handleDayOff() {
		Scanner keyboard = StoreManagement.KEYBOARD;
		// accept blank input after nextInt
		String name = keyboard.nextLine();
		System.out.print("What's the employee name to get dayoff?: ");
		name = keyboard.nextLine();
		name = name.trim();
		for (int i = 0; i < employeeList.size(); i++) {
			Employee e = employeeList.get(i);
			if ((e.getName().equals(name)) && (e instanceof FullTime)) {
				System.out.print("[For FullTime] How many hours to day off?: ");
				double dayOffHours = keyboard.nextDouble();
				((FullTime) e).takeTimeOff(dayOffHours);
				System.out.println("Successfully dayoff for " + e.getName());
				return true;
			} else {
				continue;
			}
		}
		return false;
	}
	
	public boolean handleRecruitProcess() {
		Scanner keyboard = StoreManagement.KEYBOARD;
		// accept blank input after nextInt
		String name = keyboard.nextLine();
		
		System.out.print("What's your name?: ");
		name = keyboard.nextLine();
		name = name.trim();
		
		System.out.print("Please select position: [manager, sale, parttime] ");
		String position = keyboard.nextLine();
		position = position.trim();
		
		System.out.print("Please select salaryPerHour: ");
		double salaryPerHour = keyboard.nextDouble();
		
		if (position.equals("manager")) {
			Employee e = new Manager(name, salaryPerHour);
			StoreManagement.STORE.addEmployee(e);
			System.out.println("Successully add a manager staff!");
			return true;
		} else if (position.equals("sale")) {
			System.out.print("[For SalesAssociate] Please select saleRate: ");
			double saleRate = keyboard.nextDouble();
			Employee e = new SalesAssociate(name, salaryPerHour, saleRate);
			StoreManagement.STORE.addEmployee(e);
			System.out.println("Successully add a salesassociate staff!");
			return true;
		} else if (position.equals("parttime")) {
			Employee e = new PartTime(name, salaryPerHour);
			StoreManagement.STORE.addEmployee(e);
			System.out.println("Successully add a part-time staff!");
			return true;
		} else {
			System.out.println("Invalid position: DO NO THING!");
			return false;
		}
	}
}
