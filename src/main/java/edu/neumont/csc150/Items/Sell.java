package edu.neumont.csc150.Items;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * adds the items together to reach the goal of $10000
 * @author Ashley, Marisol, Matthew
 */
public class Sell {
        private static final long serialVersionUID = 1L;

        public int accumulator = 0;

    /**
     * checks money to see if it is 10000
     * @return boolean
     */
    public boolean checkMoney() {
        if (getAccumulator() >= 10000){
            return true;
        }
        if (getAccumulator() < 10000){
            return false;
        }
        return false;
    }

    /**
     * returns the sum of total Money gained
     * @return
     */
    public int sumValue() {
                return this.getAccumulator();
        }

    /**
     * getter for Accumlator
     * @return
     */
    public int getAccumulator() {
        return accumulator;
    }

    /**
     * adds money to accumlator
     * @param x - int
     */
    public void addMoney(int x){
        this.accumulator += x;
    }



}
