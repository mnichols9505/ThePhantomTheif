package edu.neumont.csc150.Items;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * sets image of item and collects price data when picked up
 * @author Ashley, Marisol, Matthew
 */
public abstract class Cash extends CurrencyPiece{

    private Image image;

    /**
     * Default constructor
     */
    public Cash() {

    }

    /**
     * Constuctor to set image
     * @param value - int
     * @param imageURL - String
     */
    public Cash(int value, String imageURL) {
        super(value);


        this.image = new Image(imageURL);

    }

    /**
     * Getter for Image
     * @return
     */
    public Image getImage() {
        return image;
    }

    /**
     * setter for Image
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
    }
}
