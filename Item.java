public class Item{
	public static final String POTION = "potion";
	public static final String MAX_POTION = "max potion";
	public static final String HEALING = "healing";

	public static Item item(String name){
		switch(name){
			case POTION: return new Item(POTION, HEALING, 35, 60);
			case MAX_POTION: return new Item(MAX_POTION, HEALING, 200, 300);
			default: return new Item("berry", HEALING, 5, 15);
		}
	}

	public final String name;
	public String type;
	public final int value;
	public final int cost;

	private Item(String name, String type, int value, int cost){
		this.name = name;
		this.type = type;
		this.value = value;
		this.cost = cost;

	}

	public String toString(){
		return name;
	}
}