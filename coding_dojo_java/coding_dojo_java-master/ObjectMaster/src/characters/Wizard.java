package characters;

public class Wizard extends Human{
	public Wizard() {
		this.setHealth(50);
		this.setIntelligence(8);
	}

	public void heal(Human target) {
		target.changeHealth(this.getIntelligence());
	}
	
	public void fireball(Human target) {
		target.changeHealth(-(this.getIntelligence() * 3));
	}
}
