import java.util.*;

import javax.swing.*;

public class Board {

    int i = 0;
    int result;
    boolean Player1;
    Icon ic1 = new ImageIcon("Images/X.png");
    Icon ic2 = new ImageIcon("Images/O.png");
    String BoardState;
    Random random = new Random();

    public Board() {

    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public boolean isPlayer1() {
        return Player1;
    }

    public void setPlayer1(boolean player1) {
        Player1 = player1;
    }

    public Icon getIc1() {
        return ic1;
    }

    public void setIc1(Icon ic1) {
        this.ic1 = ic1;
    }

    public Icon getIc2() {
        return ic2;
    }

    public void setIc2(Icon ic2) {
        this.ic2 = ic2;
    }

    public String getBoardState() {
        return BoardState;
    }

    public void setBoardState(String boardState) {
        BoardState = boardState;
    }

    public boolean firstPlay() {
        if (random.nextInt(2) == 0) {
            Player1 = true;
            System.out.println("P1");
            return Player1;
            // print (-player 1 name- turn in screen)
        } else {
            Player1 = false;
            return Player1;
            // print (-player 2 name -turn in screen)
        }
    }

    public boolean nextPlay() {
        if (Player1 == true) {
            Player1 = false;
            return Player1;
        } else {
            Player1 = true;
            return Player1;
        }

    }

    public void State() {
        if (result == 0 || i == 9) {
            BoardState = "final";
        }
    }

}