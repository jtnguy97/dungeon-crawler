public class Attack{
	
	private static final double VERY_WEAK = .4;
	private static final double WEAK = .8;
	private static final double NORMAL = 1.25;
	private static final double STRONG = 1.50;
	

	public static int attack(Party group, String atkName){
		int dam = directory(atkName, group.getSpecialAtk(), group.getAtk());
		System.out.printf("%s used %s and dealt %d damage\n", group.getDemon(), atkName, dam);
		Config.waitNext();
		return dam;
	}

	public static int directory(String name, int special, int atk){
		switch(name){
			case "Tickle": return tickle(atk);
			case "Love Spell": return loveSpell(special);
			case "Drain": return drain(special);
			case "Moonlight Beam": return moonlightBeam(special);
			case "Slash": return slash(atk);
			case "Fireball": return fireBall(special);
			case "Whirlpool": return whirlpool(special);
			case "Cage Trap": return cageTrap(special);
			case "Chop": return chop(atk);
			case "Kick": return kick(atk);
			case "Curse": return curse(special);
			case "Grand Slam": return grandSlam(special);
			case "Poison Gust": return poisonGust(special);
			case "Butterfly Beam": return butterflyBeam(special);
			case "Fly": return fly(special);
		}
		return 0;
	}

	public static int tickle(int atk){
		return (int)(atk*WEAK);
	}
	public static int loveSpell(int special){
		return (int)(special*WEAK);
	}
	public static int drain(int special){
		return (int)(special*VERY_WEAK);
	}
	public static int moonlightBeam(int special){
		return (int)(special*STRONG);
	}
	public static int slash(int atk){
		return (int)(atk*WEAK);
	}
	public static int fireBall(int special){
		return (int)(special*NORMAL);
	}
	public static int whirlpool(int special){
		return (int)(3*special*VERY_WEAK);
	}
	public static int cageTrap(int special){
		return(int)(special*STRONG);
	}
	public static int chop(int atk){
		return(int)(atk*WEAK);
	}
	public static int kick(int atk){
		return (int)(atk*WEAK);
	}
	public static int curse(int special){
		return (int)(3*special*VERY_WEAK);
	}
	public static int grandSlam(int special){
		return (int)(special*STRONG);
	}
	public static int poisonGust(int special){
		return (int)(special*NORMAL);
	}
	public static int butterflyBeam(int special){
		return (int)(special*STRONG);
	}
	public static int fly(int special){
		return (int)(special*VERY_WEAK);
		
	}

}