package characters.tests;

import characters.*;

public class HumanTest {
	public static void main(String[] args) {
		Human test = new Human();
		Human test2 = new Human();
		
		test.attack(test2);
		
		System.out.println(test.getHealth());
		System.out.println(test2.getHealth());
	}
}
