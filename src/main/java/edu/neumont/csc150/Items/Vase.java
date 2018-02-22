package edu.neumont.csc150.Items;

public class Vase extends Cash{
    public Vase(){
        super(100);

        }
        @Override
        int getAllowedDenomination(){
            return 100;
        }
    }

