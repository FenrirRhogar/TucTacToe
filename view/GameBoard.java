package view;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Cursor;
import javax.swing.JOptionPane;

import java.awt.*;
import model.*;
import model.Board;

import java.util.ArrayList;
import java.util.Random;

public class GameBoard extends JFrame implements ItemListener, ActionListener {

    MainWindow mainwindow;
    PlayerPanel playerpanel = new PlayerPanel();
    public JButton b[] = new JButton[9];
    JPanel boardpanel = new JPanel();
    ImageIcon tictactoegameboard = new ImageIcon("Images/board.png");
    JButton boardbutton = new JButton(tictactoegameboard);
    JButton startbutton1 = new JButton("Start");
    JButton startbutton2 = new JButton("Start");
    JButton playagainbutton = new JButton("Play Again");
    JButton playagainbutton2 = new JButton("Play Again with the same Players");
    JLabel nowplaying = new JLabel();
    JLabel activeplayer = new JLabel();
    JPanel activeplayerpanel = new JPanel();
    Board board = new Board();
    AIplayer ai = new AIplayer();
    Random random = new Random();
    boolean turn;
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

    public Boolean Result(int res) {
        JFrame jFrame = new JFrame();
        if (res == 1) {
            for (int i = 0; i < 9; i++) {
                b[i].setEnabled(false);
                boardbutton.setEnabled(false);
            }
            JOptionPane.showMessageDialog(jFrame, "Player 1 wins!");
            playerpanel.roster.player1wins(playerpanel.player1name.getText(), playerpanel.player2name.getText());
            playagainbutton.setVisible(true);
            playagainbutton.setEnabled(true);
            playagainbutton2.setVisible(true);
            playagainbutton2.setEnabled(true);
            return true;
        } else if (res == -1) {
            for (int i = 0; i < 9; i++) {
                b[i].setEnabled(false);
                boardbutton.setEnabled(false);
            }
            JOptionPane.showMessageDialog(jFrame, "Player 2 wins!");
            playerpanel.roster.player2wins(playerpanel.player1name.getText(), playerpanel.player2name.getText());
            playagainbutton.setVisible(true);
            playagainbutton.setEnabled(true);
            playagainbutton2.setVisible(true);
            playagainbutton2.setEnabled(true);
            return true;
        } else {
            if (b[0].getIcon() != null && b[1].getIcon() != null && b[2].getIcon() != null && b[3].getIcon() != null
                    && b[4].getIcon() != null && b[5].getIcon() != null && b[6].getIcon() != null
                    && b[7].getIcon() != null && b[8].getIcon() != null) {
                for (int i = 0; i < 9; i++) {
                    b[i].setEnabled(false);
                    boardbutton.setEnabled(false);
                }
                JOptionPane.showMessageDialog(jFrame, "Draw!");
                playerpanel.roster.playerdraw(playerpanel.player1name.getText(), playerpanel.player2name.getText());
                playagainbutton.setVisible(true);
                playagainbutton.setEnabled(true);
                playagainbutton2.setVisible(true);
                playagainbutton2.setEnabled(true);
                return true;
            }
        }
        return false;
    }

    // add start buttons
    public JButton createstartbutton1(JFrame gameframe) {
        startbutton1.setBounds(45, 350, 110, 35);
        gameframe.add(startbutton1);
        startbutton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startbutton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                activeplayer.setText(playerpanel.player1name.getText());
                for (int i = 0; i < 9; i++) {
                    b[i].setEnabled(true);
                }
                boardbutton.setEnabled(true);
                startbutton1.setEnabled(false);
                startbutton1.setVisible(false);
                startbutton2.setEnabled(false);
                startbutton2.setVisible(false);
                nowplaying.setVisible(true);
                activeplayer.setVisible(true);
                board.setPlayer1(true);
                turn = board.firstPlay(board.isPlayer1());
                if (playerpanel.player1name.getText().equals("Mr. Bean") == true) {
                    try {
                        RandomPlayer(board.getIc1());
                        turn = board.nextPlay();
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    return;
                } /*
                   * else if (playerpanel.player1name.getText().equals("Hal") == true) {
                   * try {
                   * PerfectPlayer(board.getIc1());
                   * turn = board.nextPlay();
                   * } catch (InterruptedException e1) {
                   * // TODO Auto-generated catch block
                   * e1.printStackTrace();
                   * }
                   * return;
                   * }
                   */
                // ksekinaei o 1
            }

        });
        startbutton1.setEnabled(false);
        return startbutton1;
    }

    public JButton createstartbutton2(JFrame gameframe) {
        startbutton2.setBounds(545, 350, 110, 35);
        gameframe.add(startbutton2);
        startbutton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startbutton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                activeplayer.setText(playerpanel.player2name.getText());
                for (int i = 0; i < 9; i++) {
                    b[i].setEnabled(true);
                }
                boardbutton.setEnabled(true);
                startbutton1.setEnabled(false);
                startbutton1.setVisible(false);
                startbutton2.setEnabled(false);
                startbutton2.setVisible(false);
                nowplaying.setVisible(true);
                activeplayer.setVisible(true);
                board.setPlayer1(false);
                turn = board.firstPlay(board.isPlayer1());
                if (playerpanel.player2name.getText().equals("Mr. Bean") == true) {
                    try {
                        RandomPlayer(board.getIc2());
                        turn = board.nextPlay();
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    return;
                } /*
                   * else if (playerpanel.player2name.getText().equals("Hal") == true) {
                   * try {
                   * PerfectPlayer(board.getIc2());
                   * turn = board.nextPlay();
                   * } catch (InterruptedException e1) {
                   * // TODO Auto-generated catch block
                   * e1.printStackTrace();
                   * }
                   * return;
                   * }
                   */
                // ksekinaei o 2
            }

        });
        startbutton2.setEnabled(false);
        return startbutton2;
    }

    // play again button
    public void createplayagainbuttons(JFrame gameframe, String gamemode, Clip clip) {
        playagainbutton.setBounds(300, 350, 100, 35);
        playagainbutton2.setBounds(240, 390, 220, 35);
        playagainbutton.setBounds(300, 420, 100, 35);
        playagainbutton2.setBounds(240, 460, 220, 35);
        gameframe.add(playagainbutton);
        gameframe.add(playagainbutton2);
        playagainbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        playagainbutton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        playagainbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clip.close();
                gameframe.dispose();
                GameWindow gw = new GameWindow();
                gw.gamewindowcreation(gamemode);
            }

        });
        playagainbutton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Player player1 = playerpanel.roster.findPlayer(playerpanel.player1name.getText());
                Player player2 = playerpanel.roster.findPlayer(playerpanel.player2name.getText());
                clip.close();
                gameframe.dispose();
                GameWindow gw = new GameWindow();
                gw.gamewindowcreation(gamemode);
                gw.gameboard.playerpanel.leftbuttonaction(startbutton1, startbutton2, null, player1);
                gw.gameboard.playerpanel.rightbuttonaction(startbutton1, startbutton2, null, player2);
                gw.gameboard.startbutton1.setEnabled(true);
                gw.gameboard.startbutton2.setEnabled(true);
                gw.gameboard.startbutton1.setVisible(true);
                gw.gameboard.startbutton2.setVisible(true);
            }

        });
        playagainbutton.setVisible(false);
        playagainbutton.setEnabled(false);
        playagainbutton2.setVisible(false);
        playagainbutton2.setEnabled(false);
    }

    // game board 9 buttons creation
    public void boardcreation(JFrame frame, String gamemode, Clip clip) {
        JButton startbutton1 = createstartbutton1(frame);
        JButton startbutton2 = createstartbutton2(frame);
        createplayagainbuttons(frame, gamemode, clip);
        playerpanel.playerpanelscreation(frame, startbutton1, startbutton2, gamemode);
        boardbutton.setBounds(200, 10, 300, 300);
        boardbutton.setBounds(200, 110, 300, 300);
        boardbutton.setEnabled(false);
        frame.add(boardbutton);
        nowplaying.setBounds(290, 20, 200, 30);
        nowplaying.setFont(new Font("Monaco", Font.BOLD, 20));
        nowplaying.setForeground(Color.YELLOW);
        nowplaying.setText("Now playing:");
        nowplaying.setVisible(false);
        frame.add(nowplaying);
        activeplayer.setFont(new Font("Monaco", Font.BOLD, 20));
        activeplayer.setForeground(Color.YELLOW);
        activeplayer.setVisible(false);
        activeplayer.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        activeplayerpanel.setBounds(200, 50, 300, 50);
        activeplayerpanel.setBackground(new Color(5, 65, 90));
        activeplayer.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        activeplayerpanel.add(activeplayer);
        frame.add(activeplayerpanel);
        JLayeredPane layeredPane = frame.getLayeredPane();
        layeredPane.add(boardbutton, Integer.valueOf(0));
        int i, j, x, y;
        x = 200;
        y = 10;
        y = 110;
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

    public int score(int depth) {
        if (ResultCheck() == 1) {
            return 10 - depth;
        } else if (ResultCheck() == -1) {
            return -10 + depth;
        } else {
            return 0;
        }
    }

    public int getMin(boolean turn, Icon ic, int alpha, int beta, int depth) {
        int bestMove = -1;
        int i;

        for (i = 0; i < 9; i++) {

            if (b[i].getIcon() == null) {
                b[i].setIcon(ic);
                turn = board.nextPlay();
                int score = minimax(turn, ic, alpha, beta, depth);
                b[i].setIcon(null);
                if (score < beta) {
                    beta = score;
                    bestMove = i;
                }

                // Pruning.
                if (alpha >= beta) {
                    break;
                }
            }
        }
        if (bestMove != -1) {

            System.out.println("Bba");
            return bestMove;
        }
        return beta;
    }

    public int getMax(boolean turn, Icon ic, int alpha, int beta, int depth) {
        int bestMove = -1;
        int i;

        for (i = 0; i < 9; i++) {
            if (b[i].getIcon() == null) {
                b[i].setIcon(ic);
                turn = board.nextPlay();
                int score = minimax(turn, ic, alpha, beta, depth);
                b[i].setIcon(null);
                if (score > alpha) {
                    alpha = score;
                    bestMove = i;
                }

                // Pruning.
                if (alpha >= beta) {
                    break;
                }

            }
        }

        if (bestMove != -1) {

            System.out.println("BLa");
            return bestMove;
        }
        return alpha;

    }

    public int minimax(boolean turn, Icon ic, int alpha, int beta, int depth) {
        depth++;
        if (ResultCheck() != 0) {
            return score(depth);
        }
        if (depth == 6) {
            if (turn) {

                b[getMax(turn, ic, alpha, beta, depth)].setIcon(ic);
            } else {
                b[getMin(turn, ic, alpha, beta, depth)].setIcon(ic);
            }
        }
        if (turn) {

            return getMax(turn, ic, alpha, beta, depth);
        } else {
            return getMin(turn, ic, alpha, beta, depth);
        }

    }

    public void RandomPlayer(Icon ic) throws InterruptedException {
        int sel = 0;
        int i;
        int[] availablePos = new int[9];
        // TimeUnit.SECONDS.sleep(2);
        for (i = 0; i < 9; i++) {
            if (b[i].getIcon() == null) {
                availablePos[i] = i;
            } else {
                availablePos[i] = 10;
            }

        }
        do {
            sel = availablePos[random.nextInt(availablePos.length)];

        } while (sel == 10);

        b[sel].setIcon(ic);
    }

    /*
     * public int minmax(boolean turn) {
     * if (ResultCheck() != 0) {
     * return result;
     * }
     * if (turn) {
     * int j = Integer.MAX_VALUE;
     * for (int i = 0; i < 9; i++) {
     * if (b[i].getIcon() == null) {
     * b[i].setIcon(board.getIc1());
     * int value = minmax(false);
     * b[i].setIcon(null);
     * if (value == -1) {
     * return value;
     * }
     * j = Math.min(value, j);
     * }
     * }
     * return j;
     * }
     * int bestVal = Integer.MIN_VALUE;
     * for (int k = 0; k < 9; k++) {
     * if (b[k].getIcon() == null) {
     * b[k].setIcon(board.getIc2());
     * int value = minmax(true);
     * b[k].setIcon(null);
     * if (value == 1) {
     * return value;
     * }
     * bestVal = Math.max(bestVal, value);
     * }
     * }
     * return bestVal;
     * }
     * 
     * int[] corner = { 0, 2, 6, 8 };
     * int[] availablePos;
     * 
     * public void RandomPlayer(Icon ic) throws InterruptedException {
     * int sel = 0;
     * // TimeUnit.SECONDS.sleep(2);
     * for (int i = 0; i < 9; i++) {
     * if (b[i].getIcon() == null) {
     * availablePos[i] = i;
     * }
     * sel = availablePos[random.nextInt(availablePos[i])];
     * 
     * }
     * b[sel].setIcon(ic);
     * Result(ResultCheck());
     * 
     * }
     */
    public Boolean gameplay(int i) {

        if (turn) {
            if (b[i].getIcon() == null) {
                b[i].setIcon(board.getIc1());
                turn = board.nextPlay();
                if (Result(ResultCheck()) == true) {
                    return true;
                }
                // cheking return number
                // P2 turn
            }
        } else {
            if (b[i].getIcon() == null) {
                b[i].setIcon(board.getIc2());
                turn = board.nextPlay();
                if (Result(ResultCheck()) == true) {
                    return true;
                }
                // checking return number
                // P1 turn
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JButton actionSource = (JButton) e.getSource();

            for (int i = 0; i <= 9; i++) {

                if (playerpanel.player1name.getText().equals("Hal")
                        || playerpanel.player2name.getText().equals("Hal")) {

                    if (playerpanel.player1name.getText().equals("Hal")) {
                        if (turn) {

                            minimax(turn, board.getIc1(), Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
                            turn = board.nextPlay();
                        } else {
                            if (actionSource == b[i]) {
                                if (gameplay(i) == true) {
                                    return;
                                }
                            }

                        }
                        // gameplay(i);
                    } else {
                        if (turn) {
                            actionSource = b[i];
                            if (gameplay(i) == true) {
                                return;
                            }

                        } else {
                            // actionSource = null;
                            minimax(turn, board.getIc2(), Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
                            turn = board.nextPlay();
                            if (Result(ResultCheck()) == true) {
                                return;
                            }
                        }

                        // gameplay(i);
                    }
                } else if (playerpanel.player1name.getText().equals("Mr. Bean") || playerpanel.player2name.getText().equals("Mr. Bean")) {

                    if (playerpanel.player1name.getText().equals("Mr. Bean")) {
                        if (turn) {

                            RandomPlayer(board.getIc1());
                            turn = board.nextPlay();
                        } else {
                            if (actionSource == b[i]) {
                                if (gameplay(i) == true) {
                                    return;
                                }

                            }

                        }
                        // gameplay(i);
                    } else {
                        if (turn) {
                            if (actionSource == b[i]) {
                                if (gameplay(i) == true) {
                                    return;
                                }
                            }
                        } else {
                            actionSource = null;
                            RandomPlayer(board.getIc2());
                            turn = board.nextPlay();
                            if (Result(ResultCheck()) == true) {
                                return;
                            }
                            actionSource = b[i];
                        }

                        // gameplay(i);
                    }
                } else {
                    if (actionSource == b[i]) {
                        if (gameplay(i) == true) {
                            return;
                        }
                    }

                }
                /*
                 * } else if (actionSource == b[i] && (playerpanel.player1name.getText() ==
                 * "Mr.Bean"
                 * || playerpanel.player2name.getText() == "Mr.Bean")) {
                 * try {
                 * if (playerpanel.player1name.getText() == "Mr.Bean") {
                 * RandomPlayer(board.getIc1());
                 * turn = board.nextPlay();
                 * gameplay(i);
                 * } else {
                 * RandomPlayer(board.getIc2());
                 * turn = board.nextPlay();
                 * gameplay(i);
                 * }
                 * } catch (InterruptedException ex) {
                 * ex.printStackTrace();
                 * }
                 * }
                 */

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

}
