package src;


import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
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

import javafx.geometry.Pos;

import javafx.scene.layout.GridPane;

import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;


import java.awt.*;
import java.util.Random;

public class RegionPage {

	public RegionPage(Stage primaryStage, Player p1, Region region, Region[] array) {
		//make the page in the constructor
		//follow the same structure, but do it here
		//set on action methods can go here if there is a button in this page
		VBox vbox = new VBox(40);
		vbox.setMaxWidth( 600);
		HBox hbox = new HBox(40);
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		vbox.setAlignment(Pos.CENTER);
		Scene regionRoot = new Scene(vbox, 1000, 1000);

		regionRoot.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
		primaryStage.setTitle("Into the Universe!");
		Text text = new Text("Regions of \nthe Universe");
		text.setStyle("-fx-font-size: 50px; -fx-font-family: 'Press Start 2P', cursive;");
		text.setFill(Color.WHITE);
		text.setTextAlignment(TextAlignment.CENTER);
		BackgroundImage myBI = new BackgroundImage(new Image("galaxy.jpg", 800,
				800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

		primaryStage.setTitle(region.getDescription());


		Text text1 = new Text( "You've landed in \n the " + region.getDescription() + " Region!");
		text1.setStyle("-fx-font-size: 40px; -fx-font-family: 'Press Start 2P', cursive;");
		text1.setTextAlignment(TextAlignment.CENTER);
		Text text2 = new Text("Coordinates: " + region.getxCoord() + ", " + region.getyCoord());
		text2.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
		text1.setFill(Color.WHITE);
		text2.setFill(Color.WHITE);
		


		vbox.setBackground(new Background(myBI));

		Button toMap = new Button("go to map");
		toMap.setAlignment(Pos.BOTTOM_CENTER);
		toMap.setTextFill(Color.WHITE);
		toMap.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-background-color: black; -fx-font-size: 20px;");
		toMap.setMinSize(10,10);
		toMap.setOnMouseClicked(mouseEvent -> {
			Map mapPage = new Map(primaryStage, array);
		});

		hbox.getChildren().add(toMap);
		vbox.getChildren().addAll(text1, text2, hbox);

		primaryStage.setScene(regionRoot);

	}
}
//setOnAction if pressed, instantiate the instance of the next page