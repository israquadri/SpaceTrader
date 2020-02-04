package src;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.util.Random;

public class FarmPlanet extends Region {
	
	public FarmPlanet() {
		super(0, 0, 3, "Planet F is a planet where the simple live is lived on the farm.");
	}

	// you will create all the scene stuff in here but show it in the main class
	VBox farmVB = new VBox();
	Scene scene6 = new Scene(farmVB);

	TextField welcome = new TextField("Welcome to the Farm!");
	Canvas marketplace = new Canvas();
	TextField display = new TextField(this.getDescription());
	TextField location = new TextField("Location of planet: " + this.getxCoord() + ", " + this.getyCoord());
	TextField tlDisplay = new TextField("Technology level " + this.getTechnologyLevel());
	//Image west = new Image("file:west.jpg");
}
