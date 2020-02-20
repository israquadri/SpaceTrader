package src;

import java.util.*;
import java.util.Map;

public class SpaceShip {
    int fuel;
    String name;
    int cargoCapacity;
    int health;
    HashMap<Item, Integer> inventory = new HashMap<>();

    public SpaceShip(int fuel, String name, int cargoCapacity, int health) {
        this.fuel = fuel;
        this.name = name;
        this.cargoCapacity = cargoCapacity;
        this.health = health;
    }


    public void addToInventory(Item i) {
        cargoCapacity--;
        if (inventory.containsKey(i)) {
            int quantity = inventory.get(i);
            inventory.put(i, quantity + 1);
        } else {
            inventory.put(i, 1);
        }
    }

    public void removeFromInventory(Item i) {
        if (i != null) {
            cargoCapacity++;
            int quantity = inventory.get(i);
            if (quantity - 1 == 0) {
                inventory.remove(i);
            } else {
                inventory.put(i, quantity - 1);
            }
        }
    }

    public HashMap<Item, Integer> getInventory() {
        return this.inventory;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getHealth() {
        return health;
    }

    public int getQuantity(Item i) {
        if (inventory.containsKey(i)) {
            return inventory.get(i);
        } return 0;
    }

    public int getInventoryCapacity() {
        return inventory.size();
    }

    public int getCargoCapacity() {
        return this.cargoCapacity;
    }

    public String getName() {
        return name;
    }

}
