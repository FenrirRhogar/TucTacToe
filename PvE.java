import javax.swing.*;

public class PvE {

    GameBoard gameboard = new GameBoard();
    PlayerPanel playerpanel = new PlayerPanel();
    GameWindow gamewindow = new GameWindow();
    
    public void pveopen(JFrame frame) {
        frame.dispose();
        JFrame gameframe = gamewindow.gamewindowcreation();
        gameboard.boardcreation(gameframe);
        gameboard.createstartbutton(gameframe);
        playerpanel.leftpanel(gameframe);
        playerpanel.rightpanel(gameframe);
    }
}
