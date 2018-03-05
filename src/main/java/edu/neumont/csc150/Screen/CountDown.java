package edu.neumont.csc150.Screen;

import edu.neumont.csc150.Character.CharacterMove;
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
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import sun.applet.AppletListener;

import java.awt.*;


public class CountDown extends Application {

    private Label label;
    private Integer start = 93;
    private Integer seconds = start;
    private Integer startHard = 33;
    private Integer secondsHard = startHard;
    private Integer startStart = 3;
    private Integer secondsStart = startStart;


    Group root = new Group();

    public Stage secondStage = new Stage();

    public Timeline time = new Timeline();

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("Gameplay.fxml")
        );

      Group root = new Group();

        stage.setScene(new Scene(root, 300, 70, Color.BLUEVIOLET));
        stage.show();
    }

    /**
     * Starts the 90 sec clock
     */
    public void doTime() {
        System.out.println(secondStage+"!!");
        time.setCycleCount(Timeline.INDEFINITE);
        if (time != null) {
            time.stop();
        }
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clock();
            }
        });

        time.getKeyFrames().add(frame);
        time.playFromStart();
        time.play();
        label = new Label();
        label.setTextFill(Color.WHITESMOKE);
        label.setFont(Font.font(22));

        secondStage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Emoji_u1f319.svg/2000px-Emoji_u1f319.svg.png"));
        secondStage.setX(0);
        secondStage.setY(0);
        HBox hbox = new HBox(5);
        GaussianBlur blur = new GaussianBlur(0.0);
        hbox.setAlignment(Pos.BASELINE_RIGHT);
        secondStage.setTitle("CountDown 90 Seconds");
        hbox.getChildren().add(label);
        hbox.setLayoutX(48);
        hbox.setEffect(blur);
        root.getChildren().add(hbox);
        secondStage.setScene(new Scene(root, 300, 70, Color.BLUEVIOLET));

        secondStage.show();
    }

    /**
     * starts the 30 second clock
     */
    public void doHardTime() {

        HBox hbox = new HBox(5);

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
                    close();
                    secondStage.close();

                }
            }

        });
        time.getKeyFrames().add(frame);
        time.playFromStart();
        time.play();

        label = new Label();
        label.setTextFill(Color.WHITESMOKE);
        label.setFont(Font.font(22));
        secondStage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Emoji_u1f319.svg/2000px-Emoji_u1f319.svg.png"));
        secondStage.setX(0);
        secondStage.setY(0);
        secondStage.setTitle("CountDown 30 Seconds");
        hbox.getChildren().add(label);
        root.getChildren().add(hbox);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        secondStage.setScene(new Scene(root, 300, 70, Color.BLUEVIOLET));
        secondStage.show();

    }

    /**
     * closes the main game screen when you lose
     */
    public void close() {

            Stage stage = (Stage) label.getScene().getWindow();
            stage.close();
            MainGameS1.Gamestage.close();
            Looser looser = new Looser();
            try {
                looser.start(Looser.lose);
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    /**
     * Makes a clock that counts down. If seconds is less then or equal to 0, it calls the close method and prompts the loser screen.
     */
    public void clock() {
        seconds--;

        if (label != null) {
            label.setText("Countdown: " + seconds.toString());
        }
        if (seconds <= 0) {
            time.stop();
            close();

        }
    }

    /**
     * closes the stage of countdown
     */
    public void closeStage() {

        secondStage.close();
    }

    }



