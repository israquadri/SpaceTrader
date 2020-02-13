package src;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.ImageView;

public class Map {

    public Map(Stage primaryStage, Region[] regions, Player p1) {

        Pane map = new Pane();
        Scene mapScene = new Scene(map, 800, 800);
        BackgroundImage myBI = new BackgroundImage(new Image("galaxy.jpg", 800,
                800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        map.setBackground(new Background(myBI));
        //map.setStyle("-fx-background-color: black");

        for (Region r: regions) {
            Image image = r.getImg2();
            //image.setStyle(" -fx-background-color: transparent;");
            Button planet = new Button();
            if (!r.isVisited()) {
                planet.setText("Unknown");
            } else {
                planet.setText(r.getDescription());
            }
            planet.setGraphic(new ImageView(image));
            planet.setContentDisplay(ContentDisplay.TOP);
            planet.setStyle("-fx-font-size: 0.9em; -fx-background-color: transparent;"
                    + "  -fx-graphic-text-gap: 0px; -fx-font-family:"
                    + " 'Press Start 2P', cursive;");
            planet.setTextFill(Color.WHITESMOKE);
            planet.setLayoutX(r.getxCoord());
            planet.setLayoutY(r.getyCoord());
            map.getChildren().add(planet);

            Tooltip distanceTip = new Tooltip("Distance from current region: "
                    + r.distanceBetween(p1.getCurrentRegion()));
            distanceTip.setShowDelay(Duration.ZERO);
            planet.setTooltip(distanceTip);

            planet.setOnMouseClicked(mouseEvent -> {
                r.setVisited();
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

        VBox mapDetails = new VBox(10);

        Label coordinates = new Label("-------");
        coordinates.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
        coordinates.setTextFill(Color.WHITE);
        coordinates.setAlignment(Pos.BOTTOM_RIGHT);

        Text currentRegion = new Text("Current Region: " + p1.getCurrentRegion().getDescription());
        currentRegion.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
        currentRegion.setFill(Color.WHITE);

        Button backToOrbit = new Button("Back to Orbit");
        backToOrbit.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        backToOrbit.setTextFill(Color.WHITE);
        backToOrbit.setOnMouseClicked((MouseEvent m) -> {
            RegionPage r = new RegionPage(primaryStage, p1, p1.getCurrentRegion(), regions);
        });

        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.CORAL);
        shadow.setWidth(1.5);

        //DROP SHADOW EFFECT
        backToOrbit.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        backToOrbit.setEffect(shadow);
                    }
                });
        backToOrbit.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        backToOrbit.setEffect(null);
                    }
                });

        mapDetails.getChildren().addAll(coordinates, currentRegion, backToOrbit);
        mapDetails.setPadding(new Insets(5, 5, 5, 5));
        map.getChildren().add(mapDetails);
        map.setOnMouseMoved(e -> {
            String s = new String("(" + ((int) e.getX()) + "," + ((int) e.getY()) + ")");
            coordinates.setText(s);
        });

        primaryStage.setScene(mapScene);
        primaryStage.setTitle("Map");
        primaryStage.show();

    }
}
