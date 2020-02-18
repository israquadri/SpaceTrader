package src;

public class Item {
    
    private int sellPrice;
    private int buyPrice;
    private String name;
    private String description;
    private int quantity;

    public Item(int tax, int merchantLevel, int technologyLevel, String name, String description, int quantity) {
        sellPrice = (tax * merchantLevel);
        buyPrice = (int)((tax * merchantLevel) * (.75));
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }




}
