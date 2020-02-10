package src;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Random;
import java.util.HashMap;

public class BeforeRegionPage {

	public BeforeRegionPage(Stage primaryStage, Player p1) {
		HBox hbox = new HBox(40);
		hbox.setAlignment(Pos.TOP_LEFT);
		VBox vBox = new VBox(100);
		//vBox.setPrefWidth(800);
		//vBox.setPrefHeight(800);
		vBox.setAlignment(Pos.TOP_CENTER);
		Scene scene4 = new Scene(vBox, 800, 800);
		scene4.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");

		Button back = new Button("Back");
		back.setTextFill(Color.WHITE);
		back.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-background-color: black; -fx-font-size: 30px;");
		back.setOnMouseClicked(mouseEvent -> {
			CharacterPage characterPage = new CharacterPage(primaryStage, p1);
		});

		Button toRegionPage = new Button("Click here to \nenter the universe!");
		toRegionPage.setStyle("-fx-background-color: black; -fx-font-size: 35px;"
				+ " -fx-font-family: 'Press Start 2P', cursive;");
		toRegionPage.setTextFill(Color.WHITE);
		toRegionPage.setTextAlignment(TextAlignment.CENTER);
		toRegionPage.setMinSize(10,250);

		// DROP SHADOW HOVER EFFECT ON START BUTTON
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.CORAL);
		shadow.setWidth(1.5);

		//adding the shadow when the mouse cursor is on
		toRegionPage.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						toRegionPage.setEffect(shadow);
					}
				});

		//adding the shadow when the mouse cursor is on
		back.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						toRegionPage.setEffect(shadow);
					}
				});

		//removing shadow when mouse cursor is off
		toRegionPage.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						toRegionPage.setEffect(null);
					}
				});
		//removing shadow when mouse cursor is off
		back.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						toRegionPage.setEffect(null);
					}
				});


		//initiating regions
		CoordGenerator cg = new CoordGenerator(650);
		HashMap<Integer, Integer> xCoords = cg.getX();
		HashMap<Integer, Integer> yCoords = cg.getY();
//		for(int i = 0; i < 10; i++) {
//			System.out.println("xCoord " + i + ": " + xCoords.get(i));
//			System.out.println("yCoord " + i + ": " + yCoords.get(i));
//		}

		Region region1 = new Region(xCoords.get(0), yCoords.get(0), 0,
				"Farm", new Image("galaxy.jpg", 800,
				800, false, true), new Image( "p1.png", 100,
                100, false, true));
		Region region2 = new Region(xCoords.get(1), yCoords.get(1), 0,
				"Safari",  new Image("galaxy.jpg", 800,
				800, false, true), new Image( "p2.png", 100,
                100, false, true));
		Region region3 = new Region(xCoords.get(2), yCoords.get(2), 0,
				"2000s Boy Bands: the Planet",  new Image("galaxy.jpg", 800,
				800, false, true), new Image( "p3.png", 100,
                100, false, true));
		Region region4 = new Region(xCoords.get(3), yCoords.get(3), 0,
				"Scandinavian",  new Image("galaxy.jpg", 800,
				800, false, true),  new Image( "p4.png", 100,
                100, false, true));
		Region region5 = new Region(xCoords.get(4), yCoords.get(4), 0,
				"Arctic",  new Image("arctic.jpg", 800,
				800, false, true), new Image( "p5.png", 100,
                100, false, true));
		Region region6 = new Region(xCoords.get(5), yCoords.get(5), 0,
				"Desert",  new Image("desert.jpg", 800,
				800, false, true), new Image( "p6.png", 100,
                100, false, true));
		Region region7 = new Region(xCoords.get(6), yCoords.get(6), 0,
				"3",  new Image("galaxy.jpg", 800,
				800, false, true), new Image( "p7.png", 100,
                100, false, true));
		Region region8 = new Region(xCoords.get(7), yCoords.get(7), 0,
				"4",  new Image("galaxy.jpg", 800,
				800, false, true), new Image( "p8.png", 100,
                100, false, true));
		Region region9 = new Region(xCoords.get(8), yCoords.get(8), 0,
				"Wild west",  new Image("galaxy.jpg", 800,
				800, false, true), new Image( "p9.png", 100,
                100, false, true));
		Region region10 = new Region(xCoords.get(9), yCoords.get(9), 0,
				"Disco",  new Image("galaxy.jpg", 800,
				800, false, true), new Image( "p10.png", 100,
                100, false, true));

		Region[] arr={region1, region2, region3, region4, region5, region5, region6, region7, region8, region9, region10};
		Random r = new Random();
		int randomNumber=r.nextInt(arr.length);
		//Button test = new Button(arr[randomNumber].getDescription());

		toRegionPage.setOnMouseClicked(mouseEvent -> {
			arr[randomNumber].setVisited();
			p1.setCurrentRegion(arr[randomNumber]);
			RegionPage regionPage = new RegionPage(primaryStage, p1, arr[randomNumber], arr);
		});

		hbox.getChildren().add(back);
		vBox.getChildren().addAll(hbox, toRegionPage);

		BackgroundImage myBI = new BackgroundImage(new Image("galaxy.jpg", 800,
				800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		vBox.setBackground(new Background(myBI));
		vBox.setStyle("-fx-border-color: black; -fx-border-width: 10px");


		primaryStage.setTitle("Almost time to blastoff!");
		primaryStage.setScene(scene4);
		primaryStage.show();
	}
}
