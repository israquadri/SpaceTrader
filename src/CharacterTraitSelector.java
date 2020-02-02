package src;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class CharacterTraitSelector extends Application {
    //Create new HBox to act as framework for entirety of screen
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
        back.setSpacing(30);

        //Create a new vbox for left side of screen and add box for name, radio button for difficulty.
        VBox left = new VBox(10);
        back.getChildren().add(left);
        left.setAlignment(Pos.BOTTOM_CENTER);
        left.setPadding(new Insets(20, 50, 20, 20));

        //Create right VBox for right side of screen
        VBox right = new VBox(10);
        back.getChildren().add(right);
        right.setAlignment(Pos.TOP_CENTER);
        right.setPadding(new Insets(20, 50, 20, 20));
        //Add text for skill points remaining
        Text remain = new Text("Skill Points Remaining: " + skillPoints);
        right.getChildren().add(remain);

        //Create textfield for name and add to vbox
        TextField name = new TextField();
        name.setPromptText("Name:");
        name.setAlignment(Pos.BOTTOM_CENTER);
        left.getChildren().add(name);

        //Creating radio button for difficulty and adding to vbox
        ToggleGroup difficulty = new ToggleGroup();
        RadioButton easy = new RadioButton("Easy");
        RadioButton medium = new RadioButton("Medium");
        RadioButton hard = new RadioButton("Hard");
        easy.setStyle("margin: 0 10px 0 10px;");
        medium.setStyle("margin: 0 10px 0 10px;");
        hard.setStyle("margin: 0 10px 0 10px;");
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
        Text t1 = new Text("Pilot: " + t1val);
        trait1.getChildren().add(t1);
        Text t2 = new Text("Fighter: " + t2val);
        trait2.getChildren().add(t2);
        Text t3 = new Text("Merchant: " + t3val);
        trait3.getChildren().add(t3);
        Text t4 = new Text("Engineer: " + t4val);
        trait4.getChildren().add(t4);

        //progress bar 1 with buttons to move
        Button t1dec = new Button("<");
        ProgressBar t1pb = new ProgressBar(0);
        Button t1inc = new Button(">");
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

    @Override
    public void start(Stage primaryStage) {
        format();
        Scene main = new Scene(back, 500, 500);
        primaryStage.setScene(main);
        primaryStage.show();
    }
}
