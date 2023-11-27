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

	/*@
	  @requires paule.isInitialized;
	  @requires paule.getLocation() == locationEntry;
	  @requires at least 1 grain on exit && no other grains on tiles
	  @requires maze has to be "simply connected"
	  @ensures paule.getLocation() == locationExit;
	  @ensures sonst nichts verändert
	  @*/
	/**
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
	/*@
	  @requires paule.isInitialized;
	  @requires thisIsInitalized ???
	  @requires !paule.frontIsClear();
	  @requires !paule.isCaged();
	  @ensures paule auf angrenzendem tile
	  @ensures paule's looking direction der des tiles auf dem er ist // oder nicht weil nachbedingung von move?? sonst alles von move kopieren
	  @ensures sonst nichts verändert
	  @*/
	/**
	 *Up to three times paule turns right and moves if possible.
	 * If paule moved after turning right he stops turning
	 * paule moves forward after turning three times
	 */
	void findPath() {
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
	 *Changes paule's looking direction 90 degrees clock wise
	 */
	public void turnRight() {
		/*@
		  @loop_invariant Paule turned left i times;
		  @decreasing 3-i;
		  @*/
		for (int i = 0; i < 3; i++) {
			paule.turnLeft();
		}
	}
}

