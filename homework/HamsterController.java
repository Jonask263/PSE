package de.unistuttgart.iste.sqa.pse.sheet03.homework;

import de.hamstersimulator.objectsfirst.external.model.Hamster;

/**
 *
 * A control unit to control hamsters.
 *
 * A HamsterController knows some behavioural patterns for hamsters and makes
 * given hamsters act according to those patterns.
 *
 * @author Jonas Kaluza (3740969)
 * @author Taha Darende (3724493)
 * @author Sarah Stieß
 *
 *
 */
public class HamsterController {

	/*@
	@ requires hamster != null;
	@ ensures !hamster.grainAvailable();
	@*/
	/**
	 * Pick all grains on the hamster's tile.
	 *
	 * @param hamster The hamster that picks the grains.
	 */
	void pickAllGrains(Hamster hamster) {
		hamster.write("Executing pickAllGrains:");
		Integer counter = 0;
		while (hamster.grainAvailable()) {
			hamster.pickGrain();
			counter++;
		}
		hamster.write(String.format("%d available grains on my Tile. I picked all of them!", counter));
	}

	/*@
	@ requires hamster != null;
	@ ensures hamster.mouthEmpty();
	@*/
	/**
	 * Pick all grains on the hamster's tile.
	 *
	 * @param hamster The hamster that picks the grains.
	 */
	void putAllGrains(Hamster hamster) {
		hamster.write("Executing putAllGrains:");
		Integer counter = 0;
		while (!hamster.mouthEmpty()) {
			hamster.putGrain();
			counter++;
		}
		hamster.write(String.format("I had %d grains in my mouth. I put all of them on my Tile!", counter));
	}

	// TODO replace this comment with JavaDoc
	//


	/**
	 * Hamster runs in a semicircle
	 *
	 * @param hamster The hamster that runs in a semicircle
	 */
	void runSemicircle(Hamster hamster) {
		hamster.write("Executing runHalfCircle:");
		hamster.turnLeft();
		hamster.move();
		hamster.turnLeft();
		hamster.write("I ran a half circle!");
	}

	/**
	 * Hamster picks up all grains on its tile and moves forward
	 *
	 * @param hamster The hamster that picks up the grains and moves
	 */
	void pickAllGrainsInFront(Hamster hamster) {
		hamster.write("Executing pickAllGrainsInFront:");
		while (hamster.frontIsClear()) {
			pickAllGrains(hamster);
			hamster.move();
		}
		hamster.write("I picked all grains, on the tile behind me!");
	}

	/**
	 * Hamster turns left a set amount of times
	 *
	 * @param hamster The hamster that turns left
	 * @param turns The amount of turns the hamster executes
	 */

	void turnITimes(Hamster hamster, Integer turns) {
		hamster.write("Executing turnXTimes:");
		for (Integer i = 0; i < turns; i++) {
			hamster.turnLeft();
		}
		hamster.write(String.format("I turned %d times!", turns));
	}

	/**
	 * Hamster moves forward a set amount of times
	 *
	 * @param hamster The hamster that moves forward
	 * @param steps The amount of steps the hamster is supposed to move
	 */

	void moveISteps(Hamster hamster, Integer steps) {
		hamster.write("Executing moveXSteps:");
		Integer counter = 0;
		for (; counter < steps && hamster.frontIsClear(); counter++) {
			hamster.move();
		}
		hamster.write(String.format("I moved %d out of %d steps!", counter, steps));
	}
}