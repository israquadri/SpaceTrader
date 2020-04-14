package src;

import javafx.animation.PathTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.shape.VLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.Background;
import javafx.util.Duration;

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

        // ADDING DEV CREDIT SCREEN TEXT NODES
        Text creditText = new Text("Game Credits:\n \n");
        creditText.setStyle("-fx-font-size: 40px; -fx-font-family: 'Press Start 2P', cursive;");
        creditText.setFill(Color.WHITE);
        creditText.setTextAlignment(TextAlignment.CENTER);

        Text credits = new Text("Game Planning: Hayden Smith \n \n"
                + "User Interface Design: Savannah Joyner \n"
                + "                       Isra Quadri\n \n"
                + "Game Design: Hayden Smith\n"
                + "             Sarah Yoo\n "
                + "             Chris Turko\n \n"
                + "Sound Design: Chris Turko\n");
        credits.setStyle("-fx-font-size: 17px; -fx-font-family: 'Press Start 2P', cursive;");
        credits.setTextAlignment(TextAlignment.CENTER);
        credits.setFill(Color.WHITE);

        VBox box = new VBox();
        box.setSpacing(30);
        box.setPadding(new Insets(10, 20, 10, 20));
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(creditText, credits, replay);

        //        RotateTransition rotate = new RotateTransition(Duration.millis(3000));
        //        rotate.setNode(gameOver);
        //        rotate.setByAngle(360);
        //        rotate.setCycleCount(1);
        //        rotate.setAutoReverse(false);
        //        rotate.play();

        Path path = new Path();
        path.getElements().add(new MoveTo(400, 900));
        path.getElements().add(new VLineTo(400));
        //path.getElements().add(new MoveTo(800, 700));
        //path.getElements().add(new HLineTo(-40));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(3));
        pathTransition.setNode(box);
        //pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setPath(path);
        pathTransition.setCycleCount(1);
        pathTransition.play();

        root.getChildren().addAll(box);
        primaryStage.setTitle("End Credits");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
