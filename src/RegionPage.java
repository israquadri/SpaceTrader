package src;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;

import java.awt.*;

public class RegionPage {

	public RegionPage(Stage primaryStage) {
		//make the page in the constructor
		//follow the same structure, but do it here
		//set on action methods can go here if there is a button in this page
		VBox vbox = new VBox();
		Scene regionRoot = new Scene(vbox, 800, 800);
		primaryStage.setTitle("Into the Universe!");
		Text text = new Text("Regions of the Universe");
		text.setStyle("-fx-font-size: 40px");
		text.setFill(Color.WHITE);
		BackgroundImage myBI = new BackgroundImage(new Image("galaxy.jpg", 800,
				800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		vbox.setBackground(new Background(myBI));


		vbox.getChildren().addAll(text);
		primaryStage.setScene(regionRoot);

	}
}
//setOnAction if pressed, instantiate the instance of the next page