package characters.tests;

import characters.*;

public class Battle {
	public static void main(String[] args) {
		Wizard w = new Wizard();
		Ninja n = new Ninja();
		Samurai s = new Samurai();
		
		System.out.println(w.getHealth());
		System.out.println(n.getHealth());
		System.out.println(s.getHealth());
		
		w.fireball(n);
		n.stealHealth(s);
		s.deathBlow(w);
		
		System.out.println(w.getHealth());
		System.out.println(n.getHealth());
		System.out.println(s.getHealth());
	}
}
