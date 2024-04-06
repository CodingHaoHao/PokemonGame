package assignment;

import java.util.Random;

public abstract class Ball {
    private String type;
    protected int catchRate;
    
    Ball(){
    	
    }
   
    public Ball(String type, int catchRate) {
        this.type = type;
        this.catchRate = catchRate;
    }

    
    public String getType() {
        return this.type;
    }

    public int getCatchRate() {
        return this.catchRate;
    }

    public double calculateCatchRate(int pokemonGrade) {
        double gradeModifier = (pokemonGrade - 1) * 10;

        // Ensure catch rate doesn't fall below 0
        return Math.max(this.catchRate - gradeModifier, 0);
    }

    public boolean catchPokemon(Pokemon pokemon) {
        Random rand = new Random();
        double chance = rand.nextDouble() * 100;
        return chance < calculateCatchRate(pokemon.getGrade());
    }

    // toString method
    public String toString() {
        return "Type: " + this.type + ", Catch Rate: " + this.catchRate;
    }
}
