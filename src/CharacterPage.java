package src;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CharacterPage {

	public CharacterPage(Stage primaryStage, Player p1) {

		//Set the name of the p1 object
		//p1.setName(characterField.getText());

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
		toScene4.setStyle("-fx-font-size: 20px; -fx-background-color: indianred; -fx-font-family: 'Press Start 2P', cursive;");

		HBox bt2 = new HBox();
//        bt2.getChildren().add(backToScene2);
//        bt2.setAlignment(Pos.BASELINE_LEFT);

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
		//Stops continue button from working if name, difficulty, and skill points are not all used

		// CHRIS HELP HERE I DONT KNOW HOW TO GET EASY, MEDIUM, and HARD
/*		if (!p1.getName().equals("") && p1.getSkillPoints() == 0 && (easy.isSelected() || medium.isSelected() || hard.isSelected())) {
			//Stop the Space Trader Intro Music
			//introsongplayer.stop();
			//Start the completed character sound effect
			//soundplyr.play();
			//Activate next scene
			primaryStage.setScene(scene3);
			primaryStage.setTitle("Scene 3");
			primaryStage.show();
		}*/

		toScene4.setOnMouseClicked(mouseEvent -> {
			src.BeforeRegionPage beforeRegionPage = new BeforeRegionPage(primaryStage, p1);
		});

		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.CORAL);
		shadow.setWidth(1.5);
		Button backToScene2 = new Button("Back to Character\nConfiguration");
		backToScene2.setTextFill(Color.WHITE);
		backToScene2.setStyle("-fx-background-color: black; -fx-font-size: 20px;"
				+ " -fx-font-family: 'Press Start 2P', cursive;");

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

/*	//BACK TO SCENE 2 BUTTON
        backToScene2.setOnMouseClicked((mouseEvent -> {
		//Stop intro song and start character finish song
		//introsongplayer.play();
		//soundplyr.stop();
		//primaryStage.setScene(configPage);
		primaryStage.setTitle("Welcome user!");
		primaryStage.show();
	}));*/
		primaryStage.setTitle("Your character");
		primaryStage.setScene(scene3);
		primaryStage.show();
	}
}
