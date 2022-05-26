package view;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import model.Player;
import model.PlayerRoster;

public class HallOfFame {

    Player player = new Player();
    PlayerRoster roster = new PlayerRoster();

    public void halloffameboard(JFrame frame) {
        JLabel title = new JLabel("Hall Of Fame");
        title.setBounds(278, 10, 150, 50);
        title.setFont(new Font("Monaco", Font.BOLD, 20));
        title.setForeground(Color.RED);
        title.setVisible(false);
        printhalloffamelist(frame);
    }

    public void printhalloffamelist(JFrame frame) {
        JPanel list = new JPanel();
        list.setBounds(278, 110, 150, 900);
        frame.add(list);
        // sort players
        /*for (i = 0; i < 10; i++) {
            // list.setText(i+1 + ". " + player.username);

        }*/
    }
}