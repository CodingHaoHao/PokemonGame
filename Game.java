package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Game {
	Game(){
		
	}
	
    public void GameRules() {
		Scanner start = new Scanner(System.in);
		System.out.println("Game Rules:");
		System.out.println("1.Two wild pokemon will be dispatched out to battle against you ");
		System.out.println("2.Two pokemons would be chosen from the trainer's backpack to battle against the wild pokemons");
		System.out.println("3.Type advantages and disadvantages will be recorded and damage would be inhanced or reduced based on the pokemon types");
		System.out.println("4.Z-move would be enabled when pokemon HP<=200");
		System.out.println("5.The battle will be ended when the HP of both pokemon from a side reaches 0");
		System.out.println("6.Once you win the battle, you would be given a chance to capture the wild pokemon");
		System.out.println("\nClick's'/'S'to start your game:");
		String startGame = start.nextLine();
		//ask for user input's'/'S'
        while (!startGame.equalsIgnoreCase("s")||!startGame.equalsIgnoreCase("S")) {
            System.out.println("Invalid input. Please enter 's'/'S' to start the game:");
            startGame = start.nextLine();
        }
    }
    
    //////////////GUI Border////////////////////
    public void printGUI() {
        String sentence = "Welcome to the world of Pokemon!!!";
        int length = sentence.length() + 4;

        printBorder(length);
        System.out.println(sentence);
        printBorder(length);
    }

    public void printBorder(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

 
    
    ///////////////Stage/////////////////////// 
    public static void Stage() {
        Scanner stage = new Scanner(System.in);

        int userChoice;
        boolean isValidInput;

        do {
            System.out.println("\nBelow show the battle stage:-");
            System.out.println("1. Ocean");
            System.out.println("2. Jungle");
            System.out.println("3. Iceberg");
            System.out.println("Please select one battle stage:");

            if (stage.hasNextInt()) {
                userChoice = stage.nextInt();

                switch (userChoice) {
                    case 1:
                        System.out.println("You selected Ocean as the battle stage.\n");
                        isValidInput = true;
                        break;
                    case 2:
                        System.out.println("You selected Jungle as the battle stage.\n");
                        isValidInput = true;
                        break;
                    case 3:
                        System.out.println("You selected Iceberg as the battle stage.\n");
                        isValidInput = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid battle stage.");
                        isValidInput = false;
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                stage.next();
                isValidInput = false;
            }

        } while (!isValidInput);
    }
 

    
  /////////////////////Pokemonn/////////////////////////////////  
    public void startGame() {
    	  GameRules();
    	  printGUI();
          Player player1 = Player.createNewPlayer();
          TopFiveList topFive= new TopFiveList();
         
        Scanner choice = new Scanner(System.in);
        ArrayList<Pokemon> playerList = new ArrayList<>();
        
      	 try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Win10\\Desktop\\oop\\assignment\\src\\assignment\\pokemon.txt"))) {        
             writer.println("Charmeleon,2,2200,FlameBurst,1700,280,100,83,fire,fire,5667");
             writer.println("Salamence,4,4060,DragonRush,2300,510,101,125,dragon,dragon,5402");
       	 } catch (IOException e) {
         System.out.println("Error writing to 'pokemon.txt'");
         e.printStackTrace();
     }
      	 
		String filePath = "C:\\Users\\Win10\\Desktop\\oop\\assignment\\src\\assignment\\pokemon.txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length >= 11) {
                    Pokemon pokemon = new Pokemon();
                    pokemon.setName(attributes[0].trim());
                    pokemon.setGrade(Integer.parseInt(attributes[1].trim()));
                    pokemon.setPe(Integer.parseInt(attributes[2].trim()));
                    pokemon.setZmove(attributes[3].trim());
                    pokemon.setHp(Integer.parseInt(attributes[4].trim()));
                    pokemon.setAtk(Integer.parseInt(attributes[5].trim()));
                    pokemon.setDef(Integer.parseInt(attributes[6].trim()));
                    pokemon.setSpd(Integer.parseInt(attributes[7].trim()));
                    pokemon.setPokemontype(attributes[8].trim());
                    pokemon.setMovetype(attributes[9].trim());
                    pokemon.setCollectionnum(Integer.parseInt(attributes[10].trim()));

                    playerList.add(pokemon);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		Stage();

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(new Fire("Charizard", 3, 3140, "Flamethrower", 1900, 300, 100, 86, "fire", "fire", 3121));
        pokemonList.add(new Dragon("Fraxure", 2, 2280, "Assuranoe", 1600, 250, 90, 60, "ice", "ice", 2345));
        pokemonList.add(new Ice("Walrein", 4, 3520, "Blizzard", 2000, 500, 109, 80, "ice", "ice", 1090));
        pokemonList.add(new Water("Blastoise", 3, 3120, "HydroPump", 1500, 340, 107, 112, "water", "water", 1213));
        pokemonList.add(new Grass("Bulbasaur", 1, 1600, "RazorLeaf", 1650, 200, 90, 56, "grass", "grass", 3232));
        
        Collections.shuffle(pokemonList);//random pokemon
        List<Pokemon> selectedPokemonList = pokemonList.subList(0, 3);

        System.out.println("Searching Pokemon nearby...");
        System.out.println("You found three pokemons:");

        for (int i = 0; i < selectedPokemonList.size(); i++) {
            System.out.println((i + 1) + ": " + selectedPokemonList.get(i));
        }//print out the three random pokemon

                Scanner userchoice = new Scanner(System.in);
                int userChoice = 0;
                boolean validInput = false;

                while (!validInput) {
                    try {
                        System.out.print("Choose a Pokemon by entering the corresponding number: ");
                        userChoice = userchoice.nextInt();
                        validInput = true; // Set to true if the input is an integer
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        userchoice.nextLine(); // Consume the invalid input to avoid an infinite loop
                    }
                }

                while (userChoice < 1 || userChoice > selectedPokemonList.size()) {
                    if (userchoice.hasNextInt()) {
                        userChoice = userchoice.nextInt();
                        userchoice.nextLine(); // Consume the newline character
                        System.out.println("Invalid choice. Please choose a number between 1 and " + selectedPokemonList.size());
                    } else {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        userchoice.nextLine(); // Consume the invalid input to avoid an infinite loop
                    }
                }

              
        Pokemon chosenPokemon = selectedPokemonList.get(userChoice - 1);
        System.out.println("You catch: " + chosenPokemon.getName());

        String[] attributes = chosenPokemon.toString().split(",");

        playerList.add(chosenPokemon);
        pokemonList.remove(chosenPokemon);//remove the user chosen pokemon

        System.out.println("Here are the updated pokemon in your bag:");
        for (int i = 0; i < playerList.size(); i++) {
            System.out.println((i + 1) + ": " + playerList.get(i));
        }
        Scanner scanInput = new Scanner(System.in);
        System.out.print("\nAre you ready to battle!!!, Click 's'/'S' to start your game:");
        String startGame = scanInput.nextLine();
        while (!startGame.equalsIgnoreCase("s")&&!startGame.equalsIgnoreCase("S")) {
            System.out.println("Invalid input. Please enter 's'/'S' to start the game:");
            startGame = scanInput.nextLine();
        }
        
      Battle battle = new Battle();
      battle.fight(pokemonList,playerList,player1);//call battle class
      
      player1.savePlayerRecord();
      System.out.println("your final score:"+player1.getScore());
      topFive.loadPlayerRecords();//call top five list
    }
  }
	
    









