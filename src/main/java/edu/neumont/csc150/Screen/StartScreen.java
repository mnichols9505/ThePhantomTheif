package edu.neumont.csc150.Screen;


import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;


public class StartScreen {

    @FXML
    public void tutorialClick(MouseEvent event) throws Exception {

        Tutorial tutorial = new Tutorial();

        tutorial.start(Tutorial.tutstage);

    }

}
