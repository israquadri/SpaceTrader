package src;

import java.util.ArrayList;

public class Spaceship {

	private String name;
	private int cargoCapacity;
	private ArrayList itemInventory;
	private int fuelCapacity;
	private int health;

	public Spaceship() {

	}

	public String getName() {
		return name;
	}

	public int getCargoCapacity() {
		return cargoCapacity;
	}

	public ArrayList getItemInventory() {
		return itemInventory;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public int getHealth() {
		return health;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCargoCapacity(int cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}

	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setItemInventory(ArrayList itemInventory) {
		this.itemInventory = itemInventory;
	}
}
