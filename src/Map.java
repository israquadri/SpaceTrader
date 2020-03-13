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

import java.util.Random;

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
                planet.setText(r.getName());
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

            // THIS CHUNK OF CODE IS FOR THE "difficulty level determines npc encounter frequency" FUNCTIONALITY

//            Random npcEncounter = new Random();
//            int banditAndPoliceEncounter;
//            if (p1.getDifficulty().equals("Easy")) {
//                banditAndPoliceEncounter = npcEncounter.nextInt(30); // 5/30 = 1/6 chance of bandit OR police encounter
//            } else if (p1.getDifficulty().equals("Medium")) {
//                banditAndPoliceEncounter = npcEncounter.nextInt(20); // 5/20 = 1/4 chance of bandit OR police encounter
//            } else {
//                banditAndPoliceEncounter = npcEncounter.nextInt(10); // 5/10 = 1/2 chance of bandit OR police encounter
//            }
//
//            planet.setOnMouseClicked(mouseEvent -> {
//                p1.setDestination(r);
//                if (p1.getSpaceShip().getFuel() < 10) {
//                    Alert a = new Alert(Alert.AlertType.ERROR, "You're running"
//                            + " low on fuel. In order to avoid getting stranded,"
//                            + " refuel at the " + p1.getCurrentRegion().getName() + " market.");
//                    a.show();
//                }
//                else {
//                    if (banditAndPoliceEncounter <= 5) {
//                        int randNum = new Random().nextInt(4); // now there's 1/2 chance player will encounter bandit, and 1/2 chance player will encounter police
//                        if (randNum < 2) {
//                            BanditGotchaPage b = new BanditGotchaPage(primaryStage, regions, p1, new Bandit(25));
//                        } else {
//                            //check player's inventory size
//                            if (p1.getSpaceShip().getInventory().size() == 0) {
//                                r.setVisited();
//                                p1.getSpaceShip().setFuelAfterTravel(r.distanceBetween(p1.getCurrentRegion()));
//                                p1.setCurrentRegion(r);
//                                RegionPage regionPage = new RegionPage(primaryStage, p1, r, regions);
//                            } else {
//                                PolicePulloverPage p = new PolicePulloverPage(primaryStage, regions, p1, new Police(null, 30));
//                            }
//                        }
//                    } else {
//                        int randNum = new Random().nextInt(10); //  0 1 2 3 4 5 6 7 8 9
//                        if (randNum < 3) { // player has 3/10 chances of encountering trader
//                            //initialize trader's inventory here
//                            String[] traderItemNames = new String[] {"item0", "item1", "item2", "item3", "item4", "item5"};
//                            TraderEncounterPage t = new TraderEncounterPage(primaryStage, regions, p1, new Trader(traderItemNames, p1));
//                        } else {
//                            r.setVisited();
//                            p1.getSpaceShip().setFuelAfterTravel(r.distanceBetween(p1.getCurrentRegion()));
//                            p1.setCurrentRegion(r);
//                            RegionPage regionPage = new RegionPage(primaryStage, p1, r, regions);
//                        }
//                    }
//                }
//
//            });


            // THIS CHUNK OF CODE IS FOR THE FORCED NPC ENCOUNTERS DURING THE DEMO

            planet.setOnMouseClicked(mouseEvent -> {
                p1.setDestination(r);
                if (p1.getSpaceShip().getFuel() < 10) {
                    Alert a = new Alert(Alert.AlertType.ERROR, "You're running"
                            + " low on fuel. In order to avoid getting stranded,"
                            + " refuel at the " + p1.getCurrentRegion().getName() + " market.");
                    a.show();
                }
                else {
                    int randNum = new Random().nextInt(4);
//                  System.out.println(p1.getSpaceShip().getInventoryCapacity());
//                  use randNum below to force encounters for demo
//                  int randNum = 1;

                    //for testing
//                    System.out.println(randNum);
//                    System.out.println("player's fighter skill: " + p1.getFighterSkill());
//                    System.out.println("player's merchant skill: " + p1.getMerchantSkill());
//                    System.out.println("player's pilot skill: " + p1.getPilotSkill());
//                    System.out.println("fuel: " + p1.getSpaceShip().getFuel());

                    if (randNum == 0) {
                        BanditGotchaPage b = new BanditGotchaPage(primaryStage, regions, p1, new Bandit(25));
                    } else if (randNum == 1) {
                        //check player's inventory size
                        if (p1.getSpaceShip().getInventory().size() == 0) {
                            r.setVisited();
                            p1.getSpaceShip().setFuelAfterTravel(r.distanceBetween(p1.getCurrentRegion()));
                            p1.setCurrentRegion(r);
                            RegionPage regionPage = new RegionPage(primaryStage, p1, r, regions);
                        } else {
                            PolicePulloverPage p = new PolicePulloverPage(primaryStage, regions, p1, new Police(null, 30));
                        }
                    } else if (randNum == 2) {
                        //initialize trader's inventory here
                        String[] traderItemNames = new String[] {"item0", "item1", "item2", "item3", "item4", "item5"};
                        TraderEncounterPage t = new TraderEncounterPage(primaryStage, regions, p1, new Trader(traderItemNames, p1));
                    } else {
                        r.setVisited();
                        p1.getSpaceShip().setFuelAfterTravel(r.distanceBetween(p1.getCurrentRegion()));
                        p1.setCurrentRegion(r);
                        RegionPage regionPage = new RegionPage(primaryStage, p1, r, regions);
                    }
                }

            });

            // DROP SHADOW HOVER EFFECT ON START BUTTON
            DropShadow shadow = new DropShadow();
            shadow.setColor(Color.CORAL);
            shadow.setWidth(1.5);
            //adding the shadow when the mouse cursor is on
            planet.addEventHandler(MouseEvent.MOUSE_ENTERED,
                    new EventHandler<MouseEvent>() {
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

        Text currentRegion = new Text("Current Region: " + p1.getCurrentRegion().getName());
        currentRegion.setStyle("-fx-font-size: 15px; -fx-font-family: 'Press Start 2P', cursive;");
        currentRegion.setFill(Color.WHITE);

        Button backToOrbit = new Button("Back to Orbit");
        backToOrbit.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 20px;");
        backToOrbit.setTextFill(Color.WHITE);
        backToOrbit.setOnMouseClicked((MouseEvent m) -> {
            RegionPage r = new RegionPage(primaryStage, p1, p1.getCurrentRegion(), regions);
        });

        //fuel display
        HBox topBar = new HBox(300);
        HBox fuelBox = new HBox();
        ProgressBar fuelTank = new ProgressBar(50);
        fuelTank.setProgress(p1.getSpaceShip().getFuel() / 50.0);
        Text fuelText = new Text("Fuel");
        fuelText.setStyle("-fx-font-size: 12px; -fx-font-family: 'Press Start 2P', cursive;");
        fuelText.setFill(Color.WHITE);
        fuelBox.getChildren().addAll(fuelText, fuelTank);
        fuelBox.setSpacing(10);
        fuelBox.setPadding(new Insets(5, 5, 5, 5));
        topBar.getChildren().addAll(backToOrbit, fuelBox);

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

        mapDetails.getChildren().addAll(coordinates, currentRegion, topBar);
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
