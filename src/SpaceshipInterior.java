package src;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SpaceshipInterior {

    public SpaceshipInterior(Stage primaryStage, Player p1, Region[] array) {

        Pane map = new Pane();
        // SCENE 3 BACKING STRUCTURE SET UP
        Scene scene3 = new Scene(map, 800, 800);
        scene3.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
        BackgroundImage myBI = new BackgroundImage(new Image("interior.png", 800,
                800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        map.setBackground(new Background(myBI));

        VBox controls = new VBox();
        controls.setLayoutX(250);
        controls.setLayoutY(200);

        Button toMap = new Button("go to map");
        toMap.setTextFill(Color.WHITE);
        toMap.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        toMap.setMinSize(10, 10);
        toMap.setOnMouseClicked(mouseEvent -> {
            Map mapPage = new Map(primaryStage, array, p1);
        });

        Button toRegion = new Button("back to region");
        toRegion.setAlignment(Pos.CENTER);
        toRegion.setTextFill(Color.WHITE);
        toRegion.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        toRegion.setOnMouseClicked(mouseEvent -> {
            RegionPage regionPage = new RegionPage(primaryStage, p1, p1.getCurrentRegion(), array);
        });

        Button viewInventory = new Button("view inventory");
        viewInventory.setTextFill(Color.WHITE);
        viewInventory.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        viewInventory.setOnMouseClicked(mouseEvent -> {
            InventoryPage inventory = new InventoryPage(primaryStage, p1, p1.getCurrentRegion(), array);
        });

        controls.getChildren().addAll(viewInventory, toMap, toRegion);

        //Drop Shadow effect
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.CORAL);
        shadow.setWidth(1.5);
        toMap.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        toMap.setEffect(shadow);
                    }
                });
        toRegion.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        toRegion.setEffect(shadow);
                    }
                });
        viewInventory.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        viewInventory.setEffect(shadow);
                    }
                });
        //adding the shadow when the mouse cursor is on
        toMap.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        toMap.setEffect(null);
                    }
                });
        toRegion.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        toRegion.setEffect(null);
                    }
                });
        viewInventory.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        viewInventory.setEffect(null);
                    }
                });

        map.getChildren().add(controls);

        primaryStage.setTitle("Your spaceship");
        primaryStage.setScene(scene3);
        primaryStage.show();

    }


}
