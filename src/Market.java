package src;
import java.util.ArrayList;

public class Market {
    private String name;
    private ArrayList<Item> items;
    private double tax;
    public Market(String name, ArrayList<Item> items, double tax) {
        this.name = name;
        this.items = items;
        this.tax = tax;
    }

}
