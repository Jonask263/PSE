package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

/**
 * TODO write documentation here.
 *
 * @author your name
 */
public final class SprinterRacePlan implements RacePlan {

	@Override
	public void nextStep(final RunnerHamster hamster) {
		// put your code for task (c) here
		while (hamster.getEnergyRemaining() >= 3) {
			hamster.runHard();
		}
		hamster.runSlowly();
	}
}
