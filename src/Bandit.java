package src;

public class Bandit {

	private int credits;
	private int shipHealth;
	private int demands; // this is the number of credits they are demanding from the player

	public Bandit(int demands) {
		this.demands = demands;
	}

	public int getCredits() {
		return credits;
	}

	public int getShipHealth() {
		return shipHealth;
	}

	public int getDemands() {
		return demands;
	}

	public void setShipHealth(int shipHealth) {
		this.shipHealth = shipHealth;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public void setDemands(int demands) {
		this.demands = demands;
	}
}
