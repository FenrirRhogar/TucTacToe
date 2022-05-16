package model;

import javax.swing.*;

import view.GameBoard;
import view.GameWindow;

public class PvE {

    GameBoard gameboard = new GameBoard();
    GameWindow gamewindow = new GameWindow();
    String mode = "pve";

    public void pveopen(JFrame frame) {
        frame.dispose();
        gamewindow.gamewindowcreation(mode);
    }
}
