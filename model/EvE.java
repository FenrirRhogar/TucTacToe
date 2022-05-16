package model;

import javax.swing.*;

import view.GameBoard;
import view.GameWindow;

public class EvE {

    GameBoard gameboard = new GameBoard();
    GameWindow gamewindow = new GameWindow();
    String mode = "eve";

    public void eveopen(JFrame frame) {
        frame.dispose();
        gamewindow.gamewindowcreation(mode);
    }
}
