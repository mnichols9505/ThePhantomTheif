package edu.neumont.csc150.Items;

import java.io.Serializable;

abstract public class CurrencyPiece implements Comparable<CurrencyPiece> {

    private int value;

    public CurrencyPiece() {

    }

    public CurrencyPiece(int value) {
        this.setValue(value);
    }

    public int getValue() {
        return value;
    }

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
