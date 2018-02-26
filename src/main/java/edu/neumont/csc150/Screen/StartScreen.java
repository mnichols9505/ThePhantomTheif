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


public class StartScreen extends Application{

     static Stage startstage = new Stage();


    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("fxml/startmenu.fxml"));

        Scene scene = new Scene(root);

        startstage = stage;

        startstage.setScene(scene);
        startstage.setTitle("The Phantom Thief");
        startstage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Emoji_u1f319.svg/2000px-Emoji_u1f319.svg.png"));
        startstage.show();


    }

    @FXML
    Button startButton;

    @FXML
    public void startClick(MouseEvent event) throws Exception {

        Stage stage = (Stage) startButton.getScene().getWindow();
        stage.close();
        PickYourPoison poison = new PickYourPoison();
        poison.start(PickYourPoison.poison);

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
