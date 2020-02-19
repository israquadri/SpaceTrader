package src;
import java.util.ArrayList;

public class Market {
    private String name;
    private ArrayList<Item> items;
    private double tax;
    private Item itemWanted;

    public Market(String name, ArrayList<Item> items, double tax) {
        this.name = name;
        this.items = items;
        this.tax = tax;
    }

    public Item getItemWanted() {
        return itemWanted;
    }

    public void setItemWanted(Item itemWanted) {
        this.itemWanted = itemWanted;
    }
}
