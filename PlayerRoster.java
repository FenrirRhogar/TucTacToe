import java.io.*;
import java.io.Serializable;

import javax.swing.SortingFocusTraversalPolicy;

public class PlayerRoster implements Serializable {

    Player[] player;
    int pnum = 0;

    public PlayerRoster() {
        this.player = new Player[50];
    }

    public void addPlayer(Player p) {
        player[pnum] = p;
        pnum++;
        storePlayer();
    }

    public void storePlayer() {
        try {
            FileOutputStream fileOut = new FileOutputStream("tuctactoe.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
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
        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream FileIn = new FileInputStream("tuctactoe.ser");
            ObjectInputStream in = new ObjectInputStream(FileIn);

            while (FileIn.available() > 0) {
                Player p = (Player) in.readObject();
                this.player[pos++] = p;
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
}