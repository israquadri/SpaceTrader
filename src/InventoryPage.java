package src;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
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

import java.util.Map;

public class InventoryPage {

    public InventoryPage(Stage primaryStage, Player p1, Region region, Region[] array) {
        VBox root = new VBox(10);
        Scene inventory = new Scene(root, 800, 800);
        inventory.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
        BackgroundImage myBI = new BackgroundImage(new Image("inventoryPIC.jpeg", 800,
                800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));
        root.setAlignment(Pos.CENTER);

        //Welcome text for market
        VBox vBox = new VBox(10);
        Text welcome = new Text(p1.getName() + "'s Inventory");
        welcome.setStyle("-fx-font-size: 40px; -fx-font-family: 'Krona One'; -fx-text-align: center;");
        welcome.setTextAlignment(TextAlignment.CENTER);
        welcome.setFill(Color.WHITESMOKE);
        Background background = new Background(new BackgroundFill(Color.rgb(0, 22, 43), CornerRadii.EMPTY, Insets.EMPTY));
        vBox.setPadding(new Insets(40));
        vBox.setBackground(background);
        vBox.getChildren().add(welcome);


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
        grid.setPadding(new Insets(10,10,10,20));
        grid.setHgap(50);
        grid.setVgap(50);
        grid.setAlignment(Pos.CENTER);
        gridBox.setBackground(new Background(new BackgroundFill(Color.rgb(0, 22, 43), CornerRadii.EMPTY, Insets.EMPTY)));
        Border border = new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
        gridBox.setBorder(border);
        grid.getStyleClass().add("grid");
        gridBox.getChildren().add(grid);
        gridBox.setVgrow(grid, Priority.ALWAYS);
        //grid.setStyle(" -fx-background-radius: 25;");
        SpaceShip mySpaceship = p1.getSpaceShip();
        int cols=3, colCnt = 0, rowCnt = 0;
        for (Item i: p1.getSpaceShip().getInventory().keySet()) {
            ImageView iv = new ImageView(i.getImage());
            iv.setFitWidth(50);
            iv.setFitHeight(50);
            iv.setPreserveRatio(true);
            iv.setSmooth(true);
            iv.setCache(true);
            Button myItem = new Button("" + i.getName());
            //Button item = new Button(i.getName());
            myItem.setGraphic(iv);
            myItem.setContentDisplay(ContentDisplay.TOP);
            Tooltip preSale = new Tooltip("Sell Price: " + i.getSellPrice() + "\n"
                    + " Quantity:" + mySpaceship.getQuantity(i));
            preSale.setShowDelay(Duration.ZERO);
            myItem.setAlignment(Pos.CENTER);
            myItem.setTooltip(preSale);
            myItem.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-text-fill: white;"
                    + "-fx-background-color: rgb(128,128,128); -fx-font-size: 10px; -fx-text-align: center;");

                grid.add(myItem,colCnt,rowCnt);
                colCnt++;

                if (colCnt>cols) {
                    rowCnt++;
                    colCnt=0;
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
        scrollpane.setBackground(new Background(new BackgroundFill(Color.rgb(0, 22, 43), CornerRadii.EMPTY, Insets.EMPTY)));
        root.getChildren().addAll(back, vBox, scrollpane);

        //Adding picture of character and text showing his name
        ImageView charpic = new ImageView(new Image("CharacterPicture.png"));
        root.getChildren().add(charpic);
        Text chartext = new Text("Thanos");
        chartext.setStyle("-fx-font-size: 20px; -fx-font-family: 'Press Start 2P'; -fx-text-align: center;");
        root.getChildren().add(chartext);


        //Making scene show
        primaryStage.setScene(inventory);
        primaryStage.setTitle("Your inventory");
        primaryStage.show();
    }
}
