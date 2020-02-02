package src;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;


public class Main extends Application {

    private Scene scene1;
    private Scene scene2;
    private Scene scene3;


    /**
     * This inner class is for the Character
     */
    public class Character {
        private String name;
        private int skillPoints;
        private int credits;
        private int trait1val;
        private int trait2val;
        private int trait3val;
        private int trait4val;

        //GETTER AND SETTER FOR CHARACTER
        public Character() {
            this.name = null;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSkillPoints() {
            return this.skillPoints;
        }

        public void setSkillPoints(int skillPoints) {
            this.skillPoints = skillPoints;
        }

        public int getCredits() {
            return this.credits;
        }

        public void setCredits(int credits) {
            this.credits = credits;
        }

        public int getTrait1Val() {
            return this.trait1val;
        }

        public void setTrait1Val(int trait1val) {
            this.trait1val = trait1val;
        }

        public int getTrait2Val() {
            return this.trait2val;
        }

        public void setTrait2Val(int trait2val) {
            this.trait2val = trait2val;
        }

        public int getTrait3Val() {
            return this.trait3val;
        }

        public void setTrait3Val(int trait3val) {
            this.trait3val = trait3val;
        }

        public int getTrait4Val() {
            return this.trait4val;
        }

        public void setTrait4Val(int trait4val) {
            this.trait4val = trait4val;
        }

    }

    //CHARACTER CONFIGURATION SETUP

    HBox back = new HBox();
    int skillPoints = 16;
    int startingCredits = 1000;
    int t1val = 0;
    int t2val = 0;
    int t3val = 0;
    int t4val = 0;


    public void format() {
        //Format the backing hbox
        back.setAlignment(Pos.CENTER);

        //Create a new vbox for left side of screen and add box for name, radio button for difficulty.
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
        Text remain = new Text("Skill Points Remaining: " + skillPoints);
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
        easy.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat', sans-serif; margin: 0 10px 0 10px;");
        RadioButton medium = new RadioButton("Medium");
        medium.setTextFill(Color.WHITE);
        medium.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat', sans-serif; margin: 0 10px 0 10px;");
        RadioButton hard = new RadioButton("Hard");
        hard.setTextFill(Color.WHITE);
        hard.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat', sans-serif; margin: 0 10px 0 10px;");


        //Adding radio buttons to toggle group
        easy.setToggleGroup(difficulty);
        medium.setToggleGroup(difficulty);
        hard.setToggleGroup(difficulty);

        //EVENT HANDLER FOR EASY BUTTON
        easy.setOnAction((ActionEvent e) -> {
            skillPoints = 16;
            startingCredits = 1000;
            remain.setText("Skill Points Remaining: " + skillPoints);


        });
        //event handler for medium button
        medium.setOnAction((ActionEvent e) -> {
            skillPoints = 12;
            startingCredits = 500;
            remain.setText("Skill Points Remaining: " + skillPoints);

        });
        //event handler for hard button
        hard.setOnAction((ActionEvent e) -> {
            skillPoints = 8;
            startingCredits = 100;
            remain.setText("Skill Points Remaining: " + skillPoints);

        });
        //Adding radio buttons to vbox
        left.getChildren().add(easy);
        left.getChildren().add(medium);
        left.getChildren().add(hard);


        //CHARACTER TRAIT SELECTOR BEGINS
        //Create area where traits are selected (Create 4 hboxes to house each of the four traits)
        HBox trait1 = new HBox(2);
        trait1.setSpacing(5);
        HBox trait2 = new HBox(2);
        trait2.setSpacing(5);
        HBox trait3 = new HBox(2);
        trait3.setSpacing(5);
        HBox trait4 = new HBox(2);
        trait4.setSpacing(5);

        //Add each trait hbox to the right vbox
        right.getChildren().add(trait1);
        right.getChildren().add(trait2);
        right.getChildren().add(trait3);
        right.getChildren().add(trait4);

        //Edit each of the trait hboxs to have trait and then bar to select amount of trait wanted
        Text t1 = new Text("Pilot: " + t1val );
        trait1.getChildren().add(t1);
        t1.setFill(Color.WHITE);
        t1.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat', sans-serif;");
        Text t2 = new Text("Fighter: " + t2val);
        t2.setFill(Color.WHITE);
        t2.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat', sans-serif;");
        trait2.getChildren().add(t2);
        Text t3 = new Text("Merchant: " + t3val);
        trait3.getChildren().add(t3);
        t3.setFill(Color.WHITE);
        t3.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat', sans-serif;");
        Text t4 = new Text("Engineer: " + t4val );
        trait4.getChildren().add(t4);
        t4.setFill(Color.WHITE);
        t4.setStyle("-fx-font-size: 20px; -fx-font-family: 'Montserrat', sans-serif;");

        //progress bar 1 with buttons to move
        Button t1dec = new Button("<");
        t1dec.setStyle("-fx-background-color: black; -fx-border-color: white");
        ProgressBar t1pb = new ProgressBar(0);
        Button t1inc = new Button(">");
        t1inc.setStyle("-fx-background-color: black; -fx-border-color: white");
        t1dec.setTextFill(Color.WHITE);;
        t1inc.setTextFill(Color.WHITE);
        trait1.getChildren().add(t1dec);
        trait1.getChildren().add(t1pb);
        trait1.getChildren().add(t1inc);
        t1dec.setOnAction((ActionEvent e) -> {
            skillPoints++;
            t1val--;
            if (t1val < 0) {
                t1val = 0;
                skillPoints--;
            }
            t1.setText("Pilot: " + t1val);
            t1pb.setProgress(t1val / 16.0);
            remain.setText("Skill Points Remaining: " + skillPoints);

        });
        t1inc.setOnAction((ActionEvent e) -> {
            skillPoints--;
            t1val++;
            if (skillPoints < 0) {
                skillPoints = 0;
                t1val--;
            }
            if (t1val > 16) {
                t1val = 16;
                skillPoints--;
            }
            t1.setText("Pilot: " + t1val);
            t1pb.setProgress(t1val / 16.0);
            remain.setText("Skill Points Remaining: " + skillPoints);
        });

        //Progress bar 2
        Button t2dec = new Button("<");
        t2dec.setStyle("-fx-background-color: black; -fx-border-color: white");
        ProgressBar t2pb = new ProgressBar(0);
        Button t2inc = new Button(">");
        t2inc.setStyle("-fx-background-color: black; -fx-border-color: white");
        t2dec.setTextFill(Color.WHITE);
        t2inc.setTextFill(Color.WHITE);
        trait2.getChildren().add(t2dec);
        trait2.getChildren().add(t2pb);
        trait2.getChildren().add(t2inc);
        t2dec.setOnAction((ActionEvent e) -> {
            skillPoints++;
            t2val--;
            if (t2val < 0) {
                t2val = 0;
                skillPoints--;
            }
            t2.setText("Fighter: " + t2val);
            t2pb.setProgress(t2val / 16.0);
            remain.setText("Skill Points Remaining: " + skillPoints);

        });
        t2inc.setOnAction((ActionEvent e) -> {
            skillPoints--;
            t2val++;
            if (skillPoints < 0) {
                skillPoints = 0;
                t2val--;
            }
            if (t2val > 16) {
                t2val = 16;
                skillPoints--;
            }
            t2.setText("Fighter: " + t2val);
            t2pb.setProgress(t2val / 16.0);
            remain.setText("Skill Points Remaining: " + skillPoints);
        });

        //Progress Bar 3
        Button t3dec = new Button("<");
        t3dec.setStyle("-fx-background-color: black; -fx-border-color: white");
        ProgressBar t3pb = new ProgressBar(0);
        Button t3inc = new Button(">");
        t3inc.setStyle("-fx-background-color: black; -fx-border-color: white");
        t3dec.setTextFill(Color.WHITE);
        t3inc.setTextFill(Color.WHITE);
        trait3.getChildren().add(t3dec);
        trait3.getChildren().add(t3pb);
        trait3.getChildren().add(t3inc);
        t3dec.setOnAction((ActionEvent e) -> {
            skillPoints++;
            t3val--;
            if (t3val < 0) {
                t3val = 0;
                skillPoints--;
            }
            t3.setText("Merchant: " + t3val);
            t3pb.setProgress(t3val / 16.0);
            remain.setText("Skill Points Remaining: " + skillPoints);

        });
        t3inc.setOnAction((ActionEvent e) -> {
            skillPoints--;
            t3val++;
            if (skillPoints < 0) {
                skillPoints = 0;
                t3val--;
            }
            if (t3val > 16) {
                t3val = 16;
                skillPoints--;
            }
            t3.setText("Merchant: " + t3val);
            t3pb.setProgress(t3val / 16.0);
            remain.setText("Skill Points Remaining: " + skillPoints);
        });

        Button t4dec = new Button("<");
        t4dec.setStyle("-fx-background-color: black; -fx-border-color: white");
        ProgressBar t4pb = new ProgressBar(0);
        Button t4inc = new Button(">");
        t4inc.setStyle("-fx-background-color: black; -fx-border-color: white");
        t4dec.setTextFill(Color.WHITE);
        t4inc.setTextFill(Color.WHITE);
        trait4.getChildren().add(t4dec);
        trait4.getChildren().add(t4pb);
        trait4.getChildren().add(t4inc);
        t4dec.setOnAction((ActionEvent e) -> {
            skillPoints++;
            t4val--;
            if (t4val < 0) {
                t4val = 0;
                skillPoints--;
            }
            t4.setText("Engineer " + t4val);
            t4pb.setProgress(t4val / 16.0);
            remain.setText("Skill Points Remaining: " + skillPoints);

        });
        t4inc.setOnAction((ActionEvent e) -> {
            skillPoints--;
            t4val++;
            if (skillPoints < 0) {
                skillPoints = 0;
                t4val--;
            }
            if (t4val > 16) {
                t4val = 16;
                skillPoints--;
            }
            t4.setText("Engineer: " + t4val);
            t4pb.setProgress(t4val / 16.0);
            remain.setText("Skill Points Remaining: " + skillPoints);
        });
        //CHARACTER TRAIT ALLOCATOR ENDS




    }
    //START METHOD FOR SPACE TRADER APP
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Scene 1: Welcome Screen
        BorderPane root = new BorderPane();
        scene1 = new Scene(root, 800, 800);
        scene1.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
        scene1.getStylesheets().add("https://fonts.googleapis.com/css?family=Montserrat&display=swap\" rel=\"stylesheet");

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

        // START GAME BUTTON
        Button startButton = new Button("Start game!");
        BackgroundImage myBI = new BackgroundImage(new Image("file:galaxy.jpg", 800, 800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setStyle("-fx-border-color: lightcoral; -fx-border-width: 10px");
        root.setBackground(new Background(myBI));
        startButton.setAlignment(Pos.BASELINE_CENTER);
        startButton.setTextFill(Color.WHITE);
        startButton.setStyle("-fx-background-color: black; -fx-font-size: 40px; -fx-font-family: 'Press Start 2P', cursive;");

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
        backToHome.setStyle("-fx-background-color: black; -fx-font-size: 20px; -fx-font-family: 'Press Start 2P', cursive;");
        backToHome.setAlignment(Pos.BASELINE_LEFT);

        //CHARACTER CONFIGURATION TITLE
        Text charConfig = new Text("CHARACTER\nCONFIGURATION");
        charConfig.setFill(Color.INDIANRED);
        charConfig.setStyle("-fx-background-color: white; -fx-font-size: 50px; -fx-font-color: white; -fx-font-family: 'Press Start 2P', cursive; -fx-set-padding-left: 70px;");
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
        TextField characterField = new TextField("type name, press ENTER");
        characterField.setPrefWidth(400);
        characterField.setMaxWidth(300);
        HBox nameBox = new HBox();
        nameBox.setSpacing(10);
        nameBox.getChildren().add(characterField);
        Button enter = new Button("ENTER");
        nameBox.getChildren().add(enter);
        nameBox.setAlignment(Pos.TOP_CENTER);

        //INSTANTIATE NEW CHARACTER WHEN USER TYPES NAME IN CHARACTER TEXT FIELD
        Character character = new Character();
        enter.setOnMouseClicked((mouseEvent -> {
            String characterName = new String(characterField.getText());
            if (characterName.length() == 0) {
                Alert a = new Alert(AlertType.ERROR, "Character name cannot be" +
                        " blank. Please try again!");
                a.show();
            } else if (characterName.length() < 3) {
                Alert a = new Alert(AlertType.ERROR, "'" + characterName +
                        "' is too short. Character name must be at least" +
                        " 3 characters. Please try again!");
                a.show();
            } else {
                character.setName(characterName);
                Alert a = new Alert(AlertType.CONFIRMATION, "Welcome to" +
                        " Space Trader, " + character.getName() + "!");
                a.show();
            }
        }));


        //CONTINUE TO SCENE 3 BUTTON
        Button next = new Button("CONTINUE");
        next.setAlignment(Pos.CENTER_RIGHT);
        next.setTextFill(Color.WHITESMOKE);
        next.setStyle("-fx-background-color: black; -fx-font-size: 20px; -fx-font-family: 'Press Start 2P', cursive;");

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
        format();
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

        // SCENE 3 BACKING STRUCTURE SET UP
        VBox vb3 = new VBox(20.0);
        scene3 = new Scene(vb3, 800, 800);
        scene3.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
        vb3.setStyle("-fx-border-color: lightcoral; -fx-border-width: 10px");
        vb3.setBackground(new Background(myBI));


        //BACK TO SCENE 2 BUTTON
        Button backToScene2 = new Button("Back to Character\nConfiguration");
        backToScene2.setTextFill(Color.WHITE);
        backToScene2.setStyle("-fx-background-color: black; -fx-font-size: 20px; -fx-font-family: 'Press Start 2P', cursive;");
        HBox BT2 = new HBox();
        BT2.getChildren().add(backToScene2);
        BT2.setAlignment(Pos.BASELINE_LEFT);

        //PROCEED TO SCENE 3 BUTTON
        next.setOnMouseClicked((mouseEvent -> {
            character.setCredits(startingCredits);
            character.setSkillPoints(skillPoints);
            character.setTrait1Val(t1val);
            character.setTrait2Val(t2val);
            character.setTrait3Val(t3val);
            character.setTrait4Val(t4val);
            // ADDING CHARACTER SHEET SCREEN TEXT NODES
            Text yourCharacter = new Text("WELCOME,\n" + character.getName());
            yourCharacter.setFill(Color.INDIANRED);
            yourCharacter.setStyle("-fx-background-color: black; -fx-font-size: 60px; -fx-font-family: 'Press Start 2P', cursive;");

            Text yourNameIs = new Text("Your name is: " + character.getName());
            yourNameIs.setFill(Color.WHITE);
            yourNameIs.setStyle("-fx-font-size: 20px; -fx-background-color: purple; -fx-font-family: 'Press Start 2P', cursive;");

            Text yourTraits = new Text("Your points for Pilot: " + character.getTrait1Val()
                    + "\nYour points for Fighter: " + character.getTrait2Val()
                    + "\nYour points for Merchant: " + character.getTrait3Val()
                    + "\nYour points for Engineer: " + character.getTrait4Val());
            yourTraits.setFill(Color.WHITE);
            yourTraits.setStyle("-fx-font-size: 20px; -fx-background-color: purple; -fx-font-family: 'Press Start 2P', cursive;");

            Text yourDiff = new Text("Based on your difficulty level, you\nhave " + character.getCredits() + " credits");
            yourDiff.setFill(Color.WHITE);
            yourDiff.setStyle("-fx-font-size: 20px; -fx-background-color: purple; -fx-font-family: 'Press Start 2P', cursive;");
            vb3.getChildren().addAll(yourCharacter, BT2, yourNameIs, yourTraits, yourDiff);
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


    public static void main(String[] args) {
        launch(args);
    }
}