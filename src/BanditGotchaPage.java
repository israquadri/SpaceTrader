package src;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BanditGotchaPage {

    public BanditGotchaPage(Stage primaryStage, Region[] regions, Player p1) {
        VBox root = new VBox();
        Scene s = new Scene(root, 800, 800);
        root.getChildren().add(new Text("Beep"));




        primaryStage.setScene(s);
        primaryStage.show();
    }


}
