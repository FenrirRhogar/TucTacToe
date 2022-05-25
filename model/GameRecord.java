package model;

import java.time.LocalDateTime;

public class GameRecord {
    Player winner;
    Player loser;
    float winnerScore;
    float loserScore;
    LocalDateTime DateTime;

    public LocalDateTime getDateTime() {
        LocalDateTime current = LocalDateTime.now();
        return current;
    }

    public void saveGame(Player winner, Player Loser, float winnerScore, float loserScore) {
        LocalDateTime datetime = getDateTime();
        
    }
}