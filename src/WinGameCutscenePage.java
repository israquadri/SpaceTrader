package src;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
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

import java.awt.*;
import java.io.File;

public class WinGameCutscenePage {
    int ndx = 0;

    public WinGameCutscenePage(Stage primaryStage, Player p1) {
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: black");
        root.setAlignment(Pos.CENTER);
        Scene cutscene = new Scene(root, 800, 800);
        String[] storyarr = {"After searching space \n for glory", "And finding the most powerful\n" +
                "weapon in the universe", "You realize that you\nno longer want power",
                "What you truly desire\nis what you could have \n had all along", "A Tractor",
                "A Farm", "A Family", "and...", "An Ice Cold Beer"};

        Text t = new Text(storyarr[ndx]);
        t.setTextAlignment(TextAlignment.CENTER);
        t.setLineSpacing(2.0);
        t.setFill(Color.WHITE);
        t.setStyle("-fx-font-size: 20px;"
                + " -fx-font-family: 'Press Start 2P', cursive;");
        root.getChildren().add(t);
        FadeTransition ft0 = new FadeTransition(Duration.millis(1000));
        ft0.setFromValue(0);
        ft0.setToValue(1.0);
        ft0.setNode(t);
        ft0.play();
        FadeTransition ft2 = new FadeTransition(Duration.millis(1000));
        FadeTransition ft1 = new FadeTransition(Duration.millis(4000));

        MediaPlayer sweethome = new MediaPlayer(new Media(new File("sweethomealabama.mp3").toURI().toString()));

        //Button to skip story details "c"

        ft0.setOnFinished((ActionEvent e) -> {
            if (ndx == 4) {
                ft1.setDuration(Duration.millis(2000));
            }
            if (ndx == storyarr.length - 2) {
                sweethome.play();
            }
            ft1.setFromValue(1.0);
            ft1.setToValue(1.0);
            ft1.setNode(t);
            ft1.play();
            ft1.setOnFinished((ActionEvent k) -> {
                ft2.setFromValue(1.0);
                ft2.setToValue(0);
                ft2.setNode(t);
                ft2.play();
                ft2.setOnFinished((ActionEvent w) -> {
                    if (ndx < storyarr.length - 1) {
                        ndx++;
                        t.setText(storyarr[ndx]);
                        ft0.play();
                    } else {
                        WinGamePage wp = new WinGamePage(primaryStage, p1, sweethome);
                    }
                });
            });
        });
        primaryStage.setScene(cutscene);
        primaryStage.setTitle("Endgame Cutscene");
        primaryStage.show();
    }
}
