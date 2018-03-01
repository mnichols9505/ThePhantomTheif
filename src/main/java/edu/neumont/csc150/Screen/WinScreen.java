package edu.neumont.csc150.Screen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class WinScreen extends Application{

    public static Stage win = new Stage();


    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("fxml/WinningScreen.fxml"));

        Scene scene = new Scene(root);

        win = stage;
        win.setScene(scene);
        win.setTitle("The Phantom Thief");
        win.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Emoji_u1f319.svg/2000px-Emoji_u1f319.svg.png"));
        win.show();

    }

}
