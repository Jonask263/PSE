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
	@Override
	protected void run() {
		// Comment any operation call out, to run the others on their own.
		//this.inOrder();
		//this.reverseOrder();
		//this.sort();
		//this.sort2();
		this.sort3(descending);
		// TODO Add code for homework exercise 3 (d) here
	}

	/**
	 * TODO add documentation here.
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
	 * TODO add documentation here.
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
	 * TODO add documentation here.
	 */
	private void sort() {
		// TODO implement homework exercise 3 (b)
		Queue<Integer>queue = new PriorityQueue<>();
		this.numberOfGrainsOnTile = 0;
		this.stepsTaken = 0;
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
		this.pickingUpGrainsOnLastTile();
			queue.add(this.numberOfGrainsOnTile);
			paule.turnLeft();
			paule.turnLeft();
			int length = queue.size();
			for (int i=0; i< length; i++) {
				for (int j = 0; j < queue.peek(); j++) {
					paule.putGrain();
				}
				queue.poll();
				this.moveBackPlusTurn();
			}
		}
private void sort2(){
	List<Integer> list = new ArrayList<>();
	this.numberOfGrainsOnTile = 0;
	this.stepsTaken = 0;
	while (paule.frontIsClear()) {
		if (paule.grainAvailable()) {
			while (paule.grainAvailable()) {
				paule.pickGrain();
				this.numberOfGrainsOnTile++;
			}
		}
		list.add(this.numberOfGrainsOnTile);
		this.numberOfGrainsOnTile = 0;
		paule.move();
		this.stepsTaken++;
	}
	this.pickingUpGrainsOnLastTile();
	list.add(this.numberOfGrainsOnTile);
	paule.turnLeft();
	paule.turnLeft();
	int length = list.size();
	Collections.sort(list);
	System.out.print(list);
	for (int i=0; i< length; i++) {
		for (int j = 0; j < list.get(i); j++) {
			paule.putGrain();
		}
		this.moveBackPlusTurn();
	}
}
	private void sort3(Comparator<Integer>comparatorInteger) {
		// TODO implement homework exercise 3 (b)
		Queue<Integer> queue3 = new PriorityQueue<>(comparatorInteger);
		this.numberOfGrainsOnTile = 0;
		this.stepsTaken = 0;
		while (paule.frontIsClear()) {
			if (paule.grainAvailable()) {
				while (paule.grainAvailable()) {
					paule.pickGrain();
					this.numberOfGrainsOnTile++;
				}
			}
			queue3.add(this.numberOfGrainsOnTile);
			this.numberOfGrainsOnTile = 0;
			paule.move();
			this.stepsTaken++;
		}
		this.pickingUpGrainsOnLastTile();
		queue3.add(this.numberOfGrainsOnTile);
		paule.turnLeft();
		paule.turnLeft();
		int length = queue3.size();
		for (int i=0; i< length; i++) {
			for (int j = 0; j < queue3.peek(); j++) {
				paule.putGrain();
			}
			queue3.poll();
			this.moveBackPlusTurn();
		}
	}
public Comparator<Integer>descending = new Comparator<>() {
	@Override
	public int compare(Integer o1, Integer o2) {
		return Integer.compare(o2, o1);
	}
};
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
