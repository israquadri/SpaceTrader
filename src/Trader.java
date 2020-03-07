package src;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Trader {
    private ArrayList<Item> inventory;
    private Player player;
    private Item itemToSell;
    private boolean alreadyNegotiated = false;

    public Trader(String[] itemNames, Player p1) {
        this.player = p1;
        int randomTechLevel = new Random().nextInt(8) + 1;
        int merchantSkill = player.getMerchantSkill();
        double tax = new Random().nextDouble();
        ItemListInitializer itemInit = new ItemListInitializer();
        inventory = itemInit.createTraderItemList(randomTechLevel, merchantSkill, tax, itemNames);
        itemToSell = inventory.get(new Random().nextInt(inventory.size()));
    }

    public boolean determineSuccess(int skillLevel) {
        if (skillLevel == 0) {return false;}
        return (new Random().nextInt(8) + 1 <=  skillLevel);
    }

    //halves the buyPrice of itemToSell
    public void decreasePrice() {
        //price halved
        //is it okay if the price becomes 0?
        itemToSell.setBuyPrice(itemToSell.getBuyPrice() / 2);
    }

    //doubles the buyPrice of itemToSell
    public void increasePrice() {
        //price doubled
        itemToSell.setBuyPrice(itemToSell.getBuyPrice() * 2);
    }

    public boolean getNegotiationStatus() {
        return this.alreadyNegotiated;
    }

    public void makeNegotiationComplete() {
        this.alreadyNegotiated = true;
    }

    /**
     * Gets inventory.
     *
     * @return Value of inventory.
     */
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    /**
     * Gets itemToSell.
     *
     * @return Value of itemToSell.
     */
    public Item getItemToSell() {
        return itemToSell;
    }
}
