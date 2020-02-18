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

    public void sellGoods(Region region, Item item, SpaceShip spaceShip, Player player) {
        spaceShip.getInventory().remove(item);
        player.setCredits(player.getCredits() + (int)item.getSellPrice());
        spaceShip.inventorySize--;
    }

    public void buyGoods(Region region, Item item, SpaceShip spaceShip, Player player) {
        if (spaceShip.getInventory().size() < spaceShip.getCargoCapacity()) {
            if (item.getName().equals("fuel")) {
                spaceShip.setFuel(spaceShip.getFuel() + 20);
            } else {
                spaceShip.getInventory().add(item);
                player.setCredits(player.getCredits() - (int)item.getBuyPrice());
                spaceShip.inventorySize++;
            }
        }
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

}
