import javax.swing.*;
import java.awt.event.*;

public class GameBoard extends JFrame implements ItemListener, ActionListener {

    MainWindow mainwindow;
    JButton b[] = new JButton[9];

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

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
    }

}