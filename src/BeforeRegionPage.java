package src;

import javafx.event.EventHandler;
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

public class BeforeRegionPage {

	public BeforeRegionPage(Stage primaryStage, Player p1) {
		VBox vBox = new VBox(40);
		Scene scene4 = new Scene(vBox, 800, 800);
		scene4.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");

		Button back = new Button("Back");
		back.setTextFill(Color.BLACK);
		back.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-background-color: white; -fx-font-size: 30px;");
		back.setOnMouseClicked(mouseEvent -> {
			CharacterPage characterPage = new CharacterPage(primaryStage, p1);
		});

		Button toRegionPage = new Button("Click here to \nenter the universe!");
		toRegionPage.setStyle("-fx-background-color: black; -fx-font-size: 30px;"
				+ " -fx-font-family: 'Press Start 2P', cursive;");
		toRegionPage.setTextFill(Color.WHITE);
		toRegionPage.setTextAlignment(TextAlignment.CENTER);

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

		//removing shadow when mouse cursor is off
		toRegionPage.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						toRegionPage.setEffect(null);
					}
				});


		//initiating regions
		Random randomX = new Random();
		Random randomY = new Random();

		Region region1 = new Region(randomX.nextInt(), randomY.nextInt(), 0,
				"Farm region", new Image("galaxy.jpg", 800,
				800, false, true));
		Region region2 = new Region(randomX.nextInt(), randomY.nextInt(), 0,
				"Safari",  new Image("galaxy.jpg", 800,
				800, false, true));
		Region region3 = new Region(randomX.nextInt(), randomY.nextInt(), 0,
				"2000s Boy Bands: the Planet",  new Image("galaxy.jpg", 800,
				800, false, true));
		Region region4 = new Region(randomX.nextInt(), randomY.nextInt(), 0,
				"Scandinavian",  new Image("galaxy.jpg", 800,
				800, false, true));
		Region region5 = new Region(randomX.nextInt(), randomY.nextInt(), 0,
				"Arctic",  new Image("arctic.jpg", 800,
				800, false, true));
		Region region6 = new Region(randomX.nextInt(), randomY.nextInt(), 0,
				"Desert",  new Image("desert.jpg", 800,
				800, false, true));
		Region region7 = new Region(randomX.nextInt(), randomY.nextInt(), 0,
				"3",  new Image("galaxy.jpg", 800,
				800, false, true));
		Region region8 = new Region(randomX.nextInt(), randomY.nextInt(), 0,
				"4",  new Image("galaxy.jpg", 800,
				800, false, true));
		Region region9 = new Region(randomX.nextInt(), randomY.nextInt(), 0,
				"Wild west",  new Image("galaxy.jpg", 800,
				800, false, true));
		Region region10 = new Region(randomX.nextInt(), randomY.nextInt(), 0,
				"Disco",  new Image("galaxy.jpg", 800,
				800, false, true));

		Region[] arr={region1, region2, region3, region4, region5, region5, region6, region7, region8, region9, region10};
		Random r = new Random();
		int randomNumber=r.nextInt(arr.length);
		//Button test = new Button(arr[randomNumber].getDescription());

		toRegionPage.setOnMouseClicked(mouseEvent -> {
			RegionPage regionPage = new RegionPage(primaryStage, p1, arr[randomNumber]);
		});

		vBox.getChildren().addAll(toRegionPage, back);
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
