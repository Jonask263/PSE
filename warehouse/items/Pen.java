package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.Identifier;

/**
 * Represents a pen in a warehouse system.
 *
 * A pen is a stationary item for writing or drawing.
 */
public final class Pen extends StationeryItem {
	public Pen(final Identifier identification, final String descriptor) {
		super(identification, descriptor);
	}
}
