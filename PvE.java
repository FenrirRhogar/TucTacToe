import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;

public class PvE {

    GameBoard gameboard = new GameBoard();
    PlayerPanel playerpanel = new PlayerPanel();
    
    public void pveopen(JFrame frame) {
        gameboard.boardcreation(frame);
        gameboard.boardcreation(frame);
        playerpanel.leftpanel(frame);
        playerpanel.rightpanel(frame);
    }
}
