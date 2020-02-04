package src;

public class Region {

	private int xCoord;
	private int yCoord;
	private int technologyLevel;
	private String description;

	public Region(int xCoord, int yCoord, int technologyLevel, String description) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.technologyLevel = technologyLevel;
		this.description = description;
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


}
