package src;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
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

public class EndCreditsPage {
    public EndCreditsPage(Stage primaryStage) {
        VBox root = new VBox();
        Scene scene = new Scene(root, 800, 800);

        Button playAgain = new Button("Start Game Over");
        playAgain.setOnMouseClicked((MouseEvent m) -> {
            WelcomePage welcomePage = new WelcomePage(primaryStage);
        });


        root.getChildren().addAll(playAgain);
        primaryStage.setTitle("End Credits");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
