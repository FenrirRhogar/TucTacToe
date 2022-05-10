import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Cursor;
import javax.swing.JOptionPane;

public class GameBoard extends JFrame implements ItemListener, ActionListener {

    MainWindow mainwindow;
    PlayerPanel playerpanel = new PlayerPanel();
    JButton b[] = new JButton[9];
    JPanel boardpanel = new JPanel();
    ImageIcon tictactoegameboard = new ImageIcon("Images/board.png");
    JButton boardbutton = new JButton(tictactoegameboard);
    JButton startbutton1 = new JButton("Start");
    JButton startbutton2 = new JButton("Start");
    JButton playagainbutton = new JButton("Play Again");
    Board board = new Board();
    AIplayer ai;
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
            Player player1 = playerpanel.roster.findPlayer(playerpanel.player1name.getText());
            Player player2 = playerpanel.roster.findPlayer(playerpanel.player2name.getText());
            player1.setVictories(player1.victories + 1);
            player2.setLosses(player2.losses + 1);
            player1.setGames(player1.games + 1);
            player2.setGames(player2.games + 1);
            playagainbutton.setVisible(true);
            playagainbutton.setEnabled(true);
        } else if (res == -1) {
            for (int i = 0; i < 9; i++) {
                b[i].setEnabled(false);
                boardbutton.setEnabled(false);
            }
            JOptionPane.showMessageDialog(jFrame, "Player 2 wins!");
            playerpanel.roster.findPlayer(playerpanel.player2name.getText()).victories++;
            playerpanel.roster.findPlayer(playerpanel.player1name.getText()).losses++;
            playerpanel.roster.findPlayer(playerpanel.player1name.getText()).games++;
            playerpanel.roster.findPlayer(playerpanel.player2name.getText()).games++;
            playagainbutton.setVisible(true);
            playagainbutton.setEnabled(true);
        } else {
            if (b[0].getIcon() != null && b[1].getIcon() != null && b[2].getIcon() != null && b[3].getIcon() != null
                    && b[4].getIcon() != null && b[5].getIcon() != null && b[6].getIcon() != null
                    && b[7].getIcon() != null && b[8].getIcon() != null) {
                for (int i = 0; i < 9; i++) {
                    b[i].setEnabled(false);
                    boardbutton.setEnabled(false);
                }
                JOptionPane.showMessageDialog(jFrame, "Draw!");
                playerpanel.roster.findPlayer(playerpanel.player1name.getText()).draws++;
                playerpanel.roster.findPlayer(playerpanel.player2name.getText()).draws++;
                playerpanel.roster.findPlayer(playerpanel.player1name.getText()).games++;
                playerpanel.roster.findPlayer(playerpanel.player2name.getText()).games++;
                playagainbutton.setVisible(true);
                playagainbutton.setEnabled(true);
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
            }

        });
        startbutton2.setEnabled(false);
        return startbutton2;
    }

    // play again button
    public void createplayagainbutton(JFrame gameframe, String gamemode, Clip clip) {
        playagainbutton.setBounds(300, 350, 100, 35);
        gameframe.add(playagainbutton);
        playagainbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        playagainbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clip.close();
                gameframe.dispose();
                GameWindow gw = new GameWindow();
                gw.gamewindowcreation(gamemode);
            }

        });
        playagainbutton.setVisible(false);
        playagainbutton.setEnabled(false);
    }

    // game board 9 buttons creation
    public void boardcreation(JFrame frame, String gamemode, Clip clip) {
        JButton startbutton1 = createstartbutton1(frame);
        JButton startbutton2 = createstartbutton2(frame);
        createplayagainbutton(frame, gamemode, clip);
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
                if (actionSource == b[i]
                        && (playerpanel.player1name.getText() == "Hal" || playerpanel.player2name.getText() == "Hal")) {
                    try {
                        if (playerpanel.player1name.getText() == "Hal") {
                            ai.PerfectPlayer(board.ic1);
                        } else {
                            ai.PerfectPlayer(board.ic2);
                        }

                    } catch (InterruptedException ex) {

                        ex.printStackTrace();
                    }
                } else if (actionSource == b[i] && (playerpanel.player1name.getText() == "Mr.Bean"
                        || playerpanel.player2name.getText() == "Mr.Bean")) {
                    try {
                        if (playerpanel.player1name.getText() == "Mr.Bean") {
                            ai.RandomPlayer(board.ic1);
                        } else {
                            ai.RandomPlayer(board.ic2);
                        }
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                } else {
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