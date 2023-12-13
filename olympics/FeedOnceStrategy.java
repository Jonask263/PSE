package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

/**
 * TODO write documentation here.
 *
 * @author your name
 */
public final class FeedOnceStrategy implements FeedingStrategy {
	// if required, put attributes for task (d) here
int timesFed = 0;
	@Override
	public boolean isFeedingRequired() {
		// put code for task (d) here
if(timesFed == 0){
	timesFed = timesFed + 1;
	return true;
} else {
	return false;
}
	}

}
