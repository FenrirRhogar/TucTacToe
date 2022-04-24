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

    //mute music button configuration
    public void createmutebutton(JFrame gameframe, Clip clip) {
        ImageIcon muteicon = new ImageIcon("Images/mutebutton.png");
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
            }

        });
    }

    public void mute(Clip clip) {
        music.muteMusic(clip);
    }

    //create main window
    public void windowcreation() {
        Clip clip = music.playMenuMusic();
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

    //main menu
    public void mainmenu(Clip clip) {
        // menu title customization
        menutitle.setText("TUC TAC TOE");
        menutitle.setBounds(277, 10, 150, 50);
        menutitle.setFont(new Font("Monaco", Font.BOLD, 20));
        menutitle.setForeground(Color.RED);
        // set component boundaries
        playbutton.setBounds(275, 100, 150, 30);
        halloffamebutton.setBounds(275, 150, 150, 30);
        settingsbutton.setBounds(275, 200, 150, 30);
        exitbutton.setBounds(275, 250, 150, 30);
        backtomenubutton.setBounds(520, 510, 150, 30);
        // actionlistener addition
        playbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.add(backtomenubutton);
                backtomenubutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                gamemodeselection(clip);
            }
            
        });
        halloffamebutton.addActionListener(this);
        settingsbutton.addActionListener(this);
        exitbutton.addActionListener(this);
        backtomenubutton.addActionListener(this);
        // add components to frame
        frame.add(menutitle);
        frame.add(playbutton);
        frame.add(halloffamebutton);
        frame.add(settingsbutton);
        frame.add(exitbutton);
        playbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        halloffamebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        settingsbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exitbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }

    //pvp or pve or eve
    public void gamemodeselection(Clip clip) {
        // remove previous buttons
        frame.remove(playbutton);
        frame.remove(halloffamebutton);
        frame.remove(settingsbutton);
        frame.remove(exitbutton);
        frame.revalidate();
        frame.repaint();
        // add game mode selection buttons
        pvpbutton.setBounds(210, 150, 70, 30);
        pvebutton.setBounds(310, 150, 70, 30);
        evebutton.setBounds(410, 150, 70, 30);
        pvpbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(pvpbutton);
                frame.remove(pvebutton);
                frame.remove(evebutton);
                frame.remove(menutitle);
                frame.remove(backtomenubutton);
                frame.revalidate();
                frame.repaint();
                clip.stop();
                pvp.pvpopen(frame);
            }
            
        });
        pvebutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(pvpbutton);
                frame.remove(pvebutton);
                frame.remove(evebutton);
                frame.remove(menutitle);
                frame.remove(backtomenubutton);
                frame.revalidate();
                frame.repaint();
                clip.stop();
                pve.pveopen(frame);
            }
            
        });
        evebutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(pvpbutton);
                frame.remove(pvebutton);
                frame.remove(evebutton);
                frame.remove(menutitle);
                frame.remove(backtomenubutton);
                frame.revalidate();
                frame.repaint();
                clip.stop();
                eve.eveopen(frame);
            }
            
        });
        frame.add(pvpbutton);
        frame.add(pvebutton);
        frame.add(evebutton);
        pvpbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pvebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        evebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
            } else if (actionSource.equals(backtomenubutton)) {
                frame.remove(pvpbutton);
                frame.remove(pvebutton);
                frame.remove(backtomenubutton);
                frame.revalidate();
                frame.repaint();
                windowcreation();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}