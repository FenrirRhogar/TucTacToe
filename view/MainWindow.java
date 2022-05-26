package view;

import javax.sound.sampled.Clip;
import javax.swing.*;

import Music.Music;
import controller.GameControler;

import java.awt.*;
import java.awt.event.*;
import java.awt.Cursor;

public class MainWindow extends Frame {

    // classes
    GameControler gc = new GameControler();
    PlayerPanel playerpanel = new PlayerPanel();
    BannerPanel bannerpanel = new BannerPanel();
    HallOfFame halloffame = new HallOfFame();
    GameBoard gameboard = new GameBoard();
    Music music = new Music();
    // main frame
    JFrame frame = new JFrame("Tuc Tac Toe");
    // tuc tac toe title
    JLabel menutitle = new JLabel();
    // buttons
    JButton playbutton = new JButton("Play");
    JButton halloffamebutton = new JButton("Hall Of Fame");
    JButton settingsbutton = new JButton("Settings");
    JButton exitbutton = new JButton("Exit");
    JButton pvpbutton = new JButton("PvP");
    JButton pvebutton = new JButton("PvE");
    JButton evebutton = new JButton("EvE");
    JButton backtomenubutton = new JButton("Back to Menu");
    JButton mutebutton = new JButton();

    // mute music button configuration
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

    // create window
    public void windowcreation() {
        // play music
        Clip clip = music.playMenuMusic();
        // menu title
        menutitle.setText("TUC TAC TOE");
        menutitle.setBounds(278, 10, 150, 50);
        menutitle.setFont(new Font("Monaco", Font.BOLD, 20));
        menutitle.setForeground(Color.RED);
        menutitle.setVisible(false);
        frame.add(menutitle);
        // "Play" button
        playbutton.setBounds(275, 100, 150, 30);
        playbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                backtomenubutton.setVisible(true);
                backtomenubutton.setEnabled(true);
                backtomenubutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                gamemodeselection(clip);
            }

        });
        playbutton.setEnabled(false);
        playbutton.setVisible(false);
        playbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(playbutton);
        // "Hall Of Fame" button
        halloffamebutton.setBounds(275, 150, 150, 30);
        halloffamebutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Prits2");
                menutitle.setVisible(false);
                playbutton.setVisible(false);
                playbutton.setEnabled(false);
                halloffamebutton.setVisible(false);
                halloffamebutton.setEnabled(false);
                settingsbutton.setVisible(false);
                settingsbutton.setEnabled(false);
                exitbutton.setVisible(false);
                exitbutton.setEnabled(false);
                backtomenubutton.setVisible(true);
                backtomenubutton.setEnabled(true);
                backtomenubutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                halloffame.halloffameboard(frame);
            }

        });
        halloffamebutton.setEnabled(false);
        halloffamebutton.setVisible(false);
        halloffamebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(halloffamebutton);
        // "Settings" button
        settingsbutton.setBounds(275, 200, 150, 30);
        settingsbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Prits3");
            }

        });
        settingsbutton.setEnabled(false);
        settingsbutton.setVisible(false);
        settingsbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(settingsbutton);
        // "Exit button"
        exitbutton.setBounds(275, 250, 150, 30);
        exitbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
        exitbutton.setEnabled(false);
        exitbutton.setVisible(false);
        exitbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(exitbutton);
        // Gamemode buttons
        gamemodeButtons(clip);
        // "Back To Menu" button
        backtomenubutton.setBounds(520, 510, 150, 30);
        backtomenubutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(halloffame.titlepanel);
                frame.remove(halloffame.player1);
                frame.remove(halloffame.player2);
                frame.remove(halloffame.player3);
                frame.remove(halloffame.player4);
                frame.remove(halloffame.player5);
                frame.remove(halloffame.player6);
                frame.remove(halloffame.player7);
                frame.remove(halloffame.player8);
                frame.remove(halloffame.player9);
                frame.remove(halloffame.player10);
                frame.remove(halloffame.score1);
                frame.remove(halloffame.score2);
                frame.remove(halloffame.score3);
                frame.remove(halloffame.score4);
                frame.remove(halloffame.score5);
                frame.remove(halloffame.score6);
                frame.remove(halloffame.score7);
                frame.remove(halloffame.score8);
                frame.remove(halloffame.score9);
                frame.remove(halloffame.score10);
                frame.revalidate();
                frame.repaint();
                mainmenu(clip);
            }

        });
        backtomenubutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(backtomenubutton);
        // make menu buttons active
        mainmenu(clip);
        // application image configuration
        applicationIcon();
        // mute button
        createmutebutton(frame, clip);
        // window properties
        frameSettings();
    }

    private void gamemodeButtons(Clip clip) {
        // "PvP" gamemode button
        pvpbutton.setBounds(210, 150, 70, 30);
        pvpbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String mode = "pvp";
                clip.stop();
                frame.dispose();
                GameWindow gw = new GameWindow();
                gw.gamewindowcreation(mode);
            }

        });
        pvpbutton.setEnabled(false);
        pvpbutton.setVisible(false);
        pvpbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(pvpbutton);
        // "PvE" gamemode button
        pvebutton.setBounds(310, 150, 70, 30);
        pvebutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String mode = "pve";
                clip.stop();
                frame.dispose();
                GameWindow gw = new GameWindow();
                gw.gamewindowcreation(mode);
            }

        });
        pvebutton.setEnabled(false);
        pvebutton.setVisible(false);
        pvebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(pvebutton);
        // "EvE" gamemode button
        evebutton.setBounds(410, 150, 70, 30);
        evebutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String mode = "eve";
                clip.stop();
                frame.dispose();
                GameWindow gw = new GameWindow();
                gw.gamewindowcreation(mode);
            }

        });
        evebutton.setEnabled(false);
        evebutton.setVisible(false);
        evebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(evebutton);
    }

    private void frameSettings() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(714, 600);
        frame.getContentPane().setBackground(new Color(5, 65, 90));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void applicationIcon() {
        /*
         * ImageIcon arrowIcon = null;
         * java.net.URL imgURL = MainWindow.class.getResource("Images/gb.png");
         * if (imgURL != null) {
         * arrowIcon = new ImageIcon(imgURL);
         * frame.setIconImage(arrowIcon.getImage());
         * } else {
         * JOptionPane.showMessageDialog(frame, "Icon image not found.");
         * }
         */

        try {
            ImageIcon appicon = new ImageIcon("Images/gb.png");
            frame.setIconImage(appicon.getImage());
        } catch (Exception e) {
            System.out.println("Icon image not found.");
        }
        
    }

    // main menu
    public void mainmenu(Clip clip) {
        // enable new buttons
        menutitle.setVisible(true);
        playbutton.setEnabled(true);
        playbutton.setVisible(true);
        halloffamebutton.setEnabled(true);
        halloffamebutton.setVisible(true);
        settingsbutton.setEnabled(true);
        settingsbutton.setVisible(true);
        exitbutton.setEnabled(true);
        exitbutton.setVisible(true);
        // disable previous buttons
        pvpbutton.setEnabled(false);
        pvpbutton.setVisible(false);
        pvebutton.setEnabled(false);
        pvebutton.setVisible(false);
        evebutton.setEnabled(false);
        evebutton.setVisible(false);
        backtomenubutton.setEnabled(false);
        backtomenubutton.setVisible(false);
    }

    // pvp or pve or eve selection
    public void gamemodeselection(Clip clip) {
        menutitle.setVisible(false);
        // disabe previous buttons
        playbutton.setVisible(false);
        playbutton.setEnabled(false);
        halloffamebutton.setVisible(false);
        halloffamebutton.setEnabled(false);
        settingsbutton.setVisible(false);
        settingsbutton.setEnabled(false);
        exitbutton.setVisible(false);
        exitbutton.setEnabled(false);
        // enable new buttons
        pvpbutton.setVisible(true);
        pvpbutton.setEnabled(true);
        pvebutton.setVisible(true);
        pvebutton.setEnabled(true);
        evebutton.setVisible(true);
        evebutton.setEnabled(true);
    }

}