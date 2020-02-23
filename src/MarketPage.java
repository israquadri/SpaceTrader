package src;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class MarketPage {

    public MarketPage(Stage primaryStage, Player p1, Region region, Region[] array) {
        VBox root = new VBox(40);
        Scene mktscene = new Scene(root, 800, 800);
        root.setBackground(new Background(new BackgroundFill(Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));

        //HBox for middle of screen
        VBox mid = new VBox(20);
        mid.setAlignment(Pos.TOP_CENTER);
        mid.setBackground(new Background(new BackgroundFill(Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));

        //HBox for the top of the screen
        HBox top = new HBox(40);
        top.setAlignment(Pos.TOP_LEFT);
        top.setBackground(new Background(new BackgroundFill(Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));

        //Back to Region Page button
        Button back = new Button("Back to Orbit");
        back.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        back.setTextFill(Color.WHITE);
        back.setOnMouseClicked((MouseEvent m) -> {
            RegionPage r = new RegionPage(primaryStage, p1, region, array);
        });

        //Text to show amount of credits
        Text creditsLeft = new Text("Credits: " + p1.getCredits());
        creditsLeft.setTextAlignment(TextAlignment.CENTER);
        creditsLeft.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 10px;");

        VBox marketitems = new VBox();
        marketitems.setAlignment(Pos.TOP_CENTER);
        marketitems.getChildren().add(new Text("BUY"));
        marketitems.setSpacing(15.0);
        marketitems.setPrefHeight(400);
        for (Item i: region.getMarket().getItems()) {
            Button item = new Button(i.getName());
            item.setGraphic(new ImageView(i.getImage()));
            item.setContentDisplay(ContentDisplay.TOP);

            Tooltip preSale = new Tooltip("Price: " + i.getBuyPrice() + "\n" + i.getName()
                    + "s left in stock: " + i.getQuantity());
            preSale.setShowDelay(Duration.ZERO);
            item.setTooltip(preSale);

            marketitems.getChildren().add(item);
            item.setOnMouseClicked(mouseEvent -> {
                Alert a = p1.buyGoods(i);
                a.show();
                if (i.getQuantity() == 0) {
                    region.getMarket().removeItem(i);
                    marketitems.getChildren().remove(item);
                }

                String creditUpdate = new String("Credits: " + p1.getCredits());
                creditsLeft.setText(creditUpdate);

                Tooltip postSale = new Tooltip("Price: " + i.getBuyPrice() + "\n" + i.getName()
                        + "s left in stock: " + i.getQuantity());
                postSale.setShowDelay(Duration.ZERO);
                item.setTooltip(postSale);

            });
        }

        VBox inventoryItems = new VBox();
        inventoryItems.setAlignment(Pos.TOP_CENTER);
        inventoryItems.getChildren().add(new Text("SELL"));
        inventoryItems.setSpacing(15.0);
        inventoryItems.setPrefHeight(400);
        SpaceShip mySpaceship = p1.getSpaceShip();
        for (Item i: p1.getSpaceShip().getInventory().keySet()) {
            Button myItem = new Button("" + i.getName());
            myItem.setGraphic(new ImageView(i.getImage()));
            myItem.setContentDisplay(ContentDisplay.TOP);
            Tooltip preSale = new Tooltip("Price: " + i.getSellPrice() + "\n" + i.getName()
                    + "s left in inventory: " + mySpaceship.getQuantity(i));
            preSale.setShowDelay(Duration.ZERO);
            myItem.setTooltip(preSale);

            myItem.setOnMouseClicked(mouseEvent -> {
                p1.sellGoods(p1.getCurrentRegion(), i);
                //Removing if quantity is 0
                if (!p1.getSpaceShip().getInventory().containsKey(i)) {
                    inventoryItems.getChildren().remove(myItem);
                }

                String creditUpdate = new String("Credits: " + p1.getCredits());
                creditsLeft.setText(creditUpdate);

                Alert a = new Alert(Alert.AlertType.CONFIRMATION, p1.getName() + ", you just sold a "
                        + i.getName() + " for " + i.getSellPrice() + ". \nNow you have "
                        + mySpaceship.getQuantity(i) + " " + i.getName() + "s in your inventory!");
                DialogPane dialogPane = a.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                a.show();
                //a.getDialogPane().setStyle("-fx-background-color: black; -fx-text-fill: white;");

                Tooltip postSale = new Tooltip("Price: " + i.getSellPrice() + "\n" + i.getName()
                        + "s left in inventory: " + mySpaceship.getQuantity(i));
                postSale.setShowDelay(Duration.ZERO);
                myItem.setTooltip(postSale);

            });

            inventoryItems.getChildren().add(myItem);
        }

        Button refresh = new Button("Refresh");
        refresh.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 10px;");
        refresh.setTextFill(Color.WHITE);
        refresh.setOnMouseClicked(mouseEvent -> {
            MarketPage mkt = new MarketPage(primaryStage, p1, region, array);
        });

        //Welcome text for market
        Text welcome = new Text("Welcome to the \n" + region.getName() + " market");

        mid.getChildren().addAll(welcome, refresh);

        welcome.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
        welcome.setTextAlignment(TextAlignment.CENTER);

        //Drop shadow effect
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.CORAL);
        shadow.setWidth(1.5);

        //Drop shadow effect being applied to back button
        back.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        back.setEffect(shadow);
                    }
                });
        //adding the shadow when the mouse cursor is on
        back.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        back.setEffect(null);
                    }
                });
        top.getChildren().add(back);


        HBox bottom = new HBox();
        bottom.setSpacing(150);
        bottom.setPrefHeight(400);
        bottom.setAlignment(Pos.TOP_CENTER);
        bottom.getChildren().addAll(marketitems, creditsLeft, inventoryItems);

        root.getChildren().addAll(top, mid, bottom);

        //Making scene show
        primaryStage.setScene(mktscene);
        primaryStage.show();

    }

}
