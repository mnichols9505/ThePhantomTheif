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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class MainGameS1 extends Application {

    static Stage Gamestage = new Stage();

    public String musicFile = "song1.wav";


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

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public void gameClose(){
        Stage stage = (Stage) Gamestage.getScene().getWindow();
        stage.close();
    }
    //

}



