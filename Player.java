import java.io.Serializable;

public class Player implements Serializable {

    public String username;
    public int score, victories, losses;

    public Player(String username, int score, int victories, int losses) {
        this.username = username;
        this.score = score;
        this.victories = victories;
        this.losses = losses;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

}