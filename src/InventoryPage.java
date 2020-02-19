package src;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Map;

public class InventoryPage {

    public InventoryPage(Stage primaryStage, Player p1, Region region, Region[] array) {
        VBox root = new VBox(40);
        Scene inventory = new Scene(root, 800, 800);

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

        HBox myItems = new HBox();
        for (Map.Entry<Item, Integer> i: p1.getSpaceShip().getInventory().entrySet()) {
            Button item = new Button("" + i.getKey().getName() + ": " + i.getValue());
            myItems.getChildren().add(item);
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
        root.getChildren().addAll(back, welcome, myItems);

        //Making scene show
        primaryStage.setScene(inventory);
        primaryStage.show();
    }
}
