package src;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class CharacterPage {

	public CharacterPage(Stage primaryStage, Player p1) {
		
		// SCENE 3 BACKING STRUCTURE SET UP
		VBox vb3 = new VBox(20.0);
		Scene scene3 = new Scene(vb3, 800, 800);
		scene3.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
		vb3.setStyle("-fx-border-color: lightcoral; -fx-border-width: 10px");
		BackgroundImage myBI = new BackgroundImage(new Image("galaxy.jpg", 800,
				800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		vb3.setBackground(new Background(myBI));

		Button toScene4 = new Button("Continue");
		toScene4.setTextFill(Color.WHITE);

		toScene4.setStyle("-fx-background-color: black; -fx-font-size: 20px;"
				+ " -fx-font-family: 'Press Start 2P', cursive;");

		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.CORAL);
		shadow.setWidth(1.5);

		//DROP SHADOW EFFECT
		toScene4.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						toScene4.setEffect(shadow);
					}
				});
		toScene4.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						toScene4.setEffect(null);
					}
				});

		HBox bt2 = new HBox();

		// ADDING CHARACTER SHEET SCREEN TEXT NODES
		Text yourCharacter = new Text("WELCOME,\n" + p1.getName());
		yourCharacter.setFill(Color.INDIANRED);
		yourCharacter.setStyle("-fx-background-color: black; -fx-font-size: 60px;"
				+ " -fx-font-family: 'Press Start 2P', cursive;");

		Text yourNameIs = new Text("Your name is: " + p1.getName());
		yourNameIs.setFill(Color.WHITE);
		yourNameIs.setStyle("-fx-font-size: 20px; -fx-background-color: purple;"
				+ " -fx-font-family: 'Press Start 2P', cursive;");

		Text yourTraits = new Text("Your points for Pilot: " + p1.getTrait1Val()
				+ "\nYour points for Fighter: " + p1.getTrait2Val()
				+ "\nYour points for Merchant: " + p1.getTrait3Val()
				+ "\nYour points for Engineer: " + p1.getTrait4Val());
		yourTraits.setFill(Color.WHITE);
		yourTraits.setStyle("-fx-font-size: 20px; -fx-background-color: purple;"
				+ " -fx-font-family: 'Press Start 2P', cursive;");

		Text yourDiff = new Text("Based on your difficulty level, you\nhave "
				+ p1.getCredits() + " credits");
		yourDiff.setFill(Color.WHITE);
		yourDiff.setStyle("-fx-font-size: 20px; -fx-background-color: purple;"
				+ " -fx-font-family: 'Press Start 2P', cursive;");
		vb3.getChildren().addAll(yourCharacter, bt2, yourNameIs, yourTraits, yourDiff, toScene4);
		toScene4.setAlignment(Pos.BASELINE_LEFT);


		toScene4.setOnMouseClicked(mouseEvent -> {
			src.BeforeRegionPage beforeRegionPage = new BeforeRegionPage(primaryStage, p1);
		});

		//BACK TO SCENE 2 BUTTON
		Button backToScene2 = new Button("Back to Character\nConfiguration");
		backToScene2.setTextFill(Color.WHITE);
		backToScene2.setStyle("-fx-background-color: black; -fx-font-size: 20px;"
				+ " -fx-font-family: 'Press Start 2P', cursive;");

		bt2.getChildren().add(backToScene2);
		backToScene2.setAlignment(Pos.BASELINE_LEFT);

		//DROP SHADOW EFFECT
		backToScene2.addEventHandler(MouseEvent.MOUSE_ENTERED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						backToScene2.setEffect(shadow);
					}
				});
		backToScene2.addEventHandler(MouseEvent.MOUSE_EXITED,
				new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						backToScene2.setEffect(null);
					}
				});
		backToScene2.setOnMouseClicked((mouseEvent -> {
			ConfigPage configPage = new ConfigPage(primaryStage, p1);
		}));

        backToScene2.setOnMouseClicked((mouseEvent -> {

			ConfigPage configPage = new ConfigPage(primaryStage, p1);
	}));


		primaryStage.setTitle("Your character");
		primaryStage.setScene(scene3);
		primaryStage.show();
	}
}
