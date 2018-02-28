package edu.neumont.csc150.Items;

public class Vase extends Cash{
    public Vase(){
        super(100,"Images/vase.png");

        }
        @Override
        int getAllowedDenomination(){
            return 100;
        }
    }

