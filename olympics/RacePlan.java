package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;
/**
 * Raceplan for a RunnerHamster
 */
public interface RacePlan {

	/**
	 * Executes the next movement of the given hamster according to this race plan
	 * This method ensures that exactly one of the methods runHard(), runSteadily or runSlowly of
	 * RunnerHamster hamster gets called.
	 * @param hamster the hamster that executed this race plan
	 */
	void nextStep(final RunnerHamster hamster);
}
