import javax.swing.*;
import java.awt.event.*;

public class GameBoard extends JFrame implements ItemListener, ActionListener {

    MainWindow mainwindow;
    JButton b[] = new JButton[9];
    JButton startbutton = new JButton("Start");

    //game board 9 buttons creation
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

    public void name() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JButton actionSource = (JButton) e.getSource();

            if (actionSource.equals(startbutton)) {
                Board board = new Board();
                board.begingame();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
    }

}