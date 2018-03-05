package edu.neumont.csc150.Character;

import edu.neumont.csc150.Items.*;

import java.util.ArrayList;
import java.util.List;

/**
 * intitalizes items array
 * @author Ashley, Marisol, Matthew
 */
public class CharacterPickUp{

    private List<Cash> items = new ArrayList<>();

    public CharacterPickUp(){
        this.makeItem();
    }

    /**
     * intlizes all the items
     */
    public void makeItem(){

        //Automatic - $10,000 index 0
        items.add(new CoxPainting());
        items.add(new Vase());
        items.add(new Statue());
        items.add(new Vase());
        items.add(new Painting());
        items.add(new Sculpture());
        items.add(new Vase());
        items.add(new Painting());
        items.add(new Vase());
        items.add(new Sculpture());
        items.add(new Vase());
        items.add(new Vase());
        items.add(new Painting());

        //6 vases 3 painting 2 sculpture 1 statue



    }

    /**
     * getter for Items
     * @return
     */
    public List<Cash> getItems() {
        return items;
    }

    /**
     * Setter for Items
     * @param items
     */
    public void setItems(List<Cash> items) {
        this.items = items;
    }
}
