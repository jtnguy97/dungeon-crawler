import java.util.ArrayList;

public abstract class Character{
	
	private String name;
	private int money;
	protected ArrayList<Party> party;
	protected Party currentParty;

	public Character(String name){
		this.name = name;
		party = new ArrayList<Party>();
	}

	public String getName(){
	return name;
	}

	public Party getCurrentParty(){
	return currentParty;
	}

	public int getMoney(){
	return money;
	}

	public void earnMoney(int m){
	money+=m;
	}

	protected int spendMoney(int value){
	if(value>=money){
		System.out.println("You do not have enough money.");
		return 0;
	}
	else{
		System.out.printf("You spent %d monies.", value);
		money -= value;
		return value;
	}
	}

	protected boolean TPKO(){
		boolean allDead = true;
		for(int i=0; i<party.size();i++){
			allDead = allDead && party.get(i).isDead();
		}
		return allDead;
	}

	public abstract void catchParty(Party group);
	public abstract boolean takeTurn(Party group);
	public abstract void attackParty(Party group);
	public abstract void changeParty();
}