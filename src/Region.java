package src;

import javafx.scene.Node;
import javafx.scene.image.Image;

public class Region extends Node {

	private int xCoord;
	private int yCoord;
	private int technologyLevel;
	private String description;
	private Image img;

	public Region() {

	}

	public Region(int xCoord, int yCoord, int technologyLevel, String description, Image img) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.technologyLevel = technologyLevel;
		this.description = description;
		this.img = img;
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

	public Image getImg() {
		return this.img;
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

	public void setImg(Image img) {
		this.img = img;
	}


	@Override
	public Node getStyleableNode() {
		return null;
	}
}
