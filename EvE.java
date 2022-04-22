import javax.swing.*;

public class EvE {

    GameBoard gameboard = new GameBoard();
    PlayerPanel playerpanel = new PlayerPanel();
    GameWindow gamewindow = new GameWindow();

    public void eveopen(JFrame frame) {
        frame.dispose();
        JFrame gameframe = gamewindow.gamewindowcreation();
        gameboard.boardcreation(gameframe);
        JButton startbutton = gameboard.createstartbutton(gameframe);
        JLabel player1name = playerpanel.leftpanel(gameframe);
        JLabel player2name = playerpanel.rightpanel(gameframe);
        if (player1name != null && player2name != null) {
            startbutton.setEnabled(true);
        }
    }
}
