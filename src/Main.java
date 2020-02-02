package src;
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

import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicReference;

public class Main extends Application {

    private Scene scene1, scene2, scene3;

    //Character Trait Selector setup

    HBox back = new HBox();
    int skillPoints = 16;
    int credits = 1000;
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

        //Create right VBox for right side of screen
        VBox right = new VBox(10);
        back.getChildren().add(right);
        right.setAlignment(Pos.TOP_CENTER);

        //Add text for skill points remaining
        Text remain = new Text("Skill Points Remaining: " + skillPoints);
        remain.setFill(Color.WHITE);
        remain.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
        right.getChildren().add(remain);

        //Choose difficulty
        Text diff = new Text("Choose your difficulty level below: ");
        HBox diffHBox = new HBox();
        diffHBox.getChildren().add(diff);
        diffHBox.setAlignment(Pos.BOTTOM_CENTER);

        //Creating radio button for difficulty and adding to vbox
        ToggleGroup difficulty = new ToggleGroup();
        RadioButton easy = new RadioButton("Easy");
        easy.setTextFill(Color.WHITE);
        easy.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
        RadioButton medium = new RadioButton("Medium");
        medium.setTextFill(Color.WHITE);
        medium.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
        RadioButton hard = new RadioButton("Hard");
        hard.setTextFill(Color.WHITE);
        hard.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
        //Adding radiobuttons to togglegroup
        easy.setToggleGroup(difficulty);
        medium.setToggleGroup(difficulty);
        hard.setToggleGroup(difficulty);
        //Event handler for easy button
        easy.setOnAction((ActionEvent e) -> {
            skillPoints = 16;
            credits = 1000;
            remain.setText("Skill Points Remaining: " + skillPoints);


        });
        //event handler for medium button
        medium.setOnAction((ActionEvent e) -> {
            skillPoints = 12;
            credits = 500;
            remain.setText("Skill Points Remaining: " + skillPoints);

        });
        //event handler for hard button
        hard.setOnAction((ActionEvent e) -> {
            skillPoints = 8;
            credits = 100;
            remain.setText("Skill Points Remaining: " + skillPoints);

        });
        //Adding radio buttons to vbox
        left.getChildren().add(easy);
        left.getChildren().add(medium);
        left.getChildren().add(hard);


        //CHARACTER TRAIT SELECTOR BEGINS
        //Create area where traits are selected (Create 4 hboxes to house each of the four traits)
        HBox trait1 = new HBox(2);
        HBox trait2 = new HBox(2);
        HBox trait3 = new HBox(2);
        HBox trait4 = new HBox(2);

        //Add each trait hbox to the right vbox
        right.getChildren().add(trait1);
        right.getChildren().add(trait2);
        right.getChildren().add(trait3);
        right.getChildren().add(trait4);

        //Edit each of the trait hboxs to have trait and then bar to select amount of trait wanted
        Text t1 = new Text("Trait 1: " + t1val);
        trait1.getChildren().add(t1);
        t1.setFill(Color.WHITE);
        t1.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
        Text t2 = new Text("Trait 2: " + t2val);
        t2.setFill(Color.WHITE);
        t2.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
        trait2.getChildren().add(t2);
        Text t3 = new Text("Trait 3: " + t3val);
        trait3.getChildren().add(t3);
        t3.setFill(Color.WHITE);
        t3.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
        Text t4 = new Text("Trait 4: " + t4val);
        trait4.getChildren().add(t4);
        t4.setFill(Color.WHITE);
        t4.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");

        //progress bar 1 with buttons to move
        Button t1dec = new Button("<");
        ProgressBar t1pb = new ProgressBar(0);
        Button t1inc = new Button(">");
        t1dec.setTextFill(Color.WHITE);
        t1dec.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
        t1inc.setTextFill(Color.WHITE);
        t1inc.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
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
            t1.setText("Trait 1: " + t1val);
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
            t1.setText("Trait 1: " + t1val);
            t1pb.setProgress(t1val / 16.0);
            remain.setText("Skill Points Remaining: " + skillPoints);
        });

        //Progress bar 2
        Button t2dec = new Button("<");
        ProgressBar t2pb = new ProgressBar(0);
        Button t2inc = new Button(">");
        t2dec.setTextFill(Color.WHITE);
        t2dec.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
        t2inc.setTextFill(Color.WHITE);
        t2inc.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
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
            t2.setText("Trait 2: " + t2val);
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
            t2.setText("Trait 2: " + t2val);
            t2pb.setProgress(t2val / 16.0);
            remain.setText("Skill Points Remaining: " + skillPoints);
        });

        //Progress Bar 3
        Button t3dec = new Button("<");
        ProgressBar t3pb = new ProgressBar(0);
        Button t3inc = new Button(">");
        t3dec.setTextFill(Color.WHITE);
        t3dec.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
        t3inc.setTextFill(Color.WHITE);
        t3inc.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
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
            t3.setText("Trait 3: " + t3val);
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
            t3.setText("Trait 3: " + t3val);
            t3pb.setProgress(t3val / 16.0);
            remain.setText("Skill Points Remaining: " + skillPoints);
        });

        Button t4dec = new Button("<");
        ProgressBar t4pb = new ProgressBar(0);
        Button t4inc = new Button(">");
        t4dec.setTextFill(Color.WHITE);
        t4dec.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
        t4inc.setTextFill(Color.WHITE);
        t4inc.setStyle("-fx-font-size: 20px; -fx-font-family: Montserrat', sans-serif;");
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
            t4.setText("Trait 4: " + t4val);
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
            t4.setText("Trait 4: " + t4val);
            t4pb.setProgress(t4val / 16.0);
            remain.setText("Skill Points Remaining: " + skillPoints);
        });
        //CHARACTER TRAIT ALLOCATOR ENDS




    }

    /**
     * This inner class is for the Character
     */
    class Character {
        private String name;
        private String difficulty;
        private int Trait1SkillLevel;
        private int Trait2SkillLevel;
        private int Trait3SkillLevel;
        private int Trait4SkillLevel;

        public Character() {

        }

        public void setName(String name) {
            this.name = name;
        }

    }

    Character character = new Character();


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Scene 1: Welcome Screen
        BorderPane root = new BorderPane();
        scene1 = new Scene(root, 800, 800);
        scene1.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
        scene1.getStylesheets().add("https://fonts.googleapis.com/css?family=Montserrat&display=swap\" rel=\"stylesheet");

        Character character = new Character();

        // space trader drop shadow
        DropShadow ds = new DropShadow();
        ds.setOffsetY(7.0f);
        ds.setColor(Color.GRAY);

        //Space Trader Game Title
        VBox vbox = new VBox();
        Text spaceTrader = new Text(100.0, 50.0, "Space Trader");
        vbox.getChildren().addAll(spaceTrader);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(100, 50, 50, 50));


        spaceTrader.setFill(Color.INDIANRED);
        spaceTrader.setEffect(ds);
        spaceTrader.setCache(true);
        //spaceTrader.setX(10.0f);
        //spaceTrader.setY(260.0f);
        spaceTrader.setStyle("-fx-font-size: 60px; -fx-font-family: 'Press Start 2P', cursive;");

        //instantiating a new character
        //Character character = new Character(null);

        //animation
      /*  FadeTransition ft = new FadeTransition(Duration.millis(3000.0));
        ft.setFromValue(1.0);
        ft.setToValue(0.3);
        ft.setCycleCount(4);
        ft.setAutoReverse(true);
        ft.play();*/


        // rocket image
        Image image = new Image("file:rocket.jpg");
        ImageView iv = new ImageView();
        iv.setImage(image);
        iv.setFitHeight(350);
        iv.setFitWidth(350);
        HBox rocketHBox = new HBox();
        rocketHBox.getChildren().add(iv);
        rocketHBox.setAlignment(Pos.BOTTOM_CENTER);
        rocketHBox.setPadding(new Insets(10, 10, 30, 10));

        //start game button
        Button startButton = new Button("Start game!");
        BackgroundImage myBI = new BackgroundImage(new Image("file:galaxy.jpg", 800, 800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setStyle("-fx-border-color: lightcoral; -fx-border-width: 10px");
        root.setBackground(new Background(myBI));
        startButton.setAlignment(Pos.BASELINE_CENTER);
        startButton.setTextFill(Color.WHITE);
        startButton.setStyle("-fx-background-color: black; -fx-font-size: 40px; -fx-font-family: 'Press Start 2P', cursive;");

        //hover effect on start button
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

        //adding boxes to scene1
        root.setCenter(startButton);
        root.setTop(vbox);
        root.setBottom(rocketHBox);
        primaryStage.setTitle("Space Trader");
        primaryStage.setScene(scene1);
        primaryStage.show();

        //stuff for setting up scene 2
        //BorderPane bp2 = new BorderPane();
        VBox vb2 = new VBox(40.0);
        vb2.setPadding(new Insets(50.0, 10.0, 20.0, 10.0));

        //back to home button
        Button backToHome = new Button("Back to Home");
        backToHome.setTextFill(Color.WHITE);
        backToHome.setStyle("-fx-background-color: black; -fx-font-size: 20px; -fx-font-family: 'Press Start 2P', cursive;");
        backToHome.setAlignment(Pos.BASELINE_LEFT);
        Text charConfig = new Text("CHARACTER\nCONFIGURATION");
        charConfig.setFill(Color.INDIANRED);
        charConfig.setStyle("-fx-background-color: white; -fx-font-size: 50px; -fx-font-color: white; -fx-font-family: 'Press Start 2P', cursive; -fx-set-padding-left: 70px;");
        HBox nameHBox = new HBox(charConfig);
        nameHBox.setPadding(new Insets(90.0, 50.0, 50.0, 50.0));
        nameHBox.setAlignment(Pos.TOP_CENTER);

        back.setPadding(new Insets(50, 50, 50, 50));

        //backToHome button hover effect
        backToHome.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        backToHome.setEffect(shadow);
                    }
                });
        //removing shadow when mouse cursor is off
        backToHome.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        backToHome.setEffect(null);
                    }
                });


        //character field to enter name and press 'ENTER'
        TextField characterField = new TextField("type name, press ENTER");
        characterField.setPrefWidth(400);
        characterField.setMaxWidth(300);
        HBox nameBox = new HBox();
        nameBox.setSpacing(10);
        nameBox.getChildren().add(characterField);
        Button enter = new Button("ENTER");
        nameBox.getChildren().add(enter);
        nameBox.setAlignment(Pos.TOP_CENTER);

        enter.setOnAction(actionEvent -> {
            String characterName = characterField.getText();
        });

        //Continue to scene 3 button
        Button next = new Button("Continue");
        //help why isn't this on the right
        next.setAlignment(Pos.CENTER_RIGHT);
        next.setTextFill(Color.WHITESMOKE);
        next.setStyle("-fx-background-color: black; -fx-font-size: 20px; -fx-font-family: 'Press Start 2P', cursive;");

        next.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        next.setEffect(shadow);
                    }
                });
        //removing shadow when mouse cursor is off
        next.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        next.setEffect(null);
                    }
                });

        // adding elements to scene2
        //bp2.setCenter(nameBox);
        //bp2.setTop(s2box);
        //bp2.setBottom(next);
        format();
        vb2.getChildren().addAll(charConfig, backToHome, nameBox, back, next);
        //bp2.setRight(back);
        vb2.setStyle("-fx-border-color: lightcoral; -fx-border-width: 10px");
        vb2.setBackground(new Background(myBI));
        scene2 = new Scene(vb2, 800, 800);

        // Start button taking user to next screen
        startButton.setOnMouseClicked((mouseEvent -> {
            primaryStage.setScene(scene2);
            primaryStage.setTitle("Welcome user!");
            primaryStage.show();
        }));

        backToHome.setOnMouseClicked((mouseEvent -> {
            primaryStage.setScene(scene1);
            primaryStage.setTitle("Space Trader");
            primaryStage.show();
        }));

        next.setOnMouseClicked((mouseEvent -> {
            primaryStage.setScene(scene3);
            primaryStage.setTitle("Scene 3");
            primaryStage.show();
        }));



/*        Character character = new Character();
        enter.setOnMouseClicked((mouseEvent -> {
            String characterName = new String(characterField.getText());
            if (characterName.length() == 0) {
                Alert a = new Alert(AlertType.ERROR, "Character name cannot be" +
                        " blank. Please try again!");
                a.show();
            } else if (characterName.length() < 4) {
                Alert a = new Alert(AlertType.ERROR, "'" + characterName +
                        "' is too short. Please try again!");
                a.show();
            } else {

            }
        }));*/



        //Scene 3: Character Screen

        // Backing structure setup
        VBox vb3 = new VBox(20.0);
        scene3 = new Scene(vb3, 800, 800);
        scene3.getStylesheets().add("https://fonts.googleapis.com/css?family=Press+Start+2P&display=swap");
        vb3.setStyle("-fx-border-color: lightcoral; -fx-border-width: 10px");
        vb3.setBackground(new Background(myBI));


        //back to Scene 2
        Button backToScene2 = new Button("Back to Character\nConfiguration");
        backToScene2.setTextFill(Color.WHITE);
        backToScene2.setStyle("-fx-background-color: black; -fx-font-size: 20px; -fx-font-family: 'Press Start 2P', cursive;");
        HBox BT2 = new HBox();
        BT2.getChildren().add(backToScene2);
        BT2.setAlignment(Pos.BASELINE_LEFT);

        // adding buttons and functionality
        Text yourCharacter = new Text("YOUR\nCHARACTER");
        yourCharacter.setFill(Color.INDIANRED);
        yourCharacter.setStyle("-fx-background-color: black; -fx-font-size: 60px; -fx-font-family: 'Press Start 2P', cursive;");

        Text yourNameIs = new Text("Your name is: " + character.name);
        yourNameIs.setFill(Color.WHITE);
        yourNameIs.setStyle("-fx-font-size: 20px; -fx-background-color: purple; -fx-font-family: 'Montserrat', sans-serif;");

        Text yourTraits = new Text("Your points for Trait 1: " + t1val + "\nYour points for Trait 2" + t2val + "\nYour points for Trait 3: " + t3val + "\nYour points for Trait 4: " + t4val);
        yourTraits.setFill(Color.WHITE);
        yourTraits.setStyle("-fx-font-size: 20px; -fx-background-color: purple; -fx-font-family: 'Montserrat', sans-serif;");

        Text yourDiff = new Text("Your difficulty level is: " + "To fill in later " + credits);
        yourDiff.setFill(Color.WHITE);
        yourDiff.setStyle("-fx-font-size: 20px; -fx-background-color: purple; -fx-font-family: 'Montserrat', sans-serif;");

        //adding the shadow when the mouse cursor is on
        backToScene2.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        backToScene2.setEffect(shadow);
                    }
                });
        //removing shadow when mouse cursor is off
        backToScene2.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        backToScene2.setEffect(null);
                    }
                });

        vb3.getChildren().addAll(yourCharacter, BT2, yourNameIs, yourTraits, yourDiff);

        //back to scene 2 button
        backToScene2.setOnMouseClicked((mouseEvent -> {
            primaryStage.setScene(scene2);
            primaryStage.setTitle("Welcome user!");
            primaryStage.show();
        }));
        //

    }

    //private boolean isString(TextField input, String message) {
    //
    //}


    public static void main(String[] args) {
        launch(args);
    }
}