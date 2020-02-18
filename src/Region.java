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
