package src;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import java.util.HashMap;
import java.util.Random;

public class BeforeRegionPage2 {

    private int ndx = 0;

    public BeforeRegionPage2(Stage primaryStage, Player p1) {
        //INSTANTIATING REGIONS
        //initiating regions
        CoordGenerator cg = new CoordGenerator(700);
        HashMap<Integer, Integer> xCoords = cg.getX();
        HashMap<Integer, Integer> yCoords = cg.getY();

        Region region1 = new Region(xCoords.get(0), yCoords.get(0), 0,
                "Farm", new javafx.scene.image.Image("galaxy.jpg", 800,
                800, false, true), new javafx.scene.image.Image( "p1.png", 100,
                100, false, true));
        Region region2 = new Region(xCoords.get(1), yCoords.get(1), 0,
                "Safari",  new javafx.scene.image.Image("galaxy.jpg", 800,
                800, false, true), new javafx.scene.image.Image( "p2.png", 100,
                100, false, true));
        Region region3 = new Region(xCoords.get(2), yCoords.get(2), 0,
                "2000s Boy Bands: the Planet",  new javafx.scene.image.Image("galaxy.jpg", 800,
                800, false, true), new javafx.scene.image.Image( "p3.png", 100,
                100, false, true));
        Region region4 = new Region(xCoords.get(3), yCoords.get(3), 0,
                "Scandinavian",  new javafx.scene.image.Image("galaxy.jpg", 800,
                800, false, true),  new javafx.scene.image.Image( "p4.png", 100,
                100, false, true));
        Region region5 = new Region(xCoords.get(4), yCoords.get(4), 0,
                "Arctic",  new javafx.scene.image.Image("arctic.jpg", 800,
                800, false, true), new javafx.scene.image.Image( "p5.png", 100,
                100, false, true));
        Region region6 = new Region(xCoords.get(5), yCoords.get(5), 0,
                "Desert",  new javafx.scene.image.Image("desert.jpg", 800,
                800, false, true), new javafx.scene.image.Image( "p6.png", 100,
                100, false, true));
        Region region7 = new Region(xCoords.get(6), yCoords.get(6), 0,
                "The Glitch",  new javafx.scene.image.Image("TheGlitch.png", 800,
                800, false, true), new javafx.scene.image.Image( "p7.png", 100,
                100, false, true));
        Region region8 = new Region(xCoords.get(7), yCoords.get(7), 0,
                "4",  new javafx.scene.image.Image("galaxy.jpg", 800,
                800, false, true), new javafx.scene.image.Image( "p8.png", 100,
                100, false, true));
        Region region9 = new Region(xCoords.get(8), yCoords.get(8), 0,
                "Wild west",  new javafx.scene.image.Image("galaxy.jpg", 800,
                800, false, true), new javafx.scene.image.Image( "p9.png", 100,
                100, false, true));
        Region region10 = new Region(xCoords.get(9), yCoords.get(9), 0,
                "Disco",  new javafx.scene.image.Image("galaxy.jpg", 800,
                800, false, true), new Image( "p10.png", 100,
                100, false, true));

        Region[] arr={region1, region2, region3, region4, region5, region5, region6, region7, region8, region9, region10};
        Random r = new Random();
        int randomNumber = r.nextInt(arr.length);


        //STORY DETAILS FADE IN AND OUT
        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);
        Scene backstory = new Scene(root, 800, 800);
        root.setStyle("-fx-background-color: black");

        String[] storyarr = {"You began your life on\n your parent's humble farm", "You worked alongside your\n parents for" +
                " many years, but \n you sought adventure and fame", "Finally, after coming of age\n your parents allow you " +
                "\nto leave the farm", "With your trusty\n John Antelope TR-4CT0R spaceship \n you venture out into space," +
        "\n however you run into\n pirates almost immediately", "Escaping, you use\n most of your fuel and resources",
        "Needing to refuel and resupply\n you land on the nearest\n planet and begin your journey..."};

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
        ft0.setOnFinished((ActionEvent e) -> {
            FadeTransition ft1 = new FadeTransition(Duration.millis(4000));
            ft1.setFromValue(1.0);
            ft1.setToValue(1.0);
            ft1.setNode(t);
            ft1.play();
            ft1.setOnFinished((ActionEvent k) -> {
                FadeTransition ft2 = new FadeTransition(Duration.millis(1000));
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
                        Region currregion = arr[randomNumber];
                        currregion.setVisited();
                        p1.setCurrentRegion(currregion);
                        RegionPage rp = new RegionPage(primaryStage, p1, currregion, arr);
                    }
                });
            });
        });

        //Button to skip story details "c"
        backstory.setOnKeyPressed((KeyEvent w) -> {
            if (w.getText().equals("c")) {
                Region currregion = arr[randomNumber];
                currregion.setVisited();
                p1.setCurrentRegion(currregion);
                RegionPage rp = new RegionPage(primaryStage, p1, currregion, arr);
            }

        });


        primaryStage.setTitle("Back Story");
        primaryStage.setScene(backstory);
        primaryStage.show();
    }
}
