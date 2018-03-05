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

/**aaaaaaaa
 * controller for the normal win screen
 * @author Ashley, Marisol, Matthew
 */
public class WinScreen extends Application{

    public static Stage win = new Stage();

    /**
     * Win screen is called and showed
     * @param stage
     * @throws Exception
     */
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(this.getClass().getClassLoader().getResource("fxml/WinningScreen.fxml"));

        Scene scene = new Scene(root);

        win = stage;
        win.setScene(scene);
        win.setTitle("The Phantom Thief");
        win.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Emoji_u1f319.svg/2000px-Emoji_u1f319.svg.png"));
        win.show();

    }

    @FXML
    public Button word;

    /**
     * Takes you back to the title screen when you click the replay button
     * @param event
     * @throws Exception
     */
    @FXML
    public void replay(MouseEvent event) throws Exception {

        Stage stage = (Stage) word.getScene().getWindow();
        stage.close();
        StartScreen startScreen = new StartScreen();
        startScreen.start(StartScreen.startstage);

    }
}
