package edu.neumont.csc150.Screen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
}
