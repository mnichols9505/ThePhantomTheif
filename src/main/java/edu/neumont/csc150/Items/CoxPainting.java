package edu.neumont.csc150.Items;

public class CoxPainting extends Cash {

    public CoxPainting() {
        super(10000);
    }
    @Override
    int getAllowedDenomination() {
        return 10000;
    }

}
