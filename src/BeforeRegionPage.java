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
import java.util.ArrayList;

public class BeforeRegionPage {

    private int ndx = 0;

    public BeforeRegionPage(Stage primaryStage, Player p1) {
        //INSTANTIATING REGIONS
        //initiating regions
        CoordGenerator cg = new CoordGenerator(700);
        HashMap<Integer, Integer> xCoords = cg.getX();
        HashMap<Integer, Integer> yCoords = cg.getY();

        int mSkill = p1.getMerchantSkill();
        ItemListInitializer itemInit = new ItemListInitializer();
        String[] farmItems = {"Fuel<placeholder.png>", "Weaponry<placeholder.png>", "Seeds<placeholder.png>", "farmitem4<placeholder.png>", "farmitem5<placeholder.png>", "farmitem6<placeholder.png>"};
        Region region1 = new Region(xCoords.get(0), yCoords.get(0), 2,
                "Farm", new javafx.scene.image.Image("farm.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p1.png", 100,
                100, false, true));
        //set market's items attribute
        region1.getMarket().setItems(itemInit.createItemList(region1.getTechLevel(), mSkill, region1.getTax(), farmItems));

        String[] safariItems = {"Companion Capuchin\nMonkey<placeholder.png>", "Fuel<placeholder.png>", "Diamond<placeholder.png>", "safari4<placeholder.png>", "safari5<placeholder.png>", "fuel<placeholder.png>"};
        Region region2 = new Region(xCoords.get(1), yCoords.get(1), 4,
                "Safari",  new javafx.scene.image.Image("safari.png", 800,
                800, false, true), new javafx.scene.image.Image("p2.png", 100,
                100, false, true));
        //set market's items attribute
        region2.getMarket().setItems(itemInit.createItemList(region2.getTechLevel(), mSkill, region2.getTax(),safariItems));

        String[] boyBandItems = {"Justin Bieber: My World 2.0<placeholder.png>", "boyband2<placeholder.png>", "Fuel<placeholder.png>", "boyband4<placeholder.png>", "boyband5<placeholder.png>", "fuel<placeholder.png>"};
        Region region3 = new Region(xCoords.get(2), yCoords.get(2), 6,
                "2000s Boy Bands",  new javafx.scene.image.Image("bsb.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p3.png", 100,
                100, false, true));
        //set market's items attribute
        region3.getMarket().setItems(itemInit.createItemList(region3.getTechLevel(), mSkill, region3.getTax(), boyBandItems));

        String[] scandinavianItems = {"Rod & Reel<placeholder.png>", "Fuel<placeholder.png>", "scandi3<placeholder.png>", "scandi4<placeholder.png>", "scandi5<placeholder.png>", "scandi6<placeholder.png>"};
        Region region4 = new Region(xCoords.get(3), yCoords.get(3), 5,
                "Scandinavian",  new javafx.scene.image.Image("scandi.jpg", 800,
                800, false, true),  new javafx.scene.image.Image("p4.png", 100,
                100, false, true));
        //set market's items attribute
        region4.getMarket().setItems(itemInit.createItemList(region4.getTechLevel(), mSkill, region4.getTax(), scandinavianItems));

        String[] arcticItems = {"Air Conditioning<placeholder.png>", "Ice<placeholder.png>", "Fuel<placeholder.png>", "arctic4<placeholder.png>", "arctic5<placeholder.png>", "arctic6<placeholder.png>"};
        Region region5 = new Region(xCoords.get(4), yCoords.get(4), 6,
                "Arctic",  new javafx.scene.image.Image("arctic.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p5.png", 100,
                100, false, true));
        //set market's items attribute
        region5.getMarket().setItems(itemInit.createItemList(region5.getTechLevel(), mSkill, region5.getTax(), arcticItems));

        String[] desertItems = {"Croissants<placeholder.png>", "Fuel<placeholder.png>", "desert3<placeholder.png>", "desert4<placeholder.png>", "desert5<placeholder.png>", "fuel<placeholder.png>"};
        Region region6 = new Region(xCoords.get(5), yCoords.get(5), 3,
                "Desert",  new javafx.scene.image.Image("desert.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p6.png", 100,
                100, false, true));
        //set market's items attribute
        region6.getMarket().setItems(itemInit.createItemList(region6.getTechLevel(), mSkill, region6.getTax(), desertItems));

        String[] glitchItems = {"glitch1<placeholder.png>", "GPS<placeholder.png>", "glitch3<placeholder.png>", "glitch4<placeholder.png>", "glitch5<placeholder.png>", "glitch6<placeholder.png>"};
        Region region7 = new Region(xCoords.get(6), yCoords.get(6), 1,
                "The Glitch",  new javafx.scene.image.Image("TheGlitch.png", 800,
                800, false, true), new javafx.scene.image.Image("p7.png", 100,
                100, false, true));
        //set market's items attribute
        region7.getMarket().setItems(itemInit.createItemList(region7.getTechLevel(), mSkill, region7.getTax(), glitchItems));

        String[] medievalItems = {"Sword<placeholder.png>", "med2<placeholder.png>", "Bow and Arrow<placeholder.png>", "med4<placeholder.png>", "med5<placeholder.png>", "med6<placeholder.png>"};
        Region region8 = new Region(xCoords.get(7), yCoords.get(7), 2,
                "Medieval",  new javafx.scene.image.Image("medi.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p8.png", 100,
                100, false, true));
        //set market's items attribute
        region8.getMarket().setItems(itemInit.createItemList(region8.getTechLevel(), mSkill, region8.getTax(), medievalItems));

        String[] wildWestItems = {"Bison Burger<placeholder.png>", "wild2<placeholder.png>", "wild3<placeholder.png>", "Fuel<placeholder.png>", "wild5<placeholder.png>", "fuel<placeholder.png>"};
        Region region9 = new Region(xCoords.get(8), yCoords.get(8), 7,
                "Wild West",  new javafx.scene.image.Image("wildwest.jpg", 800,
                800, false, true), new javafx.scene.image.Image("p9.png", 100,
                100, false, true));
        //set market's items attribute
        region9.getMarket().setItems(itemInit.createItemList(region9.getTechLevel(), mSkill, region9.getTax(), wildWestItems));

        String[] discoItems = {"Disco Pant<placeholder.png>", "disco2<placeholder.png>", "disco3<placeholder.png>", "disco4<placeholder.png>", "disco5<placeholder.png>", "disco6<placeholder.png>"};
        Region region10 = new Region(xCoords.get(9), yCoords.get(9), 8,
                "Disco",  new javafx.scene.image.Image("disco.jpg", 800,
                800, false, true), new Image("p10.png", 100,
                100, false, true));
        //set market's items attribute
        region10.getMarket().setItems(itemInit.createItemList(region10.getTechLevel(), mSkill, region10.getTax(), discoItems));

        Region[] arr = {region1, region2, region3, region4, region5,
                        region6, region7, region8, region9, region10};
        Random r = new Random();
        int randomNumber = r.nextInt(arr.length);


//        //MUSIC :)
        //Media music = new Media(new File("SpaceTradeStorySong.m4a").toURI().toString());
        //MediaPlayer mp = new MediaPlayer(music);
        //mp.play();

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
