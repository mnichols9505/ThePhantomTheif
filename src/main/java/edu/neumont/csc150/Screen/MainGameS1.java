package edu.neumont.csc150.Screen;

import edu.neumont.csc150.Character.CharacterMove;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainGameS1 extends Application {

    static Stage Gamestage = new Stage();


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





    }

