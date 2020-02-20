package src;

import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

public class Region extends Node {

    private int xCoord;
    private int yCoord;
    private int techLevel;
    private String name;
    private Image img1;
    private Image img2;
    private boolean visited = false;
    private double tax;
    private Market market;

    private ArrayList<Item> regionItems = new ArrayList<Item>();

    public Region() {

    }

    public Region(int xCoord, int yCoord, int technologyLevel,
                  String name, Image img1, Image img2) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.techLevel = technologyLevel;
        this.name = name;
        this.img1 = img1;
        this.img2 = img2;
        this.market = new Market(name, technologyLevel);
//        Random rand = new Random();
/*        for (String itemName: items) {
            Item i = new Item(tax, p1.getCredits(), technologyLevel, itemName, rand.nextInt(10));
            regionItems.add(i);
        }
 */
    }

    public ArrayList<Item> getRegionItems() {
        return this.regionItems;
    }

    public int getxCoord() {
        return this.xCoord;
    }

    public int getyCoord() {
        return this.yCoord;
    }

    public int getTechLevel() {
        return this.techLevel;
    }

    public String getName() {
        return this.name;
    }

    public Image getImg1() {
        return this.img1;
    }
    public Image getImg2() {
        return this.img2;
    }



    public void setxCoord(int num) {
        this.xCoord = num;
    }

    public void setyCoord(int num) {
        this.yCoord = num;
    }

    public void setTechLevel(int num) {
        this.techLevel = num;
    }

    public void setName(String description) {
        this.name = description;
    }

    public void setImg1(Image img1) {
        this.img1 = img1;
    }
    public void setImg2(Image img2) {
        this.img2 = img2;
    }

    public int distanceBetween(Region r) {
        double xDiffSquared = Math.pow((this.getxCoord() - r.getxCoord()), 2);
        double yDiffSquared = Math.pow((this.getyCoord() - r.getyCoord()), 2);
        return (int) Math.sqrt(xDiffSquared + yDiffSquared);
    }

    public void setVisited() {
        this.visited = true;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public Node getStyleableNode() {
        return null;
    }

    /**
     * Gets market.
     * @return Value of market.
     */
    public Market getMarket() {
        return market;
    }

    /**
     * Gets tax.
     * @return Value of tax.
     */
    public double getTax() {
        return tax;
    }

    /**
     * Sets new market.
     * @param market New value of market.
     */
    public void setMarket(Market market) {
        this.market = market;
    }
}
