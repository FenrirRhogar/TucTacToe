package view;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import model.Player;
import model.PlayerRoster;

public class HallOfFame {

    Player player;
    PlayerRoster roster;

    public HallOfFame() {
        this.roster = new PlayerRoster();
    }

    public void halloffameboard(JFrame frame) {
        JLabel title = new JLabel("Hall Of Fame");
        title.setBounds(278, 10, 150, 50);
        title.setFont(new Font("Monaco", Font.BOLD, 20));
        title.setForeground(Color.RED);
        title.setVisible(false);
        // printhalloffamelist(frame);
    }

    public void printhalloffamelist() {
        // JLabel list = new JLabel();

        roster.loadPlayer();
        // sort players
        for (int i = 0; i < roster.getPlayer().length; i++) {
            for (int j = 1; j < roster.getPlayer().length; j++) {
                if (roster.getPlayer()[i].score > roster.getPlayer()[j].score) {
                    continue;
                } else {
                    j = i;
                }
            }
            System.out.println(roster.getPlayer()[i].score);
            // list.setText(i+1 + ". " + player.username);
        }
    }
}