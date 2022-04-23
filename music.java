import javax.swing.*;
import java.awt.event.*;
import java.rmi.activation.ActivationDesc;
import java.awt.Cursor;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.swing.JOptionPane;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
    public Clip playMusic() {
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("TUCTACTOEMUSIC.wav"));
            clip.open(ais);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            /*
             * SwingUtilities.invokeLater(new Runnable() {
             * public void run() {
             * // A GUI element to prevent the Clip's daemon Thread
             * // from terminating at the end of the main()
             * // JOptionPane.showMessageDialog(frame, "Close to exit!");
             * }
             * });
             */
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }
        return clip;
    }
}