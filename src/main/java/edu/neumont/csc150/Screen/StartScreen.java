package edu.neumont.csc150.Screen;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class StartScreen {
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
