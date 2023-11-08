package de.unistuttgart.iste.sqa.pse.sheet03.homework;

/**
 * Describe the class TwoHamstersHamsterGame here. hm
 *
 * @author Jonas Kaluza (3740969)
 * @author Taha Darende (3724493)
 *
 * @version 08.11.20223
 */
public class TwoHamstersHamsterGame extends InternalTwoHamstersHamsterGame {

	@Override
	void hamsterRun() {
		// delete the following lines, once you figured out what the helpers do.


		// TODO implement Exercise 2 (b) here
		controller.turnITimes(paule, 3);
		controller.moveISteps(paule, 3);
		controller.pickAllGrains(paule);
		controller.runSemicircle(paule);
		controller.pickAllGrainsInFront(paule);
		controller.pickAllGrains(paule);
		controller.turnITimes(paule, 3);
		controller.moveISteps(paule, 3);
		controller.turnITimes(paule, 3);
		controller.pickAllGrainsInFront(paule);
		controller.runSemicircle(paule);
		controller.putAllGrains(paule);

		// maybe durch paula.move  ersetzen, weil nur 1 schritt -> eigentlich nutzlos
		controller.moveISteps(paula, 1);
		controller.pickAllGrains(paula);
		//maybe durch paula. ersetzen
		controller.turnITimes(paula, 1);
		controller.moveISteps(paula, 4);
		controller.pickAllGrains(paula);
		controller.turnITimes(paula, 3);
		controller.moveISteps(paula, 2);
		controller.pickAllGrains(paula);
		controller.turnITimes(paula, 3);
		controller.moveISteps(paula, 3);
		controller.putAllGrains(paula);

	}
}
