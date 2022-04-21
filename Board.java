import java.util.*;

public class Board {

    int i = 0;
    int result;
    boolean Player1;
    String Symbol1 = "X", Symbol2 = "O", BoardState;
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

    public String getSymbol1() {
        return Symbol1;
    }

    public void setSymbol1(String symbol1) {
        Symbol1 = symbol1;
    }

    public String getSymbol2() {
        return Symbol2;
    }

    public void setSymbol2(String symbol2) {
        Symbol2 = symbol2;
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