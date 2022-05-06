import java.io.Serializable;

public class Player implements Serializable {

    public String username;
    public int victories, losses, draws, games;
    public float score;

    public Player() {

    }

    public Player(String username, float score, int victories, int losses, int draws) {

        this.username = username;
        this.score = score;
        this.victories = victories;
        this.losses = losses;
        this.draws = draws;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
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

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public float calculateScore(int victories, int draws, int games) {
        float result;
        if (games == 0) {
            result = 0;
        } else {
            result = (float) (50.0 * ((2.0 * (float) victories + (float) draws) / ((float) games)));
        }

        return result;
    }
}