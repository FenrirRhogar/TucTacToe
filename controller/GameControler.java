package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import model.*;
import view.*;

public class GameControler {
    MainWindow view;
    GameModel model;

    public void start() {
        view = new MainWindow();
        view.windowcreation();
    }

    public void quit() {
        System.out.println("bye bye...");
        System.exit(0);
    }

    public MainWindow getView() {
        return view;
    }

    public void setView(MainWindow view) {
        this.view = view;
    }

    public GameModel getModel() {
        return model;
    }

    public void setModel(GameModel model) {
        this.model = model;
    }

}
