import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerPanel implements ActionListener {

    //components creation
    JLabel player1label = new JLabel("Player 1");
    JLabel player2label = new JLabel("Player 2");
    JButton selectplayer1button = new JButton("Select Player");
    JButton selectplayer2button = new JButton("Select Player");

    //player 1 panel
    public void leftpanel(JFrame frame) {
        player1label.setBounds(60, 10, 100, 50);
        player1label.setFont(new Font("Monaco", Font.BOLD, 20));
        player1label.setForeground(Color.GREEN);
        selectplayer1button.setBounds(45, 60, 110, 20);
        frame.add(player1label);
        frame.add(selectplayer1button);
        selectplayer1button.addActionListener(this);
    }

    //player 2 panel
    public void rightpanel(JFrame frame) {
        player2label.setBounds(560, 10, 100, 50);
        player2label.setFont(new Font("Monaco", Font.BOLD, 20));
        player2label.setForeground(Color.GREEN);
        selectplayer2button.setBounds(545, 60, 110, 20);
        frame.add(player2label);
        frame.add(selectplayer2button);
        selectplayer2button.addActionListener(this);
    }

    //popup window to choose exsisting or new player
    public void selectoraddpopup() {
        JFrame jFrame = new JFrame();
        int result = JOptionPane.showConfirmDialog(jFrame, "Add new player?");
        if (result == 0) {
            String username = JOptionPane.showInputDialog("Please enter the new player's name:", null);
        } else if (result == 1) {
            System.out.println("You pressed NO");
        } else {
            System.out.println("You pressed Cancel");
        }
    }

    //action for every button configuration
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JButton actionSource = (JButton) e.getSource();

            if (actionSource.equals(selectplayer1button)) {
                selectoraddpopup();
            } else if (actionSource.equals(selectplayer2button)) {
                selectoraddpopup();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}