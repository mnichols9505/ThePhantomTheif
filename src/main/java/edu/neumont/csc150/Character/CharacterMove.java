package edu.neumont.csc150.Character;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class CharacterMove {

    @FXML
    private Canvas mainCanvas;

    private int ballx = 50,bally = 50,ballwidth =30,ballheight=30;

    private int vX = 8 , vY = 8;

    public void init() {
        Timeline timer = new Timeline(new KeyFrame(Duration.millis(10), e -> draw()));

        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    public void draw() {
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();
        gc.setFill(Color.AQUA);

        gc.fillOval(ballx, bally, ballwidth, ballheight);


    }


    public void handle(KeyEvent e) {

        if(e.getEventType() == KeyEvent. )

    }
}
