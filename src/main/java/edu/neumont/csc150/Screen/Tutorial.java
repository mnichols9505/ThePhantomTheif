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

/**
 * controller for the tutorial screen
 * @author Ashley, Marisol, Matthew
 */
public class Tutorial extends Application{

static Stage tutstage = new Stage();

    /**
     * Tutorial screen is called and shows.
     * @param stage
     * @throws Exception
     */
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("fxml/TutorialScreen.fxml"));

        Scene scene = new Scene(root);

        tutstage = stage;
        tutstage.setScene(scene);
        tutstage.setTitle("The Phantom Thief");
        tutstage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Emoji_u1f319.svg/2000px-Emoji_u1f319.svg.png"));
        tutstage.show();

    }
    @FXML
    Button backButton;

    /**
     * If back button is pressed, The title screen is recalled again.
     * @param event
     * @throws Exception
     */
    @FXML
    public void backbuttons(MouseEvent event) throws Exception {

        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        StartScreen startScreen = new StartScreen();

        startScreen.start(StartScreen.startstage);

    }
}
