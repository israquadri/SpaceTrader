package src;

import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class WelcomePage {

    public WelcomePage(Stage primaryStage) {
        //Create Player
        Player p1 = new Player();

        //Scene 1: Welcome Screen
        Scene scene1;
        BorderPane root = new BorderPane();
        scene1 = new Scene(root, 800, 800);
        scene1.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");

        //Space trader drop shadow
        DropShadow ds = new DropShadow();
        ds.setOffsetY(7.0f);
        ds.setColor(Color.WHITE);

        //Start Button
        Button startButton = new Button("Start game!");
        startButton.setAlignment(Pos.BASELINE_CENTER);
        startButton.setTextFill(Color.WHITE);
        startButton.setStyle("-fx-background-color: black; -fx-font-size: 40px;"
                + " -fx-font-family: 'Press Start 2P', cursive;");

        //MUSIC
        Media spaceTraderIntroSong = new Media((new File("SpaceTrader"
               + "IntroSong.m4a")).toURI().toString());
        MediaPlayer songplayer = new MediaPlayer(spaceTraderIntroSong);
        songplayer.play();

        //EVENT HANDLER TO SEND TO CONFIG PAGE
        startButton.setOnMouseClicked((mouseEvent -> {
            ConfigPage configPage = new ConfigPage(primaryStage, p1, songplayer);
        }));

        // DROP SHADOW HOVER EFFECT ON START BUTTON
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.CORAL);
        shadow.setWidth(1.5);

        //adding the shadow when the mouse cursor is on
        startButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        startButton.setEffect(shadow);
                    }
                });

        //removing shadow when mouse cursor is off
        startButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        startButton.setEffect(null);
                    }
                });

        //Space Trader Game Title
        VBox vbox = new VBox();
        Text spaceTrader = new Text(100.0, 50.0, "Space Trader");
        vbox.getChildren().addAll(spaceTrader);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(100, 50, 50, 50));

        // SPACE TRADER APP TITLE
        spaceTrader.setFill(Color.INDIANRED);
        spaceTrader.setEffect(ds);
        spaceTrader.setCache(true);
        spaceTrader.setStyle("-fx-font-size: 60px; -fx-font-family: 'Press Start 2P', cursive;");

        // ROCKET IMAGE
        Image image = new Image("rocket.jpg");
        ImageView iv = new ImageView();
        iv.setImage(image);
        iv.setFitHeight(350);
        iv.setFitWidth(350);
        HBox rocketHBox = new HBox();
        rocketHBox.getChildren().add(iv);
        rocketHBox.setAlignment(Pos.BOTTOM_CENTER);
        rocketHBox.setPadding(new Insets(10, 10, 30, 10));

        // ROCKET ANIMATION
        RotateTransition rotate = new RotateTransition(Duration.millis(3000));
        rotate.setNode(iv);
        rotate.setByAngle(360);
        rotate.setCycleCount(50);
        rotate.setAutoReverse(false);
        rotate.play();

        // START GAME BUTTON
        BackgroundImage myBI = new BackgroundImage(new Image("galaxy.jpg", 800,
                800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setStyle("-fx-border-color: lightcoral; -fx-border-width: 10px");
        root.setBackground(new Background(myBI));


        // SCENE 1 BACKING STRUCTURE
        root.setCenter(startButton);
        root.setTop(vbox);
        root.setBottom(rocketHBox);
        primaryStage.setTitle("Space Trader");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

}
