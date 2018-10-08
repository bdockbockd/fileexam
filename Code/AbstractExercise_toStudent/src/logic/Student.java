package logic;

import java.util.ArrayList;

public class Student {
	//To DO: Q3
	//HINT:
	//protected XXXXX<Course> coursesEnrolled;
	//protected XXXXX<Boolean> isPassedList;
	protected ArrayList<Course> coursesEnrolled;
	protected ArrayList<Boolean> isPassedList;
	private String name;
	
	
	public Student(String name) {
		super();
		//To DO: Q3
		//HINT:
		//this.coursesEnrolled = new XXXXX<Course>();
		this.coursesEnrolled = new ArrayList<Course>();
		this.name = name;
		//To DO: Q3
		//HINT:
		//this.isPassedList = new XXXXX<Boolean>();
		this.isPassedList = new ArrayList<Boolean>();
	}
	
	public void enrollCourse(Course c) {
		//TO DO: Q3
		this.coursesEnrolled.add(c);
	}
	
	public void computeIsPassed() {
		//TO DO: Q3
		for(Course c: this.coursesEnrolled) {
			this.isPassedList.add(c.isPassed());
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

// TO DO: Q3	
//	@Override
	public String toString() {
		String ans = "Student name: Anonymous\n";
		for(int i = 0; i < this.coursesEnrolled.size(); i++) {
			ans += "Course: " + this.coursesEnrolled.get(i).getName() + ", isPassed: " + this.isPassedList.get(i) + "\n";
		}
		return ans;
	}
	
	
	
	
	
	
	
}
