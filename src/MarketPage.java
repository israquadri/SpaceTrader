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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class MarketPage {

    public MarketPage(Stage primaryStage, Player p1, Region region, Region[] array) {
        //Root node for rest of scene
        VBox root = new VBox(40);
        Scene mktscene = new Scene(root, 800, 800);
        root.setBackground(new Background(new BackgroundFill(Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));

        //Music which i will promptly comment out
        //Media tradingsong = new Media(new File("SpaceTraderTradingSong.m4a").toURI().toString());
        //MediaPlayer music = new MediaPlayer(tradingsong);
        //music.play();

        //HBox for middle of screen
        VBox mid = new VBox(20);
        mid.setAlignment(Pos.TOP_CENTER);
        mid.setBackground(new Background(new BackgroundFill(Color.MIDNIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        mid.setPadding(new Insets(20, 20, 20, 20));
        Border border = new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT));
        mid.setBorder(border);

        //Drop shadow effect
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.CORAL);
        shadow.setWidth(1.5);

        //HBox for the top of the screen
        HBox top = new HBox(40);
        top.setAlignment(Pos.TOP_LEFT);
        top.setBackground(new Background(new BackgroundFill(Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));

        //HBOX for bottom of the screen where items are
        VBox bottom = new VBox();
        bottom.setSpacing(20);
        bottom.setPrefHeight(400);
        bottom.setAlignment(Pos.TOP_CENTER);

        //Back to Region Page button
        Button back = new Button("Back to Orbit");
        back.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 15px;");
        back.setTextFill(Color.WHITE);
        //Drop shadow effect
        back.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        back.setEffect(shadow);
                    }
                });
        back.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        back.setEffect(null);
                    }
                });
        back.setOnMouseClicked((MouseEvent m) -> {
            //music.stop();
            RegionPage r = new RegionPage(primaryStage, p1, region, array);
        });
        top.getChildren().add(back);

        //Text to show amount of credits
        Text creditsLeft = new Text("Credits: " + p1.getCredits());
        creditsLeft.setUnderline(true);
        creditsLeft.setFill(Color.WHITE);
        creditsLeft.setStyle("-fx-font-size: 10px; -fx-font-family: 'Press Start 2P', cursive;");
        creditsLeft.setTextAlignment(TextAlignment.CENTER);

        //Welcome text for market
        Text welcome = new Text("Welcome to the \n" + region.getName() + " market");
        welcome.setFill(Color.WHITE);
        welcome.setStyle("-fx-font-size: 30px; -fx-font-family: 'Krona One';");



        //BUY AREA BEGINS//
        //Button for buying
        Button buybutton = new Button("Buy");
        buybutton.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 15px;");
        buybutton.setTextFill(Color.WHITE);
        //drop shadow effect fo buybutton
        buybutton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        buybutton.setEffect(shadow);
                    }
                });
        //drop shadow effect for buybutton
        buybutton.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        buybutton.setEffect(null);
                    }
                });
        buybutton.setOnAction((ActionEvent e) -> {
            bottom.getChildren().clear();
            GridPane marketitems = new GridPane();
            marketitems.setAlignment(Pos.TOP_CENTER);
            Text buy = new Text("BUY");
            buy.setUnderline(true);
            buy.setFill(Color.WHITE);
            buy.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
            bottom.getChildren().add(buy);
            int row1 = 0;
            int col1 = 0;
            for (Item i: region.getMarket().getItems()) {
                Button item = new Button(i.getName());
                item.setGraphic(new ImageView(i.getImage()));
                item.setContentDisplay(ContentDisplay.TOP);

                Tooltip preSale = new Tooltip("Price: " + i.getBuyPrice() + "\n" + i.getName()
                        + "s left in stock: " + i.getQuantity());
                preSale.setShowDelay(Duration.ZERO);
                item.setTooltip(preSale);

                marketitems.add(item, col1 % 4, row1);
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
                col1++;
                row1 = col1 / 4;
            }
            bottom.getChildren().add(marketitems);

        });
        //BUY AREA ENDS//


        

        //SELL AREA BEGINS//
        //Button for selling
        Button sellbutton = new Button("Sell");
        sellbutton.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 15px;");
        sellbutton.setTextFill(Color.WHITE);
        //Drop shadow effect being applied to sellbutton
        sellbutton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        sellbutton.setEffect(shadow);
                    }
                });
        //drop shadow effect for sellbutton
        sellbutton.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        sellbutton.setEffect(null);
                    }
                });
        sellbutton.setOnAction((ActionEvent m) -> {
            bottom.getChildren().clear();
            GridPane inventoryItems = new GridPane();
            inventoryItems.setAlignment(Pos.TOP_CENTER);
            Text sell = new Text("SELL");
            sell.setUnderline(true);
            sell.setFill(Color.WHITE);
            sell.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
            bottom.getChildren().add(sell);
            inventoryItems.setPrefHeight(400);
            SpaceShip mySpaceship = p1.getSpaceShip();
            int row2 = 0;
            int col2 = 0;
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

                inventoryItems.add(myItem, col2 % 4, row2);
                col2++;
                row2 = col2 / 4;
            }
            bottom.getChildren().add(inventoryItems);
        });
        //SELL AREA ENDS//



        //HBox for buy and sell button
        HBox buysell = new HBox(10);
        buysell.setAlignment(Pos.CENTER);
        buysell.getChildren().addAll(buybutton, sellbutton);

        //Adding welcome text and buy and sell buttons to mid vbox
        mid.getChildren().addAll(welcome,creditsLeft,buysell);

       // welcome.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
        welcome.setTextAlignment(TextAlignment.CENTER);

        //Adding the three different parts of UI to root
        root.getChildren().addAll(top, mid, bottom);

        //Fire off buybutton at start so that buy gridpane automatically appears at start
        buybutton.fire();

        //Making scene show
        primaryStage.setScene(mktscene);
        primaryStage.show();

    }

}
