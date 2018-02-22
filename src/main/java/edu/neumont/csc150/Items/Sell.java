package edu.neumont.csc150.Items;

import java.io.Serializable;
import java.util.ArrayList;

public class Sell extends ArrayList<CurrencyPiece>  {
        private static final long serialVersionUID = 1L;

        public int sumValue() {
            int accumulator = 0;
            for(CurrencyPiece piece : this) {
                accumulator += piece.getValue();
            }
            return accumulator;
        }
}
