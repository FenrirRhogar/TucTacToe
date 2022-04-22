import javax.swing.*;
import java.awt.event.*;
import java.awt.Cursor;

public class GameBoard extends JFrame implements ItemListener, ActionListener {

    MainWindow mainwindow;
    JButton b[] = new JButton[9];
    JButton startbutton = new JButton("Start");
    JPanel boardpanel = new JPanel();
    ImageIcon tictactoegameboard = new ImageIcon("board.png");
    Board board = new Board();
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
        if (res == 1) {
            for (int i = 0; i < 9; i++) {
                b[i].setEnabled(false);
            }
        } else if (res == -1) {
            for (int i = 0; i < 9; i++) {
                b[i].setEnabled(false);
            }
        }
    }

    // game board 9 buttons creation
    public void boardcreation(JFrame frame) {
        JButton board = new JButton(tictactoegameboard);
        board.setBounds(200, 10, 300, 300);
        frame.add(board);
        JLayeredPane layeredPane = frame.getLayeredPane();
        layeredPane.add(board, Integer.valueOf(0));
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
            b[i].setEnabled(false);
            b[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            layeredPane.add(b[i], Integer.valueOf(1));
            // make buttons invisible
            b[i].setOpaque(false);
            b[i].setContentAreaFilled(false);
            b[i].setBorderPainted(false);

            b[i].addActionListener(this);
        }
    }

    public void createstartbutton(JFrame frame) {
        startbutton.setBounds(300, 350, 100, 35);
        frame.add(startbutton);
        startbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startbutton.addActionListener(this);
        // to koumpi energopoieitai otan epileksoun kai oi 2 paiktes
        // startbutton.setEnabled(false);
    }

    /*
     * public int minmax(boolean turn){
     * if ()
     * }
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JButton actionSource = (JButton) e.getSource();

            if (actionSource == startbutton) {
                startbutton.setEnabled(false);
                startbutton.setVisible(false);
                for (int i = 0; i < 9; i++) {
                    b[i].setEnabled(true);
                }
            }
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