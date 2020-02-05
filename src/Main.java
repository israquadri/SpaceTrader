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
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
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


public class Main extends Application {

    private Scene scene1;
    private Scene scene2;
    private Scene scene3;

    //CHARACTER CONFIGURATION SETUP

    //START METHOD FOR SPACE TRADER APP
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox back = new HBox();
        src.Player p1 = new src.Player();



        //Format the backing hbox
        back.setAlignment(Pos.CENTER);

        //Make the progress bars and accompanying text here so can use them in difficulty buttons
        ProgressBar t1pb = new ProgressBar(0);
        Text t1 = new Text("Pilot: " + p1.getTrait1Val());
        ProgressBar t2pb = new ProgressBar(0);
        Text t2 = new Text("Fighter: " + p1.getTrait2Val());
        ProgressBar t3pb = new ProgressBar(0);
        Text t3 = new Text("Merchant: " + p1.getTrait3Val());
        ProgressBar t4pb = new ProgressBar(0);
        Text t4 = new Text("Engineer: " + p1.getTrait4Val());


        //Create a new vbox for left side of screen and add box
        // for name, radio button for difficulty.
        VBox left = new VBox(10);
        back.getChildren().add(left);
        left.setAlignment(Pos.BOTTOM_CENTER);
        left.setPadding(new Insets(20, 50, 20, 20));
        left.setSpacing(20);
        //Create right VBox for right side of screen
        VBox right = new VBox(10);
        back.getChildren().add(right);
        right.setAlignment(Pos.TOP_CENTER);
        right.setPadding(new Insets(20, 50, 20, 20));
        left.setSpacing(20);
        //Add text for skill points remaining
        Text remain = new Text("Skill Points Remaining: " + p1.getSkillPoints());
        remain.setFill(Color.WHITE);
        remain.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat', sans-serif;");
        right.getChildren().add(remain);

        //Choose difficulty
        Text diff = new Text("Choose your difficulty level below: ");
        diff.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat', sans-serif;");
        diff.setFill(Color.WHITE);

        left.getChildren().add(diff);
        left.setAlignment(Pos.TOP_CENTER);

        //Creating radio button for difficulty and adding to vbox
        ToggleGroup difficulty = new ToggleGroup();
        RadioButton easy = new RadioButton("Easy");
        easy.setTextFill(Color.WHITE);
        easy.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat',"
                + " sans-serif; margin: 0 10px 0 10px;");
        RadioButton medium = new RadioButton("Medium");
        medium.setTextFill(Color.WHITE);
        medium.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat',"
                + " sans-serif; margin: 0 10px 0 10px;");
        RadioButton hard = new RadioButton("Hard");
        hard.setTextFill(Color.WHITE);
        hard.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat',"
                + " sans-serif; margin: 0 10px 0 10px;");


        //Adding radio buttons to toggle group
        easy.setToggleGroup(difficulty);
        medium.setToggleGroup(difficulty);
        hard.setToggleGroup(difficulty);

        //EVENT HANDLER FOR EASY BUTTON
        easy.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(16);
            p1.setCredits(1000);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());
            p1.setTrait1Val(0);
            p1.setTrait2Val(0);
            p1.setTrait3Val(0);
            p1.setTrait4Val(0);
            t1.setText("Pilot: " + p1.getTrait1Val());
            t2.setText("Fighter: " + p1.getTrait2Val());
            t3.setText("Merchant: " + p1.getTrait3Val());
            t4.setText("Engineer: " + p1.getTrait4Val());
            t1pb.setProgress(p1.getTrait1Val() / 16.0);
            t2pb.setProgress(p1.getTrait2Val() / 16.0);
            t3pb.setProgress(p1.getTrait3Val() / 16.0);
            t4pb.setProgress(p1.getTrait4Val() / 16.0);


        });
        //event handler for medium button
        medium.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(12);
            p1.setCredits(500);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());
            p1.setTrait1Val(0);
            p1.setTrait2Val(0);
            p1.setTrait3Val(0);
            p1.setTrait4Val(0);
            t1.setText("Pilot: " + p1.getTrait1Val());
            t2.setText("Fighter: " + p1.getTrait2Val());
            t3.setText("Merchant: " + p1.getTrait3Val());
            t4.setText("Engineer: " + p1.getTrait4Val());
            t1pb.setProgress(p1.getTrait1Val() / 16.0);
            t2pb.setProgress(p1.getTrait2Val() / 16.0);
            t3pb.setProgress(p1.getTrait3Val() / 16.0);
            t4pb.setProgress(p1.getTrait4Val() / 16.0);

        });
        //event handler for hard button
        hard.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(8);
            p1.setCredits(100);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());
            p1.setTrait1Val(0);
            p1.setTrait2Val(0);
            p1.setTrait3Val(0);
            p1.setTrait4Val(0);
            t1.setText("Pilot: " + p1.getTrait1Val());
            t2.setText("Fighter: " + p1.getTrait2Val());
            t3.setText("Merchant: " + p1.getTrait3Val());
            t4.setText("Engineer: " + p1.getTrait4Val());
            t1pb.setProgress(p1.getTrait1Val() / 16.0);
            t2pb.setProgress(p1.getTrait2Val() / 16.0);
            t3pb.setProgress(p1.getTrait3Val() / 16.0);
            t4pb.setProgress(p1.getTrait4Val() / 16.0);

        });
        //Adding radio buttons to vbox
        left.getChildren().add(easy);
        left.getChildren().add(medium);
        left.getChildren().add(hard);


        //CHARACTER TRAIT SELECTOR BEGINS
        //Create area where traits are selected (Create 4 hboxes to house each of the four traits)
        HBox trait1 = new HBox(5);
        trait1.setSpacing(5);
        HBox trait2 = new HBox(5);
        trait2.setSpacing(5);
        HBox trait3 = new HBox(5);
        trait3.setSpacing(5);
        HBox trait4 = new HBox(5);
        trait4.setSpacing(5);

        //Add each trait hbox to the right vbox
        right.getChildren().add(trait1);
        right.getChildren().add(trait2);
        right.getChildren().add(trait3);
        right.getChildren().add(trait4);

        //Edit each of the trait hboxs to have trait and then bar to
        // select amount of trait wanted
        trait1.getChildren().add(t1);
        t1.setFill(Color.WHITE);
        t1.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat', sans-serif;");
        t2.setFill(Color.WHITE);
        t2.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat', sans-serif;");
        trait2.getChildren().add(t2);
        trait3.getChildren().add(t3);
        t3.setFill(Color.WHITE);
        t3.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat', sans-serif;");
        trait4.getChildren().add(t4);
        t4.setFill(Color.WHITE);
        t4.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat', sans-serif;");

        //progress bar 1 with buttons to move
        Button t1dec = new Button("<");
        t1dec.setStyle("-fx-background-color: black; -fx-border-color: white");
        Button t1inc = new Button(">");
        t1inc.setStyle("-fx-background-color: black; -fx-border-color: white");
        t1dec.setTextFill(Color.WHITE);
        t1inc.setTextFill(Color.WHITE);
        trait1.getChildren().add(t1dec);
        trait1.getChildren().add(t1pb);
        trait1.getChildren().add(t1inc);
        t1dec.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() + 1);
            p1.setTrait1Val(p1.getTrait1Val() - 1);
            if (p1.getTrait1Val() < 0) {
                p1.setTrait1Val(0);
                p1.setSkillPoints(p1.getSkillPoints() - 1);
            }
            t1.setText("Pilot: " + p1.getTrait1Val());
            t1pb.setProgress(p1.getTrait1Val() / 16.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());

        });
        t1inc.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() - 1);
            p1.setTrait1Val(p1.getTrait1Val() + 1);
            if (p1.getSkillPoints() < 0) {
                p1.setSkillPoints(0);
                p1.setTrait1Val(p1.getTrait1Val() - 1);
            }
            if (p1.getTrait1Val() > 16) {
                p1.setTrait1Val(16);
                p1.setSkillPoints(p1.getSkillPoints() - 1);
            }
            t1.setText("Pilot: " + p1.getTrait1Val());
            t1pb.setProgress(p1.getTrait1Val() / 16.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());
        });

        //Progress bar 2
        Button t2dec = new Button("<");
        t2dec.setStyle("-fx-background-color: black; -fx-border-color: white");
        Button t2inc = new Button(">");
        t2inc.setStyle("-fx-background-color: black; -fx-border-color: white");
        t2dec.setTextFill(Color.WHITE);
        t2inc.setTextFill(Color.WHITE);
        trait2.getChildren().add(t2dec);
        trait2.getChildren().add(t2pb);
        trait2.getChildren().add(t2inc);
        t2dec.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() + 1);
            p1.setTrait2Val(p1.getTrait2Val() - 1);
            if (p1.getTrait2Val() < 0) {
                p1.setTrait2Val(0);
                p1.setSkillPoints(p1.getSkillPoints() - 1);
            }
            t2.setText("Fighter: " + p1.getTrait2Val());
            t2pb.setProgress(p1.getTrait2Val() / 16.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());

        });
        t2inc.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() - 1);
            p1.setTrait2Val(p1.getTrait2Val() + 1);
            if (p1.getSkillPoints() < 0) {
                p1.setSkillPoints(0);
                p1.setTrait2Val(p1.getTrait2Val() - 1);
            }
            if (p1.getTrait2Val() > 16) {
                p1.setTrait2Val(16);
                p1.setSkillPoints(p1.getSkillPoints() - 1);
            }
            t2.setText("Fighter: " + p1.getTrait2Val());
            t2pb.setProgress(p1.getTrait2Val() / 16.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());
        });

        //Progress Bar 3
        Button t3dec = new Button("<");
        t3dec.setStyle("-fx-background-color: black; -fx-border-color: white");
        Button t3inc = new Button(">");
        t3inc.setStyle("-fx-background-color: black; -fx-border-color: white");
        t3dec.setTextFill(Color.WHITE);
        t3inc.setTextFill(Color.WHITE);
        trait3.getChildren().add(t3dec);
        trait3.getChildren().add(t3pb);
        trait3.getChildren().add(t3inc);
        t3dec.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() + 1);
            p1.setTrait3Val(p1.getTrait3Val() - 1);
            if (p1.getTrait3Val() < 0) {
                p1.setTrait3Val(0);
                p1.setSkillPoints(p1.getSkillPoints() - 1);
            }
            t3.setText("Merchant: " + p1.getTrait3Val());
            t3pb.setProgress(p1.getTrait3Val() / 16.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());

        });
        t3inc.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() - 1);
            p1.setTrait3Val(p1.getTrait3Val() + 1);
            if (p1.getSkillPoints() < 0) {
                p1.setSkillPoints(0);
                p1.setTrait3Val(p1.getTrait3Val() - 1);
            }
            if (p1.getTrait3Val() > 16) {
                p1.setTrait3Val(16);
                p1.setSkillPoints(p1.getSkillPoints() - 1);
            }
            t3.setText("Merchant: " + p1.getTrait3Val());
            t3pb.setProgress(p1.getTrait3Val() / 16.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());
        });

        Button t4dec = new Button("<");
        t4dec.setStyle("-fx-background-color: black; -fx-border-color: white");
        Button t4inc = new Button(">");
        t4inc.setStyle("-fx-background-color: black; -fx-border-color: white");
        t4dec.setTextFill(Color.WHITE);
        t4inc.setTextFill(Color.WHITE);
        trait4.getChildren().add(t4dec);
        trait4.getChildren().add(t4pb);
        trait4.getChildren().add(t4inc);
        t4dec.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() + 1);
            p1.setTrait4Val(p1.getTrait4Val() - 1);
            if (p1.getTrait4Val() < 0) {
                p1.setTrait4Val(0);
                p1.setSkillPoints(p1.getSkillPoints() - 1);
            }
            t4.setText("Engineer " + p1.getTrait4Val());
            t4pb.setProgress(p1.getTrait4Val() / 16.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());

        });
        t4inc.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() - 1);
            p1.setTrait4Val(p1.getTrait4Val() + 1);
            if (p1.getSkillPoints() < 0) {
                p1.setSkillPoints(0);
                p1.setTrait4Val(p1.getTrait4Val() - 1);
            }
            if (p1.getTrait4Val() > 16) {
                p1.setTrait4Val(16);
                p1.setSkillPoints(p1.getSkillPoints() - 1);
            }
            t4.setText("Engineer: " + p1.getTrait4Val());
            t4pb.setProgress(p1.getTrait4Val() / 16.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());
        });

        //CHARACTER TRAIT ALLOCATOR ENDS



        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Scene 1: Welcome Screen
        BorderPane root = new BorderPane();
        scene1 = new Scene(root, 800, 800);
        scene1.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
        scene1.getStylesheets().add(
                "https://fonts.googleapis.com/css?family=Montserrat&display=swap\" rel=\"stylesheet");

        // space trader drop shadow
        DropShadow ds = new DropShadow();
        ds.setOffsetY(7.0f);
        ds.setColor(Color.WHITE);

        //Space Trader Game Title
        VBox vbox = new VBox();
        Text spaceTrader = new Text(100.0, 50.0, "Space Trader");
        vbox.getChildren().addAll(spaceTrader);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(100, 50, 50, 50));

        // SPACE TRADER APP TITLE
        spaceTrader.setFill(Color.INDIANRED);
        spaceTrader.setEffect(ds);
        spaceTrader.setCache(true);
        spaceTrader.setStyle("-fx-font-size: 60px; -fx-font-family: 'Press Start 2P', cursive;");

        // ROCKET IMAGE
        Image image = new Image("file:rocket.jpg");
        ImageView iv = new ImageView();
        iv.setImage(image);
        iv.setFitHeight(350);
        iv.setFitWidth(350);
        HBox rocketHBox = new HBox();
        rocketHBox.getChildren().add(iv);
        rocketHBox.setAlignment(Pos.BOTTOM_CENTER);
        rocketHBox.setPadding(new Insets(10, 10, 30, 10));

        // ROCKET ANIMATION
        RotateTransition rotate = new RotateTransition(Duration.millis(3000));
        rotate.setNode(iv);
        rotate.setByAngle(360);
        rotate.setCycleCount(50);
        rotate.setAutoReverse(false);
        rotate.play();

        //MUSIC :)
        //Media spaceTraderIntroSong = new Media(new File("SpaceTraderIntroSong.m4a").toURI().toString());
        //MediaPlayer songplayer = new MediaPlayer(spaceTraderIntroSong);
        //songplayer.play();

        // START GAME BUTTON
        Button startButton = new Button("Start game!");
        BackgroundImage myBI = new BackgroundImage(new Image("file:galaxy.jpg", 800,
                800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setStyle("-fx-border-color: lightcoral; -fx-border-width: 10px");
        root.setBackground(new Background(myBI));
        startButton.setAlignment(Pos.BASELINE_CENTER);
        startButton.setTextFill(Color.WHITE);
        startButton.setStyle("-fx-background-color: black; -fx-font-size: 40px;"
                + " -fx-font-family: 'Press Start 2P', cursive;");

        // DROP SHADOW HOVER EFFECT ON START BUTTON
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.CORAL);
        shadow.setWidth(1.5);
        //adding the shadow when the mouse cursor is on
        startButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        startButton.setEffect(shadow);
                    }
                });
        //removing shadow when mouse cursor is off
        startButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        startButton.setEffect(null);
                    }
                });

        // SCENE 1 BACKING STRUCTURE
        root.setCenter(startButton);
        root.setTop(vbox);
        root.setBottom(rocketHBox);
        primaryStage.setTitle("Space Trader");
        primaryStage.setScene(scene1);
        primaryStage.show();

        // SET UP SCENE 2
        VBox vb2 = new VBox(40.0);
        vb2.setPadding(new Insets(50.0, 10.0, 20.0, 10.0));

        // BACK TO HOME BUTTON
        Button backToHome = new Button("Back to Home");
        backToHome.setTextFill(Color.WHITE);
        backToHome.setStyle("-fx-background-color: black; -fx-font-size: 20px;"
                + " -fx-font-family: 'Press Start 2P', cursive;");
        backToHome.setAlignment(Pos.BASELINE_LEFT);

        //CHARACTER CONFIGURATION TITLE
        Text charConfig = new Text("CHARACTER\nCONFIGURATION");
        charConfig.setFill(Color.INDIANRED);
        charConfig.setStyle("-fx-background-color: white; -fx-font-size: 50px;"
                + " -fx-font-color: white; -fx-font-family: 'Press Start 2P', cursive;"
                + " -fx-set-padding-left: 70px;");
        HBox nameHBox = new HBox(charConfig);
        nameHBox.setPadding(new Insets(90.0, 50.0, 50.0, 50.0));
        nameHBox.setAlignment(Pos.TOP_CENTER);
        back.setPadding(new Insets(50, 50, 50, 50));

        // BACK TO HOME DROP SHADOW HOVER EFFECT
        backToHome.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        backToHome.setEffect(shadow);
                    }
                });
        backToHome.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        backToHome.setEffect(null);
                    }
                });


        // CHARACTER FIELD WHERE USER ENTERS CHARACTER NAME
        TextField characterField = new TextField();
        characterField.setPromptText("type name, press ENTER");
        characterField.setPrefWidth(400);
        characterField.setMaxWidth(300);
        HBox nameBox = new HBox();
        nameBox.setSpacing(10);
        nameBox.getChildren().add(characterField);
        Button enter = new Button("ENTER");
        nameBox.getChildren().add(enter);
        nameBox.setAlignment(Pos.TOP_CENTER);

        //INSTANTIATE NEW CHARACTER WHEN USER TYPES NAME IN CHARACTER TEXT FIELD
        enter.setOnMouseClicked((mouseEvent -> {
            String characterName = new String(characterField.getText());
            if (characterName.length() == 0) {
                Alert a = new Alert(AlertType.ERROR, "Character name cannot be"
                        + " blank. Please try again!");
                a.show();
            } else if (characterName.length() < 3) {
                Alert a = new Alert(AlertType.ERROR, "'" + characterName
                        + "' is too short. Character name must be at least"
                        + " 3 characters. Please try again!");
                a.show();
            } else {
                p1.setName(characterName);
                Alert a = new Alert(AlertType.CONFIRMATION, "Welcome to"
                        + " Space Trader, " + p1.getName() + "!");
                a.show();
            }
        }));


        //CONTINUE TO SCENE 3 BUTTON
        Button next = new Button("CONTINUE");
        next.setAlignment(Pos.CENTER_RIGHT);
        next.setTextFill(Color.WHITESMOKE);
        next.setStyle("-fx-background-color: black; -fx-font-size: 20px;"
                + " -fx-font-family: 'Press Start 2P', cursive;");

        //HOVER EFFECT FOR 'CONTINUE' BUTTON
        next.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        next.setEffect(shadow);
                    }
                });
        next.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        next.setEffect(null);
                    }
                });


        //CHARACTER CONFIGURATION
        vb2.getChildren().addAll(charConfig, backToHome, nameBox, back, next);
        //bp2.setRight(back);
        vb2.setStyle("-fx-border-color: lightcoral; -fx-border-width: 10px");
        vb2.setBackground(new Background(myBI));
        scene2 = new Scene(vb2, 800, 800);

        // START BUTTON TAKES USER TO SCENE 2
        startButton.setOnMouseClicked((mouseEvent -> {
            primaryStage.setScene(scene2);
            primaryStage.setTitle("Welcome user!");
            primaryStage.show();
        }));

        // BACK TO HOME BUTTON TAKES USER TO SCENE 1
        backToHome.setOnMouseClicked((mouseEvent -> {
            primaryStage.setScene(scene1);
            primaryStage.setTitle("Space Trader");
            primaryStage.show();
        }));

        //Scene 3: Character Screen

        //BACK TO SCENE 2 BUTTON
        Button backToScene2 = new Button("Back to Character\nConfiguration");
        backToScene2.setTextFill(Color.WHITE);
        backToScene2.setStyle("-fx-background-color: black; -fx-font-size: 20px;"
                + " -fx-font-family: 'Press Start 2P', cursive;");
        HBox bt2 = new HBox();
        bt2.getChildren().add(backToScene2);
        bt2.setAlignment(Pos.BASELINE_LEFT);


        //PROCEED TO SCENE 3 BUTTON
        next.setOnMouseClicked((mouseEvent -> {
            //Stop the Space Trader Intro Music
            //songplayer.stop();
            // SCENE 3 BACKING STRUCTURE SET UP
            VBox vb3 = new VBox(20.0);
            scene3 = new Scene(vb3, 800, 800);
            scene3.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
            vb3.setStyle("-fx-border-color: lightcoral; -fx-border-width: 10px");
            vb3.setBackground(new Background(myBI));

            // ADDING CHARACTER SHEET SCREEN TEXT NODES
            Text yourCharacter = new Text("WELCOME,\n" + p1.getName());
            yourCharacter.setFill(Color.INDIANRED);
            yourCharacter.setStyle("-fx-background-color: black; -fx-font-size: 60px;"
                    + " -fx-font-family: 'Press Start 2P', cursive;");

            Text yourNameIs = new Text("Your name is: " + p1.getName());
            yourNameIs.setFill(Color.WHITE);
            yourNameIs.setStyle("-fx-font-size: 20px; -fx-background-color: purple;"
                    + " -fx-font-family: 'Press Start 2P', cursive;");

            Text yourTraits = new Text("Your points for Pilot: " + p1.getTrait1Val()
                    + "\nYour points for Fighter: " + p1.getTrait2Val()
                    + "\nYour points for Merchant: " + p1.getTrait3Val()
                    + "\nYour points for Engineer: " + p1.getTrait4Val());
            yourTraits.setFill(Color.WHITE);
            yourTraits.setStyle("-fx-font-size: 20px; -fx-background-color: purple;"
                    + " -fx-font-family: 'Press Start 2P', cursive;");

            Text yourDiff = new Text("Based on your difficulty level, you\nhave "
                    + p1.getCredits() + " credits");
            yourDiff.setFill(Color.WHITE);
            yourDiff.setStyle("-fx-font-size: 20px; -fx-background-color: purple;"
                    + " -fx-font-family: 'Press Start 2P', cursive;");
            vb3.getChildren().addAll(yourCharacter, bt2, yourNameIs, yourTraits, yourDiff);
            primaryStage.setScene(scene3);
            primaryStage.setTitle("Scene 3");
            primaryStage.show();
        }));



        //DROP SHADOW EFFECT
        backToScene2.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        backToScene2.setEffect(shadow);
                    }
                });
        backToScene2.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        backToScene2.setEffect(null);
                    }
                });

        //BACK TO SCENE 2 BUTTON
        backToScene2.setOnMouseClicked((mouseEvent -> {
            primaryStage.setScene(scene2);
            primaryStage.setTitle("Welcome user!");
            primaryStage.show();
        }));
        
    }
}
