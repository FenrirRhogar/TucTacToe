
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
    PvE pve;
    PvP pvp;
    int pnum = 0;

    public Game() {
        this.bannerpanel = new BannerPanel();
        this.board = new Board();
        this.gameboard = new GameBoard();
        this.gamerecord = new GameRecord();
        this.halloffame = new HallOfFame();
        this.mainwindow = new MainWindow();
        player = new Player[10];
        // this.player = new Player(username, games, victories, losses);
        this.playerpanel = new PlayerPanel();
        this.playerroster = new PlayerRoster();
        this.pve = new PvE();
        this.pvp = new PvP();

        playerroster.addPlayer(new Player("Mike", 0, 0, 0, 0));
        playerroster.addPlayer(new Player("George", 0, 0, 0, 0));

    }

}
