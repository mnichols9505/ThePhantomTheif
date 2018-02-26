package edu.neumont.csc150.Screen;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class CountDown extends Application {
    private boolean poison;
    private int seconds;

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }



    public boolean isPoison() {
        return poison;
    }

    public void setPoison(boolean poison) {
        this.poison = poison;
    }



    public void start(Stage stage) throws Exception {
        HBox hbox = new HBox();
    }
}
