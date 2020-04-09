package src;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
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

        //fuel display
        HBox fuelBox = new HBox();
        //top.getChildren().add(fuelBox);
        //HBox.setHgrow(fuelBox, Priority.ALWAYS);
        fuelBox.setAlignment(Pos.BASELINE_RIGHT);
        ProgressBar fuelTank = new ProgressBar(50);
        fuelTank.setProgress(p1.getSpaceShip().getFuel() / 50.0);
        //fuelTank.setLayoutX(100);
        Text fuelText = new Text("Fuel");
        fuelText.setStyle("-fx-font-size: 12px; -fx-font-family: 'Press Start 2P', cursive;");
        fuelText.setFill(Color.WHITE);
        fuelBox.getChildren().addAll(fuelText, fuelTank);
        fuelBox.setSpacing(10);
        fuelBox.setPadding(new Insets(5, 5, 5, 5));

        //ship health display
        HBox shipHealth = new HBox();
        //HBox.setHgrow(shipHealth, Priority.ALWAYS);
        shipHealth.setAlignment(Pos.BASELINE_RIGHT);
        ProgressBar healthBar = new ProgressBar(5);
        healthBar.setProgress(p1.getSpaceShip().getHealth() / 5.0);
        Text healthText = new Text("Ship Health");
        healthText.setStyle("-fx-font-size: 12px; -fx-font-family: 'Press Start 2P', cursive;");
        healthText.setFill(Color.WHITE);
        shipHealth.getChildren().addAll(healthText, healthBar);
        shipHealth.setSpacing(10);
        shipHealth.setPadding(new Insets(5, 5, 5, 5));

        VBox shipStats = new VBox();
        shipStats.getChildren().addAll(shipHealth, fuelBox);
        shipStats.setAlignment(Pos.TOP_RIGHT);

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

        controls.getChildren().addAll(viewInventory, toMap, toRegion);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(100, 0, 0, 0));

        root.setAlignment(Pos.TOP_CENTER);
        root.getChildren().addAll(shipStats, controls);

        primaryStage.setTitle("Your spaceship");
        primaryStage.setScene(scene3);
        primaryStage.show();

    }


}
