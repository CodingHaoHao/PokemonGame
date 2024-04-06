package assignment;

public class Ice extends Pokemon {
	
	Ice(){
		
	}
	
	Ice(String name){
		System.out.println(name);
	}
	
	
	Ice(String name,int grade,int pe,String zmove,double hp,double atk,double def,int spd,String pokemontype,String movetype,int collectionnum){
		super(name,grade,pe,zmove,hp,atk,def,spd,pokemontype,movetype,collectionnum);
	}
	
	
	public void CheckDamage(String type) {
		 Reset();//call from pokemon class
	    if (type.equals("dragon")||type.equals("grass")) {
	        double extraAtk = Math.ceil(getAtk() * 1.5); // Increase attack by 50%
	        setAtk(extraAtk);
	    } 

	    if (type.equals("ice") || type.equals("water") || type.equals("grass")) {
	        double extraDef = Math.ceil(getDef() * 1.5); 
	        setDef((int) extraDef); // Assuming setDef accepts an integer value
	    }
	   
	}
	

	    
}