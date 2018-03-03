package edu.neumont.csc150.Screen;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StartCountDown extends Application{

    private Label label;
    static Stage secondStage3 = new Stage();

    public Timeline time = new Timeline();
    private Integer startStart = 3;
    private Integer secondsStart = startStart;
    private HBox hbox = new HBox();
    Group root = new Group();

    public void start(Stage stage){

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("Gameplay.fxml")
        );
        time.setCycleCount(Timeline.INDEFINITE);
        if (time != null) {
            time.stop();
        }
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                secondsStart--;

                if (label != null) {
                    label.setText("READY?: " + secondsStart.toString());
                }
                if (secondsStart <= 0) {
                    time.stop();
                    secondStage3.close();


                }
            }

        });
        secondStage3 = stage;
        time.getKeyFrames().add(frame);
        time.playFromStart();
        time.play();
        secondStage3.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Emoji_u1f319.svg/2000px-Emoji_u1f319.svg.png"));
        label = new Label();
        label.setTextFill(Color.WHITESMOKE);
        label.setFont(Font.font(120));
        secondStage3.setTitle("READY?");
        secondStage3.setX(700);
        secondStage3.setY(630);
        hbox.getChildren().add(label);
        root.getChildren().add(hbox);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        secondStage3.setScene(new Scene(root, 800, 200, Color.DARKSALMON));
        secondStage3.show();



    }
    }

