import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class PlayerPanel implements ActionListener {

    // components creation
    JLabel player1label = new JLabel("Player 1");
    JLabel player2label = new JLabel("Player 2");
    JLabel player1name = new JLabel();
    JLabel player2name = new JLabel();
    JButton selectplayer1button = new JButton("Select Player");
    JButton selectplayer2button = new JButton("Select Player");

    // player 1 panel
    public void leftpanel(JFrame frame) {
        player1label.setBounds(60, 10, 100, 50);
        player1label.setFont(new Font("Monaco", Font.BOLD, 20));
        player1label.setForeground(Color.GREEN);
        player1name.setBounds(45, 60, 110, 20);
        player1name.setForeground(Color.WHITE);
        selectplayer1button.setBounds(45, 60, 110, 20);
        frame.add(player1label);
        frame.add(selectplayer1button);
        frame.add(player1name);
        selectplayer1button.addActionListener(this);
    }

    // player 2 panel
    public void rightpanel(JFrame frame) {
        player2label.setBounds(560, 10, 100, 50);
        player2label.setFont(new Font("Monaco", Font.BOLD, 20));
        player2label.setForeground(Color.GREEN);
        player2name.setBounds(545, 60, 110, 20);
        player2name.setForeground(Color.WHITE);
        selectplayer2button.setBounds(545, 60, 110, 20);
        frame.add(player2label);
        frame.add(selectplayer2button);
        frame.add(player2name);
        selectplayer2button.addActionListener(this);
    }

    // popup window to choose exsisting or new player
    public String selectoraddpopup() {
        JFrame jFrame = new JFrame();
        String username = null;
        int result = JOptionPane.showConfirmDialog(jFrame, "Add new player?");
        if (result == 0) {
            username = JOptionPane.showInputDialog("Please enter the new player's name:", null);
            Player player = new Player(username, 0, 0, 0);
            /*
             * try {
             * FileOutputStream fileOut = new FileOutputStream("tuctactoe.ser");
             * ObjectOutputStream out = new ObjectOutputStream(fileOut);
             * out.writeObject(player);
             * out.close();
             * fileOut.close();
             * System.out.printf("Serialized data is saved in tuctactoe.ser");
             * } catch (IOException i) {
             * i.printStackTrace();
             * }
             */
            return username;
        } else if (result == 1) {
            System.out.println("You pressed NO");
        } else {
            System.out.println("You pressed Cancel");
        }
        return null;
    }

    public void addplayer(String username, int score, int victories, int losses) {
        try {
            Player player = new Player(username, score, victories, losses);
            FileOutputStream fileOut = new FileOutputStream("tuctactoe.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(player);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in tuctactoe.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    // action for every button configuration
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JButton actionSource = (JButton) e.getSource();

            if (actionSource.equals(selectplayer1button)) {
                player1name.setText(selectoraddpopup());
                selectplayer1button.setEnabled(false);
                selectplayer1button.setVisible(false);
            } else if (actionSource.equals(selectplayer2button)) {
                player2name.setText(selectoraddpopup());
                selectplayer2button.setEnabled(false);
                selectplayer2button.setVisible(false);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}