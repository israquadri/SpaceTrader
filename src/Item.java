package src;

import javafx.scene.image.Image;

import java.util.Random;

public class Item {
	private double sellPrice;
	private double buyPrice;
	private String name;
	private String description;
	private int quantity;
	private int basePrice = 10;
	private Random varRand = new Random();
	private double variance = varRand.nextDouble();
	private Image image;

	public Item(double tax, int merchantLevel, int technologyLevel, String name, String description, int quantity) {
		sellPrice = basePrice * (1 + tax) + technologyLevel + (merchantLevel * variance);
		buyPrice = (sellPrice) * (.75);
		this.name = name;
		this.description = description;
		this.quantity = quantity;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public double getSellPrice() {
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
}
