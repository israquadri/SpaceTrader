package src;

public class Item {
	private double sellPrice;
	private double buyPrice;
	private String name;
	private String description;
	private int quantity;

	public Item(double tax, int merchantLevel, int technologyLevel, String name, String description, int quantity) {
		sellPrice = (tax * merchantLevel);
		buyPrice = (tax * merchantLevel) * (.75);
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


}
