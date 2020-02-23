package src;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
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
        VBox root = new VBox(40);
        Scene inventory = new Scene(root, 800, 800);
        inventory.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
        BackgroundImage myBI = new BackgroundImage(new Image("interior.png", 800,
                800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setStyle("-fx-background-color: rgb(105,105,105);");

        //Welcome text for market
        Text welcome = new Text(p1.getName() + "'s Inventory");
        welcome.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
        welcome.setTextAlignment(TextAlignment.CENTER);

        //Back to Region Page button
        Button back = new Button("Back to Spaceship");
        back.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        back.setTextFill(Color.WHITE);
        back.setOnMouseClicked((MouseEvent m) -> {
            SpaceshipInterior r = new SpaceshipInterior(primaryStage, p1, array);
        });


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(100,100,100,100));
        grid.setHgap(100);
        grid.setVgap(100);
        grid.setAlignment(Pos.CENTER);
        grid.getStyleClass().add("grid");
        //grid.setStyle(" -fx-background-radius: 25;");
        SpaceShip mySpaceship = p1.getSpaceShip();
        int cols=2, colCnt = 0, rowCnt = 0;
        for (Item i: p1.getSpaceShip().getInventory().keySet()) {
            Button myItem = new Button("" + i.getName());
            myItem.setGraphic(new ImageView(i.getImage()));
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
        root.getChildren().addAll(back, welcome, grid);

        //Making scene show
        primaryStage.setScene(inventory);
        primaryStage.show();
    }
}
