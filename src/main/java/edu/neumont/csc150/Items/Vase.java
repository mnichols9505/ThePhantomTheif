package edu.neumont.csc150.Items;

/**
 * sets the value of the vase when one is picked up
 * @author Ashley, Marisol, Matthew
 */
public class Vase extends Cash{
    /**
     * default constructor
     */
    public Vase(){
        super(100,"Images/vase.png");

        }
        @Override
        int getAllowedDenomination(){
            return 100;
        }
    }

