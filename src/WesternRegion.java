package src;

import org.graalvm.compiler.hotspot.nodes.profiling.RandomSeedNode;

import java.util.Random;

public class WesternRegion extends Region {

	Random randomX = new Random();
	Random randomY = new Random();


	public WesternRegion() {
		super(0, 0, 3, "This planet is a Western themed planet");
	}

	// you will create all the scene stuff in here but show it in the main class
}
