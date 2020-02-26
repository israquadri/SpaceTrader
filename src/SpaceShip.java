package src;

import java.util.*;
import java.util.Map;

public class SpaceShip {
    private int fuel;
    private String name;
    private int cargoCapacity;
    private int health;
    private HashMap<Item, Integer> inventory = new HashMap<>();

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
        cargoCapacity++;
        int quantity = inventory.get(i);
        if (quantity - 1 == 0) {
            inventory.remove(i);
        } else {
            inventory.put(i, quantity - 1);
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

    public double reFuel(int buyPrice) {
        if ((this.fuel + (buyPrice / 2.0)) > 50.0) {
            this.fuel += (50.0 - this.fuel);
        } else {
            this.fuel += (buyPrice / 2.0);
        }
        return (buyPrice / 2.0);
    }

    public boolean isTankFull() {
        if (this.fuel == 50.0) {
            return true;
        } return false;
    }

    public void setFuelAfterTravel(int distanceBetween) {
        this.fuel -= (distanceBetween / 45.0);
    }
}
