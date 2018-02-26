package edu.neumont.csc150.Screen;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainGameS1 extends Application {

@FXML
    private Canvas mainCanvas;

private int x = 0, y= 0, ballwidth = 10, ballheight = 10;
private int volx = 0, voly = 0;
static Stage Gamestage = new Stage();

public void draw(){

    GraphicsContext gc = mainCanvas.getGraphicsContext2D();
    gc.setFill(Color.AQUA);
    gc.fillOval(x,y,ballwidth,ballheight);

}


    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("fxml/Gameplay.fxml"));

        Scene scene = new Scene(root);
        Gamestage.setScene(scene);
        Gamestage.show();

        draw();

    }
}
