package main;

public class RunnerChocobo extends Chocobo {
	
	public RunnerChocobo(){
		super();
		this.setSpeed(3.0);
	}
	
	public void start() {
		this.setDistance(0.0);
	}
	
	public void run() {
		this.setDistance(this.getDistance() + this.getSpeed());
	}
}
