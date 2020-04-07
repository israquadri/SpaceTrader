package src;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameOverPage {

	public GameOverPage(Stage primaryStage, Player p1) {
		VBox root = new VBox(50);
		Scene scene = new Scene(root, 800, 800);




		Button playAgain = new Button("End Credits");
		playAgain.setOnMouseClicked((MouseEvent m) -> {
			EndCreditsPage endCreditsPage = new EndCreditsPage(primaryStage);
		});


		root.getChildren().addAll(playAgain);
		primaryStage.show();


		primaryStage.setTitle("Game over!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
