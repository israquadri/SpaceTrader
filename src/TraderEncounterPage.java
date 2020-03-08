package src;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TraderEncounterPage {
    /*
    * Option 1 - Buy Item:
    *   - itemSold = trader.getItemToSell()
    *   * check if the player has enough credit to purchase item(s)
    *   - push (itemSold, itemSold.getQuantity()) to player's inventory
    *   * I don't think the trader's inventory needs to be updated since it doesn't affect anything
    *
    * Option 2 - Ignore Trader:
    *   - continue to intended destination
    *
    * Option 3 - Rob trader:
    *   1. Determine the player's success by doing trader.determineSuccess(player.getFighterSkill)
    *       - if (success) -> player robs itemToSell
    *         * the rubric only says "some of trader's items are added to player inventory" so I guess it doesn't really
    *            matter which item/how many of them is stolen?
    *       - else -> player's ship health lowered, continues to intended destination
    * Option 4 - Negotiate price
    *   1. trader.determineSuccess(player.getMerchantSkill)
    *       - if (success) -> trader.decreasePrice()
    *       - else -> trader.increasePrice()
    *  2. get rid of option 4 since the player can negotiate for price only once
    *  */
    public TraderEncounterPage(Stage primaryStage, Region[] regions, Player p1, Trader trader) {
        VBox root = new VBox();
        Scene s = new Scene(root, 800, 800);
        BackgroundImage myBI = new BackgroundImage(new Image("starback.jpg", 800,
                800, true, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));

        Button option2 = new Button("Proceed to \n" + p1.getDestination().getName());
        option2.setOnMouseClicked(mouseEvent -> {
            p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination()));
            RegionPage ignoreTrader = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
        });


        Button option3 = new Button("Negotiate with Trader");
        option3.setOnMouseClicked(mouseEvent -> {
            if (!trader.getNegotiationStatus()) {
                double previousPrice = trader.getItemToSell().getBuyPrice();
                boolean success = trader.determineSuccess(p1.getFighterSkill());
                if (success) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "The trader has decreased the price from "
                            + previousPrice + " to " + trader.getItemToSell().getBuyPrice());
                    a.show();
                } else {
                    trader.increasePrice();
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "You failed to negotiate for a lower price. The trader" +
                            "has increased the price from " + previousPrice
                            + " to " + trader.getItemToSell().getBuyPrice());
                    a.show();
                }
                trader.makeNegotiationComplete();
            } else {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "You only had one chance to negotiate with the trader.");
                a.show();
            }
        });

        Button option1 = new Button("Buy Trader's Item");
        option1.setOnMouseClicked(mouseEvent -> {
            if (p1.getCredits() >= trader.getItemToSell().getBuyPrice()) {
                p1.setCredits(p1.getCredits() - trader.getItemToSell().getBuyPrice());
                p1.getSpaceShip().addToInventory(trader.getItemToSell());
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You brought one " + trader.getItemToSell().getName() + " from the trader.");
                a.show();
                root.getChildren().removeAll(option3);
            } else {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "You don't have enough credits to purchase one "
                        + trader.getItemToSell().getName() + " . Try negotiating for a lower price.");
                a.show();
            }
        });

        Button option4 = new Button("Rob Trader");
        option4.setOnMouseClicked(mouseEvent -> {
            boolean success = trader.determineSuccess(p1.getFighterSkill());
            if (success) {
                for (int i = 0; i < trader.getInventory().size(); i++) {
                    if ((i % 2) == 0) {
                        p1.getSpaceShip().addToInventory(trader.getInventory().get(i));
                    }
                }
                p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination()));
                RegionPage ignoreTrader = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You robbed the trader!");
                a.show();
            } else {
                p1.getSpaceShip().setHealth(p1.getSpaceShip().getHealth() - 1);
                p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination()));
                RegionPage ignoreTrader = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You failed to rob the trader. Your ship's health has decreased.");
                a.show();
            }
        });

        root.getChildren().addAll(option1, option2, option3, option4);

        primaryStage.setTitle("You've encountered a fellow trader!");
        primaryStage.setScene(s);
        primaryStage.show();
    }
}

