package logic;

public class HeavyTank extends Tank{
	
	int armor;
	
	public HeavyTank() {
		super();
		this.armor = 1;
	}
	
	public HeavyTank(int health, int power, int armor) {
		super(health, power);
		if(armor <= 0) armor = 1;
		this.armor = armor;
	}
	
	public int getArmor() {
		return this.armor;
	}
	
	public boolean takeDamage(int damage) {
		return super.takeDamage(damage - this.armor);
	}
}
