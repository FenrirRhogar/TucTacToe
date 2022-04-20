import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends Frame implements ActionListener {

    // classes
    PlayerPanel playerpanel = new PlayerPanel();
    BannerPanel bannerpanel = new BannerPanel();
    HallOfFame halloffame = new HallOfFame();
    GameBoard gameboard = new GameBoard();
    PvP pvp = new PvP();
    PvE pve = new PvE();
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
    JButton backtomenubutton = new JButton("Back to Menu");

    public void windowcreation() {

        mainmenu();
        // application image configuration
        ImageIcon arrowIcon = null;
        java.net.URL imgURL = MainWindow.class.getResource("gb.png");
        if (imgURL != null) {
            arrowIcon = new ImageIcon(imgURL);
            frame.setIconImage(arrowIcon.getImage());
        } else {
            JOptionPane.showMessageDialog(frame, "Icon image not found.");
        }
        
        // window properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(714, 600);
        frame.getContentPane().setBackground(new Color(5, 65, 90));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void mainmenu() {
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
        playbutton.addActionListener(this);
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
    }

    public void gamemodeselection() {
        // remove previous buttons
        frame.remove(playbutton);
        frame.remove(halloffamebutton);
        frame.remove(settingsbutton);
        frame.remove(exitbutton);
        frame.revalidate();
        frame.repaint();
        // add game mode selection buttons
        pvpbutton.setBounds(250, 150, 70, 30);
        pvebutton.setBounds(350, 150, 70, 30);
        pvpbutton.addActionListener(this);
        pvebutton.addActionListener(this);
        frame.add(pvpbutton);
        frame.add(pvebutton);
    }

    // action for every button configuration
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JButton actionSource = (JButton) e.getSource();

            if (actionSource.equals(playbutton)) {
                frame.add(backtomenubutton);
                gamemodeselection();
            } else if (actionSource.equals(halloffamebutton)) {
                System.out.println("Prits2");
            } else if (actionSource.equals(settingsbutton)) {
                System.out.println("Prits3");
            } else if (actionSource.equals(exitbutton)) {
                System.exit(0);
            } else if (actionSource.equals(pvpbutton)) {
                frame.remove(pvpbutton);
                frame.remove(pvebutton);
                frame.remove(menutitle);
                frame.revalidate();
                frame.repaint();
                pvp.pvpopen(frame);
            } else if (actionSource.equals(pvebutton)) {
                frame.remove(pvpbutton);
                frame.remove(pvebutton);
                frame.remove(menutitle);
                frame.revalidate();
                frame.repaint();
                pve.pveopen(frame);
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