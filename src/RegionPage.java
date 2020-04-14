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

import java.util.Random;

public class RegionPage {

    public RegionPage(Stage primaryStage, Player p1, Region region, Region[] array) {
        //make the page in the constructor
        //follow the same structure, but do it here
        //set on action methods can go here if there is a button in this page
        VBox vbox = new VBox(40);
        vbox.setMaxWidth(600);
        vbox.setAlignment(Pos.CENTER);
        Scene regionRoot = new Scene(vbox, 800, 800);

        region.setVisited();
        p1.setCurrentRegion(region);

        regionRoot.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
        primaryStage.setTitle("Into the Universe!");
        Text text = new Text("Regions of \nthe Universe");
        text.setStyle("-fx-font-size: 50px; -fx-font-family: 'Press Start 2P', cursive;");
        text.setFill(Color.WHITE);
        text.setTextAlignment(TextAlignment.CENTER);

        //Everytime you enter a region, check to see if you have reached credits threshhold, if you have,
        //add infinity gauntlet to a randomly selected market
        if (p1.getCredits() >= 100 && !p1.isInfinitygauntletspawned()) {
            Random randal = new Random();
            int randy = randal.nextInt(array.length);
            array[randy].getMarket().getItems().add(new Item(array[randy].getTax(), p1.getMerchantSkill(),
                    array[randy].getTechLevel(), "Infinity Gauntlet<infinitygauntlet.png>", 1, 100));
            p1.setInfinitygauntletspawned(true);
        }


        primaryStage.setTitle(region.getName());


        Text text1 = new Text("You've landed in \n the " + region.getName() + "\n Region!");
        text1.setStyle("-fx-font-size: 40px; -fx-font-family: 'Press Start 2P', cursive;");
        text1.setTextAlignment(TextAlignment.CENTER);
        Text text2 = new Text("Coordinates: " + region.getxCoord() + ", " + region.getyCoord());
        text2.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
        Text text3 = new Text("Technology Level: " + region.getTechLevel());
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

        Button toSpaceship = new Button("Spaceship");
        toSpaceship.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        toSpaceship.setTextFill(Color.WHITE);
        toSpaceship.setOnMouseClicked((MouseEvent m) -> {
            SpaceshipInterior interior = new SpaceshipInterior(primaryStage, p1, array);
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
        toSpaceship.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        toSpaceship.setEffect(shadow);
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
        toSpaceship.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        toSpaceship.setEffect(null);
                    }
                });


        BackgroundImage myBI = new BackgroundImage(region.getImg1(), BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        vbox.setBackground(new Background(myBI));

        vbox.getChildren().addAll(text1, text2, text3, toMarket, toSpaceship);

        primaryStage.setScene(regionRoot);

    }
}
