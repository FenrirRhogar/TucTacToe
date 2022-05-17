package view;

import javax.swing.*;

import model.*;

import junit.framework.Test;

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
    JLabel player1score = new JLabel();
    JLabel player2score = new JLabel();
    JButton selectplayer1button = new JButton("Select Player");
    JButton selectplayer2button = new JButton("Select Player");
    GameBoard gameboard;
    AIplayer ai;
    String[] players = new String[10];
    PlayerRoster roster = new PlayerRoster();
    Player p;
    int aiver;

    int i = 0;

    // create player panels
    public void playerpanelscreation(JFrame frame, JButton startbutton1, JButton startbutton2, String gamemode) {
        // create player 1 and 2 panels
        if (gamemode == "pvp") {
            leftplayerpanel(frame);
            selectplayer1button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // select player

                    // do{
                    Player player = selectoraddpopup();
                    /*
                     * if(player.username == player2name.getText()){
                     * JOptionPane.showMessageDialog(null, "Cannot choose the same player!",
                     * "Player error", JOptionPane.ERROR_MESSAGE);
                     * }
                     * } while(player.username == player2name.getText());
                     */
                    player1name.setText(player.username);
                    player1score
                            .setText("Score: " + player.calculateScore(player.victories, player.draws, player.games));
                    // if player has been selected discard the button
                    if (player1name.getText() != null) {
                        selectplayer1button.setEnabled(false);
                        selectplayer1button.setVisible(false);
                    }
                    // if players have been selected, enable start button
                    if (selectplayer1button.isVisible() == false && selectplayer2button.isVisible() == false) {
                        startbutton1.setEnabled(true);
                        startbutton2.setEnabled(true);
                    }
                }

            });
            rightplayerpanel(frame);
            selectplayer2button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // select player
                    Player player = selectoraddpopup();
                    player2name.setText(player.username);
                    player2score
                            .setText("Score: " + player.calculateScore(player.victories, player.draws, player.games));
                    // if player has been selected discard the button
                    if (player2name.getText() != null) {
                        selectplayer2button.setEnabled(false);
                        selectplayer2button.setVisible(false);
                    }
                    // if players have been selected, enable start button
                    if (selectplayer1button.isVisible() == false && selectplayer2button.isVisible() == false) {
                        startbutton1.setEnabled(true);
                        startbutton2.setEnabled(true);
                    }
                }

            });
        } else if (gamemode == "pve") {
            leftplayerpanel(frame);
            selectplayer1button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // select player
                    Player player = selectoraddpopup();
                    player1name.setText(player.username);
                    player1score
                            .setText("Score: " + player.calculateScore(player.victories, player.draws, player.games));
                    // if player has been selected discard the button
                    if (player1name.getText() != null) {
                        selectplayer1button.setEnabled(false);
                        selectplayer1button.setVisible(false);
                    }
                    // if players have been selected, enable start button
                    if (selectplayer1button.isVisible() == false && selectplayer2button.isVisible() == false) {
                        startbutton1.setEnabled(true);
                        startbutton2.setEnabled(true);
                    }
                }

            });
            rightaipanel(frame);
            selectplayer2button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // select player
                    Player player = selectoraddpopup();
                    player2name.setText(player.username);
                    player2score
                            .setText("Score: " + player.calculateScore(player.victories, player.draws, player.games));
                    // if player has been selected discard the button
                    if (player2name.getText() != null) {
                        selectplayer2button.setEnabled(false);
                        selectplayer2button.setVisible(false);
                    }
                    // if players have been selected, enable start button
                    if (selectplayer1button.isVisible() == false && selectplayer2button.isVisible() == false) {
                        startbutton1.setEnabled(true);
                        startbutton2.setEnabled(true);
                    }
                }

            });
        } else if (gamemode == "eve") {

        }

    }

    // player 1 panel
    public void leftplayerpanel(JFrame frame) {
        player1label.setBounds(60, 10, 100, 50);
        player1label.setFont(new Font("Monaco", Font.BOLD, 20));
        player1label.setForeground(Color.GREEN);
        player1name.setBounds(45, 60, 110, 20);
        player1name.setForeground(Color.WHITE);
        player1name.setText(null);
        player1score.setBounds(45, 80, 110, 20);
        player1score.setForeground(Color.WHITE);
        // player1info.setBounds();
        selectplayer1button.setBounds(45, 60, 110, 30);
        frame.add(player1label);
        frame.add(selectplayer1button);
        frame.add(player1name);
        frame.add(player1score);
        selectplayer1button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    // player 2 panel
    public void rightplayerpanel(JFrame frame) {
        player2label.setBounds(560, 10, 100, 50);
        player2label.setFont(new Font("Monaco", Font.BOLD, 20));
        player2label.setForeground(Color.GREEN);
        player2name.setBounds(545, 60, 110, 20);
        player2name.setForeground(Color.WHITE);
        player2name.setText(null);
        player2score.setBounds(545, 80, 110, 20);
        player2score.setForeground(Color.WHITE);
        // player2info.setBounds();
        selectplayer2button.setBounds(545, 60, 110, 30);
        frame.add(player2label);
        frame.add(selectplayer2button);
        frame.add(player2name);
        frame.add(player2score);
        selectplayer2button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void leftaipanel(JFrame frame) {
        player1label.setBounds(60, 10, 100, 50);
        player1label.setFont(new Font("Monaco", Font.BOLD, 20));
        player1label.setForeground(Color.GREEN);
        player1name.setBounds(45, 60, 110, 20);
        player1name.setForeground(Color.WHITE);
        player1name.setText(null);
        player1score.setBounds(45, 80, 110, 20);
        player1score.setForeground(Color.WHITE);
        selectplayer1button.setBounds(45, 60, 110, 30);
        frame.add(player1label);
        frame.add(selectplayer1button);
        frame.add(player1name);
        frame.add(player1score);
        selectplayer1button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void rightaipanel(JFrame frame) {
        player1label.setBounds(60, 10, 100, 50);
        player1label.setFont(new Font("Monaco", Font.BOLD, 20));
        player1label.setForeground(Color.GREEN);
        player1name.setBounds(45, 60, 110, 20);
        player1name.setForeground(Color.WHITE);
        player1name.setText(null);
        player2score.setBounds(545, 80, 110, 20);
        player2score.setForeground(Color.WHITE);
        selectplayer2button.setBounds(545, 60, 110, 30);
        frame.add(player2label);
        frame.add(selectplayer2button);
        frame.add(player2name);
        frame.add(player2score);
        selectplayer2button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    // popup window to choose exsisting or new player
    public Player selectoraddpopup() {
        // proswrino
        JFrame jFrame = new JFrame();
        String username = null;
        Player player;

        String[] options = { "New Player", "Exsisting Player", "Cancel" };
        int optionindex = JOptionPane.showOptionDialog(jFrame, "Add new player or select an exsisting?", null,
                JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, options, null);

        // add new player
        if (optionindex == 0) {
            roster.loadPlayer();
            do {
                Boolean same;
                do {
                    same = false;
                    username = JOptionPane.showInputDialog("Please enter the new player's name", null);
                    for (int i = 0; i < 50; i++) {
                        if (roster.getPlayer()[i] == null) {
                            break;
                        }
                        if (roster.getPlayer()[i].username.equals(username) == true) {
                            same = true;
                            JOptionPane.showMessageDialog(null, "This name already exists.", "Existing name",
                                    JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                } while (same == true);
                if (username.length() > 20 || username.charAt(0) == ' '
                        || username.charAt(username.length() - 1) == ' ') {
                    JOptionPane.showMessageDialog(null,
                            "- Username cannot exeed 20 characters\n- First and last characters cannot be space",
                            "Invalid username", JOptionPane.ERROR_MESSAGE);
                } else if (username.isEmpty() == true) {
                    JOptionPane.showMessageDialog(null, "No input", "Invalid username", JOptionPane.ERROR_MESSAGE); // idk
                                                                                                                    // giati
                                                                                                                    // de
                                                                                                                    // douleuei
                                                                                                                    // auto
                }

            } while (username.isEmpty() == true || username.length() > 20 || username.charAt(0) == ' '
                    || username.charAt(username.length() - 1) == ' ');
            p = new Player(username, 0, 0, 0, 0);

            for (int i = 0; i < 50; i++) {
                if (roster.getPlayer()[i] == null) {
                    roster.addPlayer(p, i);
                    break;
                }

            }

            return p;
            // select exsisting player
        } else if (optionindex == 1) {

            roster.loadPlayer();
            for (int j = 0; j < roster.getPlayer().length; j++) {
                if (roster.getPlayer()[j] != null) {
                    players[j] = roster.getPlayer()[j].username;
                }
            }
            JFrame selectplayerframe = new JFrame();
            do {
                username = (String) JOptionPane.showInputDialog(selectplayerframe, "Select Player:", null,
                        JOptionPane.QUESTION_MESSAGE, null, players, players[0]);
                if (username.equals(player1name.getText()) || username.equals(player2name.getText())) {
                    JOptionPane.showMessageDialog(null, "This player is already selected!", "Already selected",
                            JOptionPane.ERROR_MESSAGE);
                }
            } while (username.equals(player1name.getText()) || username.equals(player2name.getText()));
            player = roster.findPlayer(username);
            return player;
            // CANCEL
        } else if (optionindex == 2) {
            return null;
        }
        return null;
    }

    // add player method

}