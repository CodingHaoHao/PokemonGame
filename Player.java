package assignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Player {
	Player(){
		
	}
	
    private String playerName;
    private int score;

    public Player(String playerName) {
        this.playerName = playerName;
        this.score = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }
    public static Player createNewPlayer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        return new Player(playerName);
    }
    public void savePlayerRecord() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("playerRecords.txt", true))) {
            writer.write(playerName + "," + score);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void increaseScore(int points) {
        this.score += points;
    }

}
