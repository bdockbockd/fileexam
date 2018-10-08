package main;

public class JumperChocobo extends Chocobo implements IObstructable{
	
	private int turnCount;
	private int obstructedDuration;
	
	public JumperChocobo(){
		super();
		this.setSpeed(7.5);
	}

	@Override
	public void start() {
		this.setDistance(0.0);
		this.turnCount = 0;
		this.obstructedDuration = 0;
	}

	@Override
	public void run() {
		this.turnCount += 1;
		if(this.turnCount % 2 == 0) {
			this.setDistance(this.getDistance() + this.getSpeed());			
		}
		
	}

	@Override
	public void obstructed() {
		if(this.obstructedDuration > 0) return;
		this.setSpeed(this.getSpeed()/2);
		this.obstructedDuration = 2;
	}

	@Override
	public void setObstructedDuration(int time) {
		this.obstructedDuration = time;
		
	}

	@Override
	public int getObstructedDuration() {
		return this.obstructedDuration;
		
	}
	

	
	
}
