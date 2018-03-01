package edu.neumont.csc150.Screen;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;

public class Looser extends Application {

    public static Stage lose = new Stage();
    @FXML
    public Button word;


    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("fxml/LosingScreen.fxml"));

        Scene scene = new Scene(root);

        lose = stage;
        lose.setScene(scene);
        lose.setTitle("The Phantom Thief");
        lose.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Emoji_u1f319.svg/2000px-Emoji_u1f319.svg.png"));
        lose.show();

    }

    @FXML
    public void replay(MouseEvent event) throws Exception {

        Stage stage = (Stage) word.getScene().getWindow();
        stage.close();
        StartScreen startScreen = new StartScreen();
        startScreen.start(StartScreen.startstage);

    }

}
