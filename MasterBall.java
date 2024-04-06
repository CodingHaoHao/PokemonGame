package assignment;

public class MasterBall extends Ball {
    // Constructor
    public MasterBall() {
        super("Master Ball", 100); // 100% catch rate
    }
    
    @Override
    public double calculateCatchRate(int pokemonGrade) {
        // MasterBall has a 100% catch rate regardless of the Pokemon's grade
        return 100;
    }
}
