package de.unistuttgart.iste.sqa.pse.sheet11.homework;

import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

import java.util.*;

/**
 * Class to implement homework exercises 1, 2 and 3 of sheet 11.
 */
public class MemoryHamsterGame extends SimpleHamsterGame {

	/**
	 * Creates a new MemoryHamsterGame.<br>
	 * Do not modify!
	 */
	public MemoryHamsterGame() {
		this.loadTerritoryFromResourceFile("/territories/order.ter");
		this.displayInNewGameWindow();
		game.startGame();
	}
	int numberOfGrainsOnTile;
	int stepsTaken;
	LinkedList<Integer>amountOfGrains = new LinkedList<>();
	Stack<Integer> aog = new Stack<>();
	Queue<Integer>queue = new PriorityQueue<>();
	@Override
	protected void run() {
		// Comment any operation call out, to run the others on their own.
		this.inOrder();
		this.reverseOrder();
		this.sort();
		this.sort(descending);
		// TODO Add code for homework exercise 3 (d) here
	}

	/**
	 * Picks up all grains towards on direction and places them in reverse order
	 */
	private void reverseOrder() {
		this.numberOfGrainsOnTile = 0;
		this.stepsTaken = 0;
		this.pickingUpGrainsTillLastTileReverseOrder();
		this.pickingUpGrainsOnLastTile();
		amountOfGrains.add(this.numberOfGrainsOnTile);
		paule.turnLeft();
		paule.turnLeft();
		for (Integer amountOfGrain : amountOfGrains) {
			for (int j = 0; j < amountOfGrain; j++) {
            	paule.putGrain();
            }
				this.moveBackPlusTurn();
        }
	}

	/**
	 * Picks up all grains towards on direction and places them in order
	 */
	private void inOrder() {
		this.numberOfGrainsOnTile = 0;
		this.stepsTaken = 0;
		this.pickingUpGrainsTillLastTileInOrder();
		this.pickingUpGrainsOnLastTile();
			aog.push(this.numberOfGrainsOnTile);
			paule.turnLeft();
			paule.turnLeft();
			int length = aog.size();
			for (int i=0; i< length; i++) {
				for (int j = 0; j < aog.peek(); j++) {
					paule.putGrain();
				}
				aog.pop();
				this.moveBackPlusTurn();
			}
		}


	/**
	 * Picks up all grains towards on direction and places them in ascending order
	 */
	private void sort() {
		this.numberOfGrainsOnTile = 0;
		this.stepsTaken = 0;
		this.pickingUpGrainsTillLastTileSorted();
		this.pickingUpGrainsOnLastTile();
			queue.add(this.numberOfGrainsOnTile);
			paule.turnLeft();
			paule.turnLeft();
			int length = queue.size();
			for (int i=0; i< length; i++) {
				if (!queue.isEmpty()){
					for (int j = 0; j < queue.peek(); j++) {
						paule.putGrain();
					}
					queue.poll();
				}
				this.moveBackPlusTurn();
			}
		}

	/**
	 * Picks up all grains towards on direction and places them in descending order
	 * @param comparatorInteger, the comparator that sorts all integers in descending order
	 */
	private void sort(Comparator<Integer>comparatorInteger) {
	Queue<Integer> queueWithComparator = new PriorityQueue<>(comparatorInteger);
	this.numberOfGrainsOnTile = 0;
	this.stepsTaken = 0;
	while (paule.frontIsClear()) {
		if (paule.grainAvailable()) {
			while (paule.grainAvailable()) {
				paule.pickGrain();
				this.numberOfGrainsOnTile++;
			}
		}
		queueWithComparator.add(this.numberOfGrainsOnTile);
		this.numberOfGrainsOnTile = 0;
		paule.move();
		this.stepsTaken++;
	}
	this.pickingUpGrainsOnLastTile();
	queueWithComparator.add(this.numberOfGrainsOnTile);
	paule.turnLeft();
	paule.turnLeft();
	int length = queueWithComparator.size();
	for (int i=0; i< length; i++) {
		if(!queueWithComparator.isEmpty()){
			for (int j = 0; j < queueWithComparator.peek(); j++) {
				paule.putGrain();
			}
			queueWithComparator.poll();
		}
		this.moveBackPlusTurn();
	}
}

	/**
	 * The comparator that order numbers in descending order
	 */
	public Comparator<Integer>descending = new Comparator<>() {
	@Override
	public int compare(Integer o1, Integer o2) {
		return Integer.compare(o2, o1);
	}
};

	/**
	 * The function used to pick up all Grains on the last tile
	 */
	public void pickingUpGrainsOnLastTile() {
	if (!paule.frontIsClear()) {
		if (paule.grainAvailable()) {
			while (paule.grainAvailable()) {
				paule.pickGrain();
				this.numberOfGrainsOnTile++;
			}
		}
	}
		}

	/**
	 * picks up all grains on all tiles but the last one
	 */
	public void pickingUpGrainsTillLastTileReverseOrder() {
	while (paule.frontIsClear()) {
		if (paule.grainAvailable()) {
			while (paule.grainAvailable()) {
				paule.pickGrain();
				this.numberOfGrainsOnTile++;
			}
		}
		amountOfGrains.add(this.numberOfGrainsOnTile);
		this.numberOfGrainsOnTile = 0;
		paule.move();
		this.stepsTaken++;
	}
}

	/**
	 * picks up all grains on all tiles but the last one
	 */
	public void pickingUpGrainsTillLastTileInOrder() {
	while (paule.frontIsClear()) {
		if (paule.grainAvailable()) {
			while (paule.grainAvailable()) {
				paule.pickGrain();
				this.numberOfGrainsOnTile++;
			}
		}
		aog.push(this.numberOfGrainsOnTile);
		this.numberOfGrainsOnTile = 0;
		paule.move();
		this.stepsTaken++;
	}
}

	/**
	 * picks up all grains on all tiles but the last one
	 */
	public void pickingUpGrainsTillLastTileSorted(){
	while (paule.frontIsClear()) {
		if (paule.grainAvailable()) {
			while (paule.grainAvailable()) {
				paule.pickGrain();
				this.numberOfGrainsOnTile++;
			}
		}
		queue.add(this.numberOfGrainsOnTile);
		this.numberOfGrainsOnTile = 0;
		paule.move();
		this.stepsTaken++;
	}
}

	/**
	 * makes the hamster move towards its starting position
	 */
	public void moveBackPlusTurn(){
	if (this.stepsTaken != 0){
		paule.move();
		this.stepsTaken--;
	} else {
		paule.turnLeft();
		paule.turnLeft();

	}
}
}
