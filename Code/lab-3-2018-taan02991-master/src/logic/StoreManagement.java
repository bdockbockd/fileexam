package logic;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class StoreManagement {
	
	/**
    *
    * @param args the command line arguments
    * @throws java.io.FileNotFoundException
    */
	
	public static Store STORE = new Store("Starbuck Coffee");
	public static Scanner KEYBOARD = new Scanner(System.in);
	public static String inputFile = "src/input.txt";
	public static final int EXIT = 8;
	
	// To be print the same format.
	public static class StringFormat {
		
		public static void printSalary(String name, double salary, String position) {
			System.out.println("- Name: " + name + " position: " + position + ", salary: " + salary);
		}
		public static String partTimeString(String name, double workHours, double salaryPerHour, double bonus) {
			return "- [PARTTIME] Name: " + name + ", salaryPerHour: " + salaryPerHour + ", workHours: " + workHours  + ", bonus: " + bonus;
		}
		public static String managerString(String name, double workHours, double salaryPerHour, double bonus) {
			return "- [MANAGER] Name: " + name + ", salaryPerHour: " + salaryPerHour + ", workHours: " + workHours  + ", bonus: " + bonus;
		}
		public static String salesAssociateString(String name, double workHours, double salaryPerHour, double salesRate, double bonus) {
			return "- [SALES ASSOCAITE] Name: " + name + ", salaryPerHour: " + salaryPerHour + ", workHours: " + workHours + ", salesRate: " + salesRate  + ", bonus: " + bonus;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		int menuInput = 0;
		readInput();
		while(menuInput != EXIT) {
			printMainMenu();
			menuInput = acceptMainMenuInput();
			if (menuInput == -1 || menuInput > EXIT) {
				System.out.println("Invalid input! Please select only 1-" + EXIT + ".\n");
				continue;
			}
			else {
				switch (menuInput) {
					case 1:
						System.out.println("-------------------------");
						STORE.showAllEmployees();
						System.out.println("-------------------------");
						break;
					case 2:
						System.out.println("-------------------------");
						STORE.handleRecruitProcess();
						System.out.println("-------------------------");
						break;
					case 3:
						System.out.println("-------------------------");
						STORE.showSalary();
						System.out.println("-------------------------");
						break;
					case 4:
						System.out.println("-------------------------");
						System.out.print("What's the employee name to be promoted?: ");
						// accept blank input after nextInt
						String name = KEYBOARD.nextLine();
						name = KEYBOARD.nextLine();
						name = name.trim();
						STORE.handlePromoteProcess(name);
						System.out.println("-------------------------");
						break;
					case 5:
						System.out.println("-------------------------");
						STORE.handleDayOff();
						System.out.println("-------------------------");
						break;
					case 6:
						System.out.println("-------------------------");
						STORE.handleOnDuty();
						System.out.println("-------------------------");
						break;
					case 7:
						System.out.println("-------------------------");
						STORE.handleReceiveTips();
						System.out.println("-------------------------");
						break;
					default:
						break;
				}
			}
		}
		KEYBOARD.close();
		System.out.println("--- Exit ---");

	}
	
	public static void printMainMenu() {
		System.out.println("--- Main Menu ---");
		System.out.println("1 - View all employees");
		System.out.println("2 - Recruit new employee");
		System.out.println("3 - Show employee's salaries");
		System.out.println("4 - [For SalesAssociate only] Promote to be a Manager");
		System.out.println("5 - [For FullTime only] Take time off");
		System.out.println("6 - [For PartTime only] On duty");
		System.out.println("7 - [For PartTime only] Received tips");
		System.out.println("8 - Exit the program");
		System.out.print("Please select what to do: ");
	}
	
	public static int acceptMainMenuInput() {
		int input = KEYBOARD.nextInt();
		if (input < 1 || input > EXIT) {
			return -1;
		}
		return input;
	}
	
	public static void readInput() {
		boolean readingEmployeeList = false;
		File file = null;
		BufferedReader fileReader = null;
		String thisLine = null;
		try {
			file = new File(inputFile);
			fileReader = new BufferedReader(new FileReader(file));
			while ((thisLine = fileReader.readLine()) != null) {
				if (thisLine.trim().equals("---Employee List---")) {
					readingEmployeeList = true;
					continue;
				} else {
					if (readingEmployeeList) {
						String[] info = thisLine.split(",");
						
						String position = info[0];
						String name = info[1];
						double salaryPerHour = Double.parseDouble(info[2]);
						
						if (position.trim().equals("manager")) {
							Employee e = new Manager(name.trim(), salaryPerHour);
							STORE.addEmployee(e);
						} else if (position.trim().equals("sale")) {
							double saleRate = Double.parseDouble(info[3]);
							Employee e = new SalesAssociate(name.trim(), salaryPerHour, saleRate);
							STORE.addEmployee(e);
						} else {
							Employee e = new PartTime(name.trim(), salaryPerHour);
							STORE.addEmployee(e);
						}
					}
				}
			}
		} 
		catch (IOException e) {
		    e.printStackTrace();
		} 
		finally {
		    try {
		        fileReader.close();
		    } 
		    catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	}

}
