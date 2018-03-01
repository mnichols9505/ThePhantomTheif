package edu.neumont.csc150.Character;

import com.sun.webkit.dom.KeyboardEventImpl;
import edu.neumont.csc150.Items.Sell;
import edu.neumont.csc150.Screen.CountDown;
import edu.neumont.csc150.Screen.PickYourPoison;
import edu.neumont.csc150.Screen.timer;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
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

import java.util.ArrayList;


public class CharacterMove implements EventHandler <KeyEvent> {


    @FXML
    private Canvas mainCanvas;

    private int ballx = 460, bally = 540, ballwidth = 50, ballheight = 50;

    private int vX = 20, vY = 20;

    Sell sell = new Sell();

    private CharacterPickUp items = new CharacterPickUp();

    private Image exit = new Image("Images/Exit.png", 164, 45, true, true);


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

    private Image sec = new Image("Images/30clock.gif", 50, 50, false, false);
    private Image secHard = new Image("Images/90 Second.gif", 50, 50, false , false);
    public ImageView timerview;
    timer timer = new timer();


    PickYourPoison pp = new PickYourPoison();

//    private void chooseImage() {
//
//    if(pp.poison == true){
//
//        timerview = new ImageView(sec);
//    }
//    if(pp.poison == false){
//        timerview= new ImageView(secHard);
//    }
//    }


    @FXML
    private void initialize() {
        moneytwo.setStyle("-fx-font: 26 arial;");
        moneytwo.setText("Money: ");
        moneytwo.setTextFill(Color.WHITESMOKE);
        money.setText(String.valueOf(sell.sumValue()));
        money.setTextFill(Color.GREEN);
        money.setStyle("-fx-font: 26 arial;");
       // count.setText(time.doTime());
    }

    public void init() {
        Timeline timer = new Timeline(new KeyFrame(Duration.millis(10), e -> draw()));

        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }


//    public Image clock(){
//        if(timer.getPoisonTime()){
//            return new Image("Images/30clock.gif", 50, 50, false, false);
//        }
//        else{
//            return new Image("Images/90 Second.gif", 50, 50, false , false);
//        }
//    }
    public void draw() {
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();

        gc.setFill(Color.rgb(40,13,75));
        gc.fillRect(0,0,this.mainCanvas.getWidth(),this.mainCanvas.getHeight());

         gc.drawImage(sec,850,50);



        gc.drawImage(exit,410,536);

       // gc.setFill(Color.rgb(200, 172, 239));
        // gc.fillOval(ballx,bally,ballwidth,ballheight);

        gc.drawImage(person.getImage(),ballx,bally,ballwidth,ballheight);

      //  gc.drawImage(person,ballx,bally,ballwidth,ballheight);

      //  gc.drawImage(timerview.getImage(), ballx, bally, ballwidth, ballheight);




        this.initialize();

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

    public boolean checkbounce(){
        if (bally + ballheight >= this.mainCanvas.getHeight()){
            bally = bally - vY;
            return true;
        }
        if (ballx + ballwidth >= this.mainCanvas.getWidth()){
            ballx = ballx - vX;
            return true;
        }
        if(bally <=0){
//            vY*=-1;
            bally *= 0;
            return true;
        }
        if(ballx <= 0){
//            vX *=-1;
            ballx *= 0;
            return true;
        }
        if (collideRec(rectone)){


        }
        return false;

    }
    public boolean Hardcheckbounce(){
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

    private int addMonies(int x){
        return items.getItems().get(x).getValue();
    }

    public void pickup(){
        //Find out the position and see if an image is in that position
        //Make image invisiable so the person cannot click it
        //Add up currency

        if(collide(one)){
            System.out.println("Cox");
            sell.addMoney(addMonies(0));
            one.setVisible(false);
        }
        if(collide(two)){
            System.out.println("2");
            sell.addMoney(addMonies(1));
            two.setVisible(false);  //makes items disapear
        }
        if(collide(three)){
            System.out.println("3");
            sell.addMoney(addMonies(2));
            three.setVisible(false);
        }

        if(collide(four)){
            System.out.println("4");
            sell.addMoney(addMonies(3));
            four.setVisible(false);
        }
        if(collide(five)){
            System.out.println("5");
            sell.addMoney(addMonies(4));
            five.setVisible(false);
        }
        if(collide(six)){
            System.out.println("6");
            sell.addMoney(addMonies(5));
            six.setVisible(false);
        }
        if(collide(seven)){
            System.out.println("7");
            sell.addMoney(addMonies(6));
            seven.setVisible(false);
        }
        if(collide(eight)){
            System.out.println("8");
            sell.addMoney(addMonies(7));
            eight.setVisible(false);
        }
        if(collide(nine)){
            System.out.println("9");
            sell.addMoney(addMonies(8));
            nine.setVisible(false);
        }
        if(collide(ten)){
            System.out.println("10");
            sell.addMoney(addMonies(9));
            ten.setVisible(false);
        }
        if(collide(eleven)){
            System.out.println("11");
            sell.addMoney(addMonies(10));
            eleven.setVisible(false);
        }
        if(collide(twelve)){
            System.out.println("12");
            sell.addMoney(addMonies(11));
            twelve.setVisible(false);
        }
        if(collide(thirteen)){
            System.out.println("13");
            sell.addMoney(addMonies(12));
            thirteen.setVisible(false);
        }

    }

    public Rectangle2D getBoundary(ImageView x){
        return new Rectangle2D(x.getLayoutX(),x.getLayoutY(),x.getFitWidth(),x.getFitHeight());
    }

    public Rectangle2D perGetBoundary(){
        return new Rectangle2D(ballx,bally,ballwidth,ballheight);
    }
    public Rectangle2D getRecBoundary(Rectangle x){
        return new Rectangle2D(x.getLayoutX(),x.getLayoutY(),x.getWidth(),x.getHeight());
    }
    public boolean collide(ImageView x){
        return perGetBoundary().intersects(getBoundary(x));
    }
    public boolean collideRec(Rectangle x){
        return perGetBoundary().intersects(getRecBoundary(x));
    }


    @Override
    public void handle(KeyEvent e) {
            if(e.getCode().equals(KeyCode.UP) || e.getCode().equals(KeyCode.W)) {
                System.out.println("UP key was pressed");
                this.checkbounce();
                if (collideRec(rectone)){


                }else {
                    bally -=vY;
                }




            }
            if(e.getCode().equals(KeyCode.DOWN)|| e.getCode().equals(KeyCode.S)){
                System.out.println("Down key was pressed");

                this.checkbounce();

                if (collideRec(rectone)){


                }else {
                    bally +=vY;
                }


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
                pickup();

        }


    }
}
