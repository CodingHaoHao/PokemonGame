package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;

public class Battle {
	Battle(){
		
	}
	
    public void fight(ArrayList<Pokemon> pokemonList, ArrayList<Pokemon> playerList,Player player) {
   	 try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Win10\\Desktop\\oop\\assignment\\src\\assignment\\pokemon.txt"))) {    
         writer.println("Charmeleon,2,2200,FlameBurst,1700,280,100,83,fire,fire,5667");
         writer.println("Salamence,4,4060,DragonRush,2300,510,101,125,dragon,dragon,5402");
   	 } catch (IOException e) {
     System.out.println("Error writing to 'pokemon.txt'");
     e.printStackTrace();
 }//rewrite initial file
   	 
        Scanner userChoiceScanner = new Scanner(System.in);

        // Choose the first Pokemon
        Pokemon chosenPokemon1 = selectPokemon(playerList, userChoiceScanner);
        System.out.println("You chose: " + chosenPokemon1.getName());
        // Choose the second Pokemon
        Pokemon chosenPokemon2 = selectPokemon(playerList, userChoiceScanner);
        System.out.println("You chose: " + chosenPokemon2.getName());

        // Display information about the battle
        System.out.println("Time to battle");
        Collections.shuffle(pokemonList);
        List<Pokemon> selectedPokemonForBattle = pokemonList.subList(0, 2);//random choose two enemy from pokrmonList
        System.out.println("Some random Pokemons appear");
        Pokemon randomPokemon1 = selectedPokemonForBattle.get(0);
        Pokemon randomPokemon2 = selectedPokemonForBattle.get(1);

        System.out.println("\n\n\t" + chosenPokemon1.getName() + " and " + chosenPokemon2.getName() +
                " vs " + randomPokemon1.getName() + " and " + randomPokemon2.getName() + "\n\n");

        // Display battle information for chosen Pokemon
        displayPokemonInfo(chosenPokemon1, randomPokemon1);
        displayPokemonInfo(chosenPokemon2, randomPokemon2);

        int round = 0;
        Scanner input = new Scanner(System.in);

        while ((randomPokemon1.getHp() > 0 || randomPokemon2.getHp() > 0) &&
        	   (chosenPokemon1.getHp() > 0 || chosenPokemon2.getHp() > 0)) {
            round += 1;
            System.out.println("Round: " + round);
            System.out.print("Type something to deal damage:");

            String userInput = input.nextLine();

            if (userInput.isEmpty()) {
                System.out.println("Please type something to deal damage.");
                continue;
            }

            handleDamage(chosenPokemon1, randomPokemon1,randomPokemon2);
            displayBattleInfo(chosenPokemon1, randomPokemon1);
            displayBattleInfo(chosenPokemon1, randomPokemon2);
       
            handleDamage(chosenPokemon2, randomPokemon1,randomPokemon2);
            displayBattleInfo(chosenPokemon2, randomPokemon1);
            displayBattleInfo(chosenPokemon2, randomPokemon2);

            handleDamage(randomPokemon1, chosenPokemon1,chosenPokemon2);
            displayBattleInfo(randomPokemon1, chosenPokemon1);
            displayBattleInfo(randomPokemon1, chosenPokemon2);
         
            handleDamage(randomPokemon2, chosenPokemon1,chosenPokemon2);
            displayBattleInfo(randomPokemon2, chosenPokemon1);
            displayBattleInfo(randomPokemon2, chosenPokemon2);
        
            player.increaseScore(10);

        }

        // Determine the winner
        determineWinner(chosenPokemon1, chosenPokemon2, randomPokemon1, randomPokemon2,player);
    }

    // Helper method to select a Pokemon from the player list
    private Pokemon selectPokemon(ArrayList<Pokemon> playerList, Scanner scanner) {
        int userChoice = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Choose a Pokemon by entering the corresponding number to fight: ");
                userChoice = scanner.nextInt();
                validInput = true; // Set to true if the input is an integer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
            }
        }

        while (userChoice < 1 || userChoice > playerList.size()) {
            System.out.println("Invalid choice. Please choose a number between 1 and " + playerList.size());
            validInput = false;

            while (!validInput) {
                try {
                    System.out.print("Choose a Pokemon by entering the corresponding number to fight: ");
                    userChoice = scanner.nextInt();
                    validInput = true; // Set to true if the input is an integer
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
                }
            }
        }

        return playerList.get(userChoice - 1);
    }


    // Helper method to display information about the battle
    private void displayPokemonInfo(Pokemon chosenPokemon, Pokemon randomPokemon) {
        System.out.println(chosenPokemon.getName() + " type: " + chosenPokemon.getPokemontype());
        System.out.println(randomPokemon.getName() + " type: " + randomPokemon.getPokemontype());
        System.out.println("Your Pokemon ATK damage: " + chosenPokemon.getAtk());
        System.out.println(randomPokemon.getName() + "'s DEF: " + randomPokemon.getDef());
        System.out.println(randomPokemon.getName() + "'s HP: " + randomPokemon.getHp() + "\n");
    }

    // Helper method to handle damage dealt by a Pokemon
    private void handleDamage(Pokemon attacker, Pokemon defender, Pokemon defender2) {
        String chosenPokemonType = attacker.getPokemontype();

        if (attacker instanceof Ice) {
            System.out.println("Ice damage");
            ((Ice) attacker).CheckDamage(defender.getPokemontype());
            ((Ice) attacker).CheckDamage(defender2.getPokemontype());//call from five element subclass
        } else if (attacker instanceof Water) {
            System.out.println("Water damage");
            ((Water) attacker).CheckDamage(defender.getPokemontype());
            ((Water) attacker).CheckDamage(defender2.getPokemontype());
        } else if (attacker instanceof Fire) {
            System.out.println("Fire damage");
            ((Fire) attacker).CheckDamage(defender.getPokemontype());
            ((Fire) attacker).CheckDamage(defender2.getPokemontype());
        } else if (attacker instanceof Grass) {
            System.out.println("Grass damage");
            ((Grass) attacker).CheckDamage(defender.getPokemontype());
            ((Grass) attacker).CheckDamage(defender2.getPokemontype());
        } else if (attacker instanceof Dragon) {
            System.out.println("Dragon damage");
            ((Dragon) attacker).CheckDamage(defender.getPokemontype());
            ((Dragon) attacker).CheckDamage(defender2.getPokemontype());
        } else {
            System.out.println("Normal damage");
        }

     // Inside handleDamage method
        double damageDeal = Math.max(attacker.getAtk() - defender.getDef(), 0);
        defender.setHp(Math.max(defender.getHp() - damageDeal, 0));

        double damageDeal2 = Math.max(attacker.getAtk() - defender2.getDef(), 0);
        defender2.setHp(Math.max(defender2.getHp() - damageDeal2, 0));

    }


    // Helper method to display battle information after each round
    private void displayBattleInfo(Pokemon attacker, Pokemon defender) {
        System.out.println(attacker.getName() + " deals " + Math.max(attacker.getAtk() - defender.getDef(), 0) +
                " damage to " + defender.getName());
        System.out.println(defender.getName() + "'s remaining HP: " + defender.getHp() + "\n");
    }
    
    // Helper method to determine the winner of the battle
    private void determineWinner(Pokemon chosenPokemon1, Pokemon chosenPokemon2, Pokemon randomPokemon1, Pokemon randomPokemon2,Player player) {
        if (randomPokemon1.getHp() <= 0 && randomPokemon2.getHp() <= 0) {
            System.out.println("You win!");
            player.increaseScore(30);


            // Randomly choose a ball
            List<Ball> balls = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                balls.add(new PokeBall());
            }
            for (int i = 0; i < 30; i++) {
                balls.add(new GreatBall());
            }
            for (int i = 0; i < 15; i++) {
                balls.add(new UltraBall());
            }
            for (int i = 0; i < 5; i++) {
                balls.add(new MasterBall());
            }//percentage to get the ball

            Collections.shuffle(balls);
            Ball catchPokemonBall = balls.get(0);//take the first ball after shuffle
            ArrayList<String> allPokemonList = new ArrayList<>();
            
            // Attempt to catch the Pokémon
            System.out.println("\nA random ball will be get...");
            System.out.println("\nCatch Rate of Ball:-\nMaster Ball:100\nUltra Ball:85\nGreat Ball:75\nPoke Ball:60");
            System.out.println("{Rate of ball will decrease by 10% for each grade above 1}");
            System.out.println("\nYou get a "+catchPokemonBall.getType()+"!!!");
            
            boolean success1 = catchPokemonBall.catchPokemon(randomPokemon1);
           
            String filePath = "C:\\Users\\Win10\\Desktop\\oop\\assignment\\src\\assignment\\pokemon.txt";
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    allPokemonList.add(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading from 'pokemon.txt'");
                e.printStackTrace();
            }
            
            System.out.println("\nCaught:"+randomPokemon1.getName()+" with Grade "+randomPokemon1.getGrade());
            if (success1) {
                System.out.println("Congratulations! You caught the "+randomPokemon1.getName());
                System.out.println("Rate of catch:"+catchPokemonBall.calculateCatchRate(randomPokemon1.getGrade()));
                allPokemonList.add(randomPokemon1.toString());
                // Add a line to your txt file here
            } else {
                System.out.println("You failed to catch the "+randomPokemon1.getName());
                System.out.println("Rate of catch:"+catchPokemonBall.calculateCatchRate(randomPokemon1.getGrade()));
            }
            
            boolean success2 = catchPokemonBall.catchPokemon(randomPokemon2);

            System.out.println("\nCaught:"+randomPokemon2.getName()+" with Grade "+randomPokemon2.getGrade());
            if (success2) {
                System.out.println("Congratulations! You caught the "+randomPokemon2.getName());
                System.out.println("Rate of catch:"+catchPokemonBall.calculateCatchRate(randomPokemon2.getGrade()));
                allPokemonList.add(randomPokemon2.toString());
            } else {
                    System.out.println("You failed to catch the "+randomPokemon2.getName());
                    System.out.println("Rate of catch:"+catchPokemonBall.calculateCatchRate(randomPokemon2.getGrade()));
                }          
                
                
                if (!allPokemonList.isEmpty()) {
                    try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
                        for (String pokemon : allPokemonList) {
                            writer.println(pokemon);
                        }
                    } catch (IOException e) {
                        System.out.println("Error writing to 'pokemon.txt'");
                        e.printStackTrace();
                    }

            } else {
                System.out.println("You failed to catch the "+randomPokemon2.getName());
                System.out.println("Rate of catch:"+catchPokemonBall.calculateCatchRate(randomPokemon2.getGrade()));
            }
        
        } else if (chosenPokemon1.getHp() <= 0 && chosenPokemon2.getHp() <= 0) {
            System.out.println("You lose!");
            player.increaseScore(10);
        } else {
            System.out.println("The battle ended.");
        }
        
    
        }
    }
   
	
 


