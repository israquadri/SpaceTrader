package src;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

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
}
