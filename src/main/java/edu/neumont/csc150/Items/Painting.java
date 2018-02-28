package edu.neumont.csc150.Items;

public class Painting extends Cash{
    public Painting(){

        super(3000,"Images/painting.png");
    }
    @Override
    int getAllowedDenomination() {

        return 3000;
    }
}
