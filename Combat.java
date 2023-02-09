public class Combat{
	
	private static int lunarRock = 0;

	public static void combat(PartyMember partyMember, Rival rival){
		boolean partyMemberWins = true;
		boolean runAway = false;
		initialDisplay(partyMember, rival);
		while(!partyMember.TPKO()&&!rival.TPKO()){
			displayHp(partyMember, rival);
			runAway = partyMember.takeTurn(rival.getCurrentParty());
			if(runAway){
				System.out.println("You quickly fled the battle!");
				return;
			}
			if(checkRival(rival, partyMember)){
				continue;
			}
			rival.takeTurn(partyMember.getCurrentParty());
			if(checkPartyMember(partyMember))
				partyMemberWins=false;
		}

		printWinnings(partyMemberWins, partyMember, rival);
	}

	public static void initialDisplay(PartyMember partyMember, Rival rival){
		System.out.printf("You're now engaging in battle with a %s\n", rival.getName());
		Config.waitNext();
		System.out.printf("The %s summoned %s!\n", rival.getName(), rival.getCurrentParty().getDemon());
		System.out.printf("You summoned %s!\n", partyMember.getCurrentParty().getDemon());
	}

	public static void displayHp(PartyMember p, Rival r){
		System.out.printf("\n%s's %s %s", r.getName(), r.getCurrentParty().getDemon(), r.getCurrentParty().displayHp());
		System.out.printf("\n%s's %s %s", p.getName(), p.getCurrentParty().getDemon(), p.getCurrentParty().displayHp());
	}

	private static boolean checkPartyMember(PartyMember partyMember){
		if(partyMember.getCurrentParty().isDead()){
			partyMember.changeParty();
		}
		if(partyMember.TPKO()){
			return true;
		}
		return false;
	}

	private static boolean checkRival(Rival rival, PartyMember partyMember){
	if(rival.getCurrentParty().isDead()){
		System.out.printf("%s has fallen!\n%s gained %d exp!\n", rival.getCurrentParty().getDemon(),partyMember.getCurrentParty().getDemon(),rival.getCurrentParty().expValue());
		partyMember.getCurrentParty().gainExp(rival.getCurrentParty().expValue());
		rival.changeParty();
		if(rival.currentParty.isDead())
			return true;
		}
		return false;
	}


	public static void printWinnings(boolean win, PartyMember partyMember, Rival rival){
		if(win){
			System.out.printf("\nBy defeating the opponent, you gained %d money!\n", rival.getMoney());
			partyMember.earnMoney(rival.getMoney());
			System.out.println("The opponent gave you a rare lunar rock from the battle!");
			lunarRock++;
		}
		else{
			System.out.println("You have been defeated, better luck next time!");
		}
	}
}