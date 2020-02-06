
package src;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;

import java.io.File;
import java.util.Random;


public class Main extends Application {

    //    //START METHOD FOR SPACE TRADER APP
    @Override
    public void start(Stage primaryStage) throws Exception {
    WelcomePage welcomePage = new WelcomePage(primaryStage);

    }

}