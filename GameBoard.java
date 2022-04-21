import javax.swing.*;
import java.awt.event.*;

public class GameBoard extends JFrame implements ItemListener, ActionListener {

    MainWindow mainwindow;
    JButton b[] = new JButton[9];
    JButton startbutton = new JButton("Start");
    Board board = new Board();
    boolean turn = board.firstPlay();
    int num, result;

    public void ResultCheck() {
        // P1 wins
        if (b[0].getText() == board.getSymbol1() &&
                b[1].getText() == board.getSymbol1() &&
                b[2].getText() == board.getSymbol1()) {
            result = 1;
            Result(result);
        }
        if (b[3].getText() == board.getSymbol1() &&
                b[4].getText() == board.getSymbol1() &&
                b[5].getText() == board.getSymbol1()) {
            result = 1;
            Result(result);
        }
        if (b[6].getText() == board.getSymbol1() &&
                b[7].getText() == board.getSymbol1() &&
                b[8].getText() == board.getSymbol1()) {
            result = 1;
            Result(result);
        }
        if (b[0].getText() == board.getSymbol1() &&
                b[3].getText() == board.getSymbol1() &&
                b[6].getText() == board.getSymbol1()) {
            result = 1;
            Result(result);
        }
        if (b[1].getText() == board.getSymbol1() &&
                b[4].getText() == board.getSymbol1() &&
                b[7].getText() == board.getSymbol1()) {
            result = 1;
            Result(result);
        }
        if (b[2].getText() == board.getSymbol1() &&
                b[5].getText() == board.getSymbol1() &&
                b[8].getText() == board.getSymbol1()) {
            result = 1;
            Result(result);
        }
        if (b[0].getText() == board.getSymbol1() &&
                b[4].getText() == board.getSymbol1() &&
                b[8].getText() == board.getSymbol1()) {
            result = 1;
            Result(result);
        }
        if (b[2].getText() == board.getSymbol1() &&
                b[4].getText() == board.getSymbol1() &&
                b[6].getText() == board.getSymbol1()) {
            result = 1;
            Result(result);
        }
        /**************************************************************** */
        // P2 wins
        if (b[0].getText() == board.getSymbol2() &&
                b[1].getText() == board.getSymbol2() &&
                b[2].getText() == board.getSymbol2()) {
            result = -1;
            Result(result);
        }
        if (b[3].getText() == board.getSymbol2() &&
                b[4].getText() == board.getSymbol2() &&
                b[5].getText() == board.getSymbol2()) {
            result = -1;
            Result(result);
        }
        if (b[6].getText() == board.getSymbol2() &&
                b[7].getText() == board.getSymbol2() &&
                b[8].getText() == board.getSymbol2()) {
            result = -1;
            Result(result);
        }
        if (b[0].getText() == board.getSymbol2() &&
                b[3].getText() == board.getSymbol2() &&
                b[6].getText() == board.getSymbol2()) {
            result = -1;
            Result(result);
        }
        if (b[1].getText() == board.getSymbol2() &&
                b[4].getText() == board.getSymbol2() &&
                b[7].getText() == board.getSymbol2()) {
            result = -1;
            Result(result);
        }
        if (b[2].getText() == board.getSymbol2() &&
                b[5].getText() == board.getSymbol2() &&
                b[8].getText() == board.getSymbol2()) {
            result = -1;
            Result(result);
        }
        if (b[0].getText() == board.getSymbol2() &&
                b[4].getText() == board.getSymbol2() &&
                b[8].getText() == board.getSymbol2()) {
            result = -1;
            Result(result);
        }
        if (b[2].getText() == board.getSymbol2() &&
                b[4].getText() == board.getSymbol2() &&
                b[6].getText() == board.getSymbol2()) {
            result = -1;
            Result(result);
        }
        // draw
        else {
            result = 0;
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
            b[i].addActionListener(this);
        }
    }

    public void createstartbutton(JFrame frame) {
        startbutton.setBounds(300, 350, 100, 35);
        frame.add(startbutton);
        startbutton.addActionListener(this);
        startbutton.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JButton actionSource = (JButton) e.getSource();
            for (int i = 0; i < 9; i++) {
                if (actionSource == b[i]) {
                    if (turn) {
                        if (b[i].getText() == "") {
                            b[i].setText(board.getSymbol1());
                            turn = board.nextPlay();
                            ResultCheck();
                            // cheking return number
                            // P2 turn
                        }

                    } else {
                        if (b[i].getText() == "") {
                            b[i].setText(board.getSymbol2());
                            turn = board.nextPlay();
                            ResultCheck();
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