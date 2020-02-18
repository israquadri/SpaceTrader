package src;

import javafx.scene.Node;
import javafx.scene.image.Image;

public class Region extends Node {

    private int xCoord;
    private int yCoord;
    private int technologyLevel;
    private String description;
    private Image img1;
    private Image img2;
    private boolean visited = false;
    private double tax;
    private String item1Name;
    private String item1Description;
    private String item2Name;
    private String item2Description;
    private String item3Name;
    private String item3Description;

    public Region() {

    }

    public Region(int xCoord, int yCoord, int technologyLevel,
                  String description, Image img1, Image img2) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.technologyLevel = technologyLevel;
        this.description = description;
        this.img1 = img1;
        this.img2 = img2;


    }

    public int getxCoord() {
        return this.xCoord;
    }

    public int getyCoord() {
        return this.yCoord;
    }

    public int getTechnologyLevel() {
        return this.technologyLevel;
    }

    public String getDescription() {
        return this.description;
    }

    public Image getImg1() {
        return this.img1;
    }
    public Image getImg2() {
        return this.img2;
    }

    public double getTax() {
        return tax;
    }

    public String getItem1Description() {
        return item1Description;
    }

    public String getItem2Description() {
        return item2Description;
    }

    public String getItem3Description() {
        return item3Description;
    }

    public String getItem1Name() {
        return item1Name;
    }

    public String getItem2Name() {
        return item2Name;
    }

    public String getItem3Name() {
        return item3Name;
    }

    public void setxCoord(int num) {
        this.xCoord = num;
    }

    public void setyCoord(int num) {
        this.yCoord = num;
    }

    public void setTechnologyLevel(int num) {
        this.technologyLevel = num;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImg1(Image img1) {
        this.img1 = img1;
    }
    public void setImg2(Image img2) {
        this.img2 = img2;
    }

    public void setItem1Description(String item1Description) {
        this.item1Description = item1Description;
    }

    public void setItem2Description(String item2Description) {
        this.item2Description = item2Description;
    }

    public void setItem3Description(String item3Description) {
        this.item3Description = item3Description;
    }

    public void setItem1Name(String item1Name) {
        this.item1Name = item1Name;
    }

    public void setItem2Name(String item2Name) {
        this.item2Name = item2Name;
    }

    public void setItem3Name(String item3Name) {
        this.item3Name = item3Name;
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
}
