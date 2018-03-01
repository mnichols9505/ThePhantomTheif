package edu.neumont.csc150.Screen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Looser extends Application {

    public static Stage lose = new Stage();


    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("fxml/LosingScreen.fxml"));

        Scene scene = new Scene(root);

        lose = stage;
        lose.setScene(scene);
        lose.setTitle("The Phantom Thief");
        lose.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Emoji_u1f319.svg/2000px-Emoji_u1f319.svg.png"));
        lose.show();

    }

}
