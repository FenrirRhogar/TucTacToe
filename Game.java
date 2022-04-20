public class Game {
    //geia sas
    BannerPanel bannerpanel;
    Board board;
    GameBoard gameboard;
    GameRecord gamerecord;
    HallOfFame halloffame;
    MainWindow mainwindow;
    Player player;
    PlayerPanel playerpanel;
    PlayerRoster playerroster;
    PvE pve;
    PvP pvp;

    public Game() {
        this.bannerpanel = new BannerPanel();
        this.board = new Board();
        this.gameboard = new GameBoard();
        this.gamerecord = new GameRecord();
        this.halloffame = new HallOfFame();
        this.mainwindow = new MainWindow();
        //this.player = new Player(username, games, victories, losses);
        this.playerpanel = new PlayerPanel();
        this.playerroster = new PlayerRoster();
        this.pve = new PvE();
        this.pvp = new PvP();
        
    }
}
