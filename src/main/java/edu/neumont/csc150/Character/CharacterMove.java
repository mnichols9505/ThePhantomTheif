package edu.neumont.csc150.Character;

import com.sun.webkit.dom.KeyboardEventImpl;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
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

        ballx +=vX;
        bally+=vY;



    }


    public void handle(KeyEvent e) {

        if(e.getCode() == KeyCode.S ){
            vY+=1;
            System.out.println("pressed");
        }
        if(e.getCode().equals(KeyCode.DOWN)){
            vY-=1;
        }
        if(e.getCode().equals(KeyCode.LEFT)){
            vX-=1;
        }
        if(e.getCode().equals(KeyCode.RIGHT)){
            vX+=1;
        }

    }
}
