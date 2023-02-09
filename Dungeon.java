import java.util.Scanner;
public class Dungeon{
	// instance variables
	private Room entrance;
	private Room chain;
	private Room ghost;
	private Room windy;
	private Room treasure;
	private Room practice;
	
	
	
	public static void main(){
		Game game = new Game();
		Combat.combat(game.getPartyMember(),game.getRival());
	}


	// main method with game loop
	// if gameLoop returns false trigger gameOver message
	public static void main(String[] args){
		gameLoop();
		gameOver();
	}

	public static void gameLoop(){
		Scanner input = new Scanner(System.in);
		Dungeon mansion = new Dungeon();
		Room current = mansion.getStartingRoom();
		System.out.println("\nFight all the players on this floor!");

		boolean isRunning = true;
		while(isRunning){
			System.out.print(current);
			System.out.println("quit");
			String choice = input.nextLine();
			System.out.println();
			
			Room next = null;
			if(choice.equals("n")){
				next = current.getNorth();
				main();
			}
			else if(choice.equals("e")){
				next = current.getEast();
				main();
			}
			else if(choice.equals("w")){
				next = current.getWest();
				main();
			}
			else if(choice.equals("s")){
				next = current.getSouth();
				main();
			}
			// return isRunning false to break out of gameLoop
			else if(choice.equals("q")){
				isRunning = false;
				break;
			}
			// choices other than n, e, w, s, q, will receive invalid choice
			else{
				System.out.println("invalid choice");
			}
			
			if (next!=null){
				current=next;
			}
			// choices n, e, w, s when not available will receive invalid exit
			else if(next==null){
				System.out.println("invalid exit");
			}

		}
	
	}
	//gameOver method
	public static void gameOver(){
	System.out.println("Play again next time!");
	}

	// constructor with same name as class
	public Dungeon(){
	this.entrance = new Room("Entrance", "Welcome to the training gym! Opponents are gathering around for a chance to battle!");
	this.chain = new Room("Chain Jail", "The opponents in the room are lining up ready to battle again!");
	this.ghost = new Room("Ghost Room", "The battle was scary good!");
	this.windy = new Room("Windy Room", "The battle blew the spectators away!");
	this.treasure = new Room("Treasure Room", "The battle was rich in energy!");
	this.practice = new Room("Last Practice", "Opponents are still training in this room!");
	this.setupRooms();
	}

	public void setupRooms(){
		// set up n, e, w, s for all locations

		entrance.setExits(null, null, null, chain);
		chain.setExits(entrance, ghost, null, treasure);
		ghost.setExits(null, practice, chain, windy);
		windy.setExits(ghost, null, treasure, null);
		treasure.setExits(chain, windy, null, null);
		practice.setExits(null, null, ghost, null);
		
	}

	// 
	public Room getStartingRoom(){
		return this.entrance;
	}
	
	

}