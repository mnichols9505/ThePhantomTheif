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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import sun.applet.AppletListener;


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
//
      Group root = new Group();
        label = new Label();
        label.setTextFill(Color.WHITESMOKE);
        label.setFont(Font.font(22));


        HBox hbox = new HBox(5);
        hbox.getChildren().add(label);
        hbox.setLayoutX(48);
        root.getChildren().add(hbox);

        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(new HBox(4, new Label("Second window"))));
        secondStage.show();

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

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    Alert c = new Alert(Alert.AlertType.WARNING);

                    alert.setHeaderText("BOOM!");
                    c.setHeaderText("You have collected:  ");
                    //  c.setContentText(sell.accumulator);
                    alert.show();
                    c.show();

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
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("BOOM!");
                    alert.show();

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


        HBox hbox = new HBox(5);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.getChildren().add(label);
        hbox.setLayoutX(48);
        root.getChildren().add(hbox);
        secondStage.setScene(new Scene(root, 300, 70, Color.BLUEVIOLET));
        secondStage.show();

    }

}

