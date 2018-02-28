package edu.neumont.csc150.Items;

import javafx.scene.image.ImageView;

public abstract class Cash extends CurrencyPiece{

    private ImageView image;

    public Cash() {

    }


    public Cash(int value, String imageURL) {
        super(value);


        this.image = new ImageView(imageURL);
        this.image.setFitHeight(30);
        this.image.setFitWidth(30);
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
