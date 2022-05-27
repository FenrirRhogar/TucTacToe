package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

public class GameRecord {

    Game[] game;
    int pnum = 0;

    public LocalDateTime getDateTime() {
        LocalDateTime current = LocalDateTime.now();
        return current;
    }

    public int addGame(Game g, int gnum) {
        game[gnum] = g;
        pnum++;
        storeGame();
        return gnum;
    }

    public void storeGame() {
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream("tuctactoe.ser");
            out = new ObjectOutputStream(fileOut);
            for (Game game : this.game) {
                out.writeObject(game);
            }

            out.close();
            fileOut.close();
            System.out.printf("\nSerialized data is saved in tuctactoe.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void loadGame() {
        int pos = 0;
        FileInputStream FileIn = null;
        ObjectInputStream in = null;
        // Deserialization
        try {
            // Reading the object from a file
            FileIn = new FileInputStream("tuctactoe.ser");
            in = new ObjectInputStream(FileIn);

            while (FileIn.available() > 0) {
                Game g = (Game) in.readObject();
                this.game[pos] = g;
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

    public Game findGame(String player) {
        for (Game g : this.game) {
            if (player != null && player.equals(g.player1.username) || player.equals(g.player2.username)) {
                return g;
            }
        }
        return null;
    }

    public Game[] getGame() {
        return game;
    }

    public void setGame(Game[] game) {
        this.game = game;
    }

    
}