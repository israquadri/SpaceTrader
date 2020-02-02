package src;

public class Character {
    private String name;
    private int skillPoints;
    private int credits;
    private int trait1val;
    private int trait2val;
    private int trait3val;
    private int trait4val;

    //Getter and Setter-ville
    public Character(String name) {
        this.name = name;
    }

    public String getName(Character c) {
        return c.name;
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
