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

/**
 * sets the stage when the Mr. cox painting is found
 * @author Ashley, Marisol, Matthew
 */
public class CoxFound extends Application {


        public static Stage cox = new Stage();

        @FXML
        public Button word;

    /**
     * Starts the cox win screen.
     * @param stage
     * @throws Exception
     */
    public void start(Stage stage) throws Exception {

            Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("fxml/MrCoxFound.fxml"));

            Scene scene = new Scene(root);

            cox = stage;
            cox.setScene(scene);
            cox.setTitle("The Phantom Thief");
            cox.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Emoji_u1f319.svg/2000px-Emoji_u1f319.svg.png"));
            cox.show();

        }

    /**
     * Starts the main screen when pressed the replay button
     * @param event
     * @throws Exception
     */
        @FXML
        public void replay(MouseEvent event) throws Exception {

            Stage stage = (Stage) word.getScene().getWindow();
            stage.close();
            StartScreen startScreen = new StartScreen();
            startScreen.start(StartScreen.startstage);

        }


}
