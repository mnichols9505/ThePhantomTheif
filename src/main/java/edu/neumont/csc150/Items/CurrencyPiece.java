package edu.neumont.csc150.Items;

import java.io.Serializable;

/**
 * is the parent of both cash and sell and sets the value of items
 * @author Ashley, Marisol, Matthew
 */
abstract public class CurrencyPiece implements Comparable<CurrencyPiece> {

    private int value;

    /**
     * Default constructor
     */
    public CurrencyPiece() {

    }

    /**
     * constructor
     * @param value - int
     */
    public CurrencyPiece(int value) {
        this.setValue(value);
    }

    /**
     * getter for value
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * setter for value
     * @param value
     */
    public void setValue(int value) {
        int allowedDenomination = getAllowedDenomination();
        if (value != allowedDenomination) {
            throw new IllegalArgumentException("wrong denomination");
        }
        this.value = value;
    }

    abstract int getAllowedDenomination();

    @Override
    public boolean equals(Object obj) {
        CurrencyPiece other = (CurrencyPiece) obj;
        return this.getValue() == other.getValue();
    }

    @Override
    public String toString() {
        return "Item Sold for=" + this.getValue();
    }
    public int compareTo(CurrencyPiece o) {

        return Double.compare(this.getValue(), o.getValue());
    }


}
