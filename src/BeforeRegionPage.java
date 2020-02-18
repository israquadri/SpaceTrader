package src;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class BeforeRegionPage {

    private int ndx = 0;

    public BeforeRegionPage(Stage primaryStage, Player p1) {
        //INSTANTIATING REGIONS
        //initiating regions
        CoordGenerator cg = new CoordGenerator(700);
        HashMap<Integer, Integer> xCoords = cg.getX();
        HashMap<Integer, Integer> yCoords = cg.getY();

        Region region1 = new Region(xCoords.get(0), yCoords.get(0), 2,
                "Farm", new javafx.scene.image.Image("farm.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p1.png", 100,
                100, false, true));
        Region region2 = new Region(xCoords.get(1), yCoords.get(1), 4,
                "Safari",  new javafx.scene.image.Image("safari.png", 800,
                800, false, true), new javafx.scene.image.Image("p2.png", 100,
                100, false, true));
        Region region3 = new Region(xCoords.get(2), yCoords.get(2), 6,
                "2000s Boy Bands",  new javafx.scene.image.Image("bsb.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p3.png", 100,
                100, false, true));
        Region region4 = new Region(xCoords.get(3), yCoords.get(3), 5,
                "Scandinavian",  new javafx.scene.image.Image("scandi.jpg", 800,
                800, false, true),  new javafx.scene.image.Image("p4.png", 100,
                100, false, true));
        Region region5 = new Region(xCoords.get(4), yCoords.get(4), 6,
                "Arctic",  new javafx.scene.image.Image("arctic.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p5.png", 100,
                100, false, true));
        Region region6 = new Region(xCoords.get(5), yCoords.get(5), 3,
                "Desert",  new javafx.scene.image.Image("desert.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p6.png", 100,
                100, false, true));
        Region region7 = new Region(xCoords.get(6), yCoords.get(6), 1,
                "The Glitch",  new javafx.scene.image.Image("TheGlitch.png", 800,
                800, false, true), new javafx.scene.image.Image("p7.png", 100,
                100, false, true));
        Region region8 = new Region(xCoords.get(7), yCoords.get(7), 2,
                "Medieval",  new javafx.scene.image.Image("medi.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p8.png", 100,
                100, false, true));
        Region region9 = new Region(xCoords.get(8), yCoords.get(8), 7,
                "Wild West",  new javafx.scene.image.Image("wildwest.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p9.png", 100,
                100, false, true));
        Region region10 = new Region(xCoords.get(9), yCoords.get(9), 8,
                "Disco",  new javafx.scene.image.Image("disco.jpg", 800,
                800, false, true), new Image("p10.png", 100,
                100, false, true));

        Region[] arr = {region1, region2, region3, region4, region5,
                        region6, region7, region8, region9, region10};
        Random r = new Random();
        int randomNumber = r.nextInt(arr.length);

        //set the item descriptions and names for each region

        //Region 1:
        region1.setItem1Name("Fuel");
        region1.setItem1Description("fuel your ship so you can go across the galaxies!");
        region1.setItem1Quantity(5);

        region1.setItem2Name("Weaponry");
        region1.setItem2Description("Defend yourself from space pirates!");
        region1.setItem2Quantity(7);

        region1.setItem3Name("Weaponry");
        region1.setItem3Description("Defend yourself from space pirates!");
        region1.setItem3Quantity(7);

        // Region 2:
        region2.setItem1Name("");
        region2.setItem1Description("");
        region2.setItem1Quantity(0);

        region2.setItem2Name("");
        region2.setItem2Description("");
        region2.setItem2Quantity(0);

        region2.setItem3Name("");
        region2.setItem3Description("");
        region2.setItem3Quantity(0);

        // Region 3:
        region3.setItem1Name("");
        region3.setItem1Description("");
        region3.setItem1Quantity(0);

        region3.setItem2Name("");
        region3.setItem2Description("");
        region3.setItem2Quantity(0);

        region3.setItem3Name("");
        region3.setItem3Description("");
        region3.setItem3Quantity(0);

        // Region 4:
        region4.setItem1Name("");
        region4.setItem1Description("");
        region4.setItem1Quantity(0);

        region4.setItem2Name("");
        region4.setItem2Description("");
        region4.setItem2Quantity(0);

        region4.setItem3Name("");
        region4.setItem3Description("");
        region4.setItem3Quantity(0);

        //Region 5:
        region5.setItem1Name("");
        region5.setItem1Description("");
        region5.setItem1Quantity(0);

        region5.setItem2Name("");
        region5.setItem2Description("");
        region5.setItem2Quantity(0);

        region5.setItem3Name("");
        region5.setItem3Description("");
        region5.setItem3Quantity(0);

        // Region 6:

        region6.setItem1Name("");
        region6.setItem1Description("");
        region6.setItem1Quantity(0);

        region6.setItem2Name("");
        region6.setItem2Description("");
        region6.setItem2Quantity(0);

        region6.setItem3Name("");
        region6.setItem3Description("");
        region6.setItem3Quantity(0);

        //Region 7:
        region7.setItem1Name("");
        region7.setItem1Description("");
        region7.setItem1Quantity(0);

        region7.setItem2Name("");
        region7.setItem2Description("");
        region7.setItem2Quantity(0);

        region7.setItem3Name("");
        region7.setItem3Description("");
        region7.setItem3Quantity(0);

        // Region 8:

        region8.setItem1Name("");
        region8.setItem1Description("");
        region8.setItem1Quantity(0);

        region8.setItem2Name("");
        region8.setItem2Description("");
        region8.setItem2Quantity(0);

        region8.setItem3Name("");
        region8.setItem3Description("");
        region8.setItem3Quantity(0);

        //Region 9
        region9.setItem1Name("");
        region9.setItem1Description("");
        region9.setItem1Quantity(0);

        region9.setItem2Name("");
        region9.setItem2Description("");
        region9.setItem2Quantity(0);

        region9.setItem3Name("");
        region9.setItem3Description("");
        region9.setItem3Quantity(0);

        //Region 10:

        region10.setItem1Name("");
        region10.setItem1Description("");
        region10.setItem1Quantity(0);

        region2.setItem2Name("");
        region2.setItem2Description("");
        region2.setItem2Quantity(0);

        region2.setItem3Name("");
        region2.setItem3Description("");
        region2.setItem3Quantity(0);





//        //MUSIC :)
//        Media music = new Media(new File("SpaceTradeStorySong.m4a").toURI().toString());
//        MediaPlayer mp = new MediaPlayer(music);
//        mp.play();

        //STORY DETAILS FADE IN AND OUT
        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);
        Scene backstory = new Scene(root, 800, 800);
        root.setStyle("-fx-background-color: black");

        String[] storyarr = {"You began your life on\n your parent's humble farm", "You worked"
                + " alongside your\n parents for many years, but \n you sought adventure and"
                + " fame", "Finally, after coming of age\n your parents allow you \nto leave the"
                + " farm", "With your trusty\n John Antelope TR-4CT0R spaceship \n you venture out"
                + " into space,\n however you run into\n pirates almost immediately", "Escaping,"
                + " you use\n most of your fuel and resources", "Needing to refuel and resupply\n "
                + "you land on the nearest\n planet and begin your journey..."};

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
                        //mp.stop();
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
                //mp.stop();
                RegionPage rp = new RegionPage(primaryStage, p1, currregion, arr);
            }

        });


        primaryStage.setTitle("Back Story");
        primaryStage.setScene(backstory);
        primaryStage.show();
    }
}
