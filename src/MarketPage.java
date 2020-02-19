package src;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.HashMap;

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
        for (Item i: region.getRegionItems()) {
            Button item = new Button(i.getName());
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

            Tooltip stock = new Tooltip("Price: " + i.getBuyPrice() + "\n" + i.getName()
                    + "s left in stock: " + i.getQuantity());
            stock.setShowDelay(Duration.ZERO);
            item.setTooltip(stock);

            });
//            sell.setOnMouseClicked(mouseEvent -> {
//                p1.sellGoods(region, item1, p1.getSpaceShip(), p1);
//            });
        }
        marketitems.setAlignment(Pos.CENTER);

        //Welcome text for market
        Text welcome = new Text("Welcome to the \n" + region.getDescription() + " market");
        welcome.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
        welcome.setTextAlignment(TextAlignment.CENTER);

        mid.getChildren().addAll(welcome, marketitems);

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
