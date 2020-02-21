package src;
import java.util.ArrayList;
import java.util.Random;

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
        Random randomQuantity = new Random();
        for (int i = 0; i < itemNames.length; i++) {
            Item item = new Item(tax, merchantSkill, techLevel, itemNames[i], randomQuantity.nextInt(7) + 1);
            items.add(item);
        }
        return items;
    }
}
