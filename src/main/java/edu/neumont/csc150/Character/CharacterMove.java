package edu.neumont.csc150.Character;

import com.sun.webkit.dom.KeyboardEventImpl;
import edu.neumont.csc150.Items.Sell;
import edu.neumont.csc150.Screen.CountDown;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CharacterMove implements EventHandler <KeyEvent> {

    @FXML
    private Canvas mainCanvas;

    private int ballx = 460,bally = 540,ballwidth =50,ballheight=50;

    private int vX = 20 , vY = 20;

    Sell sell = new Sell();
    CountDown time = new CountDown();

    @FXML
    private Label money;
    @FXML
    private Label count;

    @FXML
    private void initialize() {
        money.setText(String.valueOf(sell.sumValue()));
       // count.setText(time.doTime());
    }

    public void init() {
        Timeline timer = new Timeline(new KeyFrame(Duration.millis(10), e -> draw()));

        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }



    public void draw() {
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();

        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,this.mainCanvas.getWidth(),this.mainCanvas.getHeight());

        gc.setFill(Color.BLUE);
        gc.fillOval(ballx,bally,ballwidth,ballheight);


    }

    public boolean checkbounce(){
        if(bally + ballheight >= this.mainCanvas.getHeight() || bally <=0){
            vY*=-1;
            return true;
        }
        if(ballx + ballwidth >= this.mainCanvas.getWidth() || ballx <= 0){
            vX *=-1;
            return true;
        }
        return false;

    }
    @Override
    public void handle(KeyEvent e) {
            if(e.getCode().equals(KeyCode.UP) || e.getCode().equals(KeyCode.W)) {
                System.out.println("UP key was pressed");

                this.checkbounce();
                bally -=vY;

            }
            if(e.getCode().equals(KeyCode.DOWN)|| e.getCode().equals(KeyCode.S)){
                System.out.println("Down key was pressed");

                this.checkbounce();
                bally +=vY;

            }
             if(e.getCode().equals(KeyCode.LEFT) || e.getCode().equals(KeyCode.A)){
            System.out.println("Left key was pressed");

                this.checkbounce();
                ballx-=vX;

            }
             if(e.getCode().equals(KeyCode.RIGHT) || e.getCode().equals(KeyCode.D)){
            System.out.println("Right key was pressed");

                this.checkbounce();
                ballx+=vX;

            }

        if(e.getCode().equals(KeyCode.SPACE) || e.getCode().equals(KeyCode.D)) {
            System.out.println("Space key was pressed");
        }


    }
}
