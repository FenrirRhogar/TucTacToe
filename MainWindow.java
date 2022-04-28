import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Cursor;

public class MainWindow extends Frame implements ActionListener {

    // classes
    PlayerPanel playerpanel = new PlayerPanel();
    BannerPanel bannerpanel = new BannerPanel();
    HallOfFame halloffame = new HallOfFame();
    GameBoard gameboard = new GameBoard();
    Music music = new Music();
    PvP pvp = new PvP();
    PvE pve = new PvE();
    EvE eve = new EvE();
    // main frame
    JFrame frame = new JFrame("Tuc Tac Toe");
    // tuc tac toe label
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


    // create main window
    public void windowcreation() {
        Clip clip = music.playMenuMusic();
        menutitle.setText("TUC TAC TOE");
        menutitle.setBounds(277, 10, 150, 50);
        menutitle.setFont(new Font("Monaco", Font.BOLD, 20));
        menutitle.setForeground(Color.RED);
        menutitle.setVisible(false);
        frame.add(menutitle);

        playbutton.setBounds(275, 100, 150, 30);
        playbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                backtomenubutton.setVisible(true);
                backtomenubutton.setEnabled(true);
                menutitle.setVisible(false);
                playbutton.setEnabled(false);
                playbutton.setVisible(false);
                backtomenubutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                gamemodeselection(clip);
            }

        });
        playbutton.setEnabled(false);
        playbutton.setVisible(false);
        playbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(playbutton);

        halloffamebutton.setBounds(275, 150, 150, 30);
        halloffamebutton.setEnabled(false);
        halloffamebutton.setVisible(false);
        halloffamebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(halloffamebutton);

        settingsbutton.setBounds(275, 200, 150, 30);
        settingsbutton.setEnabled(false);
        settingsbutton.setVisible(false);
        settingsbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(settingsbutton);

        exitbutton.setBounds(275, 250, 150, 30);
        exitbutton.setEnabled(false);
        exitbutton.setVisible(false);
        exitbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(exitbutton);

        pvpbutton.setBounds(210, 150, 70, 30);
        pvpbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clip.stop();
                pvp.pvpopen(frame);
            }

        });
        pvpbutton.setEnabled(false);
        pvpbutton.setVisible(false);
        pvpbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(pvpbutton);

        pvebutton.setBounds(310, 150, 70, 30);
        pvebutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clip.stop();
                pve.pveopen(frame);
            }

        });
        pvebutton.setEnabled(false);
        pvebutton.setVisible(false);
        pvebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(pvebutton);

        evebutton.setBounds(410, 150, 70, 30);
        evebutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clip.stop();
                eve.eveopen(frame);
            }

        });
        evebutton.setEnabled(false);
        evebutton.setVisible(false);
        evebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(evebutton);

        backtomenubutton.setBounds(520, 510, 150, 30);
        backtomenubutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mainmenu(clip);
            }

        });
        backtomenubutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(backtomenubutton);

        mainmenu(clip);
        // application image configuration
        ImageIcon arrowIcon = null;
        java.net.URL imgURL = MainWindow.class.getResource("Images/gb.png");
        if (imgURL != null) {
            arrowIcon = new ImageIcon(imgURL);
            frame.setIconImage(arrowIcon.getImage());
        } else {
            JOptionPane.showMessageDialog(frame, "Icon image not found.");
        }
        createmutebutton(frame, clip);
        // window properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(714, 600);
        frame.getContentPane().setBackground(new Color(5, 65, 90));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // main menu
    public void mainmenu(Clip clip) {
        halloffamebutton.addActionListener(this);
        settingsbutton.addActionListener(this);
        exitbutton.addActionListener(this);

        menutitle.setVisible(true);
        playbutton.setEnabled(true);
        playbutton.setVisible(true);
        halloffamebutton.setEnabled(true);
        halloffamebutton.setVisible(true);
        settingsbutton.setEnabled(true);
        settingsbutton.setVisible(true);
        exitbutton.setEnabled(true);
        exitbutton.setVisible(true);

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
        // remove previous buttons
        playbutton.setVisible(false);
        playbutton.setEnabled(false);
        halloffamebutton.setVisible(false);
        halloffamebutton.setEnabled(false);
        settingsbutton.setVisible(false);
        settingsbutton.setEnabled(false);
        exitbutton.setVisible(false);
        exitbutton.setEnabled(false);

        pvpbutton.setVisible(true);
        pvpbutton.setEnabled(true);
        pvebutton.setVisible(true);
        pvebutton.setEnabled(true);
        evebutton.setVisible(true);
        evebutton.setEnabled(true);
    }

    // action for every button configuration
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JButton actionSource = (JButton) e.getSource();

            if (actionSource.equals(halloffamebutton)) {
                System.out.println("Prits2");
            } else if (actionSource.equals(settingsbutton)) {
                System.out.println("Prits3");
            } else if (actionSource.equals(exitbutton)) {
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}