package src;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.util.Duration;

import java.io.File;

public class EndCreditsPage {
    public EndCreditsPage(Stage primaryStage, Player p1) {
        VBox root = new VBox(30);
        Scene scene = new Scene(root, 800, 800);

        BackgroundImage myBI = new BackgroundImage(new Image("starback.jpg", 800,
                800, true, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));



        HBox replay = new HBox();
        Button playAgain = new Button("Start Game Over");
        replay.getChildren().add(playAgain);
        replay.setPadding(new Insets(40, 0, 0, 0));
        replay.setAlignment(Pos.BASELINE_CENTER);
        playAgain.setTextFill(Color.WHITE);

        playAgain.setStyle("-fx-background-color: black; -fx-font-size: 20px;"
                + " -fx-font-family: 'Press Start 2P', cursive;");

        playAgain.setOnMouseClicked((MouseEvent m) -> {
            WelcomePage welcomePage = new WelcomePage(primaryStage);
        });
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.CORAL);
        shadow.setWidth(1.5);

        //DROP SHADOW EFFECT
        playAgain.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        playAgain.setEffect(shadow);
                    }
                });
        playAgain.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                       playAgain.setEffect(null);
                    }
                });

        HBox bt2 = new HBox();

        // ADDING CHARACTER SHEET SCREEN TEXT NODES
        Text yourCharacter = new Text("SEE YA,\n" + p1.getName());
        yourCharacter.setFill(Color.INDIANRED);
        yourCharacter.setStyle("-fx-background-color: black; -fx-font-size: 60px;"
                + " -fx-font-family: 'Press Start 2P', cursive;");

        Text yourTraits = new Text("Your points for Pilot: " + p1.getPilotSkill()
                + "\n \nYour points for Fighter: " + p1.getFighterSkill()
                + "\n \nYour points for Merchant: " + p1.getMerchantSkill()
                + "\n \nYour points for Engineer: " + p1.getEngineerSkill());
        yourTraits.setFill(Color.WHITE);
        yourTraits.setStyle("-fx-font-size: 20px; -fx-background-color: purple;"
                + " -fx-font-family: 'Press Start 2P', cursive;");

        Text yourDiff = new Text("You ended the game with\n \n \n"
                + p1.getCredits() + " credits");
        yourDiff.setFill(Color.WHITE);
        yourDiff.setStyle("-fx-font-size: 20px; -fx-background-color: purple;"
                + " -fx-font-family: 'Press Start 2P', cursive;");
        Text yourInventory = new Text("You ended the game with:\n \n ");
        yourInventory.setFill(Color.WHITE);
        yourInventory.setStyle("-fx-font-size: 20px; -fx-background-color: purple;"
                + " -fx-font-family: 'Press Start 2P', cursive;");


        VBox gridBox = new VBox();
        gridBox.setBackground(new Background(new BackgroundFill(Color.rgb(0,
                22, 43), CornerRadii.EMPTY, Insets.EMPTY)));
        gridBox.setAlignment(Pos.CENTER);
        Border border = new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
        gridBox.setBorder(border);
        gridBox.setPrefWidth(200);
        gridBox.setPrefHeight(200);
        //grid.setStyle(" -fx-background-radius: 25;");
        SpaceShip mySpaceship = p1.getSpaceShip();
        int cols = 3;
        int colCnt = 0;
        int rowCnt = 0;
        for (Item i: p1.getSpaceShip().getInventory().keySet()) {
            ImageView iv = new ImageView(i.getImage());
            iv.setFitWidth(50);
            iv.setFitHeight(50);
            iv.setPreserveRatio(true);
            iv.setSmooth(true);
            iv.setCache(true);
            Button myItem = new Button(i.getName());
            myItem.setTextAlignment(TextAlignment.CENTER);
            myItem.setGraphic(iv);
            myItem.setContentDisplay(ContentDisplay.TOP);
            myItem.setBackground(Background.EMPTY);
            Tooltip preSale = new Tooltip("Sell Price: " + i.getSellPrice() + "\n"
                    + " Quantity:" + mySpaceship.getQuantity(i));
            preSale.setShowDelay(Duration.ZERO);
            myItem.setAlignment(Pos.CENTER);
            myItem.setTooltip(preSale);
            myItem.setStyle("-fx-font-family: 'Press Start 2P', cursive; -fx-text-fill: white;"
                    + " -fx-font-size: 10px; -fx-text-align: center;");

            //grid.add(myItem, colCnt, rowCnt);
            gridBox.getChildren().add(myItem);
            colCnt++;

            if (colCnt > cols) {
                rowCnt++;
                colCnt = 0;
            }
        }
        ScrollPane scrollpane = new ScrollPane(gridBox);
        scrollpane.setBackground(new Background(new BackgroundFill(Color.rgb(0, 22, 43),
                CornerRadii.EMPTY, Insets.EMPTY)));


        root.getChildren().addAll(yourCharacter, bt2, yourTraits, yourDiff, gridBox ,replay);
        primaryStage.setTitle("End Credits");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
