package edu.neumont.csc150.Screen;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;



public class CountDown extends Application {
    private boolean poison;
    private Integer start = 30;
    private Integer seconds = start;
    private Label label;


    public boolean isPoison() {
        return poison;
    }

    public void setPoison(boolean poison) {
        this.poison = poison;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        label = new Label();
        label.setTextFill(Color.WHITESMOKE);
        label.setFont(Font.font(22));


        HBox hbox = new HBox(5);
        hbox.getChildren().add(label);
        hbox.setLayoutX(48);
        root.getChildren().add(hbox);
        doTime();

        stage.setScene(new Scene(root, 300,70,Color.BLUEVIOLET));
        stage.show();
    }

    private void doTime() {
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
            if(time!= null){
                time.stop();
        }
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    seconds--;


                    label.setText("Countdown: "+seconds.toString());
                     if(seconds<=0){
                         time.stop();
                         Alert alert= new Alert(Alert.AlertType.INFORMATION);
                         alert.setHeaderText("BOOM!");

                     }
            }
        });

            time.getKeyFrames().add(frame);
            time.playFromStart();
    }
    public static void main(String[] args){
        Application.launch(CountDown.class, args);
    }
}