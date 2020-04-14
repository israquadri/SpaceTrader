package src;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import java.io.File;

public class WinGameCutscenePage {
    private int ndx = 0;

    public WinGameCutscenePage(Stage primaryStage, Player p1) {
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: black");
        root.setAlignment(Pos.CENTER);
        Scene cutscene = new Scene(root, 800, 800);
        String[] storyarr = {"After searching space \n for glory",
            "And finding the most powerful\n"
                + "weapon in the universe", "You realize that you\nno longer want power",
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

        MediaPlayer sweethome = new MediaPlayer(new Media(new
                File("sweethomealabama.mp3").toURI().toString()));
        MediaPlayer og = new MediaPlayer(new Media(new
                File("Endgamesong.m4a").toURI().toString()));

        //Button to skip story details "c"
        og.play();
        ft0.setOnFinished((ActionEvent e) -> {
            if (ndx == 4) {
                ft1.setDuration(Duration.millis(2000));
            }
            ft1.setFromValue(1.0);
            ft1.setToValue(1.0);
            ft1.setNode(t);
            ft1.play();
            ft1.setOnFinished((ActionEvent k) -> {
                if (ndx == storyarr.length - 2) {
                    og.stop();
                }
                ft2.setFromValue(1.0);
                ft2.setToValue(0);
                ft2.setNode(t);
                ft2.play();
                ft2.setOnFinished((ActionEvent w) -> {
                    if (ndx < storyarr.length - 1) {
                        if (ndx == storyarr.length - 2) {
                            sweethome.seek(Duration.millis(2500));
                            sweethome.play();
                            og.stop();
                        }
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
