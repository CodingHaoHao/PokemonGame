package assignment;

public class Grass extends Pokemon {
	
	Grass(){
		
	}
	
	Grass(String name){
		System.out.println(name);
	}
	
	Grass(String name,int grade,int pe,String zmove,double hp,double atk,double def,int spd,String pokemontype,String movetype,int collectionnum){
		super(name,grade,pe,zmove,hp,atk,def,spd,pokemontype,movetype,collectionnum);
	}
	
	public void CheckDamage(String type) {
		 Reset();
	    if (type.equals("water")) {
	        double extraAtk = Math.ceil(getAtk() * 1.5); // Increase attack by 50%
	        setAtk(extraAtk);
	    } else if (type.equals("grass") || type.equals("water")) {
	        double extraDef = Math.ceil(getDef() * 1.5); // Increase defense by 50% and round up
	        setDef((int) extraDef);
	    }
	}

	    
	    
	    
}

