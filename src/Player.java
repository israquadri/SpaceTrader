package src;

public class Player {
    private String name;
    private int skillPoints;
    private int credits;
    private int trait1val;
    private int trait2val;
    private int trait3val;
    private int trait4val;
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

    public SpaceShip getSpaceShip() {
        return spaceShip;
    }

    public void setSpaceShip(SpaceShip spaceShip) {
        this.spaceShip = spaceShip;
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
        spaceShip.getInventory().remove(item);
        player.setCredits(player.getCredits() + (int)item.getSellPrice());
    }

    public void buyGoods(Region region, Item item, SpaceShip spaceShip, Player player) {
        if (player.getSpaceShip().getInventory().size() < player.getSpaceShip().getCargoCapacity()) {
            if (item.getName().equals("fuel")) {
                spaceShip.setFuel(spaceShip.getFuel() + 20);
            } else {
                if (item.getQuantity() != 0) {
                    player.getSpaceShip().getInventory().add(item);
                    player.setCredits(player.getCredits() - (int) item.getBuyPrice());
                    item.setQuantity(item.getQuantity() - 1);
                } else if (item.getQuantity() == 0) {
                    //throw exception
                }
            }
        }
    }

}