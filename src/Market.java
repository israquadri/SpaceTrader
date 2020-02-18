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

    public int findInventoryIndex(SpaceShip spaceShip, Item item) {
        int index = 0;
        for (int i = 0; i < spaceShip.getInventory().size(); i++) {
            if (spaceShip.getInventory().get(i).equals(item.getName())) {
                index = i;
            } else {
                //throw exception because it isnt there
            }
        }
        return index;
    }

    public Item getItemWanted() {
        return itemWanted;
    }

    public void setItemWanted(Item itemWanted) {
        this.itemWanted = itemWanted;
    }
}
