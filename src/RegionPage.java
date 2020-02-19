package src;


import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.Background;

public class RegionPage {

    public RegionPage(Stage primaryStage, Player p1, Region region, Region[] array) {
        //make the page in the constructor
        //follow the same structure, but do it here
        //set on action methods can go here if there is a button in this page
        VBox vbox = new VBox(40);
        vbox.setMaxWidth(600);
        HBox hbox = new HBox(40);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        vbox.setAlignment(Pos.CENTER);
        Scene regionRoot = new Scene(vbox, 800, 800);


        regionRoot.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
        primaryStage.setTitle("Into the Universe!");
        Text text = new Text("Regions of \nthe Universe");
        text.setStyle("-fx-font-size: 50px; -fx-font-family: 'Press Start 2P', cursive;");
        text.setFill(Color.WHITE);
        text.setTextAlignment(TextAlignment.CENTER);


        primaryStage.setTitle(region.getDescription());


        Text text1 = new Text("You've landed in \n the " + region.getDescription() + "\n Region!");
        text1.setStyle("-fx-font-size: 40px; -fx-font-family: 'Press Start 2P', cursive;");
        text1.setTextAlignment(TextAlignment.CENTER);
        Text text2 = new Text("Coordinates: " + region.getxCoord() + ", " + region.getyCoord());
        text2.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
        Text text3 = new Text("Technology Level: " + region.getTechnologyLevel());
        text3.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
        text1.setFill(Color.WHITE);
        text2.setFill(Color.WHITE);

        text3.setFill(Color.WHITE);

        //Add button to go to market
        Button toMarket = new Button("Market");
        toMarket.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        toMarket.setTextFill(Color.WHITE);
        toMarket.setOnMouseClicked((MouseEvent m) -> {
            MarketPage mkt = new MarketPage(primaryStage, p1, region, array);
        });

        //Drop Shadow effect
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.CORAL);
        shadow.setWidth(1.5);
        toMarket.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        toMarket.setEffect(shadow);
                    }
                });
        //adding the shadow when the mouse cursor is on
        toMarket.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        toMarket.setEffect(null);
                    }
                });


        BackgroundImage myBI = new BackgroundImage(region.getImg1(), BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


        vbox.setBackground(new Background(myBI));

        Button toMap = new Button("go to map");
        toMap.setAlignment(Pos.BOTTOM_CENTER);
        toMap.setTextFill(Color.WHITE);
        toMap.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        toMap.setMinSize(10, 10);
        toMap.setOnMouseClicked(mouseEvent -> {
            Map mapPage = new Map(primaryStage, array, p1);
        });

        //adding the shadow when the mouse cursor is on
        toMap.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        toMap.setEffect(shadow);
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

        hbox.getChildren().add(toMap);
        vbox.getChildren().addAll(text1, text2, text3, toMarket, hbox);

        primaryStage.setScene(regionRoot);

    }
}
