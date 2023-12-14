package de.unistuttgart.iste.sqa.pse.sheet07.homework.painter;

import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

/**
 * Describe the purpose of this class here.
 *
 * @author (Your name)
 * @version (a version number or a date)
 */
public class PainterPauleHamsterGame extends SimpleHamsterGame {
	//@ public instance invariant game.getTerritory != null;
	//@ public instance invariant !game.getTerritory().hasInnerWalls();
	//@ public instance invariant game.getTerritory() == quadratic;
	//@ public instance invariant game.getAmountHamsters > 0;
	//@ public instance invariant pauleIsInitialized;


	/**
	 * Creates a new PainterPauleHamsterGame.<br>
	 * Do not modify!
	 */
	public PainterPauleHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/PainterPauleTerritory.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}

	/**
	 * requires Territory to be quadratic;
	 * requires Territory has no inner walls;
	 * requires pauleIsInitialized;
	 * ensures The biggest possible spiral was drawn;
	 * ensures paule.getGrains() == 0;
	 * Makes Paule paint the biggest possible spiral
	 * @throws IllegalArgumentException if possible is not initialized
	 */
	@Override
	protected void run() {
		if(paule == null){
			throw new IllegalArgumentException();
		}else {
			paule.putGrain();
			int sideLength = getDistanceToWall() - 1;
		/*@
		@ loop_invariant paule moved sideLength * i steps, put sideLength * i grains and turned right i times
		@ decreasing 3-i
		@*/
			for (int i = 0; i < 3; i++) {
				this.moveAndPutNTimes(sideLength);
				this.turnNTimes(3);
			}
			sideLength = sideLength - 2;
		/*@
		@ loop_invariant paule moved sideLength * i steps, put sideLength * i grains and turned right i times
		@ decreasing (sideLength/2 - 1)-i
		@*/
			while(sideLength > 0){
			/*@
			@ loop_invariant paule moved sideLength * i steps, put sideLength * i grains and turned right i times
			@ decreasing 2-i
			@*/
				for(int i=0;i<2;i++) {
					this.moveAndPutNTimes(sideLength);
					this.turnNTimes(3);
				}
				sideLength = sideLength -2;
			}
		}
	}


	////////////////////////////////////////
	// helpers to ascertain preconditions //
	////////////////////////////////////////

	/**
	 * requires paule to be initialized
	 * requires Territory to be quadratic
	 * requires Territory to have no inner Walls
	 * ensures nothing changed
	 *
	 * Calculate paules distance to the next wall.
	 *
	 * (Only Works, if the territory is quadratic and has no inner walls)
	 *
	 * @return paule's distance to the next wall.
	 */
	private int getDistanceToWall() {
		int size = game.getTerritory().getTerritorySize().getColumnCount();
		switch (paule.getDirection()) {
			case NORTH: {
				return paule.getLocation().getRow();
			}
			case EAST: {
				return size - paule.getLocation().getColumn();
			}
			case SOUTH: {
				return size - paule.getLocation().getRow();
			}
			case WEST: {
				return paule.getLocation().getColumn();
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + paule.getDirection());
		}
	}

	/**
	 * requires Paule to be initialized
	 * ensures Nothing changed
	 * Calculate the number of grains paule currently hold in his mouth.
	 *
	 * @return number of grains currently in paule's mouth.
	 */
	private int getPaulesGrainCount() {
		int grainCounter = 0;
		/*@
		@ loop_invariant paule put a grain for each already executed loop iteration.
		@ decreasing grains remaining in paules mouth.
		@*/
		while (!paule.mouthEmpty()) {
			paule.putGrain();
			grainCounter++;
		}
		/*@
		@ loop_invariant paule picked a grain for each already executed loop iteration.
		@ decreasing grains remaining on the tile.
		@*/
		while (paule.grainAvailable()) {
			paule.pickGrain();
		}
		return grainCounter;
	}

	/**
	 * Calculate the number of grains required to paint the desired spiral on the current territory.
	 *
	 * @return number of grains required to paint the desired spiral on the current territory.
	 */
	private int getNumberOfRequiredGrains() {
		final int territorySize = game.getTerritory().getTerritorySize().getColumnCount();
		int lineSize = territorySize - 3;

		int total = lineSize;
		/*@
		@ loop_invariant total is the sum of the previous total plus two times the current linesize + 2
		@ decreasing lineSize
		@*/
		while (lineSize > 0) {
			total += 2 * lineSize;
			lineSize -= 2;
		}
		return total;
	}
	/**
	 * requires Paule to be initialized
	 * ensures Paules looking direction changed 90 degrees counter clock wise numberOfTurnsLeft times
	 * Paule turns left a set amount of times
	 * @param numberOfTurnsLeft The amount of times Paule turns left
	 */
	private void turnNTimes( final int numberOfTurnsLeft) {
		assert paule != null;
		/*@
		@loop_invariant Paule turned left i times;
		@decreasing numberOfTurnsLeft-i;
		@*/
		for (int i=0;i<numberOfTurnsLeft;i++){
			paule.turnLeft();
		}
	}

	/**
	 * requires Paule to be initialized;
	 * ensures Paule moved moveNTimes steps
	 * Paule turns left a set amount of times
	 * @param numberOfSteps The amount of steps paule is supposed to move
	 */
	private void moveAndPutNTimes(final int numberOfSteps) {
		assert paule != null;
		/*@
		@loop_invariant Paule moved i times and put i grains;
		@decreasing numberOfSteps-i;
		@*/
		for (int i=0;i<numberOfSteps;i++){
			paule.move();
			if(!paule.mouthEmpty()){
				paule.putGrain();
			}
		}
	}
}


