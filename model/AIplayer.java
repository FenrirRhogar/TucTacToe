package model;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.Icon;
//import javax.swing.JButton;

import view.*;

public class AIplayer {

    GameBoard gb = new GameBoard();
    Board b = new Board();
    Player p = new Player("Hal", 0, 0, 0, 0);
    Random random = new Random();
    int[] corner = { 0, 2, 6, 8 };
    int[] availablePos;

    public void PerfectPlayer(Icon ic) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        int bestVal = Integer.MAX_VALUE;
        int bestMove = corner[random.nextInt(corner.length)];
        for (int i = 0; i < 9; i++) {
            if (gb.b[i].getIcon() == null) {
                gb.b[i].setIcon(ic);
                int value = gb.minmax(false);
                gb.b[i].setIcon(null);
                if (value < bestVal) {
                    bestVal = value;
                    bestMove = i;

                }
                if (value == -1) {
                    break;
                }
            }
            gb.b[bestMove].setIcon(ic);
            gb.Result(gb.ResultCheck());

        }
    }

    public void RandomPlayer(Icon ic) throws InterruptedException {
        int sel = 0;
        TimeUnit.SECONDS.sleep(2);
        for (int i = 0; i < 9; i++) {
            if (gb.b[i].getIcon() == null) {
                availablePos[i] = i;
            }
            sel = availablePos[random.nextInt(availablePos[i])];

        }
        gb.b[sel].setIcon(ic);
        gb.Result(gb.ResultCheck());

    }

}
