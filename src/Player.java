package src;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;

import java.util.Random;

public class Player {
    private String name;
    private int skillPoints;
    private int credits;
    private int pilotSkill;
    private int fighterSkill;
    private int merchantSkill;
    private int engineerSkill;
    private String difficulty;
    private Region currentRegion;
    private SpaceShip spaceShip;
    private Region destination;

    //Getter and Setter-ville
    public Player() {
        this.spaceShip = new SpaceShip(50, "John Antelope", 15, 5);
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

    public int getPilotSkill() {
        return pilotSkill;
    }

    public int getMerchantSkill() {
        return merchantSkill;
    }

    public int getFighterSkill() {
        return fighterSkill;
    }

    public int getEngineerSkill() {
        return engineerSkill;
    }

    public SpaceShip getSpaceShip() {
        return spaceShip;
    }

    public void setSpaceShip(SpaceShip spaceShip) {
        this.spaceShip = spaceShip;
    }

    public void setPilotSkill(int pilotSkill) {
        this.pilotSkill = pilotSkill;
    }

    public void setFighterSkill(int fighterSkill) {
        this.fighterSkill = fighterSkill;
    }

    public void setMerchantSkill(int merchantSkill) {
        this.merchantSkill = merchantSkill;
    }

    public void setEngineerSkill(int engineerSkill) {
        this.engineerSkill = engineerSkill;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public void setCurrentRegion(Region r) {
        this.currentRegion = r;
    }

    public Region getCurrentRegion() {
        return this.currentRegion;
    }

    public Region getDestination() {
        return destination;
    }

    public void setDestination(Region destination) {
        this.destination = destination;
    }

    public void sellGoods(Region region, Item item) {
        this.spaceShip.removeFromInventory(item);
        this.setCredits(this.getCredits() + item.getSellPrice());
        region.getMarket().addItem(item);
    }

    public Alert buyGoods(Item item) {
        if (this.getCredits() <= 0) {
            this.setCredits(0);
        }
        if (this.getSpaceShip().getCargoCapacity() == 0) {
            Alert a = new Alert(Alert.AlertType.INFORMATION,
                    "Your cargo capacity is full! Trade out items to make"
                            + " space in your inventory.");
            return a;
        }
        if (item.getQuantity() == 0) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "There are no items remaining!");
            return a;
        }
        if (this.getCredits() - item.getBuyPrice() < 0) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "You do not have"
                    + " enough money to purchase this item!");
            return a;
        }
        item.setQuantity(item.getQuantity() - 1);
        this.getSpaceShip().addToInventory(item);
        this.setCredits(this.getCredits() - (int) item.getBuyPrice());
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, this.getName() + ", you just bought "
                + item.getName() + " for " + item.getBuyPrice() + ".\nNow you have "
                + this.getSpaceShip().getQuantity(item) + " " + item.getName()
                + "s in your inventory!");
        DialogPane dialogPane = a.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("myDialogs.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        return a;


    }

}