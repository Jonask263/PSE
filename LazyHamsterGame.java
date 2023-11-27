package de.unistuttgart.iste.sqa.pse.sheet06.homework.exceptions;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;
import de.unistuttgart.iste.sqa.pse.sheet06.homework.maze.AmazingPauleHamsterGame; //klappt nicht

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
	//moveMultipleSteps(5)
	@Override
	protected void run() {moveMultipleSteps(5);
	}

	/*@
	  @requires paule.isInitialized;
	  @ensures Nothing changed or paue moved // muss man move nachbedingungen aufschreiben??
	  @*/
	/**
	 * Hamster has a 70% chance of moving forward
	 * else he does not move
	 * @throws TooLazyException When Hamster did not move
	 */
	public void tryToMove() {
		double randomValue = Math.random();
		if (randomValue > 0.3) {
			paule.move();
		} else {
			//throw new TooLazyException(); moveMultipleSteps geht damit nicht
		}
	}


    /*@
	  @requires paule.isInitialized;
	  @ensures Nothing changed or paule moved // muss man move nachbedingungen aufschreiben??
	  @*/
	/**
	 * makes a lazy hamster move a certain amount of steps
	 * If the hamster can't move forward it is checked hierarchically whether
	 * the hamster can move left, right or backwards, if so, the hamster moves
	 * If the hamster is too lazy to move, he will be motivated
	 * @throws NoWayToGoException if hamster is caged
	 * @param numberOfSteps The amount of steps the hamster should move
	 */
	public void moveMultipleSteps(int numberOfSteps) { //dreht sich bisschen weird wegen left/behind/right checks
		for (int i = 0; i < numberOfSteps; i++) {
				/*@
				@loop_invariant Paule moved i steps
				@decreasing numberOfSteps-i;
				@*/
			Location locationPaule = paule.getLocation();
			if (paule.frontIsClear()) {
				tryToMove();
				if(locationPaule == paule.getLocation()) {
					paule.write("You can do it!");
					i--;
				}
			} else if (checkLeftClear()) {
				paule.turnLeft();
				tryToMove();
				if(locationPaule == paule.getLocation()) {
					paule.write("You can do it!");
					i--;
				}
			}else if (checkRightClear()) {
				/*@
				@loop_invariant Paule turned left j times;
				@decreasing 3-j;
				@*/
				for(int j=0; j<3;j++) {  //maybe mit turnRight ersetzten
					paule.turnLeft();
				}
				tryToMove();
				if(locationPaule == paule.getLocation()) {
					paule.write("You can do it!");
					i--;
				}
			} else if (checkBehindClear()) {
				/*@
				@loop_invariant Paule turned left k times;
				@decreasing 2-k;
				@*/
				for(int k=0;k<2;k++) {
					paule.turnLeft();
				}
				tryToMove();
				if(locationPaule == paule.getLocation()) {
					paule.write("You can do it!");
					i--;
				}
			}else {
				throw new NoWayToGoException();
			}
		}
	}

	/*@
	  @requires paule.isInitialized;
	  @ensures Nothing changed
	  @*/
	/**
	 * Checks whether paule is surrounded by walls
	 * uses paule.frontIsClear() and checkLeft/Behind/RightClear
	 * to check whether paule is surrounded by walls
	 * @return true if he is surrounded by walls; false if he is not surrounded by walls
	 */
	public boolean isCaged() {

		if(!(paule.frontIsClear() && this.checkLeftClear() && this.checkBehindClear() && checkRightClear())) { //maybe da umschreiben damit weniger steht
			paule.write("GEFANGEN"); // muss noch weg aber check nicht wie true returnt wird
			return true;
		}else {
			paule.write("frei");
			return false;
		}
	}

	/*@
	  @requires paule.isInitialized;
	  @ensures Nothing changed
	  @*/
	/**
	 * Checks whether the hamster could execute a move command successfully onto the tile  // Hier noch genauer mit wiederherstellen vom direction erklären oder fine?
	 * 90 degrees counter clock wise to his line of sight
	 * @return true if the hamster could execute a move command successfully; false if he could not
	 */
	public boolean checkLeftClear() {
		paule.turnLeft();
		boolean isLeftClear = paule.frontIsClear();
		/*@
		@loop_invariant Paule turned left i times;
		@decreasing 3-i;
		@*/
		for (int i = 0; i < 3; i++) { // Freitag mit turnright ersetzten
			paule.turnLeft();
		}
		return isLeftClear;
	}
	/*@
	  @requires paule.isInitialized;
	  @ensures Nothing changed
	  @*/
	/**
	 * Checks whether the hamster could execute a move command successfully
	 * onto the tile behind him
	 * @return true if the hamster could execute a move command successfully; false if he could not
	 */
	public boolean checkBehindClear() {
		/*@
		@loop_invariant Paule turned left i times;
		@decreasing 2-i;
		@*/
		for(int i = 0; i<2; i++) {
			paule.turnLeft();
		}
		boolean isBehindClear = paule.frontIsClear();
				/*@
		@loop_invariant Paule turned left j times;
		@decreasing 2-j;
		@*/
		for(int j=0;j<2;j++) {
			paule.turnLeft();
		}
		return isBehindClear;
	}
    /*@
	  @requires paule.isInitialized;
	  @ensures Nothing changed
	  @*/
	/**
	 * Checks whether the hamster could execute a move command successfully
	 * onto the tile 90 degrees clock wise
	 * @return true if the hamster could execute a move command successfully; false if he could not
	 */
	public boolean checkRightClear() {
		/*@
		@loop_invariant Paule turned left i times;
		@decreasing 3-i;
		@*/
		for(int i = 0; i<3; i++) {
			paule.turnLeft();
		}
		boolean isRightClear = paule.frontIsClear();
		paule.turnLeft();
		return isRightClear;
	}
}



