package characters;

public class Samurai extends Human{
	
	private static int numSamurai = 0;
	
	public Samurai() {
		this.setHealth(200);
		this.numSamurai++;
	}
	
	public void deathBlow(Human target) {
		target.setHealth(0);
		this.setHealth(this.getHealth()/2);
	}
	
	public void meditate() {
		this.setHealth(this.getHealth() * 1.5);
	}
	
	public int howMany() {
		return this.numSamurai;
	}
}
