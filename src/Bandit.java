package src;

import java.util.ArrayList;
import java.util.Random;

public class Bandit {

    private int credits;
    private int shipHealth;
    private int demands; // this is the number of credits they are demanding from the player
    private ArrayList<Item> inventory;

    public Bandit(int demands) {
        this.demands = demands;
        this.credits = 500;
    }

    public int getCredits() {
        return credits;
    }

    public int getShipHealth() {
        return shipHealth;
    }

    public int getDemands() {
        return demands;
    }

    public void setShipHealth(int shipHealth) {
        this.shipHealth = shipHealth;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setDemands(int demands) {
        this.demands = demands;
    }

    public void addToInventory(Item item) {
        this.inventory.add(item);
    }

    public int randInventoryIndx() {
        Random rand = new Random();
        int index = rand.nextInt(this.inventory.size());
        return index;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public boolean determineSuccess(int skillLevel) {
        if (skillLevel == 0) {
            return false;
        }
        return (new Random().nextInt(8) + 1 <=  skillLevel);
    }
}
