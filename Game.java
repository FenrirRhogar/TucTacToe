/*import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JOptionPane;*/

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

    /*public void music() {
        playMusic("TUCTACTOEMUSIC.wav");
    }
    public static void playMusic(String filepath) {
        InputStream music;
        try {
            music = new FileInputStream(new File(filepath));
            AudioInputStream audios = new AudioInputStream((TargetDataLine) music);
            AudioPlayer.player.start(audios);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }*/
}
