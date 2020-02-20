package src;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

public class MarketPage {

    public MarketPage(Stage primaryStage, Player p1, Region region, Region[] array) {
        VBox root = new VBox(40);
        Scene mktscene = new Scene(root, 800, 800);

        //HBox for middle of screen
        VBox mid = new VBox(40);
        mid.setAlignment(Pos.TOP_CENTER);
        mid.setPrefHeight(400);

        //HBox for the top of the screen
        HBox top = new HBox(40);
        top.setAlignment(Pos.TOP_LEFT);
        top.setPrefHeight(400);

        //Back to Region Page button
        Button back = new Button("Back to Orbit");
        back.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        back.setTextFill(Color.WHITE);
        back.setOnMouseClicked((MouseEvent m) -> {
            RegionPage r = new RegionPage(primaryStage, p1, region, array);
        });

        HBox marketitems = new HBox();
        marketitems.setSpacing(15.0);
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
                try {
                    p1.buyGoods(region, i, p1.getSpaceShip(), p1);
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION, p1.getName() + ", you just bought "
                            + i.getName() + " for " + i.getBuyPrice() + ". Now you have "
                            + p1.getSpaceShip().getQuantity(i) + " " + i.getName() + "s in your inventory!");
                    a.show();
                } catch (IllegalAccessException s) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "This item is all sold out! Come back " +
                            "another time.");
                    a.show();
                } catch (IllegalStateException s) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "your cargo capacity is full. time to sell " +
                            "your stuff");
                    a.show();
                }

            Tooltip postSale = new Tooltip("Price: " + i.getBuyPrice() + "\n" + i.getName()
                    + "s left in stock: " + i.getQuantity());
            postSale.setShowDelay(Duration.ZERO);
            item.setTooltip(postSale);

            });
//            sell.setOnMouseClicked(mouseEvent -> {
//                p1.sellGoods(region, item1, p1.getSpaceShip(), p1);
//            });
        }
        marketitems.setAlignment(Pos.CENTER);

        //Welcome text for market
        Text welcome = new Text("Welcome to the \n" + region.getName() + " market");
        ArrayList<Item> items = region.getMarket().getItems();
        for (int p = 0; p < items.size(); p++) {
            Item i = items.get(p);
            System.out.println("Item " + p + ": " + i.getName());
            System.out.println("Item " + p + " quantity: " + i.getQuantity());
        }

        welcome.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
        welcome.setTextAlignment(TextAlignment.CENTER);


        //Add buttons for buying or selling
        //Hbox to hold these buttons
        HBox toggletrade = new HBox();
        toggletrade.setAlignment(Pos.CENTER);
        Button buy = new Button("Buy");
        buy.setOnAction((ActionEvent e) -> {
            mid.getChildren().remove(2);
            mid.getChildren().add(marketitems);
        });
        Button sell = new Button("Sell");
        sell.setOnAction((ActionEvent e) -> {
            HBox invenitems = new HBox();
            invenitems.setAlignment(Pos.CENTER);
            HashMap<Item, Integer> inventory = p1.getSpaceShip().getInventory();
            for (Item i : inventory.keySet()) {
                Button b = new Button(i.getName());
                b.setOnAction((ActionEvent ae) -> {
                    i.setQuantity(i.getQuantity() - 1);
                    inventory.remove(i);
                    invenitems.getChildren().remove(b);
                    p1.setCredits(p1.getCredits() + i.getSellPrice());
                });
                invenitems.getChildren().add(b);
            }
            mid.getChildren().remove(2);
            mid.getChildren().add(invenitems);
        });

        toggletrade.getChildren().addAll(buy, sell);



        mid.getChildren().addAll(welcome, toggletrade, marketitems);

//        // testing backend, it works!!
//             Text testing = new Text("Testing: " + p1.getSpaceShip().getName() + ", " + region.getItem1Description());
//        Text itemForSale = new Text("For sale: " + item1.getName() + ". The price is " + item1.getBuyPrice());

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

        root.getChildren().addAll(top, mid);


        //Making scene show
        primaryStage.setScene(mktscene);
        primaryStage.show();

    }

}
