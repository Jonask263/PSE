package de.unistuttgart.iste.sqa.pse.sheet06.homework.exceptions;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * A SimpleHamsterGame with exceptions
 *
 *  @author Jonas Kaluza (3740969)
 *  @author Taha Darende (3724493)
 *
 */
public class LazyHamsterGame extends SimpleHamsterGame {

	/**
	 * This constructor is used for loading a territory for the game and for displaying it.
	 * Do not modify.
	 */
	public LazyHamsterGame(final String territoryFile) {
		this.loadTerritoryFromResourceFile(territoryFile);
		this.displayInNewGameWindow();
		game.startGame();
	}
	/**
	 * Do not modify this operation.
	 */
	@Override
	protected void run() {moveMultipleSteps(5);
	}

	/**
	 * requires Paule to be initialized and his front to be clear
	 * ensures Paule either moved once or TooLazyException was thrown
	 * Paule has a 70% chance of moving forward
	 * else he does not move
	 * @throws TooLazyException When Hamster did not move
	 */
	public void tryToMove() {
		double randomValue = Math.random();
		if (randomValue > 0.3) {
			paule.move();
		} else {
			//throw new TooLazyException(); // else moveMultipleSteps does not work, remove // to test tryToMove
		}
	}
	/**
	 * requires Paule to be initialized
	 * ensures Paule moved a set amount of times
	 * makes a lazy paule move a certain amount of steps
	 * If paule can't move forward it is checked hierarchically whether
	 * he can move left, right or backwards, if so, the hamster moves.
	 * Else NoWayToGo Exception is thrown
	 * If paule is too lazy to move, he will be motivated.
	 * @throws NoWayToGoException If hamster is caged
	 * @param numberOfSteps The amount of steps the hamster should move
	 */
	public void moveMultipleSteps(int numberOfSteps) {
		/*@
		@loop_invariant Paule moved i steps
		@decreasing numberOfSteps-i;
		@*/
		for (int i = 0; i < numberOfSteps; i++) {
			Location locationPaule = paule.getLocation();
			if (paule.frontIsClear()) {
				this.tryToMove();
				if (locationPaule == paule.getLocation()) {
					paule.write("You can do it!");
					i--;
				}
			} else if (checkLeftClear()) {
				paule.turnLeft();
				this.tryToMove();
				if (locationPaule == paule.getLocation()) {
					paule.write("You can do it!");
					i--;
				}
			} else if (checkRightClear()) {
                this.turnNTimes(3);
				this.tryToMove();
				if (locationPaule == paule.getLocation()) {
					paule.write("You can do it!");
					i--;
				}
			} else if (checkBehindClear()) {
				this.turnNTimes(2);
				this.tryToMove();
				if (locationPaule == paule.getLocation()) {
					paule.write("You can do it!");
					i--;
				}
			} else {
				throw new NoWayToGoException();
			}
		}
	}
	/**
	 * requires Paule to be initialized
	 * ensures Nothing changed
	 * Checks whether paule is surrounded by walls
	 * uses paule.frontIsClear() and checkLeft/Behind/RightClear
	 * to check whether paule is surrounded by walls
	 * @return true if he is surrounded by walls; false if he is not surrounded by walls
	 */
	public boolean isCaged() {
		if(!(paule.frontIsClear() && this.checkLeftClear() && this.checkBehindClear() && checkRightClear())) {
			paule.write("I'm caged :(");
			return true;
		}else {
			paule.write("I'm free :)");
			return false;
		}
	}
	/**
	 * requires paule to be initialized
	 * ensures Nothing changed
	 * Checks whether the hamster could execute a move command successfully onto the tile
	 * 90 degrees counter clock wise to his line of sight
	 * @return true if the hamster could execute a move command successfully; false if he could not
	 */
	private boolean checkLeftClear() {
		paule.turnLeft();
		boolean isLeftClear = paule.frontIsClear();
        this.turnNTimes(3);
		return isLeftClear;
	}
	/**
	 * requires Paule to be initialized
	 * ensure Nothing changed
	 * Checks whether the hamster could execute a move command successfully
	 * onto the tile behind him
	 * @return true if the hamster could execute a move command successfully; false if he could not
	 */
	private boolean checkBehindClear() {
        this.turnNTimes(2);
		boolean isBehindClear = paule.frontIsClear();
        this.turnNTimes(2);
		return isBehindClear;
	}
	/**
	 * requires Paule to be initialized
	 * ensure Nothing changed
	 * Checks whether the hamster could execute a move command successfully
	 * onto the tile 90 degrees clock wise
	 * @return true if the hamster could execute a move command successfully; false if he could not
	 */
	private boolean checkRightClear() {
        this.turnNTimes(3);
		boolean isRightClear = paule.frontIsClear();
		paule.turnLeft();
		return isRightClear;
	}
	/**
	 * requires Paule to be initialized
	 * ensure Paule turned left a set amount of times
	 * Paule turns left a set amount of times
	 * @param numberOfTurnsLeft The amount of times Paule turns left
	 */
	private void turnNTimes(int numberOfTurnsLeft) {
		/*@
		@loop_invariant Paule turned left i times;
		@decreasing numberOfTurnsLeft-i;
		@*/
		for (int i=0;i<numberOfTurnsLeft;i++){
			paule.turnLeft();
		}
	}
}



