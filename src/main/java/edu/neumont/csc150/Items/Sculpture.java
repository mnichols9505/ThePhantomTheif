package edu.neumont.csc150.Items;

/**
 * sets the value of the sculpture
 * @author Ashley, Marisol, Matthew
 */
public class Sculpture extends Cash{

    /**
     * default constructor
     */
    public Sculpture(){
        super(500,"Images/sculpture.png");
    }
    @Override
    int getAllowedDenomination() {

        return 500;
    }

}
