package src;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    //    //START METHOD FOR SPACE TRADER APP
    @Override
    public void start(Stage primaryStage) throws Exception {
        WelcomePage welcomePage = new WelcomePage(primaryStage);
    }

}