import java.io.File;
import javax.sound.sampled.AudioInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
    public Clip playGameMusic() {
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("gametheme.wav"));
            clip.open(ais);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }
        return clip;
    }

    public Clip playMenuMusic() {
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("menutheme.wav"));
            clip.open(ais);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        }
        return clip;
    }

    public void muteMusic(Clip clip) {
        if (clip.isActive() == true) {
            clip.stop();
        } else if (clip.isActive() == false) {
            clip.start();
        }
    }
}