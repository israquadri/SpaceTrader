package src;

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

    public void sellGoods(Region region, Item item, SpaceShip spaceShip, Player player) {
        spaceShip.removeFromInventory(item);
        player.setCredits(player.getCredits() + (int)item.getSellPrice());
    }

    public void buyGoods(Region region, Item item, SpaceShip spaceShip, Player player) throws IllegalAccessException {
        if (player.getSpaceShip().getCargoCapacity() > 0) {
            if (item.getQuantity() > 0) {
                item.setQuantity(item.getQuantity() - 1);
                player.getSpaceShip().addToInventory(item);
                player.setCredits(player.getCredits() - (int) item.getBuyPrice());
            } else if (item.getQuantity() == 0) {
                throw new IllegalAccessException("item is sold out");
            }
        } else {
            throw new IllegalStateException("your cargo capacity is full");
        }
    }

}