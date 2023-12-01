package de.unistuttgart.iste.sqa.pse.sheet06.homework.maze;

import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * Describe the purpose of this class here.
 *
 *  @author Jonas Kaluza (3740969)
 *  @author Taha Darende (3724493)
 * @version 26.11.2023
 */
public class AmazingPauleHamsterGame extends SimpleHamsterGame {

	/**
	 * Creates a new AmazingPauleHamsterGame.<br>
	 * Do not modify!
	 */
	public AmazingPauleHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/AmazingPauleTerritory.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}

	/**
	 * Ignore this method.<br>
	 * Put your code in passTheMaze()!
	 */
	@Override
	protected void run() {
		passTheMaze();
	}
	/**
	 * requires Paule to be initialized,the maze to be "simply connected",
	 * Paule's location to be at the entrance as well as no grains on any tiles except at least one on the Exit
	 * ensures Paule to be at the exit
	 * Makes paule find the exit of the maze
	 * As long as paule has not found the exit he tries to move left (left-hand-rule)
	 * If there's no path to his left findPath() is used
	 */
	void passTheMaze() {
		/*@
		  @loop_invariant The amount of loop iterations i equals the amount of steps paule moved
		  @decreasing amountOfStepsTillExit-i
		  @*/
		while (!paule.grainAvailable()) {
			paule.turnLeft();
			if (paule.frontIsClear()) {
				paule.move();
			} else {
			this.findPath();
			}
		}
	}
	/**
	 * requires Paule to be initialized, Paule's front to be blocked but Paule not to be caged
	 * ensures Paule found a path and therefore moved once
	 * Up to three times paule turns right and moves if possible.
	 * If paule moved after turning right he stops turning
	 * paule moves forward after turning three times
	 */
	private void findPath() {
		this.turnRight();
		if (paule.frontIsClear()) {
			paule.move();
		} else {
			this.turnRight();
			if (paule.frontIsClear()) {
				paule.move();
			} else {
				this.turnRight();
				paule.move();
				}
			}
		}
    /*@
	  @requires paule.isInitialized;
	  @ensures /old(paule.getDirection()) == Direction.NORTH ==> paule.getDirection == Direction.EAST;
	  @ensures /old(paule.getDirection()) == Direction.EAST ==> paule.getDirection == Direction.SOUTH;
	  @ensures /old(paule.getDirection()) == Direction.SOUTH ==> paule.getDirection == Direction.WEST;
	  @ensures /old(paule.getDirection()) == Direction.WEST ==> paule.getDirection == Direction.NORTH;
	  @*/
	/**
	 * Changes paule's looking direction 90 degrees clock wise
	 */
	void turnRight() {
		/*@
		  @loop_invariant Paule turned left i times;
		  @decreasing 3-i;
		  @*/
		for (int i = 0; i < 3; i++) {
			paule.turnLeft();
		}
	}
}

