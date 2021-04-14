package characters;

public class Ninja extends Human{
	public Ninja() {
		this.setStealth(10);
	}
	
	public void stealHealth(Human target) {
		target.changeHealth(-(this.getStealth()));
		this.changeHealth(this.getStealth());
	}
	
	public void runAway() {
		this.changeHealth(-10);
	}
}
