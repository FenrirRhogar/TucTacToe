import javax.swing.*;
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
    String[] players = new String[10];
    PlayerRoster roster = new PlayerRoster();
    Player p;

    int i = 0;

    // create player panels
    public void playerpanelscreation(JFrame frame, JButton startbutton, String gamemode) {
        // create player 1 and 2 panels
        leftpanel(frame);
        rightpanel(frame);
        // add actions to select player buttons
        selectplayer1button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // select player
                Player player = selectoraddpopup();
                player1name.setText(player.username);
                player1score.setText("Score: " + player.score);
                // if player has been selected discard the button
                if (player1name.getText() != null) {
                    selectplayer1button.setEnabled(false);
                    selectplayer1button.setVisible(false);
                }
                // if players have been selected, enable start button
                if (selectplayer1button.isVisible() == false && selectplayer2button.isVisible() == false) {
                    startbutton.setEnabled(true);
                }
            }

        });
        selectplayer2button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // select player
                Player player = selectoraddpopup();
                player2name.setText(player.username);
                player2score.setText("Score: " + player.score);
                // if player has been selected discard the button
                if (player2name.getText() != null) {
                    selectplayer2button.setEnabled(false);
                    selectplayer2button.setVisible(false);
                }
                // if players have been selected, enable start button
                if (selectplayer1button.isVisible() == false && selectplayer2button.isVisible() == false) {
                    startbutton.setEnabled(true);
                }
            }

        });
    }

    // player 1 panel
    public void leftpanel(JFrame frame) {
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
    public void rightpanel(JFrame frame) {
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

    // popup window to choose exsisting or new player
    public Player selectoraddpopup() {
        // proswrino
        JFrame jFrame = new JFrame();
        String username = null;
        Player player;
        Game g = new Game();
        String[] options = { "New Player", "Exsisting Player", "Cancel" };
        int optionindex = JOptionPane.showOptionDialog(jFrame, "Add new player or select an exsisting?", null,
                JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, options, null);

        // add new player
        if (optionindex == 0) {
            roster.loadPlayer();
            do {
                username = JOptionPane.showInputDialog("Please enter the new player's name:", null);
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
            roster.pnum = g.playerroster.pnum;
            System.out.println(roster.pnum);
            roster.addPlayer(p);
            for (int k = 0; k < roster.pnum; k++) {
                System.out.println(roster.player[k].username);

            }

            // gia kapoio logo apothikeuei ton paikth ksana sth thesi 0 apo oti vlepw an
            // xrisimopoihsw thn roster.addPlayer(p) kati prp na paizei me ton tropo kai
            // to pou dhlwnoume tous paixtes an to vreis prin to vradi pes mou logika den
            // einai polu zoriko alla nustazw opote ta leme aurio

            // update fainetai na pernei kai ton epomeno paikth meta apo kati allages
            // omws meta sto option 2 den tous gazei olous gia kapoio logo pou ontws tha dw
            // aurio
            // giati eprepe na xw koimithei ap thn wra pou egrafa to apo panw sxolio
            // h arxikh ektimisi mou htan pws to kanei gt kati paizei me ton periorismo tou
            // loadPlayer alla otan ton allaksa eixa error opote dne kserw ti ftaiei
            // (an kai sunexizw na to pisteuw gt an to trekseis tha deis oti vgazei mnma gia
            // apothikeusi 3 stoixeiwn)
            // an to deis prin apo mena kai exeis oreksh tsekare to ligo

            roster.storePlayer();
            return p;
            // select exsisting player
        } else if (optionindex == 1) {
            roster.loadPlayer();
            for (int j = 0; j < roster.player.length; j++) {
                if (roster.player[j] != null) {
                    players[j] = roster.player[j].username;
                }
            }
            JFrame selectplayerframe = new JFrame();
            username = (String) JOptionPane.showInputDialog(selectplayerframe, "Select Player:", null,
                    JOptionPane.QUESTION_MESSAGE, null, players, players[0]);
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