package edu.neumont.csc150.Screen;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class StartScreen extends Application{

     static Stage startstage = new Stage();


    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("fxml/startmenu.fxml"));

        Scene scene = new Scene(root);

        startstage = stage;

        startstage.setScene(scene);
        startstage.setTitle("The Phantom Thief");
        startstage.show();


    }

    @FXML
    Button button;

    @FXML
    public void tutorialClick(MouseEvent event) throws Exception {

        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
        Tutorial tutorial = new Tutorial();

        tutorial.start(Tutorial.tutstage);


    }

}
