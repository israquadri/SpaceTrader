package src;
import java.util.ArrayList;
import java.util.Random;

public class Market {
    private String name;
    private ArrayList<Item> items;
    private double tax;
    private Item itemWanted;
    private int techLevel;

    public Market(String name, int techLevel) {
        this.name = name;
        this.tax = new Random().nextDouble();
        this.techLevel = techLevel;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * Gets items.
     * @return Value of items.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getItemWanted() {
        return itemWanted;
    }

    public void setItemWanted(Item itemWanted) {
        this.itemWanted = itemWanted;
    }

}
