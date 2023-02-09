import java.util.ArrayList;

public class PartyMember extends Character{
	private ArrayList<Item> items;

	public PartyMember(String name, Party group){
	super(name);
	catchParty(group);
	currentParty = group;
	items = new ArrayList<Item>();
	}

	public void catchParty(Party group){
		System.out.printf("\nYou selected %s to fight!\n", group.getDemon());
		super.party.add(group);
	}

	public boolean takeTurn(Party group){
		if(TPKO()){
			System.out.println("Your group are all knocked out. You have to run!");
			return true;
		}
		turnMenu();
		int choice = Config.nextInt(1,5);
		return turnAction(choice,group);
	}

	public void attackParty(Party enemy){
		System.out.println("\nChoose an attack!");
		System.out.println(currentParty.atkDisplay());
		int choice = Config.nextInt(1,currentParty.getNumberOfAtks()+1);
		enemy.takeDamage(Attack.attack(currentParty, currentParty.getAttack(choice-1)));
	}

	public void useItem(){
		displayItems();
		int choice = Config.nextInt(1, items.size()+1);
		currentParty.heal(items.get(choice-1).value);
		System.out.printf("You heal %s for %d hp.\n", currentParty.getDemon(), items.get(choice-1).value);
		items.remove(choice-1);
	}

	public void changeParty(){
		System.out.println("Which party member will you choose?");
		displayParty();
		int choice = Config.nextInt(1, party.size()+1);
		currentParty= party.get(choice-1);
	}

	public void displayParty(){
		for(int i=0; i<party.size(); i++){
			System.out.printf("%d. %s %s\n", (i+1), party.get(i).getDemon(),party.get(i).displayHp());
		}
	}

	public void displayItems(){
		String str = "";
		for(int i=0; i<items.size();i++){
			str += (i+1)+" "+items.get(i)+"\n";
		}
		System.out.println(str);
	}

	public void addItem(String name){
		items.add(Item.item(name));
	}

	private boolean turnAction(int choice, Party group){
		switch(choice){
			case 1: {attackParty(group);} break;
			case 2: {changeParty();} break;
			case 3: {
				if(items.size()==0){
					System.out.println("You don't have any items.");
					takeTurn(group);
				}
				useItem();
			}
			break;
			default: {
				return true;
			}
		}
		return false;
	}

	private void turnMenu(){
		System.out.println("\n\nIt's your turn! What would you like to do?");
		System.out.println("1. Attack 2. CHANGE PARTY MEMBER");
		System.out.println("3. ITEM   4. RUN\n");

		
	}
}