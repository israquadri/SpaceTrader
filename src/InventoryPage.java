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
import javafx.scene.layout.Background;
import javafx.util.Duration;

public class InventoryPage {

    public InventoryPage(Stage primaryStage, Player p1, Region region, Region[] array) {
        VBox root = new VBox(10);
        Scene inventory = new Scene(root, 800, 800);
        inventory.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
        BackgroundImage myBI = new BackgroundImage(new Image("inventoryPIC.jpeg", 800,
                800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20));

        //Welcome text for inventory
        VBox vBox = new VBox(10);
        Text welcome = new Text(p1.getName() + "'s Inventory");
        welcome.setStyle("-fx-font-size: 40px; -fx-font-family:"
                + " 'Press Start 2P'; -fx-text-align: center;");
        welcome.setTextAlignment(TextAlignment.CENTER);
        Text credits = new Text("Credits: " + p1.getCredits());
        credits.setStyle("-fx-font-size: 15px; -fx-font-family:"
                + " 'Press Start 2P'; -fx-text-align: center;");
        credits.setFill(Color.WHITE);
        welcome.setFill(Color.WHITESMOKE);
        Background background = new Background(new BackgroundFill(Color.rgb(0,
                22, 43), CornerRadii.EMPTY, Insets.EMPTY));
        vBox.setPadding(new Insets(30, 10, 30, 10));
        vBox.setBackground(background);
        vBox.getChildren().addAll(welcome, credits);
        vBox.setAlignment(Pos.TOP_CENTER);

        //HBox fo hold inventory, character and upgrades
        HBox mid = new HBox();

        //VBox or inventory
        VBox left = new VBox();
        left.setPrefWidth(267);
        left.setPrefHeight(400);
        left.setAlignment(Pos.CENTER);
        Text inventorytext = new Text("Inventory");
        inventorytext.setStyle("-fx-font-size: 15px; -fx-font-family:"
                + " 'Press Start 2P'; -fx-text-align: center;");
        inventorytext.setFill(Color.WHITE);
        left.getChildren().add(inventorytext);


        //Back to Region Page button
        Button back = new Button("Back to Spaceship");
        back.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        back.setTextFill(Color.WHITE);
        back.setOnMouseClicked((MouseEvent m) -> {
            SpaceshipInterior r = new SpaceshipInterior(primaryStage, p1, array);
        });


        VBox gridBox = new VBox();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 20));
        grid.setHgap(50);
        grid.setVgap(50);
        grid.setAlignment(Pos.CENTER);
        gridBox.setBackground(new Background(new BackgroundFill(Color.rgb(0,
                22, 43), CornerRadii.EMPTY, Insets.EMPTY)));
        gridBox.setAlignment(Pos.CENTER);
        Border border = new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
        gridBox.setBorder(border);
        grid.getStyleClass().add("grid");
        //gridBox.getChildren().add(grid);
        VBox.setVgrow(grid, Priority.ALWAYS);
        gridBox.setPrefWidth(240);
        gridBox.setPrefHeight(400);
        //grid.setStyle(" -fx-background-radius: 25;");
        SpaceShip mySpaceship = p1.getSpaceShip();
        int cols = 3;
        int colCnt = 0;
        int rowCnt = 0;
        for (Item i: p1.getSpaceShip().getInventory().keySet()) {
            ImageView iv = new ImageView(i.getImage());
            iv.setFitWidth(50);
            iv.setFitHeight(50);
            iv.setPreserveRatio(true);
            iv.setSmooth(true);
            iv.setCache(true);
            Button myItem = new Button(i.getName());
            myItem.setTextAlignment(TextAlignment.CENTER);
            myItem.setGraphic(iv);
            myItem.setContentDisplay(ContentDisplay.TOP);
            myItem.setBackground(Background.EMPTY);
            Tooltip preSale = new Tooltip("Sell Price: " + i.getSellPrice() + "\n"
                    + " Quantity:" + mySpaceship.getQuantity(i));
            preSale.setShowDelay(Duration.ZERO);
            myItem.setAlignment(Pos.CENTER);
            myItem.setTooltip(preSale);
            myItem.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-text-fill: white;"
                    + " -fx-font-size: 10px; -fx-text-align: center;");

            //grid.add(myItem, colCnt, rowCnt);
            gridBox.getChildren().add(myItem);
            colCnt++;

            if (colCnt > cols) {
                rowCnt++;
                colCnt = 0;
            }
        }

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

        //Adding different hboxes to root vbox node
        ScrollPane scrollpane = new ScrollPane(gridBox);
        scrollpane.setFitToHeight(true);
        scrollpane.setFitToWidth(true);
        scrollpane.setBackground(new Background(new BackgroundFill(Color.rgb(0, 22, 43),
                CornerRadii.EMPTY, Insets.EMPTY)));
        root.getChildren().addAll(back, vBox, mid);

        //Adding picture of character and text showing his name
        Text chartext = new Text("Thanos");
        chartext.setStyle("-fx-font-size: 20px; -fx-font-family:"
                + " 'Press Start 2P'; -fx-text-align: center;");
        chartext.setFill(Color.WHITE);

        //Making a right vbox for the character upgrades
        VBox right = new VBox();
        right.setSpacing(10);
        right.setPadding(new Insets(10, 0, 0, 10));
        right.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        right.setAlignment(Pos.TOP_CENTER);
        right.setPrefWidth(240);
        right.setBackground(new Background(new BackgroundFill(Color.rgb(0,
                22, 43), CornerRadii.EMPTY, Insets.EMPTY)));

        Text upgrade = new Text("Character Upgrades:");
        upgrade.setStyle("-fx-font-size: 10px; -fx-font-family:"
                + " 'Press Start 2P'; -fx-text-align: center;");
        upgrade.setFill(Color.WHITE);


        Text gauntlet = new Text("Explorer: \nUnlock all planet names\n (50 Credits)");
        gauntlet.setStyle("-fx-font-size: 10px; -fx-font-family:"
                + " 'Press Start 2P'");
        gauntlet.setTextAlignment(TextAlignment.CENTER);
        gauntlet.setFill(Color.WHITE);
        Button upgrade1btn = new Button("Activate");
        upgrade1btn.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: gray; -fx-font-size: 10px;");
        upgrade1btn.setOnAction((ActionEvent e) -> {
            if (p1.getCredits() < 50) {
                Alert a = new Alert(Alert.AlertType.ERROR,
                        "You do not have enough credits to purchase this upgrade");
                DialogPane dialogPane = a.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                a.show();
            } else {
                p1.setCredits(p1.getCredits() - 50);
                for (Region r : array) {
                    r.setVisited();
                }
                right.getChildren().removeAll(gauntlet, upgrade1btn);
                p1.setUpgrade1(true);
            }
        });

        right.getChildren().addAll(upgrade);
        if (!p1.isUpgrade1()) {
            right.getChildren().addAll(gauntlet, upgrade1btn);
        }




        //Adding everything to mid hbox
        VBox midmid = new VBox();
        midmid.setAlignment(Pos.BOTTOM_CENTER);
        midmid.setPrefWidth(265);
        midmid.getChildren().addAll(chartext);
        left.getChildren().add(scrollpane);


        mid.getChildren().addAll(left, midmid, right);

        //Making scene show
        primaryStage.setScene(inventory);
        primaryStage.setTitle("Your inventory");
        primaryStage.show();
    }
}
