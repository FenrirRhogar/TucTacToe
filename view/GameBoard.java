package view;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Cursor;
import javax.swing.JOptionPane;

import java.awt.*;
import model.*;
import model.Game;

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
    GameRecord gamerecord = new GameRecord();
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
        // gamerecord.loadGame();
        if (res == 1) {
            for (int i = 0; i < 9; i++) {
                b[i].setEnabled(false);
                boardbutton.setEnabled(false);
            }
            JOptionPane.showMessageDialog(jFrame, "Player 1 wins!");
            playagainbutton.setVisible(true);
            playagainbutton.setEnabled(true);
            playagainbutton2.setVisible(true);
            playagainbutton2.setEnabled(true);
            /*
             * Game g = new
             * Game(playerpanel.roster.findPlayer(playerpanel.player1name.getText()),
             * playerpanel.roster.findPlayer(playerpanel.player2name.getText()),
             * playerpanel.roster.findPlayer(playerpanel.player1name.getText()).getScore(),
             * playerpanel.roster.findPlayer(playerpanel.player1name.getText()).getScore(),
             * 1);
             * for (int i = 0; i < 50; i++) {
             * if (gamerecord.getGame()[i] == null) {
             * gamerecord.addGame(g, i);
             * break;
             * }
             * }
             */
            playerpanel.roster.player1wins(playerpanel.player1name.getText(), playerpanel.player2name.getText());
            return true;
        } else if (res == -1) {
            for (int i = 0; i < 9; i++) {
                b[i].setEnabled(false);
                boardbutton.setEnabled(false);
            }
            JOptionPane.showMessageDialog(jFrame, "Player 2 wins!");
            playagainbutton.setVisible(true);
            playagainbutton.setEnabled(true);
            playagainbutton2.setVisible(true);
            playagainbutton2.setEnabled(true);
            /*
             * Game g = new
             * Game(playerpanel.roster.findPlayer(playerpanel.player1name.getText()),
             * playerpanel.roster.findPlayer(playerpanel.player2name.getText()),
             * playerpanel.roster.findPlayer(playerpanel.player1name.getText()).getScore(),
             * playerpanel.roster.findPlayer(playerpanel.player1name.getText()).getScore(),
             * 2);
             * for (int i = 0; i < 50; i++) {
             * if (gamerecord.getGame()[i] == null) {
             * gamerecord.addGame(g, i);
             * break;
             * }
             * }
             */
            playerpanel.roster.player2wins(playerpanel.player1name.getText(), playerpanel.player2name.getText());
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
                playagainbutton.setVisible(true);
                playagainbutton.setEnabled(true);
                playagainbutton2.setVisible(true);
                playagainbutton2.setEnabled(true);
                /*
                 * Game g = new
                 * Game(playerpanel.roster.findPlayer(playerpanel.player1name.getText()),
                 * playerpanel.roster.findPlayer(playerpanel.player2name.getText()),
                 * playerpanel.roster.findPlayer(playerpanel.player1name.getText()).getScore(),
                 * playerpanel.roster.findPlayer(playerpanel.player1name.getText()).getScore(),
                 * 0);
                 * for (int i = 0; i < 50; i++) {
                 * if (gamerecord.getGame()[i] == null) {
                 * gamerecord.addGame(g, i);
                 * break;
                 * }
                 * }
                 */
                playerpanel.roster.playerdraw(playerpanel.player1name.getText(), playerpanel.player2name.getText());
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
                        activeplayer.setText(playerpanel.player2name.getText());
                        turn = board.nextPlay();
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    return;
                } 
                   else if (playerpanel.player1name.getText().equals("Hal") == true) {
                   try {
                   PerfectPlayer(turn);
                   turn = board.nextPlay();
                  } catch (InterruptedException e1) {
                   // TODO Auto-generated catch block
                   e1.printStackTrace();
                   }
                   return;
                   }
                  
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
                        activeplayer.setText(playerpanel.player1name.getText());
                        turn = board.nextPlay();
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    return;
                } 
                   else if (playerpanel.player2name.getText().equals("Hal") == true) {
                   try {
                   PerfectPlayer(turn);
                   turn = board.nextPlay();
                   } catch (InterruptedException e1) {
                   // TODO Auto-generated catch block
                   e1.printStackTrace();
                   }
                   return;
                   }
                  
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
        activeplayer.setFont(new Font("Monaco", Font.BOLD, 19));
        activeplayer.setForeground(Color.YELLOW);
        activeplayer.setVisible(false);
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

    public int getAvailable() {
        int num = 0;
        for (int i = 0; i < 9; i++) {
            if (b[i].getIcon() != null) {
                num++;
            }
        }
        return num;
    }

    public int minimax(boolean isMaximizing, int depth) {
        if (ResultCheck() != 0) {
            return score(depth);
        }
        if (getAvailable() == 0) {
            return 0;
        }
        if (isMaximizing) {
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (b[i].getIcon() == null) {
                    b[i].setIcon(board.getIc1());
                    best = Math.max(best, minimax(!isMaximizing, depth + 1));
                    b[i].setIcon(null);
                }
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (b[i].getIcon() == null) {
                    b[i].setIcon(board.getIc2());
                    best = Math.min(best, minimax(!isMaximizing, depth + 1));
                    b[i].setIcon(null);
                }
            }
            return best;
        }
    }

    public void PerfectPlayer(boolean turn) throws InterruptedException {

        if (turn) {
            int bestMove = -1;
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (b[i].getIcon() == null) {
                    b[i].setIcon(board.getIc1());
                    int move = minimax(false, 0);
                    b[i].setIcon(null);
                    System.out.println(move + "turn");
                    if (move > best) {
                        best = move;
                        bestMove = i;
                    }
                }
                System.out.println(best + "turn");
            }
            System.out.println("\n" + bestMove + "turn");
            b[bestMove].setIcon(board.getIc1());
        } else {
            int bestMove = -1;
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (b[i].getIcon() == null) {
                    b[i].setIcon(board.getIc2());
                    int move = minimax(true, 0);
                    b[i].setIcon(null);
                    System.out.println(move + "MOVE");
                    if (move < best) {
                        best = move;
                        bestMove = i;
                    }
                }
                System.out.println(bestMove + "IN_LOOP");
            }
            System.out.println("\n" + best + "FINAL");
            b[bestMove].setIcon(board.getIc2());
        }

    }

    public void RandomPlayer(Icon ic) throws InterruptedException {
        int sel = 0;
        int i;
        int[] availablePos = new int[9];

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

    public Boolean gameplay(int i) {

        if (turn) {
            if (b[i].getIcon() == null) {
                activeplayer.setText(playerpanel.player2name.getText());
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
                activeplayer.setText(playerpanel.player1name.getText());
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
        // Timer t = new Timer(1000, listener)
        try {
            JButton actionSource = (JButton) e.getSource();

            for (int i = 0; i <= 9; i++) {

                if (playerpanel.player1name.getText().equals("Hal")
                        || playerpanel.player2name.getText().equals("Hal")) {

                    if (playerpanel.player1name.getText().equals("Hal")) {
                        if (turn) {

                            PerfectPlayer(turn);
                            activeplayer.setText(playerpanel.player1name.getText());
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
                            PerfectPlayer(turn);
                            activeplayer.setText(playerpanel.player1name.getText());
                            turn = board.nextPlay();
                            if (Result(ResultCheck()) == true) {
                                return;
                            }
                            actionSource = b[i];
                        }

                        // gameplay(i);
                    }
                } else if (playerpanel.player1name.getText().equals("Mr. Bean")
                        || playerpanel.player2name.getText().equals("Mr. Bean")) {

                    if (playerpanel.player1name.getText().equals("Mr. Bean")) {
                        if (turn) {

                            RandomPlayer(board.getIc1());
                            activeplayer.setText(playerpanel.player1name.getText());
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
                            activeplayer.setText(playerpanel.player1name.getText());
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