package src;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.ToggleButton;

public class MarketPage {

    public MarketPage(Stage primaryStage, Player p1, Region region, Region[] array) {
        //Root node for rest of scene
        VBox root = new VBox(40);

        Scene mktscene = new Scene(root, 800, 800);
        BackgroundImage myBI = new BackgroundImage(new Image("starback.jpg", 800,
                800, true, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));
        //root.setBackground(new Background(new BackgroundFill(Color.INDIANRED,
        // CornerRadii.EMPTY, Insets.EMPTY)));


        //Music which i will promptly comment out
        //Media tradingsong = new Media(new File("SpaceTraderTradingSong.m4a").toURI().toString());
        //MediaPlayer music = new MediaPlayer(tradingsong);
        //music.play();

        //HBox for middle of screen
        VBox mid = new VBox(20);
        mid.setAlignment(Pos.TOP_CENTER);
        mid.setBackground(new Background(new BackgroundFill(Color.rgb(0, 22, 43),
                CornerRadii.EMPTY, Insets.EMPTY)));
        mid.setPadding(new Insets(20, 20, 20, 20));
        Border border = new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, BorderWidths.DEFAULT));
        mid.setBorder(border);

        //Drop shadow effect
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.CORAL);
        shadow.setWidth(0.3);

        //HBox for the top of the screen
        HBox top = new HBox(40);
        top.setAlignment(Pos.TOP_LEFT);
        //top.setBackground(new Background(new
        // BackgroundFill(Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));

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

        //fuel display
        HBox fuelBox = new HBox();
        top.getChildren().add(fuelBox);
        top.setHgrow(fuelBox, Priority.ALWAYS);
        fuelBox.setAlignment(Pos.BASELINE_RIGHT);
        ProgressBar fuelTank = new ProgressBar(50);
        fuelTank.setProgress(p1.getSpaceShip().getFuel() / 50.0);
        fuelTank.setLayoutX(150);
        Text fuelText = new Text("Fuel");
        fuelText.setStyle("-fx-font-size: 12px; -fx-font-family: 'Press Start 2P', cursive;");
        fuelText.setFill(Color.WHITE);
        fuelBox.getChildren().addAll(fuelText, fuelTank);
        fuelBox.setSpacing(10);
        fuelBox.setPadding(new Insets(5, 5, 5, 5));

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
        //button group for toggle
        final ToggleGroup group = new ToggleGroup();
        //Button for buying
        ToggleButton buybutton = new ToggleButton("Buy");
        buybutton.setToggleGroup(group);
        buybutton.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: gray; -fx-font-size: 25px;");
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
            marketitems.setPadding(new Insets(10, 10, 10, 20));
            marketitems.setHgap(50);
            marketitems.setVgap(50);
            marketitems.setPrefHeight(400);
            marketitems.setBackground(new Background(new BackgroundFill(Color.rgb(0, 22, 43),
                    CornerRadii.EMPTY, Insets.EMPTY)));
            marketitems.setAlignment(Pos.TOP_CENTER);
            marketitems.setBorder(border);
            Text buy = new Text("BUY");
            buy.setUnderline(true);
            buy.setFill(Color.WHITE);
            buy.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
            bottom.getChildren().add(buy);
            int row1 = 0;
            int col1 = 0;
            for (Item i: region.getMarket().getItems()) {
                ImageView iv = new ImageView(i.getImage());
                iv.setFitWidth(100);
                iv.setFitHeight(100);
                iv.setPreserveRatio(true);
                iv.setSmooth(true);
                iv.setCache(true);
                Button item = new Button(i.getName());
                item.setGraphic(iv);
                item.setBackground(Background.EMPTY);
                item.setContentDisplay(ContentDisplay.TOP);
                item.setTextAlignment(TextAlignment.CENTER);
                item.setStyle("-fx-font-size: 0.9em; -fx-graphic-text-gap: 10px; -fx-font-family:"
                        + " 'Press Start 2P', cursive;");
                item.setTextFill(Color.WHITESMOKE);

                //DROP SHADOW EFFECT
                item.addEventHandler(MouseEvent.MOUSE_ENTERED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                item.setEffect(shadow);
                            }
                        });
                item.addEventHandler(MouseEvent.MOUSE_EXITED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                item.setEffect(null);
                            }
                        });

                Tooltip preSale = new Tooltip("Price: " + i.getBuyPrice() + "\n" + i.getName()
                        + "s left in stock: " + i.getQuantity());
                preSale.setShowDelay(Duration.ZERO);
                item.setTooltip(preSale);

                marketitems.add(item, col1 % 4, row1);
                item.setOnMouseClicked(mouseEvent -> {
                    if (i.getName().equals("Fuel") && !p1.getSpaceShip().isTankFull()) {
                        if (i.getBuyPrice() > p1.getCredits()) {
                            Alert a = new Alert(Alert.AlertType.ERROR, "You don't have"
                                    + " enough credits to refuel.");
                            a.show();
                        } else {
                            p1.setCredits(p1.getCredits() - i.getBuyPrice());
                            p1.getSpaceShip().reFuel(i.getBuyPrice());
                            fuelTank.setProgress(p1.getSpaceShip().getFuel() / 50.0);
                            String creditUpdate = new String("Credits: " + p1.getCredits());
                            creditsLeft.setText(creditUpdate);
                            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You added"
                                    + " approximately "
                                    + Math.round(p1.getSpaceShip().reFuel(i.getBuyPrice()))
                                    + " gallons to your fuel tank.");
                            a.show();
                        }
                    } else {
                        Alert a = p1.buyGoods(i);
                        a.show();
                        if (i.getQuantity() == 0) {
                            region.getMarket().removeItem(i);
                            marketitems.getChildren().remove(item);
                        }

                        String creditUpdate = new String("Credits: " + p1.getCredits());
                        creditsLeft.setText(creditUpdate);

                        Tooltip postSale = new Tooltip("Price: " + i.getBuyPrice()
                                + "\n" + i.getName() + "s left in stock: " + i.getQuantity());
                        postSale.setShowDelay(Duration.ZERO);
                        item.setTooltip(postSale);
                    }
                });
                col1++;
                row1 = col1 / 4;
            }
            bottom.getChildren().add(marketitems);
        });
        //BUY AREA ENDS//


        //SELL AREA BEGINS//
        //Button for selling
        ToggleButton sellbutton = new ToggleButton("Sell");
        sellbutton.setToggleGroup(group);
        sellbutton.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-base: gray; -fx-font-size: 25px; -fx-margin: 20px;");
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
            inventoryItems.setBackground(new Background(new
                    BackgroundFill(Color.rgb(0, 22, 43),
                    CornerRadii.EMPTY, Insets.EMPTY)));
            //Border border = new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,
            // CornerRadii.EMPTY, BorderWidths.DEFAULT));
            inventoryItems.setBorder(border);
            inventoryItems.setPadding(new Insets(10, 10, 10, 20));
            inventoryItems.setHgap(50);
            inventoryItems.setVgap(50);

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
                Button myItem = new Button(i.getName());
                ImageView iv = new ImageView(i.getImage());
                iv.setFitWidth(100);
                iv.setFitHeight(100);
                iv.setPreserveRatio(true);
                iv.setSmooth(true);
                iv.setCache(true);
                myItem.setGraphic(iv);
                myItem.setBackground(Background.EMPTY);
                myItem.setContentDisplay(ContentDisplay.TOP);
                myItem.setStyle("-fx-font-size: 0.9em; -fx-font-family:"
                        + " 'Press Start 2P', cursive;");
                myItem.setTextAlignment(TextAlignment.CENTER);
                myItem.setTextFill(Color.WHITESMOKE);

                //DROP SHADOW EFFECT
                myItem.addEventHandler(MouseEvent.MOUSE_ENTERED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                myItem.setEffect(shadow);
                            }
                        });
                myItem.addEventHandler(MouseEvent.MOUSE_EXITED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                myItem.setEffect(null);
                            }
                        });

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

                    Alert a = new Alert(Alert.AlertType.CONFIRMATION, p1.getName()
                            + ", you just sold a " + i.getName() + " for " + i.getSellPrice()
                            + ". \nNow you have " + mySpaceship.getQuantity(i) + " "
                            + i.getName() + "s in your inventory!");
                    DialogPane dialogPane = a.getDialogPane();
                    dialogPane.getStylesheets().add(
                            getClass().getResource("myDialogs.css").toExternalForm());
                    dialogPane.getStyleClass().add("myDialog");
                    a.show();
                    //a.getDialogPane().setStyle("-fx-background-color:
                    // black; -fx-text-fill: white;");

                    Tooltip postSale = new Tooltip("Price: " + i.getSellPrice()
                            + "\n" + i.getName() + "s left in inventory: "
                            + mySpaceship.getQuantity(i));
                    postSale.setShowDelay(Duration.ZERO);
                    myItem.setTooltip(postSale);

                });

                inventoryItems.add(myItem, col2 % 4, row2);
                col2++;
                row2 = col2 / 4;
            }

            ScrollPane scrollpane = new ScrollPane(inventoryItems);
            scrollpane.setBackground(new Background(new BackgroundFill(Color.rgb(0, 22, 43),
                    CornerRadii.EMPTY, Insets.EMPTY)));
            scrollpane.setFitToHeight(true);
            scrollpane.setFitToWidth(true);
            bottom.getChildren().add(scrollpane);
        });
        //SELL AREA ENDS//



        //HBox for buy and sell button
        HBox buysell = new HBox(15);
        buysell.setAlignment(Pos.CENTER);
        buysell.getChildren().addAll(buybutton, sellbutton);

        //Adding welcome text and buy and sell buttons to mid vbox
        mid.getChildren().addAll(welcome, creditsLeft, buysell);

        //welcome.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
        welcome.setTextAlignment(TextAlignment.CENTER);

        //Adding the three different parts of UI to root
        root.getChildren().addAll(top, mid, bottom);

        //Fire off buybutton at start so that buy gridpane automatically appears at start
        buybutton.fire();

        //creating scrollpane with root inside of scroll pane
        //ScrollPane scrollpane = new ScrollPane(inventoryItems);
        //scrollpane.setFitToHeight(true);
        //scrollpane.setFitToWidth(true);
        //Scene mktscene = new Scene(scrollpane, 800, 800);

        //Making scene show
        primaryStage.setScene(mktscene);
        primaryStage.show();

    }

}
