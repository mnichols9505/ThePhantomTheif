package edu.neumont.csc150.Items;

/**
 * sets value when a statue is picked up
 * @author Ashley, Marisol, Matthew
 */
public class Statue extends Cash {

    /**
     * default constructor
     */
    public Statue(){
        super(400,"Images/statue.png");
    }
    @Override
    int getAllowedDenomination() {
        return 400;
    }
}
