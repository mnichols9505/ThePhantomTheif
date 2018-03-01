package edu.neumont.csc150.Items;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Cash extends CurrencyPiece{

    private Image image;

    public Cash() {
        //ha ba ba

    }


    public Cash(int value, String imageURL) {
        super(value);


        this.image = new Image(imageURL);

    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
