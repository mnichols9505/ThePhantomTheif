package edu.neumont.csc150.Items;

public class Sculpture extends Cash{

    public Sculpture(){
        super(500);
    }
    @Override
    int getAllowedDenomination() {
        return 300;
    }

}
