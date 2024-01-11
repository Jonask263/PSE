package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Pen;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;

import java.util.*;

/**
 * Represents a warehouse that can hold a fixed number of items.
 * The number of holdable items is defined by the capacity of the storage rack.
 *
 * @author your name
 */
public final class StorageRack {
	// @ private instance invariant capacity > 0;
	// @ private instance invariant numberOfItems >= 0;
	// @ private instance invariant numberOfItems <= capacity;

	private final int capacity;
	private int numberOfItems;
	// TODO: Add data structures for exercises 1a and 1c here.

	List<Optional<StationeryItem>> items; //maybe final oder some shit private who really knows
	Map<Identifier, Integer> items2;
	/*@
	@ requires capacity > 0;
	@ ensures this.capacity == capacity;
	@ ensures numberOfItems == 0;
	@ TODO add missing pre- and postconditions here or in the JavaDoc.
	@*/

	/**
	 * Creates a new storage rack with the given capacity.
	 * ensures items is initialized with Optional.empty() elements and the number of compartments equals capacity, items2 is initialized
	 * @param capacity capacity of the storage rack.
	 * @throws IllegalArgumentException If capacity is less than 1.
	 */
	public StorageRack(final int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("A warehouse must have a minimum capacity of 1.");
		}
		this.capacity = capacity;
		numberOfItems = 0;
		items = new ArrayList<Optional<StationeryItem>>(capacity);
		/*@
		  @loop_invariant i Optional.empty() elements have been added if i = loop iterations
		  @decreasing capacity - i;
		 @*/
		for (int i = 0; i < capacity; i++) {
			items.add(Optional.empty());
		}
		items2 = new HashMap<Identifier, Integer>(capacity);
	}

	// TODO add documentation here.

	/**
	 * Adds an item to the storage rack, if it isn't full yet
	 * requires storage rack to be initialized + numberOfItems < capacity
	 * ensures that item is added to the storage rack (both lists) + numberOfItems is increased by 1
	 * @param stationeryItem the item supposed to be added to the storage rack
	 * @throws //maybe wegen full muss mal checken
	 */
	public void addItem(final StationeryItem stationeryItem) {
		if (numberOfItems >= capacity) {
			System.out.println("Is full :(((");
		} else {
			/*@
		    @loop_invariant i elements have been checked if i = loop iterations
		    @decreasing compartmentNumberOfFirstEmptySlot - i;
		    @*/
			for (int i = 0; i < capacity; i++) {
				Optional<StationeryItem> currentItem = items.get(i);
				if (currentItem.isEmpty()) {
					Identifier itemIdentifier = stationeryItem.getIdentifier();
					items.set(i, Optional.of(stationeryItem));
					numberOfItems++;
					items2.put(itemIdentifier, i);
					break;
				}
			}
		}
	}

	// TODO add documentation here.

	/**
	 * removes an item from the storage rack
	 * requires storage rack to be initialized, numberOfItems > 0, items.get(compartmentNumber).isPresent
	 * ensures items.get(compartmentNumber) is set to Optional.empty() + item is removed from items2 + numberOfItems is decreased by 1
	 * @param compartmentNumber the position of the item in the storage rack
	 */
	public void removeItem(final int compartmentNumber) {
		if (numberOfItems <= 0) {
			System.out.println("Liste ist leer lol");
		} else if (items.get(compartmentNumber).isEmpty()) {
			System.out.println("Da ist gar nichts lol");
		} else {
			StationeryItem currentItem = items.get(compartmentNumber).get();
			items.set(compartmentNumber, Optional.empty()); //so ohne remove und dann add empty aber idrk / sollte passen ig lol
			numberOfItems--;
			Identifier itemIdentifier = currentItem.getIdentifier();
			items2.remove(itemIdentifier);
			// TODO implement exercises 1b and 1d here.
		}
	}

	// TODO add documentation here.

	/**
	 * returns the value of the storage space
	 * requires storage rack to be initialized + items.get(compartmentNumber).isPresent()
	 * ensures that the specific item has been returned
	 * @param compartmentNumber the position of the item in the storage rack
	 * @return currentItem, the specific item
	 */
	public /*@ pure @*/ Optional<StationeryItem> getItem(final int compartmentNumber) {
		Optional<StationeryItem> currentItem = items.get(compartmentNumber);
		if (currentItem.isPresent()) {
			System.out.println(currentItem);
			return currentItem; //IDk ob das passt wegen dynamischen typ aber ich werde mir gleich weh tun
		} else {
			return Optional.empty(); // TODO delete this line if necessary.

		}
	}


	// TODO add documentation here.

	/**
	 * Returns the compartment number of the specific item
	 * requires storage rack to be initialized + items2.containsKey(identifier)
	 * ensures that the corresponding compartment number has been returned
	 * @param identifier Identification of the item
	 * @return Optional.of(cNumber), the corresponding compartment number
	 */
	public /*@ pure @*/ Optional<Integer> getCompartmentNumberOf(final Identifier identifier) {
		if (items2.containsKey(identifier)){
			Integer cNumber = items2.get(identifier);
			return Optional.of(cNumber);
		}else {
			return Optional.empty(); // TODO delete this line if necessary.
			// TODO implement exercise 1d here.
		}
	}

	/*@
	@ ensures \result == capacity;
	@*/
	/**
	 * @return The capacity of this warehouse in items.
	 */
	public /*@ pure @*/ int getCapacity() {
		return capacity;
	}

	/*@
	@ ensures \result == numberOfItems;
	@*/
	/**
	 * @return The number of items in this warehouse.
	 */
	public /*@ pure @*/ int getNumberOfItems() {
		return this.numberOfItems;
	}
}
