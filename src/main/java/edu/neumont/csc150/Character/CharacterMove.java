package edu.neumont.csc150.Character;

import com.sun.webkit.dom.KeyboardEventImpl;
import edu.neumont.csc150.Items.Sell;
import edu.neumont.csc150.Screen.*;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

import static edu.neumont.csc150.Screen.WinScreen.win;


public class CharacterMove implements EventHandler <KeyEvent> {
    CountDown c = new CountDown();

    @FXML
    private Canvas mainCanvas;

    private int ballx = 460, bally = 540, ballwidth = 50, ballheight = 50;


    private int vX = 20, vY = 20;

    Sell sell = new Sell();

    private CharacterPickUp items = new CharacterPickUp();

    private int exity = 536, exitx = 410, exitwidth = 164, exitheight = 45;
    private Image e = new Image("Images/Exit.png", exitwidth, exitheight, true, true);
    private ImageView exit = new ImageView(e);


    @FXML
    private Label money;

    @FXML
    private Label moneytwo;

    @FXML
    private ImageView one;
    @FXML
    private ImageView two;
    @FXML
    private ImageView three;
    @FXML
    private ImageView four;
    @FXML
    private ImageView five;
    @FXML
    private ImageView six;
    @FXML
    private ImageView seven;
    @FXML
    private ImageView eight;
    @FXML
    private ImageView nine;
    @FXML
    private ImageView ten;
    @FXML
    private ImageView eleven;
    @FXML
    private ImageView twelve;
    @FXML
    private ImageView thirteen;

    private Image p = new Image("Images/ghost.png");
    private ImageView person = new ImageView(p);

    @FXML
    private void initialize() throws Exception {
        moneytwo.setStyle("-fx-font: 26 arial;");
        moneytwo.setText("Money: ");
        moneytwo.setTextFill(Color.WHITESMOKE);
        money.setText(String.valueOf(sell.sumValue()));
        money.setTextFill(Color.GREEN);
        money.setStyle("-fx-font: 26 arial;");

    }

    private void makeItem() {

        one.setImage(items.getItems().get(0).getImage());
        two.setImage(items.getItems().get(1).getImage());
        three.setImage(items.getItems().get(2).getImage());
        four.setImage(items.getItems().get(3).getImage());
        five.setImage(items.getItems().get(4).getImage());
        six.setImage(items.getItems().get(5).getImage());
        seven.setImage(items.getItems().get(6).getImage());
        eight.setImage(items.getItems().get(7).getImage());
        nine.setImage(items.getItems().get(8).getImage());
        ten.setImage(items.getItems().get(9).getImage());
        eleven.setImage(items.getItems().get(10).getImage());
        twelve.setImage(items.getItems().get(11).getImage());
        thirteen.setImage(items.getItems().get(12).getImage());


    }

    public void init() {
        makeItem();
        Timeline timer = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            try {
                draw();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }));

        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    public void draw() throws Exception {
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();

        gc.setFill(Color.rgb(40, 13, 75));
        gc.fillRect(0, 0, this.mainCanvas.getWidth(), this.mainCanvas.getHeight());

        gc.drawImage(exit.getImage(), exitx, exity);

        gc.drawImage(person.getImage(), ballx, bally, ballwidth, ballheight);

        this.initialize();


    }


    @FXML
    public Rectangle rectone;
    @FXML
    public Rectangle recttwo;
    @FXML
    public Rectangle rectthree;
    @FXML
    public Rectangle rectfour;
    @FXML
    public Rectangle rectfive;
    @FXML
    public Rectangle rectsix;
    @FXML
    public Rectangle rectseven;
    @FXML
    public Rectangle recteight;
    @FXML
    public Rectangle rectnine;

    public boolean checkbounce() {
        if (bally + ballheight >= this.mainCanvas.getHeight()) {
            bally = bally - vY;
            return true;
        }
        if (ballx + ballwidth >= this.mainCanvas.getWidth()) {
            ballx = ballx - vX;
            return true;
        }
        if (bally <= 0) {
//            vY*=-1;
            bally *= 0;
            return true;
        }
        if (ballx <= 0) {
//            vX *=-1;
            ballx *= 0;
            return true;
        }
        if (vX == 2 || vY == 2) {




        }else if (collideRec(rectone) || collideRec(recttwo) || collideRec(rectthree) || collideRec(rectfour) || collideRec(rectfive) || collideRec(rectsix) || collideRec(rectseven) || collideRec(recteight) || collideRec(rectnine)) {
            slow();
        }


        return false;

    }



    public void slow(){
        vX -= 2;
        vY -= 2;
    }

    public boolean Hardcheckbounce() {
        if (bally + ballheight >= this.mainCanvas.getHeight() || bally <= 0) {
            vY *= -1;
            return true;
        }
        if (ballx + ballwidth >= this.mainCanvas.getWidth() || ballx <= 0) {
            vX *= -1;
            return true;
        }
        return false;

    }

    private int addMonies(int x) {
        return items.getItems().get(x).getValue();
    }


    public void pickup() {
        //Find out the position and see if an image is in that position
        //Make image invisiable so the person cannot click it
        //Add up currency

        if (collide(one)) {
            System.out.println("Cox");
            if (one.getImage() != null) {
                one.setImage(null);
                sell.addMoney(addMonies(0));
                try {
                    winCox();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            one.setVisible(false);

        }
        if (collide(two)) {
            System.out.println("2");
            if (two.getImage() != null) {
                two.setImage(null);
                sell.addMoney(addMonies(1));
            }
            two.setVisible(false);  //makes items disapear

        }
        if (collide(three)) {
            System.out.println("3");
            if (three.getImage() != null) {
                three.setImage(null);
                sell.addMoney(addMonies(2));
            }
            three.setVisible(false);
        }

        if (collide(four)) {
            System.out.println("4");
            if (four.getImage() != null) {
                four.setImage(null);
                sell.addMoney(addMonies(3));
            }
            four.setVisible(false);
        }
        if (collide(five)) {
            System.out.println("5");
            if (five.getImage() != null) {
                five.setImage(null);
                sell.addMoney(addMonies(4));
            }
            five.setVisible(false);
        }
        if (collide(six)) {
            System.out.println("6");
            if (six.getImage() != null) {
                six.setImage(null);
                sell.addMoney(addMonies(5));
            }
            six.setVisible(false);
        }
        if (collide(seven)) {
            System.out.println("7");
            if (seven.getImage() != null) {
                seven.setImage(null);
                sell.addMoney(addMonies(6));
            }
            seven.setVisible(false);
        }
        if (collide(eight)) {
            System.out.println("8");
            if (eight.getImage() != null) {
                eight.setImage(null);
                sell.addMoney(addMonies(7));
            }
            eight.setVisible(false);
        }
        if (collide(nine)) {
            System.out.println("9");
            sell.addMoney(addMonies(8));
            nine.setVisible(false);
        }
        if (collide(ten)) {
            System.out.println("10");
            if (ten.getImage() != null) {
                ten.setImage(null);
                sell.addMoney(addMonies(9));
            }
            ten.setVisible(false);
        }
        if (collide(eleven)) {
            System.out.println("11");
            if (eleven.getImage() != null) {
                eleven.setImage(null);
                sell.addMoney(addMonies(10));
            }
            eleven.setVisible(false);
        }
        if (collide(twelve)) {
            System.out.println("12");
            if (twelve.getImage() != null) {
                twelve.setImage(null);
                sell.addMoney(addMonies(11));
            }
            twelve.setVisible(false);
        }
        if (collide(thirteen)) {
            System.out.println("13");
            if (thirteen.getImage() != null) {
                thirteen.setImage(null);
                sell.addMoney(addMonies(12));
            }
            thirteen.setVisible(false);
        }
        if (perGetBoundary().intersects(exitSign())) {
            System.out.println("exit");
            try {
                checkWin();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }


    }

    public Rectangle2D getBoundary(ImageView x) {
        return new Rectangle2D(x.getLayoutX(), x.getLayoutY(), x.getFitWidth(), x.getFitHeight());
    }

    public Rectangle2D perGetBoundary() {
        return new Rectangle2D(ballx, bally, ballwidth, ballheight);
    }

    public Rectangle2D getRecBoundary(Rectangle x) {
        return new Rectangle2D(x.getLayoutX(), x.getLayoutY(), x.getWidth(), x.getHeight());
    }

    public boolean collide(ImageView x) {
        return perGetBoundary().intersects(getBoundary(x));
    }

    public boolean collideRec(Rectangle x) {
        return perGetBoundary().intersects(getRecBoundary(x));
    }

    public Rectangle2D exitSign() {
        return new Rectangle2D(exitx, exity, exitwidth, exitheight);
    }

    public boolean IntersectRec(Rectangle x) {
        return personColideRec().intersects(x.getBoundsInParent());
    }

    public Rectangle personColideRec() {
        return new Rectangle(ballx, bally, ballwidth, ballheight);
    }


    @Override
    public void handle(KeyEvent e) {

                if (e.getCode().equals(KeyCode.UP) || e.getCode().equals(KeyCode.W)) {

                    System.out.println("UP key was pressed");
                    this.checkbounce();
                    bally -= vY;

                }
                if (e.getCode().equals(KeyCode.DOWN) || e.getCode().equals(KeyCode.S)) {
                    System.out.println("Down key was pressed");

                    this.checkbounce();
                    bally += vY;


                }
                if (e.getCode().equals(KeyCode.LEFT) || e.getCode().equals(KeyCode.A)) {
                    System.out.println("Left key was pressed");

                    this.checkbounce();
                    ballx -= vX;


                }
                if (e.getCode().equals(KeyCode.RIGHT) || e.getCode().equals(KeyCode.D)) {
                    System.out.println("Right key was pressed");

                    this.checkbounce();
                    ballx += vX;


                }

                if (e.getCode().equals(KeyCode.SPACE) || e.getCode().equals(KeyCode.D)) {
                    System.out.println("Space key was pressed");
                    pickup();

                }

    }

    public void checkWin() throws Exception {
        if (sell.checkMoney()) {
            win();

        } else {
            loose();

        }
    }

    public void winCox () throws Exception {
        CoxFound coxFound = new CoxFound();
        Stage stage = (Stage) this.rectthree.getScene().getWindow();
        stage.close();
        coxFound.start(CoxFound.cox);
        c.secondStage.close();
    }

    public void win () throws Exception {
        WinScreen winScreen = new WinScreen();
        Stage stage = (Stage) this.recttwo.getScene().getWindow();
        stage.close();
        winScreen.start(WinScreen.win);

        c.secondStage.close();
    }

    public void loose () throws Exception {
        Looser looser = new Looser();
        Stage stage = (Stage) this.rectthree.getScene().getWindow();
        stage.close();
        looser.start(Looser.lose);

        c.secondStage.close();

    }
}
