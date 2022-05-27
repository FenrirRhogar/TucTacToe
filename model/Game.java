package model;

import java.time.LocalDateTime;

public class Game {
    Player player1;
    Player player2;
    float winnerScore;
    float loserScore;
    int winner; //1 for player1, 2 for player2, 0 for draw
    LocalDateTime DateTime;

    public Game(Player player1, Player player2, float winnerScore, float loserScore, int winner) {
        this.player1 = player1;
        this.player2 = player2;
        this.winnerScore = winnerScore;
        this.loserScore = loserScore;
        this.winner = winner;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public float getWinnerScore() {
        return winnerScore;
    }

    public void setWinnerScore(float winnerScore) {
        this.winnerScore = winnerScore;
    }

    public float getLoserScore() {
        return loserScore;
    }

    public void setLoserScore(float loserScore) {
        this.loserScore = loserScore;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public LocalDateTime getDateTime() {
        LocalDateTime current = LocalDateTime.now();
        return current;
    }

    public void setDateTime(LocalDateTime dateTime) {
        DateTime = dateTime;
    }
}
