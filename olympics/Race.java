package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

import de.hamstersimulator.objectsfirst.datatypes.Location;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents a race of RunnerHamsters.
 * Call executeRace() to run the race from start to finish
 *
 */
public final class Race {

	private final List<RunnerHamster> runners;
	private final List<RunnerHamster> finishers;
	private final List<RunnerHamster> didNotFinishRunners;

	private final Location startLocation = new Location(1, 1);

	public Race(final List<RunnerHamster> competitors) {
		this.runners = competitors;
		finishers = new ArrayList<RunnerHamster>();
		didNotFinishRunners = new ArrayList<RunnerHamster>();
	}

	/**
	 * runs the entire race. Each competitor gets to take a single action one ofter the other until
	 * everyone has crossed the finish line
	 */
	public void executeRace() {
		while (!runners.isEmpty()) {
			executeStep();
		}
	}

	/**
	 * runs a single time step of the race, consisting of one round of steps from each of the competitors
	 * that are still on the course
	 */
	private void executeStep() {
		Iterator<RunnerHamster> it = runners.iterator();
		while (it.hasNext()) {
			final RunnerHamster currentRunner = it.next();
			currentRunner.executeNextAction();

			if (currentRunner.hasFinished()) {
				it.remove();
				finishers.add(currentRunner);
				currentRunner.write("I needed " + currentRunner.getActionsTaken() + " actions!");
			}
			if (currentRunner.getLocation().equals(startLocation)) {
				it.remove();
				didNotFinishRunners.add(currentRunner);
				currentRunner.write("I didn't make it to the goal :(");
			}
		}
	}
}
