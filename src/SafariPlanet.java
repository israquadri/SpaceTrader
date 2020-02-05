package src;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.util.Random;

public class SafariPlanet extends Region {

	public SafariPlanet() {
		super(0, 0, 3, "Planet S is a jungle of the universe's most dangerous creatures.");
	}

	// you will create all the scene stuff in here but show it in the main class
	VBox safariVB = new VBox();
	Scene scene5 = new Scene(safariVB);

	TextField welcome = new TextField("Welcome to the Safari");
	Canvas marketplace = new Canvas();
	TextField display = new TextField(this.getDescription());
	TextField location = new TextField("Location of planet: " + this.getxCoord() + ", " + this.getyCoord());
	TextField tlDisplay = new TextField("Technology level " + this.getTechnologyLevel());
	//Image west = new Image("yellowstone.jpg");
}
