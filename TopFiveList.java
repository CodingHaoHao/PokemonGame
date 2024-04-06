package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopFiveList {
	TopFiveList(){
		
	}
	
    public void loadPlayerRecords() {
        List<PlayerRecord> playerRecords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("playerRecords.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                String playerName = record[0];
                int score = Integer.parseInt(record[1]);

                playerRecords.add(new PlayerRecord(playerName, score));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Sort player records by score in descending order
        Collections.sort(playerRecords, Collections.reverseOrder());

        // Display only the top 5 scores
        System.out.println("Top 5 Scores:");
        int count = 0;
        for (PlayerRecord record : playerRecords) {
            System.out.println("Player: " + record.getPlayerName() + ", Score: " + record.getScore());
            count++;
            if (count == 5) {
                break; // Break the loop after displaying the top 5 scores
            }
        }
    }

    public static class PlayerRecord implements Comparable<PlayerRecord> {
        private String playerName;
        private int score;

        public PlayerRecord(String playerName, int score) {
            this.playerName = playerName;
            this.score = score;
        }

        public String getPlayerName() {
            return playerName;
        }

        public int getScore() {
            return score;
        }

        public int compareTo(PlayerRecord other) {
            return Integer.compare(this.score, other.score);
        }
    }
}
