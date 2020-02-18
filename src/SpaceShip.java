package src;

import java.util.ArrayList;

public class SpaceShip {
    int fuel;
    ArrayList<Item> inventory;


    public void addToInventory(Item i) {
        inventory.add(i);
    }

    public void removeFromInventory(Item i) {
        inventory.add(i);
    }
    
    public int getFuel() {
        return fuel;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

}
