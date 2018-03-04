package edu.neumont.csc150.Items;

public class Painting extends Cash{
    /**
     * default constructor
     */
    public Painting(){

        super(3000,"Images/painting.png");
    }

    /**
     * sets allowed ammount
     * @return
     */
    @Override
    int getAllowedDenomination() {

        return 3000;
    }
}
