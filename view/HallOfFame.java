package view;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import model.Player;
import model.PlayerRoster;
import javax.sound.sampled.Clip;
import javax.swing.*;

import Music.Music;
import controller.GameControler;

import java.awt.*;
import java.awt.event.*;
import java.awt.Cursor;

public class HallOfFame {

    Player player;
    PlayerRoster roster;
    JLabel title = new JLabel("Hall Of Fame");
    JPanel titlepanel = new JPanel();
    JLabel player1 = new JLabel();
    JLabel player2 = new JLabel();
    JLabel player3 = new JLabel();
    JLabel player4 = new JLabel();
    JLabel player5 = new JLabel();
    JLabel player6 = new JLabel();
    JLabel player7 = new JLabel();
    JLabel player8 = new JLabel();
    JLabel player9 = new JLabel();
    JLabel player10 = new JLabel();
    JLabel score1 = new JLabel();
    JLabel score2 = new JLabel();
    JLabel score3 = new JLabel();
    JLabel score4 = new JLabel();
    JLabel score5 = new JLabel();
    JLabel score6 = new JLabel();
    JLabel score7 = new JLabel();
    JLabel score8 = new JLabel();
    JLabel score9 = new JLabel();
    JLabel score10 = new JLabel();

    public HallOfFame() {
        this.roster = new PlayerRoster();
    }

    public void halloffameboard(JFrame frame) {
        titlepanel.add(title);
        frame.add(titlepanel);
        titlepanel.setBounds(200, 10, 300, 40);
        titlepanel.setBackground(new Color(5, 65, 90));
        title.setText("Hall Of Fame");
        title.setBounds(10, 10, 150, 100);
        title.setFont(new Font("Monaco", Font.BOLD, 20));
        title.setForeground(Color.RED);
        title.setVisible(true);
        title.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        printhalloffamelist(frame);
    }

    public void printhalloffamelist(JFrame frame) {
        frame.add(player1);
        frame.add(player2);
        frame.add(player3);
        frame.add(player4);
        frame.add(player5);
        frame.add(player6);
        frame.add(player7);
        frame.add(player8);
        frame.add(player9);
        frame.add(player10);
        frame.add(score1);
        frame.add(score2);
        frame.add(score3);
        frame.add(score4);
        frame.add(score5);
        frame.add(score6);
        frame.add(score7);
        frame.add(score8);
        frame.add(score9);
        frame.add(score10);
        player1.setBounds(150, 50, 500, 50);
        player1.setFont(new Font("Monaco", Font.ITALIC, 20));
        score1.setBounds(500, 50, 300, 50);
        score1.setFont(new Font("Monaco", Font.ITALIC, 20));

        player2.setBounds(150, 80, 500, 50);
        player2.setFont(new Font("Monaco", Font.ITALIC, 20));
        score2.setBounds(500, 80, 300, 50);
        score2.setFont(new Font("Monaco", Font.ITALIC, 20));

        player3.setBounds(150, 110, 500, 50);
        player3.setFont(new Font("Monaco", Font.ITALIC, 20));
        score3.setBounds(500, 110, 300, 50);
        score3.setFont(new Font("Monaco", Font.ITALIC, 20));

        player4.setBounds(150, 140, 500, 50);
        player4.setFont(new Font("Monaco", Font.ITALIC, 20));
        score4.setBounds(500, 140, 300, 50);
        score4.setFont(new Font("Monaco", Font.ITALIC, 20));

        player5.setBounds(150, 170, 500, 50);
        player5.setFont(new Font("Monaco", Font.ITALIC, 20));
        score5.setBounds(500, 170, 300, 50);
        score5.setFont(new Font("Monaco", Font.ITALIC, 20));

        player6.setBounds(150, 200, 500, 50);
        player6.setFont(new Font("Monaco", Font.ITALIC, 20));
        score6.setBounds(500, 200, 300, 50);
        score6.setFont(new Font("Monaco", Font.ITALIC, 20));

        player7.setBounds(150, 230, 500, 50);
        player7.setFont(new Font("Monaco", Font.ITALIC, 20));
        score7.setBounds(500, 230, 300, 50);
        score7.setFont(new Font("Monaco", Font.ITALIC, 20));

        player8.setBounds(150, 260, 500, 50);
        player8.setFont(new Font("Monaco", Font.ITALIC, 20));
        score8.setBounds(500, 260, 300, 50);
        score8.setFont(new Font("Monaco", Font.ITALIC, 20));

        player9.setBounds(150, 290, 500, 50);
        player9.setFont(new Font("Monaco", Font.ITALIC, 20));
        score9.setBounds(500, 290, 300, 50);
        score9.setFont(new Font("Monaco", Font.ITALIC, 20));

        player10.setBounds(150, 320, 500, 50);
        player10.setFont(new Font("Monaco", Font.ITALIC, 20));
        score10.setBounds(500, 320, 300, 50);
        score10.setFont(new Font("Monaco", Font.ITALIC, 20));

        player1.setForeground(Color.WHITE);
        player2.setForeground(Color.WHITE);
        player3.setForeground(Color.WHITE);
        player4.setForeground(Color.WHITE);
        player5.setForeground(Color.WHITE);
        player6.setForeground(Color.WHITE);
        player7.setForeground(Color.WHITE);
        player8.setForeground(Color.WHITE);
        player9.setForeground(Color.WHITE);
        player10.setForeground(Color.WHITE);
        score1.setForeground(Color.WHITE);
        score2.setForeground(Color.WHITE);
        score3.setForeground(Color.WHITE);
        score4.setForeground(Color.WHITE);
        score5.setForeground(Color.WHITE);
        score6.setForeground(Color.WHITE);
        score7.setForeground(Color.WHITE);
        score8.setForeground(Color.WHITE);
        score9.setForeground(Color.WHITE);
        score10.setForeground(Color.WHITE);

        // sort players
        roster.loadPlayer();
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
        int i = 0;
        player1.setText(i+1 + ". " + roster.getPlayer()[i].getUsername());
        score1.setText(" " + (int) roster.getPlayer()[i++].getScore());
        player2.setText(i+1 + ". " + roster.getPlayer()[i].getUsername());
        score2.setText(" " + (int) roster.getPlayer()[i++].getScore());
        player3.setText(i+1 + ". " + roster.getPlayer()[i].getUsername());
        score3.setText(" " + (int) roster.getPlayer()[i++].getScore());
        player4.setText(i+1 + ". " + roster.getPlayer()[i].getUsername());
        score4.setText(" " + (int) roster.getPlayer()[i++].getScore());
        player5.setText(i+1 + ". " + roster.getPlayer()[i].getUsername());
        score5.setText(" " + (int) roster.getPlayer()[i++].getScore());
        player6.setText(i+1 + ". " + roster.getPlayer()[i].getUsername());
        score6.setText(" " + (int) roster.getPlayer()[i++].getScore());
        player7.setText(i+1 + ". " + roster.getPlayer()[i].getUsername());
        score7.setText(" " + (int) roster.getPlayer()[i++].getScore());
        player8.setText(i+1 + ". " + roster.getPlayer()[i].getUsername());
        score8.setText(" " + (int) roster.getPlayer()[i++].getScore());
        player9.setText(i+1 + ". " + roster.getPlayer()[i].getUsername());
        score9.setText(" " + (int) roster.getPlayer()[i++].getScore());
        player10.setText(i+1 + ". " + roster.getPlayer()[i].getUsername());
        score10.setText(" " + (int) roster.getPlayer()[i++].getScore());
    }
}