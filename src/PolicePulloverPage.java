package src;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.util.*;

public class PolicePulloverPage {

    public PolicePulloverPage(Stage primaryStage, Region[] regions, Player p1, Police police) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 800, 800);
        BackgroundImage myBI = new BackgroundImage(new Image("starback.jpg", 800,
                800, true, true), BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));

        //itemWanted.quantity is incorrect
        ArrayList<Item> itemsCopy = new ArrayList<>(p1.getSpaceShip().getInventory().keySet());
        //for testing
        //for(Item i : itemsCopy) {
        //System.out.println("item: " + i.getName());
        //}
        int index = new Random().nextInt(p1.getSpaceShip().getInventory().size());
        police.setItemWanted(itemsCopy.get(index));
        //System.out.println("item wanted: " + police.getItemWanted());


        ImageView policeShip = new ImageView(new Image("police.png"));
        policeShip.setFitHeight(600);
        policeShip.setFitWidth(600);

        Path path = new Path();
        path.getElements().add(new MoveTo(800, 300));
        path.getElements().add(new HLineTo(-20));


        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(15));
        pathTransition.setNode(policeShip);
        pathTransition.setPath(path);
        pathTransition.setCycleCount(Animation.INDEFINITE);
        pathTransition.setAutoReverse(true);


        pathTransition.play();

        // 3 options that are buttons presented to the user

        VBox optionBox = new VBox();
        optionBox.setPadding(new Insets(10, 10, 10, 10));
        optionBox.setSpacing(20.0);

        // Option 1
        /*
        Forfeit the items to the Police and continue to the desired destination.
        */

        Button option1 = new Button("Comply with Police");
        option1.setOnMouseClicked(mouseEvent ->  {
            police.addToPoliceInventory(police.getItemWanted());
            p1.getSpaceShip().getInventory().remove(police.getItemWanted());
            RegionPage rp = new RegionPage(primaryStage, p1, p1.getDestination(), regions);
            Alert a1 = new Alert(Alert.AlertType.CONFIRMATION, "You complied,"
                    + " gave the police your " + police.getItemWanted().toString()
                    + ", and get to continue to the next region.");
            DialogPane dialogPane = a1.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("myDialogs.css").toExternalForm());
            dialogPane.getStyleClass().add("myDialog");
            a1.show();
        });
        option1.setAlignment(Pos.CENTER);
        option1.setTextFill(Color.WHITE);
        option1.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 17px;");


        /*
        Try to flee back to the previous region. The success of fleeing is
        dependent on the player’s Pilot skill (higher Pilot level, higher
        chance of escape). If the player successfully flees back to the original
        region, they should still lose the fuel required to travel initially, but they
        keep all their items and they are safe. If the player fails to
        flee, the Police will confiscate the stolen items, damage the
        health value of the player's ship, and force the player to pay a fine
        for evasion. Then the player returns to the previous region.
        */

        Button option2 = new Button("Attempt to flee");
        option2.setOnMouseClicked(mouseEvent -> {
            if (police.determineSuccess(p1.getPilotSkill())) {
                p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().
                        distanceBetween(p1.getDestination()));
                RegionPage proceed = new RegionPage(primaryStage, p1,
                        p1.getDestination(), regions);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have"
                        + " successfully fled from the police!");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                alert.show();
            } else {
                p1.getSpaceShip().getInventory().remove(police.getItemWanted());
                p1.getSpaceShip().setHealth(p1.getSpaceShip().getHealth() - 1);
                if (p1.getSpaceShip().getHealth() <= 5) {
                    GameOverPage gameOver = new GameOverPage(primaryStage, p1);
                }
                p1.setCredits(p1.getCredits() - police.getFineDemanded());
                p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().
                        distanceBetween(p1.getDestination()));
                if (p1.getSpaceShip().checkIfGameOver()) {
                    GameOverPage gop = new GameOverPage(primaryStage, p1);
                }
                else {
                    RegionPage proceed = new RegionPage(primaryStage, p1,
                            p1.getDestination(), regions);
                    Alert a2 = new Alert(Alert.AlertType.INFORMATION, "The police"
                            + " have decreased your ship health, confiscated the"
                            + " stolen items, and charged you a fine of "
                            + police.getFineDemanded() + " credits.");
                    DialogPane dialogPane = a2.getDialogPane();
                    dialogPane.getStylesheets().add(
                            getClass().getResource("myDialogs.css").toExternalForm());
                    dialogPane.getStyleClass().add("myDialog");
                    a2.show();
                }
            }
        });
        option2.setAlignment(Pos.CENTER);
        option2.setTextFill(Color.WHITE);
        option2.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 17px;");


        // Option 3:
        /*
        Try to fight off the police. The success of defeating the police is dependent
        on the player’s Fighter skill (higher Fighter level, higher chance of
        winning). Successfully fighting off the police will allow the player to
        travel as intended to the desired destination, keeping the stolen items
         in their inventory.
         */

        Button option3 = new Button("Attempt to fight off police");
        option3.setOnMouseClicked(mouseEvent -> {
            if (police.determineSuccess(p1.getFighterSkill())) {
                // They get to go to the desired region
                p1.getSpaceShip().setFuelAfterTravel(p1.getCurrentRegion().
                        distanceBetween(p1.getDestination()));
                RegionPage proceed = new RegionPage(primaryStage, p1,
                        p1.getDestination(), regions);
                Alert a1 = new Alert(Alert.AlertType.CONFIRMATION, "You fought"
                        + " them off successfully!");
                DialogPane dialogPane = a1.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                a1.show();
            } else {
                RegionPage rp2 = new RegionPage(primaryStage, p1,
                        p1.getCurrentRegion(), regions);
                Alert a2 = new Alert(Alert.AlertType.INFORMATION, "You did not"
                        + " fight them off, so you ended up at your last region.");
                DialogPane dialogPane = a2.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                a2.show();
            }
        });
        option3.setAlignment(Pos.CENTER);
        option3.setTextFill(Color.WHITE);
        option3.setStyle("-fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-background-color: black; -fx-font-size: 17px;");

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

        //ImageView policePic = new ImageView(new Image("spacePolice.png"));

        Text policeText = new Text("You've been pulled\nover by the \nspace police!");
        policeText.setStyle("-fx-font-size: 40px; -fx-font-family:"
                + " 'Press Start 2P', cursive;");
        policeText.setTextAlignment(TextAlignment.CENTER);
        policeText.setFill(Color.WHITE);
        policeText.setTextAlignment(TextAlignment.CENTER);

        Text policeDemands = new Text("They're accusing you\nof stealing a "
                + police.getItemWanted().getName() + "!");
        policeDemands.setStyle("-fx-font-size: 17px; -fx-font-family:"
                + " 'Press Start 2P', cursive;");
        policeDemands.setTextAlignment(TextAlignment.CENTER);
        policeDemands.setFill(Color.WHITE);

        VBox box2 = new VBox();
        //box2.setPadding(new Insets(10, 10, 10, 10));
        box2.setSpacing(15);
        box2.setAlignment(Pos.CENTER);
        box2.getChildren().addAll(policeText, policeDemands, optionBox);


        root.getChildren().addAll(policeShip, box2);

        primaryStage.setScene(scene);
        primaryStage.setTitle("The police have pulled you over");
        primaryStage.show();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
