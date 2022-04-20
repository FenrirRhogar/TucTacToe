public class Player {
    
    public String username;
    public int games, victories, losses;
    GameRecord[] gamerecord;

    public Player(String username, int games, int victories, int losses){

        this.username = username;
        this.games = games;
        this.victories = victories;
        this.losses = losses;
        this.gamerecord = new GameRecord[5];
    }

    //Player player = new Player("Mr Bean", 0, 0, 0);
    
}