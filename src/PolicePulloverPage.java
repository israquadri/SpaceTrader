package src;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PolicePulloverPage {

	public PolicePulloverPage(Stage primaryStage, Region region, Region[] regions, Player p1, Police police) {
		VBox root = new VBox();
		Scene scene = new Scene(root, 800, 800);

		// 3 options that are buttons presented to the user

		Button option1 = new Button("Comply with Police");
		Button option2 = new Button("Attempt to flee");
		Button option3 = new Button("Attempt to fight off police");

		// Option 1
	/*
	Forfeit the items to the Police and continue to the desired destination.
	 */

		option1.setOnMouseClicked(mouseEvent ->  {
			police.addToPoliceInventory(police.getItemWanted());
			p1.getSpaceShip().getInventory().remove(police.getItemWanted());
			Map map = new Map(primaryStage, regions, p1);
		});

		/*
		 Try to flee back to the previous region. The success of fleeing is dependent on the
		player’s Pilot skill (higher Pilot level, higher chance of escape). If the player successfully
		flees back to the original region, they should still lose the fuel required to travel initially,
		but they keep all their items and they are safe. If the player fails to flee, the Police will
		confiscate the stolen items, damage the health value of the player's ship, and force the
		player to pay a fine for evasion. Then the player returns to the previous region.
		 */

		option2.setOnMouseClicked(mouseEvent -> {
			if (p1.getPilotSkill() > 2) {
				//lose the fuel
				//check if they have enough fuel

				//take note of what the region was that they clicked on before they encountered the police

				Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have successfully fled from the police!");
				alert.show();
				RegionPage rp = new RegionPage(primaryStage, p1, region, regions);
			} else {
				p1.getSpaceShip().getInventory().remove(police.getItemWanted());
				p1.getSpaceShip().setHealth(p1.getSpaceShip().getHealth() -1);
				p1.setCredits(p1.getCredits() - police.getFineDemanded());
				Alert a = new Alert(Alert.AlertType.INFORMATION, "The police have decreased your ship health, confiscated the stolen items, and charged you a fine of " + police.getFineDemanded() + " credits.");
				RegionPage prev = new RegionPage(primaryStage, p1, region, regions);
			}
		});

		// Option 3:
		/*
		Try to fight off the police. The success of defeating the police is dependent on the
		player’s Fighter skill (higher Fighter level, higher chance of winning). Successfully
		fighting off the police will allow the player to travel as intended to the desired
		destination, keeping the stolen items in their inventory.
		 */

		option3.setOnMouseClicked(mouseEvent -> {
			if (p1.getFighterSkill() > 2) {
				// They get to go to the desired region
				RegionPage rp = new RegionPage(null, null, null, null);
			}
		});


		root.getChildren().addAll(option1, option2, option3);

		primaryStage.setScene(scene);
		primaryStage.setTitle("The police have pulled you over");
		primaryStage.show();
	}





}
