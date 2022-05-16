package view;

import javax.swing.*;

import model.Player;

public class HallOfFame {

    Player player;

    public void halloffameboard() {
        JLabel title = new JLabel("Hall Of Fame");
        title.setBounds(50, 50, 100, 30);
        printhalloffamelist();
    }

    public void printhalloffamelist() {
        // JLabel list = new JLabel();
        // sort players
        for (int i = 0; i < 10; i++) {
            // list.setText(i+1 + ". " + player.username);

        }
    }
}