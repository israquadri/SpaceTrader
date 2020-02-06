package src;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;

import java.awt.*;
import java.util.Random;

public class RegionPage {

	public RegionPage(Stage primaryStage, Player p1, Region region) {
		//make the page in the constructor
		//follow the same structure, but do it here
		//set on action methods can go here if there is a button in this page
		VBox vbox = new VBox();

		Scene regionRoot = new Scene(vbox, 800, 800);
		primaryStage.setTitle(region.getDescription());
		Text text1 = new Text(region.getDescription());
		Text text2 = new Text("Coordinates: " + region.getxCoord() + ", " + region.getyCoord());
		text1.setStyle("-fx-font-size: 40px");
		text1.setFill(Color.WHITE);
		text2.setFill(Color.WHITE);
		BackgroundImage myBI = new BackgroundImage(region.getImg(), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		vbox.setBackground(new Background(myBI));




		vbox.getChildren().addAll(text1, text2);
		primaryStage.setScene(regionRoot);

	}
}
//setOnAction if pressed, instantiate the instance of the next page