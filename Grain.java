package de.unistuttgart.iste.sqa.pse.sheet13.homework.settler;

/**
 * Grain as specific resource
 */
public final class Grain extends Resource {
    /**
     * the constructor of Grain
     * @param name, most definitely going to be "Grain"
     * @param position, the position of the grain
     * @param resourceType, the type of resource, most definitely going to be "Grain"
     */
    public Grain(final String name, final Position position, final ResourceType resourceType) {
        super(name, position, resourceType);
    }

}
