import javax.swing.*;
/*import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;*/

public class PvP {

    GameBoard gameboard = new GameBoard();
    PlayerPanel playerpanel = new PlayerPanel();
    
    public void pvpopen(JFrame frame) {
        gameboard.boardcreation(frame);
        playerpanel.leftpanel(frame);
        playerpanel.rightpanel(frame);
        
    }
}