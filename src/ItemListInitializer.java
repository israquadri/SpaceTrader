package src;
import java.util.ArrayList;

public class ItemListInitializer {
    /**
     * Item list initializer
     * @param techLevel
     * @param merchantSkill
     * @param tax
     * @param itemNames
     * @return list of items
     */
    public ArrayList<Item> createItemList(int techLevel, int merchantSkill, double tax, String[] itemNames) {
        ArrayList<Item> items = new ArrayList<>();
        //initialize quantity
        int[] quantity = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < itemNames.length; i++) {
            Item item = new Item(tax, merchantSkill, techLevel, itemNames[i], quantity[i]);
            items.add(item);
        }
        return items;
    }
}
