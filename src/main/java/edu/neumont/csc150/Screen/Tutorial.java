package edu.neumont.csc150.Screen;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;

public class Tutorial extends Application{

static Stage tutstage = new Stage();

    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("fxml/TutorialScreen.fxml"));

        Scene scene = new Scene(root);

        tutstage = stage;
        tutstage.setScene(scene);
        tutstage.setTitle("The Phantom Thief");
        tutstage.show();

    }
    @FXML
    Button backButton;

    @FXML
    public void backbuttons(MouseEvent event) throws Exception {

        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        StartScreen startScreen = new StartScreen();

        startScreen.start(StartScreen.startstage);

    }
}
