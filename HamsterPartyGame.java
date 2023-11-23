package de.unistuttgart.iste.sqa.pse.sheet05.homework;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.model.Hamster;
import de.hamstersimulator.objectsfirst.external.model.Territory;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * In this hamster-game {@code paule} gets four new friends.
 *
 * @author Jonas Kaluza (3740969)
 * @author Taha Darende (3724493)
 * @version 21.11.2023
 */
public class HamsterPartyGame extends SimpleHamsterGame {

	/**
	 * Constructor for the Party Game.
	 */
	public HamsterPartyGame() {
		this.loadTerritoryFromResourceFile("/territories/territory-hamsterparty.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}
	
	/**
	 * Starts the HamsterPartyGame.	
	 * 
	 */
	protected void run() {
	Territory territoryAdam = game.getTerritory();
	Location locationAdam = new Location(3,6);
	Direction directionAdam = Direction.WEST;
	Integer grainCountAdam = 1;
	Hamster adam = new Hamster(territoryAdam,locationAdam,directionAdam,grainCountAdam);

	Territory territoryEve = game.getTerritory();
	Location locationEve = new Location(4,6);
	Direction directionEve = Direction.WEST;
	Integer grainCountEve = 1;
	Hamster eve = new Hamster(territoryEve,locationEve,directionEve,grainCountEve);

	Territory territoryErik = game.getTerritory();
	Location locationErik = new Location(2,3);
	Direction directionErik = Direction.SOUTH;
	Integer grainCountErik = 0;
	Hamster erik = new Hamster(territoryErik,locationErik,directionErik,grainCountErik);

	Territory territoryLupin = game.getTerritory();
	Location locationLupin = new Location(4,3);
	Direction directionLupin = Direction.NORTH;
	Integer grainCountLupin = 0;
	Hamster lupin = new Hamster(territoryLupin,locationLupin,directionLupin,grainCountLupin);
	}
}
Boolean D = !paule.canViewSunsrise() || (paule.getDirection() = Direction.EAST && paule.frontIsClear();
