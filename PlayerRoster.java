public class PlayerRoster {

    Player[] player;

    int pnum = 0;

    public PlayerRoster() {
        this.player = new Player[50];
    }

    public void addPlayer(Player p) {
        player[pnum] = p;
        pnum++;
    }

    public String findPlayerNames(Player pl) {
        for (Player p : this.player) {
            if (p != null && p.equals(pl))
                return p.username;
        }
        return null;
    }

    public Player findPlayer(String name) {
        for (Player player : this.player) {
            if (player != null && player.getUsername().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void findHallOfFame(int number) {

    }
}