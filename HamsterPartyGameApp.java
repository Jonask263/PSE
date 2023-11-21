package de.unistuttgart.iste.sqa.pse.sheet05.homework;

/**
 * This class contains the {@code main} method with which the game can be
 * started.
 */
public final class HamsterPartyGameApp {

	/**
	 * Main-method that creates and starts a new PaulesFriendsGame.
	 *
	 * @param args serves no purpose here
	 */
	public static void main(String[] args) {
		final HamsterPartyGame game = new HamsterPartyGame();
		game.doRun();
	}
}
