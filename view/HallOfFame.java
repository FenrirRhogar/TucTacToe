package view;

import javax.swing.*;

import model.Player;
import model.PlayerRoster;

public class HallOfFame {

    Player player;
    PlayerRoster roster;

    public HallOfFame() {
        this.roster = new PlayerRoster();
    }

    public void halloffameboard() {
        JLabel title = new JLabel("Hall Of Fame");
        title.setBounds(50, 50, 100, 30);
        printhalloffamelist();
    }

    public void printhalloffamelist() {
        // JLabel list = new JLabel();
        String[] plr = new String[roster.getPlayer().length];
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