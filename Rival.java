public class Rival extends Character{
	
	public Rival(String name, Party group){
		super(name);
		catchParty(group);
		currentParty = group;
	}

	public void catchParty(Party group){
		party.add(group);
	}

	public boolean takeTurn(Party enemy){
		if(TPKO()){
			return true;
		}
		System.out.printf("%s's turn!\n", getName());
		if(currentParty.isDead()){
			changeParty();
		}
		attackParty(enemy);
		return false;
	}

	public void attackParty(Party enemy){
		int choice = (Config.rand(currentParty.getNumberOfAtks()-1));
		enemy.takeDamage(Attack.attack(currentParty, currentParty.getAttack(choice-1)));	
	}

	public void changeParty(){
		for(int i=0; i<party.size();i++){
			if(!party.get(i).isDead()){
				currentParty = party.get(i);
				break;
			}
		}
	}
	
}