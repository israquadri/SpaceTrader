package src;

import javafx.scene.image.Image;

import java.util.Random;

public class Item {
	private int sellPrice;
	private int buyPrice;
	private String name;
	private int quantity;
	private int basePrice = 10;
	private Random varRand = new Random();
	private int variance = varRand.nextInt(8);
	private Image image;

	public Item(double tax, int merchantLevel, int technologyLevel, String name, int quantity) {
		sellPrice = (int)(basePrice * (1 + tax) + technologyLevel + (merchantLevel * variance));
		buyPrice = (int)((sellPrice) * (.75));
		this.name = name;
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void decreaseQuantity() {
	    this.quantity--;
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
