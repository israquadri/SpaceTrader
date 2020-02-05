package src;

import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;
import javafx.scene.image.Image;
import javafx.scene.control.TextField;

import java.awt.*;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;

public class WesternRegion extends Region {

	private VBox westernVB = new VBox();
	private Scene scene4 = new Scene(westernVB);
	private Button next = new Button("Next");
	private TextField welcome = new TextField("Welcome");
	private Canvas marketplace = new Canvas();
	//private TextField description = new TextField();
	//private TextField location = new TextField("Location of planet: " + this.getxCoord() + ", " + this.getyCoord());
	//private TextField tlDisplay = new TextField("Technology level " + this.getTechnologyLevel());
	private Image west = new Image("file:west.jpg");


	public WesternRegion() {
		super(0, 0, 3, "Planet W is a planet where the culture of the wild west reigns free.");
	}

	public Scene getScene4() {
		return this.scene4;
	}

	public VBox getWesternVB() {
		return this.westernVB;
	}

	public Button getNext() {
		return this.next;
	}

	public TextField getWelcome() {
		return this.welcome;
	}

	public Canvas getMarketplace() {
		return this.marketplace;
	}

	public Image getWest() {
		return this.west;
	}










}
