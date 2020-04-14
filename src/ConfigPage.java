package src;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


public class ConfigPage {

    public ConfigPage(Stage primaryStage, Player p1, MediaPlayer player) {

        Scene scene2;
        HBox back = new HBox();


        BackgroundImage myBI = new BackgroundImage(new Image("galaxy.jpg", 800,
                800, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.CORAL);
        shadow.setWidth(1.5);

        //Format the backing hbox
        back.setAlignment(Pos.CENTER);

        //Make the progress bars and accompanying text here so can use them in difficulty buttons
        ProgressBar t1pb = new ProgressBar(0);
        Text t1 = new Text("Pilot: " + p1.getPilotSkill());
        ProgressBar t2pb = new ProgressBar(0);
        Text t2 = new Text("Fighter: " + p1.getFighterSkill());
        ProgressBar t3pb = new ProgressBar(0);
        Text t3 = new Text("Merchant: " + p1.getMerchantSkill());
        ProgressBar t4pb = new ProgressBar(0);
        Text t4 = new Text("Engineer: " + p1.getEngineerSkill());


        //Create a new vbox for left side of screen and add box
        // for name, radio button for difficulty.
        VBox left = new VBox(10);
        back.getChildren().add(left);
        left.setAlignment(Pos.BOTTOM_CENTER);
        left.setPadding(new Insets(20, 50, 20, 20));
        left.setSpacing(20);

        //Create right VBox for right side of screen
        VBox right = new VBox(10);
        right.setPrefWidth(400);
        back.getChildren().add(right);
        right.setAlignment(Pos.TOP_RIGHT);
        right.setPadding(new Insets(20, 50, 20, 20));
        left.setSpacing(20);

        //Add text for skill points remaining
        Text remain = new Text("Skill Points Remaining: " + p1.getSkillPoints());
        remain.setFill(Color.WHITE);
        remain.setStyle("-fx-font-size: 10px; -fx-font-family: 'Press Start 2P', cursive;");
        right.getChildren().add(remain);

        //Choose difficulty
        Text diff = new Text("Choose your difficulty \n level below: ");
        diff.setTextAlignment(TextAlignment.CENTER);
        diff.setLineSpacing(4);
        diff.setStyle("-fx-font-size: 10px; -fx-font-family: 'Press Start 2P', cursive;");
        diff.setFill(Color.WHITE);

        left.getChildren().add(diff);
        left.setAlignment(Pos.TOP_CENTER);

        //Creating radio button for difficulty and adding to vbox
        ToggleGroup difficulty = new ToggleGroup();
        RadioButton easy = new RadioButton("Easy");
        easy.setTextFill(Color.WHITE);
        easy.setStyle("-fx-font-size: 10px; -fx-font-family: 'Press Start 2P', cursive;");
        RadioButton medium = new RadioButton("Medium");
        medium.setTextFill(Color.WHITE);
        medium.setStyle("-fx-font-size: 10px; -fx-font-family: 'Press Start 2P', cursive;");
        RadioButton hard = new RadioButton("Hard");
        hard.setTextFill(Color.WHITE);
        hard.setStyle("-fx-font-size: 10px; -fx-font-family: 'Press Start 2P', cursive;");


        //Adding radio buttons to toggle group
        easy.setToggleGroup(difficulty);
        medium.setToggleGroup(difficulty);
        hard.setToggleGroup(difficulty);

        //EVENT HANDLER FOR EASY BUTTON
        easy.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(16);
            p1.setCredits(1000);
            p1.setDifficulty("Easy");
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());
            p1.setPilotSkill(0);
            p1.setFighterSkill(0);
            p1.setMerchantSkill(0);
            p1.setEngineerSkill(0);
            t1.setText("Pilot: " + p1.getPilotSkill());
            t2.setText("Fighter: " + p1.getFighterSkill());
            t3.setText("Merchant: " + p1.getMerchantSkill());
            t4.setText("Engineer: " + p1.getEngineerSkill());
            t1pb.setProgress(p1.getPilotSkill() / 8.0);
            t2pb.setProgress(p1.getFighterSkill() / 8.0);
            t3pb.setProgress(p1.getMerchantSkill() / 8.0);
            t4pb.setProgress(p1.getEngineerSkill() / 8.0);


        });
        //event handler for medium button
        medium.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(12);
            p1.setCredits(500);
            p1.setDifficulty("Medium");
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());
            p1.setPilotSkill(0);
            p1.setFighterSkill(0);
            p1.setMerchantSkill(0);
            p1.setEngineerSkill(0);
            t1.setText("Pilot: " + p1.getPilotSkill());
            t2.setText("Fighter: " + p1.getFighterSkill());
            t3.setText("Merchant: " + p1.getMerchantSkill());
            t4.setText("Engineer: " + p1.getEngineerSkill());
            t1pb.setProgress(p1.getPilotSkill() / 8.0);
            t2pb.setProgress(p1.getFighterSkill() / 8.0);
            t3pb.setProgress(p1.getMerchantSkill() / 8.0);
            t4pb.setProgress(p1.getEngineerSkill() / 8.0);

        });
        //event handler for hard button
        hard.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(8);
            p1.setCredits(100);
            p1.setDifficulty("Hard");
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());
            p1.setPilotSkill(0);
            p1.setFighterSkill(0);
            p1.setMerchantSkill(0);
            p1.setEngineerSkill(0);
            t1.setText("Pilot: " + p1.getPilotSkill());
            t2.setText("Fighter: " + p1.getFighterSkill());
            t3.setText("Merchant: " + p1.getMerchantSkill());
            t4.setText("Engineer: " + p1.getEngineerSkill());
            t1pb.setProgress(p1.getPilotSkill() / 8.0);
            t2pb.setProgress(p1.getFighterSkill() / 8.0);
            t3pb.setProgress(p1.getMerchantSkill() / 8.0);
            t4pb.setProgress(p1.getEngineerSkill() / 8.0);

        });
        //Adding radio buttons to vbox
        left.getChildren().add(easy);
        left.getChildren().add(medium);
        left.getChildren().add(hard);


        //CHARACTER TRAIT SELECTOR BEGINS
        //Create area where traits are selected (Create 4 hboxes to house each of the four traits)
        HBox trait1 = new HBox(5);
        trait1.setAlignment(Pos.CENTER_RIGHT);
        HBox trait2 = new HBox(5);
        trait2.setAlignment(Pos.CENTER_RIGHT);
        HBox trait3 = new HBox(5);
        trait3.setAlignment(Pos.CENTER_RIGHT);
        HBox trait4 = new HBox(5);
        trait4.setAlignment(Pos.CENTER_RIGHT);

        //Add each trait hbox to the right vbox
        right.getChildren().add(trait1);
        right.getChildren().add(trait2);
        right.getChildren().add(trait3);
        right.getChildren().add(trait4);

        //Edit each of the trait hboxs to have trait and then bar to
        // select amount of trait wanted
        trait1.getChildren().add(t1);
        t1.setFill(Color.WHITE);
        t1.setStyle("-fx-font-size: 10px; -fx-font-family: 'Press Start 2P', cursive;");
        t2.setFill(Color.WHITE);
        t2.setStyle("-fx-font-size: 10px; -fx-font-family: 'Press Start 2P', cursive;");
        trait2.getChildren().add(t2);
        trait3.getChildren().add(t3);
        t3.setFill(Color.WHITE);
        t3.setStyle("-fx-font-size: 10px; -fx-font-family: 'Press Start 2P', cursive;");
        trait4.getChildren().add(t4);
        t4.setFill(Color.WHITE);
        t4.setStyle("-fx-font-size: 10px; -fx-font-family: 'Press Start 2P', cursive;");

        //progress bar 1 with buttons to move
        Button t1dec = new Button("<");
        t1dec.setStyle("-fx-background-color: black;"
                + " -fx-border-color: white; -fx-font-family: 'Press Start 2P';"
                + " -fx-font-size: 10px");
        Button t1inc = new Button(">");
        t1inc.setStyle("-fx-background-color: black;"
                + " -fx-border-color: white; -fx-font-family: 'Press Start 2P';"
                + " -fx-font-size: 10px");
        t1dec.setTextFill(Color.WHITE);
        t1inc.setTextFill(Color.WHITE);
        trait1.getChildren().add(t1dec);
        trait1.getChildren().add(t1pb);
        trait1.getChildren().add(t1inc);
        t1dec.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() + 1);
            p1.setPilotSkill(p1.getPilotSkill() - 1);
            if (p1.getPilotSkill() < 0) {
                p1.setPilotSkill(0);
                p1.setSkillPoints(p1.getSkillPoints() - 1);
            }
            t1.setText("Pilot: " + p1.getPilotSkill());
            t1pb.setProgress(p1.getPilotSkill() / 8.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());

        });
        t1inc.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() - 1);
            p1.setPilotSkill(p1.getPilotSkill() + 1);
            if (p1.getSkillPoints() < 0) {
                p1.setSkillPoints(0);
                p1.setPilotSkill(p1.getPilotSkill() - 1);
            }
            if (p1.getPilotSkill() > 8) {
                p1.setPilotSkill(8);
                p1.setSkillPoints(p1.getSkillPoints() + 1);
            }
            t1.setText("Pilot: " + p1.getPilotSkill());
            t1pb.setProgress(p1.getPilotSkill() / 8.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());
        });

        //Progress bar 2
        Button t2dec = new Button("<");
        t2dec.setStyle("-fx-background-color: black;"
                + " -fx-border-color: white; -fx-font-family: 'Press Start 2P';"
                + " -fx-font-size: 10px");
        Button t2inc = new Button(">");
        t2inc.setStyle("-fx-background-color: black;"
                + " -fx-border-color: white; -fx-font-family: 'Press Start 2P';"
                + " -fx-font-size: 10px");
        t2dec.setTextFill(Color.WHITE);
        t2inc.setTextFill(Color.WHITE);
        trait2.getChildren().add(t2dec);
        trait2.getChildren().add(t2pb);
        trait2.getChildren().add(t2inc);
        t2dec.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() + 1);
            p1.setFighterSkill(p1.getFighterSkill() - 1);
            if (p1.getFighterSkill() < 0) {
                p1.setFighterSkill(0);
                p1.setSkillPoints(p1.getSkillPoints() - 1);
            }
            t2.setText("Fighter: " + p1.getFighterSkill());
            t2pb.setProgress(p1.getFighterSkill() / 8.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());

        });
        t2inc.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() - 1);
            p1.setFighterSkill(p1.getFighterSkill() + 1);
            if (p1.getSkillPoints() < 0) {
                p1.setSkillPoints(0);
                p1.setFighterSkill(p1.getFighterSkill() - 1);
            }
            if (p1.getFighterSkill() > 8) {
                p1.setFighterSkill(8);
                p1.setSkillPoints(p1.getSkillPoints() + 1);
            }
            t2.setText("Fighter: " + p1.getFighterSkill());
            t2pb.setProgress(p1.getFighterSkill() / 8.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());
        });

        //Progress Bar 3
        Button t3dec = new Button("<");
        t3dec.setStyle("-fx-font-family: 'Press Start 2P'");
        t3dec.setStyle("-fx-background-color: black;"
                + " -fx-border-color: white; -fx-font-family: 'Press Start 2P';"
                + " -fx-font-size: 10px");
        Button t3inc = new Button(">");
        t3inc.setStyle("-fx-background-color: black;"
                + " -fx-border-color: white; -fx-font-family: 'Press Start 2P';"
                + " -fx-font-size: 10px");
        t3dec.setTextFill(Color.WHITE);
        t3inc.setTextFill(Color.WHITE);
        trait3.getChildren().add(t3dec);
        trait3.getChildren().add(t3pb);
        trait3.getChildren().add(t3inc);
        t3dec.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() + 1);
            p1.setMerchantSkill(p1.getMerchantSkill() - 1);
            if (p1.getMerchantSkill() < 0) {
                p1.setMerchantSkill(0);
                p1.setSkillPoints(p1.getSkillPoints() - 1);
            }
            t3.setText("Merchant: " + p1.getMerchantSkill());
            t3pb.setProgress(p1.getMerchantSkill() / 8.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());

        });
        t3inc.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() - 1);
            p1.setMerchantSkill(p1.getMerchantSkill() + 1);
            if (p1.getSkillPoints() < 0) {
                p1.setSkillPoints(0);
                p1.setMerchantSkill(p1.getMerchantSkill() - 1);
            }
            if (p1.getMerchantSkill() > 8) {
                p1.setMerchantSkill(8);
                p1.setSkillPoints(p1.getSkillPoints() + 1);
            }
            t3.setText("Merchant: " + p1.getMerchantSkill());
            t3pb.setProgress(p1.getMerchantSkill() / 8.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());
        });

        Button t4dec = new Button("<");
        t4dec.setStyle("-fx-background-color: black;"
                + " -fx-border-color: white; -fx-font-family: 'Press Start 2P';"
                + " -fx-font-size: 10px");
        Button t4inc = new Button(">");
        t4inc.setStyle("-fx-background-color: black;"
                + " -fx-border-color: white; -fx-font-family: 'Press Start 2P';"
                + " -fx-font-size: 10px");
        t4dec.setTextFill(Color.WHITE);
        t4inc.setTextFill(Color.WHITE);
        trait4.getChildren().add(t4dec);
        trait4.getChildren().add(t4pb);
        trait4.getChildren().add(t4inc);
        t4dec.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() + 1);
            p1.setEngineerSkill(p1.getEngineerSkill() - 1);
            if (p1.getEngineerSkill() < 0) {
                p1.setEngineerSkill(0);
                p1.setSkillPoints(p1.getSkillPoints() - 1);
            }
            t4.setText("Engineer " + p1.getEngineerSkill());
            t4pb.setProgress(p1.getEngineerSkill() / 8.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());

        });
        t4inc.setOnAction((ActionEvent e) -> {
            p1.setSkillPoints(p1.getSkillPoints() - 1);
            p1.setEngineerSkill(p1.getEngineerSkill() + 1);
            if (p1.getSkillPoints() < 0) {
                p1.setSkillPoints(0);
                p1.setEngineerSkill(p1.getEngineerSkill() - 1);
            }
            if (p1.getEngineerSkill() > 8) {
                p1.setEngineerSkill(8);
                p1.setSkillPoints(p1.getSkillPoints() + 1);
            }
            t4.setText("Engineer: " + p1.getEngineerSkill());
            t4pb.setProgress(p1.getEngineerSkill() / 8.0);
            remain.setText("Skill Points Remaining: " + p1.getSkillPoints());
        });

        //CHARACTER TRAIT ALLOCATOR ENDS

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
        characterField.setPromptText("Name:");
        characterField.setStyle("-fx-font-size: 10px; -fx-font-family: 'Press Start 2P', cursive;");
        characterField.setPrefWidth(400);
        characterField.setMaxWidth(300);
        HBox nameBox = new HBox();
        nameBox.setSpacing(10);
        nameBox.getChildren().add(characterField);
        nameBox.setAlignment(Pos.TOP_CENTER);

        characterField.setOnAction(actionEvent -> {
            p1.setName(characterField.getText());
        });


        //CONTINUE TO SCENE 3 BUTTON
        Button next = new Button("Continue");
        next.setTextFill(Color.WHITESMOKE);
        next.setStyle("-fx-background-color: black; -fx-font-size: 20px;"
                + " -fx-font-family: 'Press Start 2P', cursive;");
        next.setAlignment(Pos.BASELINE_RIGHT);


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

        next.setOnMouseClicked(mouseEvent -> {
            p1.setName(characterField.getText());
            if (!p1.getName().equals("") && p1.getSkillPoints() == 0
                    && (easy.isSelected() || medium.isSelected() || hard.isSelected())) {
                player.stop();
                CharacterPage characterPage = new CharacterPage(primaryStage, p1);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "You didn't finish"
                        + " making your character!");
                DialogPane dialogPane = a.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("myDialogs.css").toExternalForm());
                dialogPane.getStyleClass().add("myDialog");
                a.show();
            }
        });

        //CHARACTER CONFIGURATION
        HBox bottomBtn = new HBox(300);
        bottomBtn.getChildren().addAll(backToHome, next);
        bottomBtn.setAlignment(Pos.BOTTOM_CENTER);

        vb2.getChildren().addAll(charConfig, nameBox, back, bottomBtn);
        VBox.setVgrow(bottomBtn, Priority.ALWAYS);
        vb2.setStyle("-fx-border-color: lightcoral; -fx-border-width: 10px");
        vb2.setBackground(new Background(myBI));
        scene2 = new Scene(vb2, 800, 800);

        // BACK TO HOME BUTTON TAKES USER TO SCENE 1
        backToHome.setOnMouseClicked((mouseEvent -> {
            WelcomePage welcomePage = new WelcomePage(primaryStage);
        }));

        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(scene2);
        primaryStage.show();

    }
}
