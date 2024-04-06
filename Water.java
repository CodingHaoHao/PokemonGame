package assignment;

public class Water extends Pokemon {
	
	Water(){
		
	}
	
	Water(String name,int grade,int pe,String zmove,double hp,double atk,double def,int spd,String pokemontype,String movetype,int collectionnum){
		super(name,grade,pe,zmove,hp,atk,def,spd,pokemontype,movetype,collectionnum);
	} 
	
	public void CheckDamage(String type) {
		 Reset();
		    if (type.equals("fire")) {
		        double extraAtk = Math.ceil(getAtk() * 1.5); 
		        setAtk(extraAtk);
		    } else if (type.equals("water") || type.equals("ice")) {
		        double extraDef = Math.ceil(getDef() * 1.5); 
		        setDef(extraDef);
		    }
		}

	    

}

