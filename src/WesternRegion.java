package src;

import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;

import java.awt.*;
import java.util.Random;

public class WesternRegion extends Region {

	private VBox westernVB = new VBox();
	private Scene scene4 = new Scene(westernVB);

	public WesternRegion() {
		super(0, 0, 3, "Planet W is a planet where the culture of the wild west reigns free.");
	}

	// you will create all the scene stuff in here but show it in the main class
	//VBox westernVB = new VBox();
	//Scene scene4 = new Scene(westernVB);

	TextField welcome = new TextField("Welcome to the Wild West");
	Canvas marketplace = new Canvas();
	TextField display = new TextField(this.getDescription());
	TextField location = new TextField("Location of planet: " + this.getxCoord() + ", " + this.getyCoord());
	TextField tlDisplay = new TextField("Technology level " + this.getTechnologyLevel());
	//Image west = new Image("file:west.jpg");

	public Scene getScene4() {
		return this.scene4;
	}

	public VBox getWesternVB() {
		return this.westernVB;
	}






}
