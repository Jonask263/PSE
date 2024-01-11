package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.Identifier;

/**
 * Represents a ruler in the warehouse system.
 *
 * A Ruler is an elongates piece of plastic or wood with a scale on it.
 */
public final class Ruler extends StationeryItem {
	public Ruler(final Identifier identification, final String descriptor) {
		super(identification, descriptor);
	}
}
