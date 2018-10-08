package main;

public class Pikachu implements IObstructable,ICharacter,Comparable<Object> {
	
	private Double speed;
	private Double distance;
	private int obstructedDuration;
	
	public Pikachu() {
		this.speed = 4.0;
		this.distance = 0.0;
		this.obstructedDuration = 0;
	}
	
	@Override
	public void obstructed() {
		if(this.obstructedDuration > 0) return;
		this.obstructedDuration = 1;
		this.speed = 0.0;
	}

	@Override
	public void setObstructedDuration(int time) {
		this.obstructedDuration = time;
	}

	@Override
	public int getObstructedDuration() {
		return this.obstructedDuration;
	}


	@Override
	public void start() {
		this.distance = 0.0;
	}


	@Override
	public void run() {
		this.setDistance(this.getDistance() + this.getSpeed());
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
		this.speed = 4.0;
	}


	@Override
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	public int compareTo(Object o) {
		if(o instanceof JumperChocobo) {
			if(this.getDistance() > ((JumperChocobo) o).getDistance()) return 1;
			if(this.getDistance() < ((JumperChocobo) o).getDistance()) return -1;
		}
		if(o instanceof RunnerChocobo) {
			if(this.getDistance() > ((RunnerChocobo) o).getDistance()) return 1;
			if(this.getDistance() < ((RunnerChocobo) o).getDistance()) return -1;
		}
		return 1;
	}
}
