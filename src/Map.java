package src;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.Group;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.tools.Tool;
import java.util.concurrent.atomic.AtomicInteger;

public class Map {

    public Map(Stage primaryStage, Region[] regions, Player p1) {

        Pane map = new Pane();
        Scene mapScene = new Scene(map, 800, 800);
        map.setStyle("-fx-background-color: black");

        for (Region r: regions) {
            Button planet = new Button(r.getDescription());
            planet.setStyle("-fx-background-color: white");
            planet.setLayoutX(r.getxCoord());
            planet.setLayoutY(r.getyCoord());
            map.getChildren().add(planet);

            Tooltip distanceTip = new Tooltip("Distance from current region: \n" + r.distanceBetween(p1.getCurrentRegion()));
            distanceTip.setShowDelay(Duration.ZERO);
            planet.setTooltip(distanceTip);

            planet.setOnMouseClicked(mouseEvent -> {
                p1.setCurrentRegion(r);
                RegionPage regionPage = new RegionPage(primaryStage, p1, r, regions);
            });

            // DROP SHADOW HOVER EFFECT ON START BUTTON
            DropShadow shadow = new DropShadow();
            shadow.setColor(Color.CORAL);
            shadow.setWidth(1.5);
            //adding the shadow when the mouse cursor is on
            planet.addEventHandler(MouseEvent.MOUSE_ENTERED,
                    new javafx.event.EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            planet.setEffect(shadow);
                        }
                    });
            //adding the shadow when the mouse cursor is on
            planet.addEventHandler(MouseEvent.MOUSE_EXITED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            planet.setEffect(null);
                        }
                    });

        }

        VBox mapDetails = new VBox();
        Label coordinates = new Label("-------");
        coordinates.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
        coordinates.setTextFill(Color.WHITE);
        coordinates.setAlignment(Pos.BOTTOM_RIGHT);
        Text currentRegion = new Text("Current Region: " + p1.getCurrentRegion().getDescription());
        currentRegion.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
        currentRegion.setFill(Color.WHITE);
        mapDetails.getChildren().addAll(coordinates, currentRegion);
        map.getChildren().add(mapDetails);
        map.setOnMouseMoved(e -> {
            String s = new String("(" + (e.getX()) + "," + (e.getY()) + ")");
            coordinates.setText(s);
        });

        primaryStage.setScene(mapScene);
        primaryStage.setTitle("Map");
        primaryStage.show();

    }
}
