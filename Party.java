public class Party{
	public static final String AKI = "Aki";
	public static final String SUSANO = "Susano";
	public static final String GOWON = "Gowon";
	public static final String BEDE = "Bede";

	public static Party generateParty(String name){
		Party group;
		switch(name){
			case AKI: {group = new Aki();} break;
			case SUSANO: {group = new Susano();} break;
			case GOWON: {group = new Gowon();} break; 
			default: {group = new Bede();}
		}
		return group;
	}

	public static Party generateRandom(){
		Party group;
		int choice = Config.rand(4);
		switch(choice){
			case 1: {group = new Aki();} break;
			case 2: {group = new Susano();} break;
			case 3: {group = new Gowon();} break;
			default: {group = new Bede();} 
		}
		return group;
	}

	private String demon;
	private int maxHp;
	private int hp;
	private int atk;
	private int specialAtk;

	private int level;
	private int exp;
	private int levelUpHp;
	private int levelUpAtk;
	private int levelUpSpecial;

	private String[] attacks;

	protected Party(String demon){
		this(demon, 150, 15, 15, 1);
	}

	protected Party(String demon, int hp, int atk, int special){
		this(demon, hp, atk, special, 1);

	}

	private Party(String demon, int hp, int atk, int special, int level){
	this.demon = demon;
	this.hp = hp;
	this.maxHp = hp;
	this.atk = atk;
	this.specialAtk = special;
	this.level = level;
	this.exp = 0;

	}

	protected void setUpAttacks(String ... atks){
		attacks = new String[4];
		for(int i = 0; i<atks.length;i++){
			if(i>=4){
				break;
			}
			attacks[i] = atks[i];
		}
	}

	protected void setUpLevelingValues(int hp, int atk, int spec){
		this.levelUpHp = hp;
		this.levelUpAtk = atk;
		this.levelUpSpecial = spec;

	}

	public void takeDamage(int damage){
		if(damage >= hp){
			hp = 0;
		}
		else{
			hp -= damage;
		}
	}

	public void heal(int value){
		if(hp+value >= maxHp){
			hp = maxHp;
		}
		else{
			hp+=value;
		}
	}

	public boolean isDead(){
		return hp <=0;
	}

	public int expValue(){
		return level*5;
	}

	public String getAttack(int index){
		return attacks[index];
	}

	public int getAtk(){
		return this.atk;
	}

	public int getSpecialAtk(){
		return this.specialAtk;
	}

	public void gainExp(int exp){
		this.exp+= exp;
		int toNext = 0;
		for(int i=0; i<=this.level;i++){
			toNext += i*50;
		}
		if(this.exp>= toNext){
			levelUp();
		}
	}

	private void levelUp(){
		level++;
		maxHp+=levelUpHp;
		atk += levelUpAtk;
		specialAtk += levelUpSpecial;
		System.out.printf("%s gained a level and is now level %d\n", demon, level);
		System.out.println(this);
	}

	@Override
	public String toString(){
		return String.format("%s\nATK[%d]\nSPECIAL[%d]\nLEVEL[%d]\n", displayHp(), atk, specialAtk, level);
	}

	public String atkDisplay(){
		String atks = "";
		for(int i=0; i<attacks.length;i++){
			atks +=""+(i+1)+" "+attacks[i]+"\n";
		}
		return atks;
	}

	public int getNumberOfAtks(){
		int c = 0;
		for(int i=0;i<attacks.length;i++){
			if(attacks[i]!=null){
				c++;
			}
		}
		return c;
	}

	public String displayHp(){
		return String.format("HP[%d/%d]", hp, maxHp);
	}

	public String getDemon(){
		return demon;
	}

}