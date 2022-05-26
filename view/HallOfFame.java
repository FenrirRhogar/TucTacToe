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
        printhalloffamelist(frame);
    }

    public void printhalloffamelist(JFrame frame) {
        // JLabel list = new JLabel();
        roster.loadPlayer();
        // sort players
        String[] plr = new String[10];
        for (int i = 0; i < roster.getPlayer().length; i++) {
            if (roster.getPlayer()[i] != null) {

                for (int j = i + 1; j < roster.getPlayer().length; j++) {
                    if (roster.getPlayer()[j] != null) {

                        if (roster.getPlayer()[i].getScore() < roster.getPlayer()[j].getScore()) {
                            Player p = roster.getPlayer()[j];
                            roster.getPlayer()[j] = roster.getPlayer()[i];
                            roster.getPlayer()[i] = p;
                        }

                    }
                }

                // list.setText(i+1 + ". " + player.username);
                System.out.println(roster.getPlayer()[i].getScore());
            }
        }
    }
}