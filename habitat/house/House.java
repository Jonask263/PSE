package de.unistuttgart.iste.sqa.pse.sheet08.homework.habitat.house;

import java.util.Set;

/**
 * A house in the habitat game.
 *
 * A house consists of a least one wall and up to one door per wall.
 *
 * @author (your name)
 *
 */
public final class House {

	private final Set<HouseWall> walls;

	/**
	 * Get all the walls of the house.
	 * @return walls of the house.
	 */
	public Set<HouseWall> getWalls() {
		return walls;
	}

	/**
	 * Get all the doors of the house.
	 *
	 * @return doors of the house.
	 */
	public Set<Door> getDoors() {
		// TODO implement 2 (g) here
		return Set.of(); // TODO remove this line if necessary.
	}

	/**
	 * Creates a new house with the specified walls.
	 *
	 * @param walls walls of the new house.
	 */
	public House(final Set<HouseWall> walls) {
		if (walls == null || walls.isEmpty()) {
			throw new IllegalArgumentException("A house must have at least one wall, but there are none.");
		}
		this.walls = walls;
	}
}
