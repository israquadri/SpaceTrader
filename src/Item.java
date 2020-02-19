package src;

import javafx.scene.image.Image;

import java.util.Random;

public class Item {
	private int sellPrice;
	private int buyPrice;
	private String name;
	private String description;
	private int quantity;
	private int basePrice = 10;
	private Random varRand = new Random();
	private float variance = varRand.nextFloat();
	private Image image;

	public Item(double tax, int merchantLevel, int technologyLevel, String name, String description, int quantity) {
		sellPrice = (int)(basePrice * (1 + tax) + technologyLevel + (merchantLevel * variance));
		buyPrice = (int)((sellPrice) * (.75));
		this.name = name;
		this.description = description;
		this.quantity = quantity;
	}

	public int findInventoryIndex(Player player) {
		int index = 0;
		for (int i = 0; i < player.getSpaceShip().getInventory().size(); i++) {
			if (player.getSpaceShip().getInventory().get(i).equals(this.getName())) {
				index = i;
			} else {
				//throw exception because it isnt there
			}
		}
		return index;
	}

	public int getBuyPrice() {
		return buyPrice;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getVariance() {
		return variance;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setQuantity(int num) {
		this.quantity = num;
	}
}
