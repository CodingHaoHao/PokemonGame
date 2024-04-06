package assignment;

public class Pokemon{
		private String name;
		private int grade;
		private int pe ;
		private String zmove;
		private double hp;
		private double atk;
		private double def;
		private int spd;
		private String pokemontype;
		private String movetype;
		private int collectionnum;
	    private double originalAtk;
	    private double originalDef;

		
		Pokemon(){

		}
		
		Pokemon(String name,int grade,int pe,String zmove,double hp,double atk,double def,int spd,String pokemontype,String movetype,int collectionnum){
			super();
			this.name = name;
			this.grade = grade;
			this.pe = pe;
			this.zmove = zmove;
			this.hp = hp;
			this.atk = atk;
			this.def = def;
			this.spd = spd;
			this.pokemontype = pokemontype;
			this.movetype = movetype;
			this.collectionnum = collectionnum;
	        this.originalAtk = atk;
	        this.originalDef = def;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public int getGrade() {
			return grade;
		}

		public void setGrade(int grade) {
			this.grade = grade;
		}

		public int getPe() {
			return pe;
		}

		public void setPe(int pe) {
			this.pe = pe;
		}

		public String getZmove() {
			return zmove;
		}

		public void setZmove(String zmove) {
			this.zmove = zmove;
		}

		public double getHp() {
			return hp;
		}

		public void setHp(double hp) {
			this.hp = hp;
		}

		public double getAtk() {
			return atk;
		}

		public void setAtk(double atk) {
			this.atk = atk;
		}

		public double getDef() {
			return def;
		}

		public void setDef(double def) {
			this.def = def;
		}

		public int getSpd() {
			return spd;
		}

		public void setSpd(int spd) {
			this.spd = spd;
		}

		public String getPokemontype() {
			return pokemontype;
		}

		public void setPokemontype(String pokemontype) {
			this.pokemontype = pokemontype;
		}

		public String getMovetype() {
			return movetype;
		}

		public void setMovetype(String movetype) {
			this.movetype = movetype;
		}

		public int getCollectionnum() {
			return collectionnum;
		}

		public void setCollectionnum(int collectionnum) {
			this.collectionnum = collectionnum;
		}
		
		public String toString() {
			return String.format("Name:%s, Grade:%d, PE:%d, Z-Move:%s, HP:%.2f, ATK:%.2f, DEF:%.2f, SPD:%d, PokemonType:%s, MoveType:%s, CollectionNum:%d",name,grade,pe,zmove,hp,atk,def,spd,pokemontype,movetype,collectionnum);
		}
		
	    public void Reset() {
	        setAtk(originalAtk);
	        setDef(originalDef);
	    }
		



	}


