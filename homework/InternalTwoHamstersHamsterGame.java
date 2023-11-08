package de.unistuttgart.iste.sqa.pse.sheet03.homework;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.inspector.InspectableSimpleHamsterGame;

/**
 * This class is used to prepare and run a game.
 * You do not need to alter anything in this class.
 */
public abstract class InternalTwoHamstersHamsterGame extends InspectableSimpleHamsterGame {

	Hamster paula;
	HamsterController controller;

	/**
	 * This constructor is used for loading a territory for the game and for displaying it.
	 */
	InternalTwoHamstersHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/territory_twoHamsters.ter");
		this.displayInNewGameWindow();

		game.startGame();
		paula = new Hamster(game.getTerritory(), Location.from(1, 5), Direction.SOUTH, 0);
		controller = new HamsterController();
	}

	@Override
	protected void run() {
		hamsterRun();
		game.stopGame();
	}

	/**
	 * This method contains everything that the hamster is supposed to do.
	 */
	abstract void hamsterRun();
}
