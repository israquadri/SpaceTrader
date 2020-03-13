package src;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

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

        ImageView traderShip = new ImageView(new Image("trader.png"));
        traderShip.setFitHeight(250);
        traderShip.setFitWidth(250);

        Path path = new Path();
        path.getElements().add (new MoveTo(800, 90));
        path.getElements().add (new HLineTo(-20));
        path.getElements().add (new MoveTo(800, 700));
        path.getElements().add (new HLineTo(-40));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(10));
        pathTransition.setNode(traderShip);
        //pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setPath(path);
        pathTransition.setCycleCount(Animation.INDEFINITE);

        pathTransition.play();

        VBox optionBox = new VBox();
        optionBox.setPadding(new Insets(10, 10, 10, 10));
        optionBox.setSpacing(20.0);


        Button option2 = new Button("Proceed to \n" + p1.getDestination().getName());
        option2.setOnMouseClicked(mouseEvent -> {
            p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination()));
            RegionPage ignoreTrader = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
        });
        option2.setAlignment(Pos.CENTER);
        option2.setTextFill(Color.WHITE);
        option2.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 17px;");
        option2.setTextAlignment(TextAlignment.CENTER);


        Text traderOffer = new Text("Trader: I can sell you a " + trader.getItemToSell().getName() +  " for " + trader.getItemToSell().getBuyPrice() + " credits.");
        traderOffer.setStyle("-fx-font-size: 17px; -fx-font-family: 'Press Start 2P', cursive;");
        traderOffer.setTextAlignment(TextAlignment.CENTER);
        traderOffer.setFill(Color.WHITE);

        Button option3 = new Button("Negotiate with Trader");
        option3.setOnMouseClicked(mouseEvent -> {
            double previousPrice = trader.getItemToSell().getBuyPrice();
            boolean success = trader.determineSuccess(p1.getFighterSkill());
            if (success) {
                trader.decreasePrice();
                traderOffer.setText("Trader: I can sell you a " + trader.getItemToSell().getName() +  " for " + trader.getItemToSell().getBuyPrice() + " credits.");
                Alert a = new Alert(Alert.AlertType.INFORMATION, "The trader has decreased the price from "
                        + previousPrice + " to " + trader.getItemToSell().getBuyPrice() + " credits.");
                DialogPane dialogPane = a.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                a.show();
            } else {
                trader.increasePrice();
                traderOffer.setText("Trader: I can sell you a " + trader.getItemToSell().getName() +  " for " + trader.getItemToSell().getBuyPrice() + " credits.");
                Alert a = new Alert(Alert.AlertType.INFORMATION, "You failed to negotiate for a lower price. The trader"
                        + " has increased the price from " + previousPrice
                        + " to " + trader.getItemToSell().getBuyPrice() + " credits.");
                DialogPane dialogPane = a.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                a.show();
            }
            trader.makeNegotiationComplete();
            optionBox.getChildren().remove(option3);
        });

        option3.setAlignment(Pos.CENTER);
        option3.setTextFill(Color.WHITE);
        option3.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 17px;");


        Button option1 = new Button("Buy Trader's Item");
        option1.setOnMouseClicked(mouseEvent -> {
            if (p1.getCredits() >= trader.getItemToSell().getBuyPrice()) {
                p1.setCredits(p1.getCredits() - trader.getItemToSell().getBuyPrice());
                p1.getSpaceShip().addToInventory(trader.getItemToSell());
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You bought one " + trader.getItemToSell().getName() + " from the trader.");
                DialogPane dialogPane = a.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                a.show();
            } else {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "You don't have enough credits to purchase one "
                        + trader.getItemToSell().getName() + " . Try negotiating for a lower price.");
                DialogPane dialogPane = a.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                a.show();
            }
        });
        option1.setAlignment(Pos.CENTER);
        option1.setTextFill(Color.WHITE);
        option1.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 17px;");

        Button option4 = new Button("Rob Trader");
        option4.setOnMouseClicked(mouseEvent -> {
            boolean success = trader.determineSuccess(p1.getFighterSkill());
            if (success) {
                ArrayList<String> stolenItems = new ArrayList<>();
                for (int i = 0; i < trader.getInventory().size(); i++) {
                    if ((i % 2) == 0) {
                        p1.getSpaceShip().addToInventory(trader.getInventory().get(i));
                        stolenItems.add(trader.getInventory().get(i).getName());
                    }
                }
                p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination()));
                RegionPage ignoreTrader = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You robbed the trader! Stolen items: " + stolenItems.toString());
                DialogPane dialogPane = a.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                a.show();
            } else {
                p1.getSpaceShip().setHealth(p1.getSpaceShip().getHealth() - 1);
                p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().distanceBetween(p1.getDestination()));
                RegionPage ignoreTrader = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You failed to rob the trader. Your ship's health has decreased.");
                DialogPane dialogPane = a.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                a.show();
            }
        });
        option4.setAlignment(Pos.CENTER);
        option4.setTextFill(Color.WHITE);
        option4.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 17px;");

        //Drop Shadow effect
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.CORAL);
        shadow.setWidth(1.5);
        option1.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        option1.setEffect(shadow);
                    }
                });
        option2.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        option2.setEffect(shadow);
                    }
                });
        option3.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        option3.setEffect(shadow);
                    }
                });
        option4.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        option4.setEffect(shadow);
                    }
                });
        //adding the shadow when the mouse cursor is on
        option1.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        option1.setEffect(null);
                    }
                });
        option2.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        option2.setEffect(null);
                    }
                });
        option3.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        option3.setEffect(null);
                    }
                });
        option4.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        option4.setEffect(null);
                    }
                });

        optionBox.getChildren().addAll(option1, option2, option3, option4);
        optionBox.setAlignment(Pos.CENTER);
        optionBox.setPadding(new Insets(15, 5, 0, 0));

        Text traderText = new Text("You've encountered\na fellow trader!");
        traderText.setStyle("-fx-font-size: 40px; -fx-font-family: 'Press Start 2P', cursive;");
        traderText.setTextAlignment(TextAlignment.CENTER);
        traderText.setFill(Color.WHITE);

        VBox box2 = new VBox();
        //box2.setPadding(new Insets(10, 10, 10, 10));
        box2.setSpacing(15);
        box2.setAlignment(Pos.CENTER);
        box2.getChildren().addAll(traderText, traderOffer, optionBox);

        root.getChildren().addAll(traderShip, box2);

        primaryStage.setTitle("You've encountered a fellow trader!");
        primaryStage.setScene(s);
        primaryStage.show();
    }
}

