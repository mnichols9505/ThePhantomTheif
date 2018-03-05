package edu.neumont.csc150.Items;

/**
 * sets the value of a painting when picked up
 * @author Ashley, Marisol, Matthew
 */
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
