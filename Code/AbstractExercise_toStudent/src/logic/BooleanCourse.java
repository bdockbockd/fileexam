package logic;

public class BooleanCourse extends Course {
	
	boolean grade;
	
	public BooleanCourse(String name, boolean grade) {
		super(name);
		this.grade = grade;
	}

	@Override
	public boolean isPassed() {
		return grade;
	}

	@Override
	public String toString() {
		return "(BolleanCourse): " + this.getName() + ", grade:" + this.isPassed();
	}
	
}
