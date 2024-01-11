package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.Identifier;

/**
 * Represents an individual stationary item in the warehouse system.
 */
public abstract class StationeryItem {
	// @ private instance invariant identification != null;

	private final Identifier identifier;
	private final String descriptor;

	/*@
	@ requires identification != null && type != null
	@ ensures this.identification == identification
	@ ensures this.type == type
	@*/
	/**
	 * Creates a new item with the given identification.
	 * @param identifier Identification of the item.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public StationeryItem(final Identifier identifier, final String descriptor) {
		if (identifier == null || descriptor == null) {
			throw new IllegalArgumentException("A stationary item's identifier or descriptor must not be null.");
		}
		this.identifier = identifier;
		this.descriptor = descriptor;
	}

	/**
	 * @return The identification object of this item.
	 */
	public Identifier getIdentifier() {
		return identifier;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " (" + descriptor + ")";
	}
}
