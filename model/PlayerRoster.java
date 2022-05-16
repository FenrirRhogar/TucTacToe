package model;

import java.io.*;
import java.io.Serializable;

import javax.swing.SortingFocusTraversalPolicy;

public class PlayerRoster implements Serializable {

    Player[] player;
    int pnum = 0;

    public PlayerRoster() {
        this.player = new Player[50];
    }

    public Player[] getPlayer() {
        return player;
    }

    public void setPlayer(Player[] player) {
        this.player = player;
    }

    public int addPlayer(Player p, int pnum) {
        player[pnum] = p;
        pnum++;
        storePlayer();
        return pnum;
    }

    public void storePlayer() {
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream("tuctactoe.ser");
            out = new ObjectOutputStream(fileOut);
            for (Player player : this.player) {
                out.writeObject(player);
            }
            out.close();
            fileOut.close();
            System.out.printf("\nSerialized data is saved in tuctactoe.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void loadPlayer() {
        int pos = 0;
        FileInputStream FileIn = null;
        ObjectInputStream in = null;
        // Deserialization
        try {
            // Reading the object from a file
            FileIn = new FileInputStream("tuctactoe.ser");
            in = new ObjectInputStream(FileIn);

            while (FileIn.available() > 0) {
                Player p = (Player) in.readObject();
                this.player[pos] = p;
                pos++;
            }
            in.close();
            FileIn.close();

            System.out.println("\nObject has been deserialized ");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    public String findPlayerNames(Player pl) {
        for (Player p : this.player) {
            if (p != null && p.equals(pl))
                return p.username;
        }
        return null;
    }

    public Player findPlayer(String name) {
        for (Player player : this.player) {
            if (player != null && player.getUsername().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void findHallOfFame(int number) {

    }

    public void player1wins(String name1, String name2) {
        loadPlayer();
        findPlayer(name1).victories++;
        findPlayer(name2).losses++;
        findPlayer(name1).games++;
        findPlayer(name2).games++;
    }

    public void player2wins(String name1, String name2) {
        loadPlayer();
        findPlayer(name2).victories++;
        findPlayer(name1).losses++;
        findPlayer(name1).games++;
        findPlayer(name2).games++;
    }

    public void playerdraw(String name1, String name2) {
        loadPlayer();
        findPlayer(name1).draws++;
        findPlayer(name2).draws++;
        findPlayer(name1).games++;
        findPlayer(name2).games++;
    }
}