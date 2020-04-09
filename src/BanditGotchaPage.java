package src;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.animation.Animation;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javafx.scene.shape.*;
import javafx.animation.PathTransition;
import javafx.util.Duration;

public class BanditGotchaPage {

    public BanditGotchaPage(Stage primaryStage, Region[] regions, Player p1, Bandit bandit) {
        StackPane root = new StackPane();
        Scene s = new Scene(root, 800, 800);
        BackgroundImage myBI = new BackgroundImage(new Image("starback.jpg", 800,
                800, true, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));


        ImageView banditShip = new ImageView(new Image("bandits.png"));
        banditShip.setFitHeight(900);
        banditShip.setFitWidth(700);

        Path path = new Path();
        path.getElements().add(new MoveTo(800, 400));
        path.getElements().add(new HLineTo(-20));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(15));
        pathTransition.setNode(banditShip);
        pathTransition.setPath(path);
        pathTransition.setCycleCount(Animation.INDEFINITE);
        pathTransition.setAutoReverse(true);

        pathTransition.play();

        // 3 buttons and the 3 different scenarios happen based on which button the user selects

        VBox optionBox = new VBox();
        optionBox.setPadding(new Insets(10, 10, 10, 10));
        optionBox.setSpacing(20.0);

        // Option 1:
        /*
        Pay the bandit's demand and continue to the desired destination. If the player cannot
        afford the bandit's demands, then the player must give the bandit all the items in their
        inventory. If the player has no items, the bandit will damage the ship's health. Then the
        player continues to the target destination.
        */

        Button option1 = new Button("Pay bandit and continue");
        option1.setAlignment(Pos.CENTER);
        option1.setTextFill(Color.WHITE);
        option1.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 17px;");

        // backend of what happens when the player picks this option

        option1.setOnMouseClicked(mouseEvent -> {
            if (p1.getCredits() >= bandit.getDemands()) {
                bandit.setCredits(bandit.getCredits() + bandit.getDemands());
                p1.setCredits(p1.getCredits() - bandit.getDemands());
                p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().
                        distanceBetween(p1.getDestination()));
                RegionPage proceed = new RegionPage(primaryStage, p1,
                        p1.getDestination(), regions);
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You paid the"
                        + " bandit and were able to escape!");
                DialogPane dialogPane = a.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                a.show();
            } else {
                if (p1.getSpaceShip().getInventory().size() > 0) {
                    // this might be our loophole.. add the items to the bandit
                    // inventory and have the cops ask for the bandit's items
                    //Set<Item> keySet = p1.getSpaceShip().getInventory().keySet();
                    //Object[] itemArr = keySet.toArray();
                    //for (int i = 0; i < itemArr.length; i++) {
                    //bandit.addToInventory((Item)itemArr[i]);
                    //}
                    p1.getSpaceShip().getInventory().clear();
                    p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().
                            distanceBetween(p1.getDestination()));
                    RegionPage proceed = new RegionPage(primaryStage, p1,
                            p1.getDestination(), regions);
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION,
                            "The bandit stole your entire inventory.");
                    DialogPane dialogPane = alert2.getDialogPane();
                    dialogPane.getStylesheets().add(
                            getClass().getResource("myDialogs.css").toExternalForm());
                    dialogPane.getStyleClass().add("myDialog");
                    alert2.show();
                } else {
                    p1.getSpaceShip().setHealth(p1.getSpaceShip().getHealth() - 1);
                    p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().
                            distanceBetween(p1.getDestination()));
                    RegionPage proceed = new RegionPage(primaryStage, p1,
                            p1.getDestination(), regions);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "The bandit"
                            + " decreased your ship health.");
                    DialogPane dialogPane = alert1.getDialogPane();
                    dialogPane.getStylesheets().add(
                            getClass().getResource("myDialogs.css").toExternalForm());
                    dialogPane.getStyleClass().add("myDialog");
                    alert1.show();
                }
            }
        });

        // Option 2:
        /*
        Try to flee back to the previous region. The success of fleeing is dependent on the
        player’s Pilot skill (higher Pilot level, higher chance of escape). If the player
        successfully flees back to the original region, they should still lose the fuel
        required to travel initially, but they keep all their credits & items and they
        are safe. If the player fails to flee, the bandit will take all their credits and
        damage the health value of the player's ship.
        */

        Button option2 = new Button("Try to flee");
        option2.setAlignment(Pos.CENTER);
        option2.setTextFill(Color.WHITE);
        option2.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 17px;");


        option2.setOnMouseClicked(mouseEvent -> {
            boolean success = bandit.determineSuccess(p1.getPilotSkill());
            if (success) {
                p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().
                        distanceBetween(p1.getDestination())); // subtract fuel it took
                RegionPage rp = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "Phew! Because your"
                        + " Pilot skill is " + p1.getPilotSkill() + ", you could flee back"
                        + " to the last planet you were on!");
                DialogPane dialogPane = alert2.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                alert2.show();
            } else {
                bandit.setCredits(p1.getCredits());
                p1.setCredits(0);
                p1.getSpaceShip().setHealth(p1.getSpaceShip().getHealth() - 1);
                p1.getSpaceShip().setFuel(p1.getSpaceShip().getFuel() - 5);
                RegionPage rp = new RegionPage(primaryStage, p1, p1.getCurrentRegion(), regions);
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "You weren't able to "
                        + "flee from the bandits! They damaged your ship and stole your credits!");
                DialogPane dialogPane = alert1.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                alert1.show();
            }
        });

        // Option 3:
        /*
        Try to fight off the bandit. The success of defeating the bandit is dependent on the
        player’s fighter skill (higher fighter level, higher chance of winning). Successfully
        fighting off the bandit will allow the player to travel as intended to the desired
        destination without any new consequences. Additionally, success will grant the player
        some of the bandit's credits as a reward for winning the fight. Failing to fight off the
        bandit will cost the player all their credits and should damage the health of the player's
        ship.
         */

        Button option3 = new Button("Attempt to fight");
        option3.setAlignment(Pos.CENTER);
        option3.setTextFill(Color.WHITE);
        option3.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 17px;");

        option3.setOnMouseClicked(mouseEvent -> {
            boolean success = bandit.determineSuccess(p1.getFighterSkill());
            if (success) {
                p1.setCredits(p1.getCredits() + ((int) (bandit.getCredits() * .2)));
                p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().
                        distanceBetween(p1.getDestination()));
                RegionPage proceed = new RegionPage(primaryStage, p1,
                        p1.getDestination(), regions);
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "You successfully"
                        + " fought off the bandits");
                DialogPane dialogPane = a1.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                a1.show();
            } else {
                bandit.setCredits(p1.getCredits() + bandit.getCredits());
                p1.setCredits(0);
                p1.getSpaceShip().setHealth(p1.getSpaceShip().getHealth() - 1);
                //System.out.println("health: " + p1.getSpaceShip().getHealth());
                if (p1.getSpaceShip().getHealth() <= 0) {
                    GameOverPage gameOver = new GameOverPage(primaryStage, p1);
                } else {
                    p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().
                            distanceBetween(p1.getDestination()));
                    RegionPage proceed = new RegionPage(primaryStage, p1,
                            p1.getDestination(), regions);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "The bandit stole "
                            + "your credits and decreased your ship health.");
                    DialogPane dialogPane = alert1.getDialogPane();
                    dialogPane.getStylesheets().add(
                            getClass().getResource("myDialogs.css").toExternalForm());
                    dialogPane.getStyleClass().add("myDialog");
                    alert1.show();
                }

            }
        });

        //Drop Shadow effect
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.CORAL);
        shadow.setWidth(1.5);
        option1.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        option1.setEffect(shadow);
                    }
                });
        option2.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        option2.setEffect(shadow);
                    }
                });
        option3.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        option3.setEffect(shadow);
                    }
                });
        //adding the shadow when the mouse cursor is on
        option1.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        option1.setEffect(null);
                    }
                });
        option2.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        option2.setEffect(null);
                    }
                });
        option3.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        option3.setEffect(null);
                    }
                });

        optionBox.getChildren().addAll(option1, option2, option3);
        optionBox.setAlignment(Pos.CENTER);
        optionBox.setPadding(new Insets(15, 5, 0, 0));

        Text banditText = new Text("Oh no!\nBandits have\nstopped your ship!");
        banditText.setStyle("-fx-font-size: 40px; -fx-font-family: 'Press Start 2P', cursive;");
        banditText.setFill(Color.WHITE);
        banditText.setTextAlignment(TextAlignment.CENTER);

        Text banditDemands = new Text("They're demanding a \npayment of "
                + bandit.getDemands() + " credits!");
        banditDemands.setStyle("-fx-font-size: 17px; -fx-font-family: 'Press Start 2P', cursive;");
        banditDemands.setTextAlignment(TextAlignment.CENTER);
        banditDemands.setFill(Color.WHITE);

        VBox box2 = new VBox();
        box2.setSpacing(15);
        //box2.setPadding(new Insets(10, 10, 10, 10));
        box2.setAlignment(Pos.CENTER);
        box2.getChildren().addAll(banditText, banditDemands, optionBox);

        root.getChildren().addAll(banditShip, box2);
        root.setPadding(new Insets(15, 15, 15, 15));


        primaryStage.setTitle("Oh no! Bandits have stopped your ship!");
        primaryStage.setScene(s);
        primaryStage.show();
    }


}
