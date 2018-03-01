package edu.neumont.csc150.Screen;

import edu.neumont.csc150.Character.CharacterMove;
import edu.neumont.csc150.Items.Sell;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainGameS1 extends Application {

    static Stage Gamestage = new Stage();
    private Integer start = 90;
    private Integer seconds = start;
    private Integer startHard = 30;
    private Integer secondsHard = startHard;
    private Label timerLabel;
    boolean poison = true;




    public void start(Stage stage) throws Exception {


        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/Gameplay.fxml"));
        Parent root = loader.load();


        Scene scene = new Scene(root);

        Gamestage = stage;
        Gamestage.setScene(scene);
        Gamestage.setTitle("The Phantom Thief");
        Gamestage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Emoji_u1f319.svg/2000px-Emoji_u1f319.svg.png"));
        Gamestage.show();

        CharacterMove dude = loader.getController();
        scene.setOnKeyPressed(dude);
        dude.init();


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


                if (timerLabel != null) {
                    timerLabel.setText("Countdown: " + seconds.toString());
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


                if (timerLabel != null) {
                    timerLabel.setText("Countdown: " + secondsHard.toString());
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

    }
}



