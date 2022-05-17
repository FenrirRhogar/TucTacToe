package view;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Cursor;
import javax.swing.JOptionPane;

import model.*;
import model.Board;

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
    Board board = new Board();
    AIplayer ai;
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

    public void Result(int res) {
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
            }
        }
    }

    // add start buttons
    public JButton createstartbutton1(JFrame gameframe) {
        startbutton1.setBounds(45, 350, 110, 35);
        gameframe.add(startbutton1);
        startbutton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startbutton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    b[i].setEnabled(true);
                }
                boardbutton.setEnabled(true);
                startbutton1.setEnabled(false);
                startbutton1.setVisible(false);
                startbutton2.setEnabled(false);
                startbutton2.setVisible(false);
                board.setPlayer1(true);
                turn = board.firstPlay(board.isPlayer1());
                System.out.println(playerpanel.player1name.getText());
                if (playerpanel.player1name.getText() == "Hal") {
                    try {
                        ai.PerfectPlayer(board.getIc1());
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                if (playerpanel.player1name.getText() == "Mr.Bean") {
                    try {
                        ai.RandomPlayer(board.getIc1());
                    } catch (InterruptedException e1) {

                        e1.printStackTrace();
                    }
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
                for (int i = 0; i < 9; i++) {
                    b[i].setEnabled(true);
                }
                boardbutton.setEnabled(true);
                startbutton1.setEnabled(false);
                startbutton1.setVisible(false);
                startbutton2.setEnabled(false);
                startbutton2.setVisible(false);
                board.setPlayer1(false);
                turn = board.firstPlay(board.isPlayer1());
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
        boardbutton.setEnabled(false);
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
