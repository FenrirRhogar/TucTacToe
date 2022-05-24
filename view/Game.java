package view;

import controller.GameControler;
import model.*;

public class Game {

    BannerPanel bannerpanel;
    Board board;
    GameBoard gameboard;
    GameRecord gamerecord;
    HallOfFame halloffame;
    MainWindow mainwindow;
    Player[] player;
    PlayerPanel playerpanel;
    PlayerRoster playerroster;
    GameControler gc;

    public Game() {
        this.bannerpanel = new BannerPanel();
        this.board = new Board();
        this.gameboard = new GameBoard();
        this.gamerecord = new GameRecord();
        this.halloffame = new HallOfFame();
        this.mainwindow = new MainWindow();
        // this.player = new Player(username, games, victories, losses);
        this.playerpanel = new PlayerPanel();
        this.playerroster = new PlayerRoster();

        // playerroster.addPlayer(new Player("Panos", 0, 0, 0, 0));
        // playerroster.addPlayer(new Player("Christian", 0, 0, 0, 0));

    }

}
