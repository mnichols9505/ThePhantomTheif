package edu.neumont.csc150.Screen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import sun.applet.AppletListener;

import java.awt.*;


public class CountDown extends Application {
    private boolean poison;
    private Label label;
    private Integer start = 90;
    private Integer seconds = start;
    private Integer startHard = 30;
    private Integer secondsHard = startHard;
    private Label timerLabel;
    Group root = new Group();

    public boolean isPoison() {
        return poison;
    }

    public void setPoison(boolean poison) {
        this.poison = poison;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("Gameplay.fxml")
        );

      Group root = new Group();

        stage.setScene(new Scene(root, 300, 70, Color.BLUEVIOLET));
        stage.show();
    }

    public void doTime() {
        poison = true;
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        if (time != null) {
            time.stop();
        }
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                seconds--;


                if (label != null) {
                    label.setText("Countdown: " + seconds.toString());
                }
                if (seconds <= 0) {
                    time.stop();

                }
            }
        });

        time.getKeyFrames().add(frame);
        time.playFromStart();
        time.play();
        Stage secondStage = new Stage();
        label = new Label();
        label.setTextFill(Color.WHITESMOKE);
        label.setFont(Font.font(22));

        secondStage.setX(0);
        secondStage.setY(0);
        HBox hbox = new HBox(5);
        GaussianBlur blur = new GaussianBlur(0.0);
        hbox.setAlignment(Pos.BASELINE_RIGHT);
        hbox.getChildren().add(label);
        hbox.setLayoutX(48);
        hbox.setEffect(blur);
        root.getChildren().add(hbox);
        secondStage.setScene(new Scene(root, 300, 70, Color.BLUEVIOLET));
        secondStage.show();
    }
    public void doHardTime() {
        poison = true;
        HBox hbox = new HBox(5);
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        if (time != null) {
            time.stop();
        }
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                secondsHard--;

                if (label != null) {
                    label.setText("Countdown: " + secondsHard.toString());
                }
                if (secondsHard <= 0) {
                    time.stop();
                }
            }

        });
        time.getKeyFrames().add(frame);
        time.playFromStart();
        time.play();
        Stage secondStage = new Stage();
        label = new Label();
        label.setTextFill(Color.WHITESMOKE);
        label.setFont(Font.font(22));

        secondStage.setX(0);
        secondStage.setY(0);
        hbox.getChildren().add(label);
        root.getChildren().add(hbox);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        secondStage.setScene(new Scene(root, 300, 70, Color.BLUEVIOLET));
        secondStage.show();

    }

}

