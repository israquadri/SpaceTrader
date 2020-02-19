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

        String[] region1items = {"Fuel", "Weaponry", "Seeds", "farmitem4", "farmitem5", "farmitem6"};
        Region region1 = new Region(xCoords.get(0), yCoords.get(0), 2,
                "Farm", new javafx.scene.image.Image("farm.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p1.png", 100,
                100, false, true), region1items, p1);
        String[] region2items = {"Companion Capuchin Monkey", "Fuel", "Diamond", "safari4", "safari5", "fuel"};
        Region region2 = new Region(xCoords.get(1), yCoords.get(1), 4,
                "Safari",  new javafx.scene.image.Image("safari.png", 800,
                800, false, true), new javafx.scene.image.Image("p2.png", 100,
                100, false, true), region2items, p1);
        String[] region3items = {"Justin Bieber: My World 2.0", "boyband2", "Fuel", "boyband4", "boyband5", "fuel"};
        Region region3 = new Region(xCoords.get(2), yCoords.get(2), 6,
                "2000s Boy Bands",  new javafx.scene.image.Image("bsb.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p3.png", 100,
                100, false, true), region3items, p1);
        String[] region4items = {"Rod & Reel", "Fuel", "scandi3", "scandi4", "scandi5", "scandi6"};
        Region region4 = new Region(xCoords.get(3), yCoords.get(3), 5,
                "Scandinavian",  new javafx.scene.image.Image("scandi.jpg", 800,
                800, false, true),  new javafx.scene.image.Image("p4.png", 100,
                100, false, true), region4items, p1);
        String[] region5items = {"Air Conditioning", "Ice", "Fuel", "arctic4", "arctic5", "arctic6"};
        Region region5 = new Region(xCoords.get(4), yCoords.get(4), 6,
                "Arctic",  new javafx.scene.image.Image("arctic.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p5.png", 100,
                100, false, true), region5items, p1);
        String[] region6items = {"Croissants", "Fuel", "desert3", "desert4", "desert5", "fuel"};
        Region region6 = new Region(xCoords.get(5), yCoords.get(5), 3,
                "Desert",  new javafx.scene.image.Image("desert.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p6.png", 100,
                100, false, true), region6items, p1);
        String[] region7items = {"glitch1", "GPS", "glitch3", "glitch4", "glitch5", "glitch6"};
        Region region7 = new Region(xCoords.get(6), yCoords.get(6), 1,
                "The Glitch",  new javafx.scene.image.Image("TheGlitch.png", 800,
                800, false, true), new javafx.scene.image.Image("p7.png", 100,
                100, false, true), region7items, p1);
        String[] region8items = {"Sword", "med2", "Bow and Arrow", "med4", "med5", "med6"};
        Region region8 = new Region(xCoords.get(7), yCoords.get(7), 2,
                "Medieval",  new javafx.scene.image.Image("medi.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p8.png", 100,
                100, false, true), region8items, p1);
        String[] region9items = {"Bison Burger", "wild2", "wild3", "Fuel", "wild5", "fuel"};
        Region region9 = new Region(xCoords.get(8), yCoords.get(8), 7,
                "Wild West",  new javafx.scene.image.Image("wildwest.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p9.png", 100,
                100, false, true), region9items, p1);
        String[] region10items = {"Disco Pant", "disco2", "disco3", "disco4", "disco5", "disco6"};
        Region region10 = new Region(xCoords.get(9), yCoords.get(9), 8,
                "Disco",  new javafx.scene.image.Image("disco.jpg", 800,
                800, false, true), new Image("p10.png", 100,
                100, false, true), region10items, p1);

        Region[] arr = {region1, region2, region3, region4, region5,
                        region6, region7, region8, region9, region10};
        Random r = new Random();
        int randomNumber = r.nextInt(arr.length);


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
