import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;

public class PvP {

    GameBoard gameboard = new GameBoard();
    PlayerPanel playerpanel = new PlayerPanel();
    GameWindow gamewindow = new GameWindow();

    public void pvpopen(JFrame frame) {
        frame.dispose();
        JFrame gameframe = gamewindow.gamewindowcreation();
        gameboard.boardcreation(gameframe);
        gameboard.createstartbutton(gameframe);
        playerpanel.leftpanel(gameframe);
        playerpanel.rightpanel(gameframe);
    }
}
