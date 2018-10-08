package main;

public abstract class Chocobo implements ICharacter, Comparable<Object> {
	protected double speed;
	protected double distance;
	
	public Chocobo(){
		this.speed = 0;
		this.distance = 0;
	}
	
	@Override
	public Double getSpeed() {
		return this.speed;
	}
	
	@Override
	public Double getDistance() {
		return this.distance;
	}

	@Override
	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	@Override
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	public int compareTo(Object o) {
		if(o instanceof Pikachu) {
			if(this.getDistance() > ((Pikachu) o).getDistance()) return 1;
			if(this.getDistance() < ((Pikachu) o).getDistance()) return -1;
			return -1;
		}
		else if(o instanceof JumperChocobo) {
			if(this.getDistance() > ((JumperChocobo) o).getDistance()) return 1;
			if(this.getDistance() < ((JumperChocobo) o).getDistance()) return -1;
			return -1;
		}
		else {
			if(this.getDistance() > ((RunnerChocobo) o).getDistance()) return 1;
			if(this.getDistance() < ((RunnerChocobo) o).getDistance()) return -1;
			return 1;
		}

	}

}
