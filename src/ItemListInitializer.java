package src;
import java.util.ArrayList;
import java.util.Random;

public class ItemListInitializer {
    /**
     * Item list initializer
     * @param techLevel region tech level
     * @param merchantSkill merchant skill
     * @param tax region tax
     * @param itemNames region item namesx
     * @return list of items
     */
    public ArrayList<Item> createItemList(int techLevel,
                                          int merchantSkill, double tax, String[] itemNames) {
        ArrayList<Item> items = new ArrayList<>();
        //initialize quantity
        for (int i = 0; i < itemNames.length; i++) {
            int basePrice = new Random().nextInt(11) + 30;
            Item item = new Item(tax, merchantSkill, techLevel, itemNames[i],
                    new Random().nextInt(7) + 1, basePrice);
            items.add(item);
        }
        return items;
    }
    //quantity range is reduced [1,4] per item
    public ArrayList<Item> createTraderItemList(int techLevel,
                                          int merchantSkill, double tax, String[] itemNames) {
        ArrayList<Item> items = new ArrayList<>();
        //initialize quantity
        for (int i = 0; i < itemNames.length; i++) {
            int basePrice = new Random().nextInt(11) + 30;
            Item item = new Item(tax, merchantSkill, techLevel, itemNames[i],
                    new Random().nextInt(3) + 1, basePrice, true);
            items.add(item);
        }
        return items;
    }
}
