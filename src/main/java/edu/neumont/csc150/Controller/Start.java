package edu.neumont.csc150.Controller;

import edu.neumont.csc150.Screen.StartScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {

    static Stage startstage = new Stage();

    public static void main(String[] args) {
        Application.launch(Start.class, args);
    }

    /**
     * Start the screen
     * @param stage
     * @throws Exception
     */
    public void start(Stage stage) throws Exception {

        StartScreen sc = new StartScreen();
        sc.start(startstage);


    }
}
