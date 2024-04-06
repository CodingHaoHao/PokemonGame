package assignment;

public class Dragon extends Pokemon {
	
	Dragon(){
		
	}
	
	Dragon(String name){
		System.out.println(name);
	}
	
	Dragon(String name,int grade,int pe,String zmove,double hp,double atk,double def,int spd,String pokemontype,String movetype,int collectionnum){
		super(name,grade,pe,zmove,hp,atk,def,spd,pokemontype,movetype,collectionnum);
	}
	
	public void CheckDamage(String type) {
		 Reset();
	    if (type.equals("dragon")) {
	        double extraAtk = Math.ceil(getAtk() * 1.5); // Increase attack by 50%
	        setAtk(extraAtk);
	    } 

	    if (type.equals("fire") || type.equals("water") || type.equals("grass")) {
	        double extraDef = Math.ceil(getDef() * 1.5); 
	        setDef((int) extraDef); // Assuming setDef accepts an integer value
	    }
	}

	    
	    
	    
}

