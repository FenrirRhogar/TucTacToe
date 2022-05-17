package model;

import controller.GameControler;

public class GameModel {

    Player[] gamePlayers;
    PlayerRoster roster;
    GameControler gc;

    public GameModel(GameControler gc) {
        this.gc = gc;
        gamePlayers = new Player[10];
    }

    public Player[] getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(Player[] gamePlayers) {
        this.gamePlayers = gamePlayers;
    }

    public PlayerRoster getRoster() {
        return roster;
    }

    public void setRoster(PlayerRoster roster) {
        this.roster = roster;
    }

    public boolean ready() {
        return gamePlayers[0] != null && gamePlayers[1] != null;
    }

    public void selectplayer(Player player, int pos) {
        if (pos < 0 && pos > 1)
            return;
        gamePlayers[pos] = player;
    }

    public void takePLayer(Player p) {

    }
}
