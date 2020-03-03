package src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AfterNPC_EncounterPage {

	public AfterNPC_EncounterPage(Stage primaryStage, Region regions[], Player p1) {

		VBox root = new VBox();
		Scene scene = new Scene(root, 800, 800);




		primaryStage.setScene(scene);
		primaryStage.setTitle("you moved on");
		primaryStage.show();
	}
}
