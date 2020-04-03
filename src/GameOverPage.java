package src;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameOverPage {

	public GameOverPage(Stage primaryStage, Player p1) {
		VBox root = new VBox(50);
		Scene scene = new Scene(root, 800, 800);






		primaryStage.setTitle("Game over!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
