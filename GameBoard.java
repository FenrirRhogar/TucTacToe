import javax.swing.*;
import java.awt.event.*;
import java.rmi.activation.ActivationDesc;
import java.awt.Cursor;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.swing.JOptionPane;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class GameBoard extends JFrame implements ItemListener, ActionListener {

    MainWindow mainwindow;
    PlayerPanel playerpanel = new PlayerPanel();
    JButton b[] = new JButton[9];
    JPanel boardpanel = new JPanel();
    ImageIcon tictactoegameboard = new ImageIcon("board.png");
    JButton boardbutton = new JButton(tictactoegameboard);
    JButton startbutton = new JButton("Start");
    Board board = new Board();
    Music music = new Music();
    boolean turn = board.firstPlay();
    int num, result;

    public int ResultCheck() {
        // P1 wins
        if (b[0].getIcon() == board.getIc1() &&
                b[1].getIcon() == board.getIc1() &&
                b[2].getIcon() == board.getIc1()) {
            result = 1;
            return result;
        }
        if (b[3].getIcon() == board.getIc1() &&
                b[4].getIcon() == board.getIc1() &&
                b[5].getIcon() == board.getIc1()) {
            result = 1;
            return result;
        }
        if (b[6].getIcon() == board.getIc1() &&
                b[7].getIcon() == board.getIc1() &&
                b[8].getIcon() == board.getIc1()) {
            result = 1;
            return result;
        }
        if (b[0].getIcon() == board.getIc1() &&
                b[3].getIcon() == board.getIc1() &&
                b[6].getIcon() == board.getIc1()) {
            result = 1;
            return result;
        }
        if (b[1].getIcon() == board.getIc1() &&
                b[4].getIcon() == board.getIc1() &&
                b[7].getIcon() == board.getIc1()) {
            result = 1;
            return result;
        }
        if (b[2].getIcon() == board.getIc1() &&
                b[5].getIcon() == board.getIc1() &&
                b[8].getIcon() == board.getIc1()) {
            result = 1;
            return result;
        }
        if (b[0].getIcon() == board.getIc1() &&
                b[4].getIcon() == board.getIc1() &&
                b[8].getIcon() == board.getIc1()) {
            result = 1;
            return result;
        }
        if (b[2].getIcon() == board.getIc1() &&
                b[4].getIcon() == board.getIc1() &&
                b[6].getIcon() == board.getIc1()) {
            result = 1;
            return result;
        }
        /**************************************************************** */
        // P2 wins
        if (b[0].getIcon() == board.getIc2() &&
                b[1].getIcon() == board.getIc2() &&
                b[2].getIcon() == board.getIc2()) {
            result = -1;
            return result;
        }
        if (b[3].getIcon() == board.getIc2() &&
                b[4].getIcon() == board.getIc2() &&
                b[5].getIcon() == board.getIc2()) {
            result = -1;
            return result;
        }
        if (b[6].getIcon() == board.getIc2() &&
                b[7].getIcon() == board.getIc2() &&
                b[8].getIcon() == board.getIc2()) {
            result = -1;
            return result;
        }
        if (b[0].getIcon() == board.getIc2() &&
                b[3].getIcon() == board.getIc2() &&
                b[6].getIcon() == board.getIc2()) {
            result = -1;
            return result;
        }
        if (b[1].getIcon() == board.getIc2() &&
                b[4].getIcon() == board.getIc2() &&
                b[7].getIcon() == board.getIc2()) {
            result = -1;
            return result;
        }
        if (b[2].getIcon() == board.getIc2() &&
                b[5].getIcon() == board.getIc2() &&
                b[8].getIcon() == board.getIc2()) {
            result = -1;
            return result;
        }
        if (b[0].getIcon() == board.getIc2() &&
                b[4].getIcon() == board.getIc2() &&
                b[8].getIcon() == board.getIc2()) {
            result = -1;
            return result;
        }
        if (b[2].getIcon() == board.getIc2() &&
                b[4].getIcon() == board.getIc2() &&
                b[6].getIcon() == board.getIc2()) {
            result = -1;
            return result;
        }
        // draw
        else {
            result = 0;
            return result;
        }

    }

    public void Result(int res) {
        JFrame jFrame = new JFrame();
        if (res == 1) {
            for (int i = 0; i < 9; i++) {
                b[i].setEnabled(false);
                boardbutton.setEnabled(false);
            }
            JOptionPane.showMessageDialog(jFrame, "Player 1 wins!");
        } else if (res == -1) {
            for (int i = 0; i < 9; i++) {
                b[i].setEnabled(false);
                boardbutton.setEnabled(false);
            }
            JOptionPane.showMessageDialog(jFrame, "Player 2 wins!");
        } else {
            if (b[0].getIcon() != null && b[1].getIcon() != null && b[2].getIcon() != null && b[3].getIcon() != null
                    && b[4].getIcon() != null && b[5].getIcon() != null && b[6].getIcon() != null
                    && b[7].getIcon() != null && b[8].getIcon() != null) {
                for (int i = 0; i < 9; i++) {
                    b[i].setEnabled(false);
                    boardbutton.setEnabled(false);
                }

                JOptionPane.showMessageDialog(jFrame, "Draw!");
            }
        }
    }

    public JButton createstartbutton(JFrame frame) {
        startbutton.setBounds(300, 350, 100, 35);
        frame.add(startbutton);
        startbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    b[i].setEnabled(true);
                }
                startbutton.setEnabled(false);
                startbutton.setVisible(false);
            }

        });
        startbutton.setEnabled(false);
        return startbutton;
    }

    // game board 9 buttons creation
    public void boardcreation(JFrame frame, String gamemode) {
        JButton button = createstartbutton(frame);
        playerpanel.playerpanelscreation(frame, button, gamemode);
        boardbutton.setBounds(200, 10, 300, 300);
        frame.add(boardbutton);
        JLayeredPane layeredPane = frame.getLayeredPane();
        layeredPane.add(boardbutton, Integer.valueOf(0));
        int i, j, x, y;
        x = 200;
        y = 10;
        j = 0;
        for (i = 0; i <= 8; i++, x += 100, j++) {
            b[i] = new JButton();
            if (j == 3) {
                j = 0;
                y += 100;
                x = 200;
            }
            b[i].setBounds(x, y, 100, 100);
            frame.add(b[i]);
            layeredPane.add(b[i], Integer.valueOf(1));
            b[i].setEnabled(false);
            // make buttons invisible
            b[i].setOpaque(false);
            b[i].setContentAreaFilled(false);
            b[i].setBorderPainted(false);
            b[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            b[i].addActionListener(this);
        }
    }

    public int minmax(boolean turn) {
        if (ResultCheck() != 0) {
            return result;
        }
        if (turn) {
            int j = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (b[i].getIcon() == null) {
                    b[i].setIcon(board.getIc1());
                    int value = minmax(false);
                    b[i].setIcon(null);
                    if (value == -1) {
                        return value;
                    }
                    j = Math.min(value, j);
                }
            }
            return j;
        }
        int bestVal = Integer.MIN_VALUE;
        for (int k = 0; k < 9; k++) {
            if (b[k].getIcon() == null) {
                b[k].setIcon(board.getIc2());
                int value = minmax(true);
                b[k].setIcon(null);
                if (value == 1) {
                    return value;
                }
                bestVal = Math.min(bestVal, value);
            }
        }
        return bestVal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JButton actionSource = (JButton) e.getSource();

            /*
             * if (actionSource == startbutton) {
             * for (int i = 0; i < 9; i++) {
             * b[i].setEnabled(true);
             * }
             * startbutton.setEnabled(false);
             * startbutton.setVisible(false);
             * } *
             * else if (actionSource == playerpanel.selectplayer1button) {
             * if (playerpanel.player1name.getText() != null &&
             * playerpanel.player2name.getText() != null) {
             * startbutton.setEnabled(true);
             * }
             * } else if (actionSource == playerpanel.selectplayer2button) {
             * if (playerpanel.player1name.getText() != null &&
             * playerpanel.player2name.getText() != null) {
             * startbutton.setEnabled(true);
             * }
             * }
             */

            for (int i = 0; i < 9; i++) {
                if (actionSource == b[i]) {
                    if (turn) {
                        if (b[i].getIcon() == null) {
                            b[i].setIcon(board.getIc1());
                            turn = board.nextPlay();
                            Result(ResultCheck());
                            // cheking return number
                            // P2 turn
                        }

                    } else {
                        if (b[i].getIcon() == null) {
                            b[i].setIcon(board.getIc2());
                            turn = board.nextPlay();
                            Result(ResultCheck());
                            // checking return number
                            // P1 turn
                        }
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

}