import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Cursor;

public class PlayerPanel {

    // components creation
    JLabel player1label = new JLabel("Player 1");
    JLabel player2label = new JLabel("Player 2");
    JLabel player1name = new JLabel();
    JLabel player2name = new JLabel();
    JButton selectplayer1button = new JButton("Select Player");
    JButton selectplayer2button = new JButton("Select Player");
    GameBoard gameboard;

    //create player panels
    public void playerpanelscreation(JFrame frame, JButton startbutton, String gamemode) {
        // create player 1 and 2 panels
        leftpanel(frame);
        rightpanel(frame);
        // add actions to select player buttons
        selectplayer1button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // select player
                player1name.setText(selectoraddpopup());
                // if player has been selected discard the button
                if (player1name.getText() != null) {
                    selectplayer1button.setEnabled(false);
                    selectplayer1button.setVisible(false);
                }
                // if players have been selected, enable start button
                if (selectplayer1button.isVisible() == false && selectplayer2button.isVisible() == false) {
                    startbutton.setEnabled(true);
                }
            }

        });
        selectplayer2button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // select player
                player2name.setText(selectoraddpopup());
                // if player has been selected discard the button
                if (player2name.getText() != null) {
                    selectplayer2button.setEnabled(false);
                    selectplayer2button.setVisible(false);
                }
                // if players have been selected, enable start button
                if (selectplayer1button.isVisible() == false && selectplayer2button.isVisible() == false) {
                    startbutton.setEnabled(true);
                }
            }

        });
    }

    // player 1 panel
    public void leftpanel(JFrame frame) {
        player1label.setBounds(60, 10, 100, 50);
        player1label.setFont(new Font("Monaco", Font.BOLD, 20));
        player1label.setForeground(Color.GREEN);
        player1name.setBounds(45, 60, 110, 20);
        player1name.setForeground(Color.WHITE);
        player1name.setText(null);
        selectplayer1button.setBounds(45, 60, 110, 30);
        frame.add(player1label);
        frame.add(selectplayer1button);
        frame.add(player1name);
        selectplayer1button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    // player 2 panel
    public void rightpanel(JFrame frame) {
        player2label.setBounds(560, 10, 100, 50);
        player2label.setFont(new Font("Monaco", Font.BOLD, 20));
        player2label.setForeground(Color.GREEN);
        player2name.setBounds(545, 60, 110, 20);
        player2name.setForeground(Color.WHITE);
        player2name.setText(null);
        selectplayer2button.setBounds(545, 60, 110, 30);
        frame.add(player2label);
        frame.add(selectplayer2button);
        frame.add(player2name);
        selectplayer2button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    // popup window to choose exsisting or new player
    public String selectoraddpopup() {
        String[] players = {"p1", "p2", "p3"}; //proswrino
        JFrame jFrame = new JFrame();
        String username = null;
        String[] options = {"New Player", "Exsisting Player", "Cancel"};
        int optionindex = JOptionPane.showOptionDialog(jFrame, "Add new player or select an exsisting?", null, JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, options, null);
        
        //add new player
        if (optionindex == 0) {
            username = JOptionPane.showInputDialog("Please enter the new player's name:", null);
            //Player player = new Player(username, 0, 0, 0);
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
            //select exsisting player
        } else if (optionindex == 1) {
            JFrame selectplayerframe = new JFrame();
            username = (String) JOptionPane.showInputDialog(selectplayerframe, "Select Player:", null, JOptionPane.QUESTION_MESSAGE, null, players, players[0]);
            return username;
            // CANCEL
        } else if (optionindex == 2) {
            return null;
        }
        return null;
    }

    // add player method
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
}