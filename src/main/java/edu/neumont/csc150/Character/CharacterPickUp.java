package edu.neumont.csc150.Character;

import edu.neumont.csc150.Items.*;

import java.util.ArrayList;
import java.util.List;

public class CharacterPickUp{

    private List<Cash> items = new ArrayList<>();

    public CharacterPickUp(){
        this.makeItem();
    }

    public void makeItem(){

        //Automatic - $10,000 index 0
        items.add(new CoxPainting());

        while(!check()) {
            for (int x = 0; x < 7; x++) {
                items.add(randItem());
            }
        }

    }

    public Cash randItem(){
        int num =  (int)((Math.random()*5)+1);

        switch (num){
            case 1:
                return new Vase();
            case 2:
                return new Statue();
            case 3:
                return new Sculpture();
            case 4:
                return new Painting();
             default:
                 return null;
        }
    }

    public boolean check(){

        int cash = 0;

        for(Cash e : this.items){
            cash += e.getValue();
        }

        if(cash == 20000){
            return true;
        }
        else{
            return false;
        }

    }

    public List<Cash> getItems() {
        return items;
    }

    public void setItems(List<Cash> items) {
        this.items = items;
    }
}
