package src;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WinGamePage {

	public WinGamePage(Stage primaryStage, Player p1) {
		VBox root = new VBox();
		Scene scene = new Scene(root, 800, 800);


		primaryStage.setTitle("you win");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
