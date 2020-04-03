package src;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class SpaceshipInterior {


    public SpaceshipInterior(Stage primaryStage, Player p1, Region[] array) {


        VBox root = new VBox();
        Scene scene3 = new Scene(root, 800, 800);
        scene3.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
        BackgroundImage myBI = new BackgroundImage(new Image("interior.png", 800,
                800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));

        VBox controls = new VBox();
        controls.setPadding(new Insets(10, 10, 10, 10));
        controls.setSpacing(20.0);

        // this will display the ship's health
        Text shipHealth = new Text("Ship Health: " + p1.getSpaceShip().getHealth());
        shipHealth.setFill(Color.WHITE);
        shipHealth.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-font-size: 40px;");



        Button toMap = new Button("go to map");
        toMap.setOnMouseClicked(mouseEvent -> {
            Map mapPage = new Map(primaryStage, array, p1);
        });
        toMap.setAlignment(Pos.CENTER);
        toMap.setTextFill(Color.WHITE);
        toMap.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");

        Button toRegion = new Button("back to region");
        toRegion.setAlignment(Pos.CENTER);
        toRegion.setTextFill(Color.WHITE);
        toRegion.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        toRegion.setOnMouseClicked(mouseEvent -> {
            RegionPage regionPage = new RegionPage(primaryStage, p1, p1.getCurrentRegion(), array);
        });

        Button viewInventory = new Button("view inventory");
        viewInventory.setAlignment(Pos.CENTER);
        viewInventory.setTextFill(Color.WHITE);
        viewInventory.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        viewInventory.setOnMouseClicked(mouseEvent -> {
            InventoryPage inventory = new
                    InventoryPage(primaryStage, p1, p1.getCurrentRegion(), array);
        });


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

        controls.getChildren().addAll(shipHealth, viewInventory, toMap, toRegion);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(130, 0, 0, 0));



        root.setAlignment(Pos.TOP_CENTER);
        root.getChildren().add(controls);

        primaryStage.setTitle("Your spaceship");
        primaryStage.setScene(scene3);
        primaryStage.show();

    }


}
