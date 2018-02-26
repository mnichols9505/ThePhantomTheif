package edu.neumont.csc150.Screen;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class CountDown extends Application {
    private boolean poison;
    private int seconds;
    private AnimationTimer timer;
    private Duration duration;
    private long lastTimerCall;

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

    public void create() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now > lastTimerCall + 30) {
                    duration = duration.subtract(Duration.seconds(1));

                    int remainingSeconds = (int) duration.toSeconds();
                }
            }

        };
    }
            public void start(Stage stage) throws Exception {
                HBox hbox = new HBox(seconds);
                hbox.setBackground(new Background(new BackgroundFill(Color.web("#CCCCFF"), CornerRadii.EMPTY, Insets.EMPTY)));
                hbox.setPadding(new Insets(10));

                Scene scene = new Scene(hbox);

                stage.setScene(scene);
                stage.show();

                timer.start();
            }




}