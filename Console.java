import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Console {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // open window
        Game g = new Game();
        g.mainwindow.windowcreation();

    }

}