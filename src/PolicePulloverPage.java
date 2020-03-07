package src;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.*;

public class PolicePulloverPage {

	public PolicePulloverPage(Stage primaryStage, Region[] regions, Player p1, Police police) {
		VBox root = new VBox();
		Scene scene = new Scene(root, 800, 800);
		BackgroundImage myBI = new BackgroundImage(new Image("starback.jpg", 800,
				800, true, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		root.setBackground(new Background(myBI));

		//itemWanted.quantity is incorrect
		ArrayList<Item> itemsCopy = new ArrayList<>(p1.getSpaceShip().getInventory().keySet());
		//for testing
		for(Item i : itemsCopy) {
			System.out.println("item: " + i.getName());
		}
		int index = new Random().nextInt(p1.getSpaceShip().getInventory().size());
		police.setItemWanted(itemsCopy.get(index));
		System.out.println("item wanted: " + police.getItemWanted());

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
			Alert a1 = new Alert(Alert.AlertType.CONFIRMATION, "You complied, gave the police your " + police.getItemWanted().toString() + ", and get to continue to the next region.");
			a1.show();
			RegionPage rp = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
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
			if (police.determineSuccess(p1.getPilotSkill())) {
				if (p1.getSpaceShip().getFuel() > (p1.getCurrentRegion().distanceBetween(regions[3]))) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have successfully fled from the police!");
					alert.show();
					p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination()));
					RegionPage proceed = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
				} else {
					Alert a1 = new Alert(Alert.AlertType.ERROR, "You do not have enough fuel to go to your destination.");
					a1.show();
					RegionPage rp = new RegionPage(primaryStage, p1, p1.getCurrentRegion(), regions);
				}

			} else {
				p1.getSpaceShip().getInventory().remove(police.getItemWanted());
				p1.getSpaceShip().setHealth(p1.getSpaceShip().getHealth() -1);
				p1.setCredits(p1.getCredits() - police.getFineDemanded());
				Alert a2 = new Alert(Alert.AlertType.INFORMATION, "The police have decreased your ship health, confiscated the stolen items, and charged you a fine of " + police.getFineDemanded() + " credits.");
				a2.show();
				p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination()));
				RegionPage proceed = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
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
			if (police.determineSuccess(p1.getFighterSkill())) {
				// They get to go to the desired region
				Alert a1 = new Alert(Alert.AlertType.CONFIRMATION, "You fought them off successfully and get to continue!");
				a1.show();
				p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination()));
				RegionPage proceed = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
			} else {
				Alert a2 = new Alert(Alert.AlertType.INFORMATION, "You did not fight them off, so you went back to your last region.");
				a2.show();
				RegionPage rp2 = new RegionPage(primaryStage, p1, p1.getCurrentRegion(), regions);
			}
		});

		ImageView policePic = new ImageView(new Image("spacePolice.png"));
		root.getChildren().addAll(option1, option2, option3,policePic);

		primaryStage.setScene(scene);
		primaryStage.setTitle("The police have pulled you over");
		primaryStage.show();
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
