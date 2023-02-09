public class Game{
	private PartyMember partyMember;
	private Rival rival;

	public Game(){
		setUpPartyMember();
		rival = setUpRival();
		rival.earnMoney(Config.rand(70));
	}

	public void setUpPartyMember(){
		String name = "Player";
		Party group = getParty();
		partyMember = new PartyMember(name, group);
		partyMember.earnMoney(100);
		partyMember.addItem(Item.POTION);
	}

	private Party getParty(){
		Party group;
		System.out.println("There's a dangerous rival up ahead!");
		System.out.println("Which demon do you want to summon?");
		System.out.println("1. Aki [type: fighting]\n2. Susano [type: fire]\n3. Gowon [type: bug/flying]\n4. Bede [type: fairy/ghost]");
		int choice = Config.nextInt(1,6);
		return getParty(choice);
	}

	private Party getParty(int choice){
		if(choice==1)
			return Party.generateParty(Party.AKI);
		else if(choice==2)
			return Party.generateParty(Party.SUSANO);
		else if(choice==3)
			return Party.generateParty(Party.GOWON);
		else
			return Party.generateParty(Party.BEDE);
	}

	public Rival setUpRival(){
		return new Rival("Rival", Party.generateRandom());
	}

	public PartyMember getPartyMember(){
		return partyMember;
	}

	public Rival getRival(){
		return rival;
	}
}