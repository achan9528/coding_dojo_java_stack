package characters;

public class Human {
	
	private double strength;
	private double intelligence;
	private double stealth;
	private double health;
	
	public Human() {
		this.strength = 3;
		this.intelligence = 3;
		this.stealth = 3;
		this.health = 100;
	}
	
	public void attack(Human target) {
		target.changeHealth(-10);
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public double getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(double intelligence) {
		this.intelligence = intelligence;
	}

	public double getStealth() {
		return stealth;
	}

	public void setStealth(double stealth) {
		this.stealth = stealth;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}
	
	public void changeHealth(double change) {
		this.health += change;
	}
	
	
}