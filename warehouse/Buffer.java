package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;

import java.util.*;

/**
 * Represents a buffer for temporary storage of items.
 *
 * @author your name
 */
public final class Buffer {

	// TODO add data structure for exercise 1f here.
	List<StationeryItem> items3;

	// TODO add documentation here

	/**
	 * Creates a new Buffer
	 * requires //?????
	 * ensures items3 is initialized as new Linkedlist
	 */
	public Buffer() {
		items3 = new LinkedList<StationeryItem>();
		// TODO initialize data structure for exercise 1f here.
	}

	// TODO add documentation here

	/**
	 * Puts an item in the buffer
	 * requires Buffer to be initialized
	 * ensures Item has been added to buffer
	 * @param stationeryItem The item to be buffered
	 */
	public void bufferItem(final StationeryItem stationeryItem) { //muss item damit aus Lagerregal genommen werden?
		items3.add(stationeryItem);
		// TODO implement exercise 1g here.
	}

	// TODO add documentation here

	/**
	 * removes first item from the Buffer to be released
	 * requires Buffer to be initialized + at least 1 item in the buffer
	 * ensures first item has been removed from buffer
	 * @return item The item that has been released
	 */
	public StationeryItem releaseItem() {
		StationeryItem item = items3.get(0);
		items3.remove(0);
		// TODO implement exercise 1g here.
		return item; // TODO delete this line if necessary.
	}

	// TODO add documentation here

	/**
	 * Checks whether the buffer is empty
	 * requires Buffer to be initialized
	 * ensures nothing changed
	 * @return true If buffer is empty, false If there is at least 1 item
	 */
	public /*@ pure @*/ boolean isEmpty() {
		if(items3.isEmpty()){
			return true;
		} else {
			return false; // TODO delete this line if necessary.
		}
		// TODO implement exercise 1g here.
	}
}
