package logic;

public class GradedCourse extends Course{
	
	int score;

	public GradedCourse(String name, int score) {
		super(name);
		this.score = score;
	}

	@Override
	public boolean isPassed() {
		return score > 50;
	}

	@Override
	public String toString() {
		return "(GradedCourse): " + this.getName() + ", score: " + this.score;
	}

}
