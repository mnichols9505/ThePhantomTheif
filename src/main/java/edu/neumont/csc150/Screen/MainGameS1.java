package edu.neumont.csc150.Screen;

import edu.neumont.csc150.Character.PhantomController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * controller to start the game
 * @author Ashley, Marisol, Matthew
 */
public class MainGameS1 extends Application {

    public static Stage Gamestage = new Stage();
    public static CountDown easy;

    /**
     * Default Constructor
     */
    public MainGameS1(){ }

    /**
     * Constructor for MainGameS1
     * @param countDown - a timer
     */
    public MainGameS1 (CountDown countDown){

        this.easy = countDown;
    }

    /**
     * Starts the game screen
     * @param stage
     * @throws Exception
     */
    public void start(Stage stage) throws Exception {



        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/Gameplay.fxml"));
        Parent root = loader.load();


        Scene scene = new Scene(root);

        Gamestage = stage;
        Gamestage.setScene(scene);
        Gamestage.setTitle("The Phantom Thief");
        Gamestage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Emoji_u1f319.svg/2000px-Emoji_u1f319.svg.png"));
        Gamestage.show();

        PhantomController dude = loader.getController();
        scene.setOnKeyPressed(dude);
        dude.init();


    }

    /**
     * Closes game Screen
     */
    public void gameClose(){
        Stage stage = (Stage) Gamestage.getScene().getWindow();
        stage.close();
    }

    /**
     * returns easy
     * @return easy
     */
    public CountDown getEasy() {
        return easy;
    }

    /**
     * sets easy
     * @param easy - Countdown
     */
    public void setEasy(CountDown easy) {
        this.easy = easy;
    }

}




