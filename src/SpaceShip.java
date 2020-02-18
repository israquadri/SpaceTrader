package src;

import java.util.ArrayList;

public class SpaceShip {
    int fuel;
    ArrayList<Item> inventory;
    String name;
    int cargoCapacity;
    int health;
    Item holder = new Item(20.0, 2, 2, "", "", 1);

    public SpaceShip(int fuel, String name, int cargoCapacity, int health) {
        this.fuel = fuel;
        inventory = new ArrayList<Item>();
        inventory.add(holder);
        this.name = name;
        this.cargoCapacity = cargoCapacity;
        this.health = health;

    }
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

    public int getHealth() {
        return health;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public String getName() {
        return name;
    }
}
