import java.util.Random;
import javax.swing.JButton;

public class AIplayer {

    GameBoard gb = new GameBoard();
    Board b = new Board();
    Player p = new Player("Hal", 0, 0, 0);
    Random random = new Random();
    int[] corner = { 0, 2, 6, 8 };

    public void PerfectPlayer() {
        int bestVal = Integer.MAX_VALUE;
        int bestMove = corner[random.nextInt(corner.length)];
        if (b.Player1 && p.getUsername() == "Hal") { // Wrong
            for (int i = 0; i < 9; i++) {
                if (gb.b[i].getIcon() == null) {
                    gb.b[i].setIcon(b.getIc1());
                    int value = gb.minmax(false);
                    gb.b[i].setIcon(null);
                    if (value < bestVal) {
                        bestVal = value;
                        bestMove = i;

                    }
                }
            }

        }

    }

}
