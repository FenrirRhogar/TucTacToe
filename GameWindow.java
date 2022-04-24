import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.sound.sampled.Clip;

public class GameWindow extends Frame implements ActionListener {
    JFrame gameframe = new JFrame("Tuc Tac Toe");
    GameBoard gameboard = new GameBoard();
    JButton backtomenubutton = new JButton("Back to Menu");
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
                mainwindow = new MainWindow();
                mainwindow.windowcreation();
                clip.stop();
            }

        });
    }

    public JFrame gamewindowcreation(String gamemode) {
        Clip clip = music.playGameMusic();
        ImageIcon arrowIcon = null;
        java.net.URL imgURL = MainWindow.class.getResource("gb.png");
        if (imgURL != null) {
            arrowIcon = new ImageIcon(imgURL);
            gameframe.setIconImage(arrowIcon.getImage());
        } else {
            JOptionPane.showMessageDialog(gameframe, "Icon image not found.");
        }
        gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameframe.setSize(714, 600);
        gameframe.getContentPane().setBackground(new Color(5, 65, 90));
        gameframe.setLocationRelativeTo(null);
        gameframe.setResizable(false);
        gameframe.setLayout(null);
        gameframe.setVisible(true);
        backbutton(gameframe, clip);
        gameboard.boardcreation(gameframe, gamemode);
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
