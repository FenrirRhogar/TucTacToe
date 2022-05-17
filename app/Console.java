package app;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import controller.GameControler;
import view.Game;

public class Console {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // open window
        GameControler gc = new GameControler();
        gc.start();

    }

}