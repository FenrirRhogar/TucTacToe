import javax.swing.*;

public class PvP {

    GameBoard gameboard = new GameBoard();
    GameWindow gamewindow = new GameWindow();
    String mode = "pvp";

    public void pvpopen(JFrame frame) {
        frame.dispose();
        gamewindow.gamewindowcreation(mode);
    }
}
