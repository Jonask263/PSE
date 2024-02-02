package de.unistuttgart.iste.sqa.pse.sheet13.homework.settler;

/**
 * Represents a Person
 */
public abstract class Settler {
    public final String name;
    public final Position position;

    /**
     * Creates a Settler with name and position
     * @param name, the name of the settler
     * @param position, the position of the settler
     */
    public Settler(final String name, final Position position) {
        this.name = name;
        this.position = position;
    }

    /**
     * abstract method for every settler which is going to be specialized
     */
    public abstract void settle();

    /**
     * Returns the name of the Settler
     * @return the name of the Settler
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the position of the settler
     * @return the position of the Settler
     */
    public Position getPosition() {
        final Position positionCopy = new Position(position.getLongitude(), position.getLatitude());
        return positionCopy;
    }
}
