package src;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameOverPage {

	public GameOverPage(Stage primaryStage, Player p1) {
		VBox root = new VBox(250);
		Scene scene = new Scene(root, 800, 800);

		BackgroundImage myBI = new BackgroundImage(new Image("starback.jpg", 800,
				800, true, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		root.setBackground(new Background(myBI));

		ImageView gameOver = new ImageView(new Image("gameover.png"));
		gameOver.setFitHeight(300);
		gameOver.setFitWidth(400);

		RotateTransition rotate = new RotateTransition(Duration.millis(3000));
		rotate.setNode(gameOver);
		rotate.setByAngle(360);
		rotate.setCycleCount(1);
		rotate.setAutoReverse(false);
		rotate.play();

		Path path = new Path();
		path.getElements().add(new MoveTo(800, 300));
		path.getElements().add(new HLineTo(400));
		//path.getElements().add(new MoveTo(800, 700));
		//path.getElements().add(new HLineTo(-40));

		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.seconds(1.5));
		pathTransition.setNode(gameOver);
		//pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setPath(path);
		pathTransition.setCycleCount(1);

		pathTransition.play();


		Button playAgain = new Button("End Credits");
		playAgain.setOnMouseClicked((MouseEvent m) -> {
			EndCreditsPage endCreditsPage = new EndCreditsPage(primaryStage);
		});
		playAgain.setAlignment(Pos.BASELINE_CENTER);
		playAgain.setTextFill(Color.WHITE);
		playAgain.setStyle("-fx-background-color: black; -fx-font-size: 25px;"
				+ " -fx-font-family: 'Press Start 2P', cursive;");

		Text gameOverText = new Text("You lose!\nYour health hit zero and your ship crashed.");
		gameOverText.setStyle("-fx-font-size: 12px; -fx-font-family: 'Press Start 2P', cursive;");
		gameOverText.setFill(Color.WHITE);
		gameOverText.setTextAlignment(TextAlignment.CENTER);

		VBox box = new VBox(35);
		//box.setPadding(new Insets(10, 10, 10, 10));

		box.setAlignment(Pos.CENTER);
		box.getChildren().addAll(gameOverText, playAgain);

		root.getChildren().addAll(gameOver,box);
		primaryStage.show();


		primaryStage.setTitle("Game over!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
