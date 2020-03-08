package src;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.Set;

public class BanditGotchaPage {

    public BanditGotchaPage(Stage primaryStage, Region[] regions, Player p1, Bandit bandit) {
        VBox root = new VBox();
        Scene s = new Scene(root, 800, 800);
        BackgroundImage myBI = new BackgroundImage(new Image("starback.jpg", 800,
                800, true, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));
        root.getChildren().add(new Text("Beep"));

        // 3 buttons and the 3 different scenarios happen based on which button the user selects

        // Option 1:
        /*
            Pay the bandit's demand and continue to the desired destination. If the player cannot
            afford the bandit's demands, then the player must give the bandit all the items in their
            inventory. If the player has no items, the bandit will damage the ship's health. Then the
            player continues to the target destination.
         */
        Button option1 = new Button("Pay bandit and \n continue");

        // backend of what happens when the player picks this option

        option1.setOnMouseClicked(mouseEvent -> {
            if (p1.getCredits() >= bandit.getDemands()) {
                bandit.setCredits(bandit.getCredits() + bandit.getDemands());
                p1.setCredits(p1.getCredits() - bandit.getDemands());
                p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination()));
                RegionPage proceed = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You paid the bandit and were able to escape!");
                a.show();
            } else {
                if (p1.getSpaceShip().getInventory().size() > 0) {
                    // this might be our loophole.. add the items to the bandit inventory and have the cops ask for the bandit's items
//                    Set<Item> keySet = p1.getSpaceShip().getInventory().keySet();
//                    Object[] itemArr = keySet.toArray();
//                    for (int i = 0; i < itemArr.length; i++) {
//                        bandit.addToInventory((Item)itemArr[i]);
//                    }
                    p1.getSpaceShip().getInventory().clear();
                    p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination()));
                    RegionPage proceed = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION, "The bandit stole your entire inventory.");
                    alert2.show();
                } else {
                    p1.getSpaceShip().setHealth(p1.getSpaceShip().getHealth() - 1);
                    p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination()));
                    RegionPage proceed = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "The bandit decreased your ship health.");
                    alert1.show();
                }
            }
        });

        // Option 2:
        /*
        Try to flee back to the previous region. The success of fleeing is dependent on the
        player’s Pilot skill (higher Pilot level, higher chance of escape). If the player successfully
        flees back to the original region, they should still lose the fuel required to travel initially,
        but they keep all their credits & items and they are safe. If the player fails to flee, the
        bandit will take all their credits and damage the health value of the player's ship.
                 */

        Button option2 = new Button("Try to flee");

        option2.setOnMouseClicked(mouseEvent -> {
            boolean success = bandit.determineSuccess(p1.getPilotSkill());
            if (success) {
                p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination())); // subtract fuel it took
                RegionPage rp = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "Phew! Because your Pilot skill is " + p1.getPilotSkill() + ", you could flee back to the last planet you were on!");
                alert2.show();
            } else {
                bandit.setCredits(p1.getCredits());
                p1.setCredits(0);
                p1.getSpaceShip().setHealth(p1.getSpaceShip().getHealth() -1);
                RegionPage rp = new RegionPage(primaryStage, p1, p1.getCurrentRegion(), regions);
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "You weren't able to flee from the bandits! They damaged your ship and stole your credits!");
                alert1.show();
            }
        });

        // Option 3:
        /*
              Try to fight off the bandit. The success of defeating the bandit is dependent on the
        player’s fighter skill (higher fighter level, higher chance of winning). Successfully
        fighting off the bandit will allow the player to travel as intended to the desired
        destination without any new consequences. Additionally, success will grant the player
        some of the bandit's credits as a reward for winning the fight. Failing to fight off the
        bandit will cost the player all their credits and should damage the health of the player's
        ship.
         */

        Button option3 = new Button("Attempt to fight");

        option3.setOnMouseClicked(mouseEvent -> {
            boolean success = bandit.determineSuccess(p1.getFighterSkill());
            if (success) {
                p1.setCredits(p1.getCredits() + ((int)(bandit.getCredits() * .2)));
                p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination()));
                RegionPage proceed = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "You successfully fought off the bandits");
                a1.show();
            } else {
                bandit.setCredits(p1.getCredits() + bandit.getCredits());
                p1.setCredits(0);
                p1.getSpaceShip().setHealth(p1.getSpaceShip().getHealth() - 1);
                p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination()));
                RegionPage proceed = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "The bandit stole your credits and decreased your ship health.");
                alert1.show();
            }
        });

        root.getChildren().addAll(option1, option2, option3);

        primaryStage.setTitle("Oh no! Bandits have stopped your ship!");
        primaryStage.setScene(s);
        primaryStage.show();
    }


}
