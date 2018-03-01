package edu.neumont.csc150.Items;

import java.io.Serializable;
import java.util.ArrayList;

public class Sell {
        private static final long serialVersionUID = 1L;

        public int accumulator = 0;

    public boolean checkMoney() {
        if (getAccumulator() >= 10000){
            return true;
        }
        if (getAccumulator() < 10000){
            return false;
        }
        return false;
    }

    public int sumValue() {
                return this.getAccumulator();
        }


    public int getAccumulator() {
        return accumulator;
    }

    public void addMoney(int x){
        this.accumulator += x;
    }



}
