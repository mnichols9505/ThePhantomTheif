package edu.neumont.csc150.Items;

public class Sculpture extends Cash{

    public Sculpture(){
        super(500,"Images/sculpture.png");
    }
    @Override
    int getAllowedDenomination() {

        return 500;
    }

}
