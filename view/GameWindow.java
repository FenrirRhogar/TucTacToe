package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

import Music.Music;
import Images.*;
import javax.sound.sampled.Clip;

public class GameWindow extends Frame implements ActionListener {
    JFrame gameframe = new JFrame("Tuc Tac Toe");
    GameBoard gameboard = new GameBoard();
    JButton backtomenubutton = new JButton("Back to Menu");
    JButton mutebutton = new JButton();
    MainWindow mainwindow;
    Music music = new Music();

    public void backbutton(JFrame frame, Clip clip) {
        backtomenubutton.setBounds(520, 510, 150, 30);
        backtomenubutton.addActionListener(this);
        frame.add(backtomenubutton);
        backtomenubutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backtomenubutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gameframe.dispose();
                clip.stop();
                mainwindow = new MainWindow();
                mainwindow.windowcreation();
            }

        });
    }

    public void createmutebutton(JFrame gameframe, Clip clip) {
        ImageIcon muteicon = new ImageIcon("Images/mutebutton.png");
        ImageIcon muteiconenabled = new ImageIcon("Images/mutebuttonenabled.png");
        mutebutton.setBounds(665, 5, 30, 30);
        gameframe.add(mutebutton);
        mutebutton.setIcon(muteicon);
        mutebutton.setOpaque(false);
        mutebutton.setContentAreaFilled(false);
        mutebutton.setBorderPainted(false);
        mutebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mutebutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mute(clip);
                if (mutebutton.getIcon() == muteicon) {
                    mutebutton.setIcon(muteiconenabled);
                } else if (mutebutton.getIcon() == muteiconenabled) {
                    mutebutton.setIcon(muteicon);
                }
            }
        });
    }

    public void mute(Clip clip) {
        music.muteMusic(clip);
    }

    public JFrame gamewindowcreation(String gamemode) {
        Clip clip = music.playGameMusic();

        ImageIcon arrowIcon = null;
        // java.net.URL imgURL = MainWindow.class.getResource("Images/gb.png");
        /*
         * if (imgURL != null) {
         * arrowIcon = new ImageIcon(imgURL);
         * gameframe.setIconImage(arrowIcon.getImage());
         * } else {
         * JOptionPane.showMessageDialog(gameframe, "Icon image not found.");
         * }
         */
        ImageIcon appicon = new ImageIcon("Images/gb.png");
        gameframe.setIconImage(appicon.getImage());
        gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameframe.setSize(714, 600);
        gameframe.getContentPane().setBackground(new Color(5, 65, 90));
        gameframe.setLocationRelativeTo(null);
        gameframe.setResizable(false);
        gameframe.setLayout(null);
        gameframe.setVisible(true);
        backbutton(gameframe, clip);
        createmutebutton(gameframe, clip);
        gameboard.boardcreation(gameframe, gamemode, clip);
        return gameframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
         * try {
         * JButton actionSource = (JButton) e.getSource();
         * if (actionSource.equals(backtomenubutton)) {
         * gameframe.dispose();
         * mainwindow = new MainWindow();
         * mainwindow.windowcreation();
         * }
         * } catch (Exception ex) {
         * System.out.println(ex);
         * }
         */

    }

}
