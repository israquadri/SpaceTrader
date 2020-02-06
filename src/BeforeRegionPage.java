package src;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Random;

public class BeforeRegionPage {

	public BeforeRegionPage(Stage primaryStage, Player p1) {
		VBox vBox = new VBox(40);
		Scene scene4 = new Scene(vBox, 1000, 1000);
		scene4.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");

		Button back = new Button("Back");
		back.setTextFill(Color.BLACK);
		back.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-background-color: white; -fx-font-size: 30px;");
		back.setOnMouseClicked(mouseEvent -> {
			CharacterPage characterPage = new CharacterPage(primaryStage, p1);
		});

		Button toRegionPage = new Button("Click here to \nenter the universe!");
		toRegionPage.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-background-color: indianred; -fx-font-size: 30px;");
		toRegionPage.setTextFill(Color.WHITE);
		toRegionPage.setTextAlignment(TextAlignment.CENTER);


		//initiating regions
		Random randomX = new Random();
		Random randomY = new Random();
		int x1 = randomX.nextInt();
		int y1 = randomY.nextInt();
		int x2 = randomX.nextInt();
		int y2 = randomY.nextInt();
		int x3 = randomX.nextInt();
		int y3 = randomY.nextInt();
		int x4 = randomX.nextInt();
		int y4 = randomY.nextInt();
		int x5 = randomX.nextInt();
		int y5 = randomY.nextInt();
		int x6 = randomX.nextInt();
		int y6 = randomY.nextInt();
		int x7 = randomX.nextInt();
		int y7 = randomY.nextInt();
		int x8 = randomX.nextInt();
		int y8 = randomY.nextInt();
		int x9 = randomX.nextInt();
		int y9 = randomY.nextInt();
		int x10 = randomX.nextInt();
		int y10 = randomY.nextInt();

		Region region1 = new Region(x1, y1, 0, "Farm region", new Image("galaxy.jpg"));
		Region region2 = new Region(x2, y2, 0, "Safari",  new Image("galaxy.jpg"));
		Region region3 = new Region(x3, y3, 0, "2000s Boy Bands: the Planet",  new Image("galaxy.jpg"));
		Region region4 = new Region(x4, y4, 0, "Scandinavian",  new Image("galaxy.jpg"));
		Region region5 = new Region(x5, y5, 0, "1",  new Image("galaxy.jpg"));
		Region region6 = new Region(x6, y6, 0, "2",  new Image("galaxy.jpg"));
		Region region7 = new Region(x7, y7, 0, "3",  new Image("galaxy.jpg"));
		Region region8 = new Region(x8, y8, 0, "4",  new Image("galaxy.jpg"));
		Region region9 = new Region(x9, y9, 0, "Wild west",  new Image("galaxy.jpg"));
		Region region10 = new Region(x10, y10, 0, "Disco",  new Image("galaxy.jpg"));

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
