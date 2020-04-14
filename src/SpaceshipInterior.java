package src;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.File;

public class SpaceshipInterior {
    //This is for keeping track of place in radio
    private int curr = 0;


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

        //Music for my radio, had to instantiate uphere to work with the event handlers
        //Radio is an array of MediaPlayers
        MediaPlayer[] radioarr = new MediaPlayer[7];
        radioarr[0] = new MediaPlayer(new Media(new
                File("SpaceTradeStorySong.m4a").toURI().toString()));
        radioarr[1] = new MediaPlayer(new Media(new
                File("SpaceTraderIntroSong.m4a").toURI().toString()));
        radioarr[2] = new MediaPlayer(new Media(new
                File("SpaceTraderTradingSong.m4a").toURI().toString()));
        radioarr[3] = new MediaPlayer(new Media(new
                File("sweethomealabama.mp3").toURI().toString()));
        radioarr[4] = new MediaPlayer(new Media(new
                File("Endgamesong.m4a").toURI().toString()));
        radioarr[5] = new MediaPlayer(new Media(new
                File("banditsong.m4a").toURI().toString()));
        radioarr[6] = new MediaPlayer(new Media(new
                File("policesong.m4a").toURI().toString()));



        Button toMap = new Button("go to map");
        toMap.setOnMouseClicked(mouseEvent -> {
            Map mapPage = new Map(primaryStage, array, p1);
            radioarr[curr].stop();
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
            radioarr[curr].stop();
        });

        Button viewInventory = new Button("view inventory");
        viewInventory.setAlignment(Pos.CENTER);
        viewInventory.setTextFill(Color.WHITE);
        viewInventory.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        viewInventory.setOnMouseClicked(mouseEvent -> {
            InventoryPage inventory = new
                    InventoryPage(primaryStage, p1, p1.getCurrentRegion(), array);
            radioarr[curr].stop();

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

        //This is the radio inside the ship, radioLbl is label for the radio
        Button radioLbl = new Button("Radio");
        radioLbl.setAlignment(Pos.CENTER);
        radioLbl.setTextFill(Color.WHITE);
        radioLbl.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");

        //Radio control hbox to store buttons
        HBox radiocntrl = new HBox();
        radiocntrl.setAlignment(Pos.CENTER);
        radiocntrl.setSpacing(20);

        //Rewind button
        Button rewind = new Button();
        rewind.setGraphic(new ImageView(new Image("rewind.png", 15, 15, false, false)));
        rewind.setAlignment(Pos.CENTER);
        rewind.setTextFill(Color.WHITE);
        rewind.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: white; -fx-font-size: 20px;");
        rewind.setOnAction((ActionEvent e) -> {
            radioarr[curr].stop();
            curr--;
            if (curr < 0) {
                curr = radioarr.length - 1;
            }
            radioarr[curr].play();
        });



        //Play pause button
        Button playpause = new Button();
        //Creating two imageviews for play and pause that I will switch in and out
        ImageView play = new ImageView(new Image("playbutton.png", 15, 15, false, false));
        ImageView pause = new ImageView(new Image("pause.png", 18, 18, false, false));
        //Set initial attributes for the playpause button
        playpause.setGraphic(play);
        playpause.setAlignment(Pos.CENTER);
        playpause.setTextFill(Color.WHITE);
        playpause.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: white; -fx-font-size: 20px;");
        playpause.setOnAction((ActionEvent e) -> {
            if (radioarr[curr].getStatus().equals((MediaPlayer.Status.PAUSED))
                || radioarr[curr].getStatus().equals(MediaPlayer.Status.READY)) {
                radioarr[curr].play();
                playpause.setGraphic(pause);
            } else {
                radioarr[curr].pause();
                playpause.setGraphic(play);
            }
        });

        //Fast forward button
        Button fastfor = new Button();
        fastfor.setGraphic(new ImageView(new Image("fastforward.png", 15, 15, false, false)));
        fastfor.setAlignment(Pos.CENTER);
        fastfor.setTextFill(Color.WHITE);
        fastfor.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: white; -fx-font-size: 20px;");
        fastfor.setOnAction((ActionEvent e) -> {
            radioarr[curr].stop();
            curr = (curr + 1) % radioarr.length;
            radioarr[curr].play();
        });

        //Add buttons to radiocntrl Hbox
        radiocntrl.getChildren().addAll(rewind, playpause, fastfor);
        //Vbox to hold radio
        VBox radioVbox = new VBox();
        radioVbox.setAlignment(Pos.CENTER);
        radioVbox.setSpacing(10);
        radioVbox.getChildren().addAll(radioLbl, radiocntrl);

        //Drop Shadow effect
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.CORAL);
        shadow.setWidth(1.5);
        DropShadow shadow2 = new DropShadow();
        shadow2.setColor(Color.WHITE);
        shadow2.setWidth(3.0);
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
        rewind.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        rewind.setEffect(shadow2);
                    }
                });
        fastfor.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        fastfor.setEffect(shadow2);
                    }
                });
        playpause.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        playpause.setEffect(shadow2);
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
        rewind.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        rewind.setEffect(null);
                    }
                });
        fastfor.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        fastfor.setEffect(null);
                    }
                });
        playpause.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        playpause.setEffect(null);
                    }
                });
        //Add buffer hbox to create space
        HBox buffer = new HBox();
        buffer.setPrefHeight(10);

        controls.getChildren().addAll(viewInventory, toMap, toRegion, buffer,  radioVbox);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(100, 0, 0, 0));

        root.setAlignment(Pos.TOP_CENTER);
        root.getChildren().addAll(shipStats, controls);

        primaryStage.setTitle("Your spaceship");
        primaryStage.setScene(scene3);
        primaryStage.show();

    }


}
