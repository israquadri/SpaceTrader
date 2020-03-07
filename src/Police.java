package src;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Police {
	private ArrayList<Item> inventory = new ArrayList<>();
	private int fineDemanded;
	private Item itemWanted;


	public Police(Item itemWanted, int fineDemanded) {
		this.itemWanted = itemWanted;
		this.fineDemanded = fineDemanded;
	}

	public int getFineDemanded() {
		return fineDemanded;
	}

	public Item getItemWanted() {
		return itemWanted;
	}

	public void setItemWanted(Item itemWanted) {
		this.itemWanted = itemWanted;
	}

	public void addToPoliceInventory(Item item) {
		inventory.add(item);
	}

	public boolean determineSuccess(int skillLevel) {
		if (skillLevel == 0) {return false;}
		return (new Random().nextInt(8) + 1 <=  skillLevel);
	}

	/**
	 * Gets inventory
	 * @return Value of inventory.
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}
}
