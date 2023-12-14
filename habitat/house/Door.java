package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house;

import de.hamstersimulator.objectsfirst.datatypes.Location;

/**
 * A door in a wall.
 * A door marks a position in a wall where hamsters can pass through.
 *
 * @param position the position of the door.
 */
public record Door(Location position) {}
