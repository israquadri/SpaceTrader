package src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.Group;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.concurrent.atomic.AtomicInteger;

public class Map {
    public Map(Stage primaryStage, Region[] regions) {

        Pane map = new Pane();
        Scene mapScene = new Scene(map, 800, 800);
        map.setStyle("-fx-background-color: black");

        for (Region r: regions) {
            Button planet = new Button(r.getDescription());
            planet.setStyle("-fx-background-color: white");
            planet.setLayoutX(r.getxCoord());
            planet.setLayoutY(r.getyCoord());
            map.getChildren().add(planet);
        }

        primaryStage.setScene(mapScene);
        primaryStage.setTitle("Map");
        primaryStage.show();

    }

}