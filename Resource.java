package de.unistuttgart.iste.sqa.pse.sheet13.homework.settler;

/**
 * Represents Resources with name, position and type
 */
public abstract class Resource{
    public final String name;
    public final Position position;
    public final ResourceType resourceType;

    /**
     * Creates a resource
     * @param name, the name of the resource
     * @param position, the position of the resource
     * @param resourceType, the type of the resource
     */
    public Resource(final String name, final Position position, final ResourceType resourceType) {
        this.name = name;
        this.position = position;
        this.resourceType = resourceType;
    }

    /**
     * returns the name of the resource
     * @return the name of the resource
     */
    public String getName() {
        return name;
    }

    /**
     * returns the position of the resource
     * @return, the position of the resource
     */
    public Position getPosition() {
        final Position positionCopy = new Position(position.getLongitude(), position.getLatitude());
        return positionCopy;
    }

    /**
     * Returns the type of the resource
     * @return, the type of the resource
     */
    public ResourceType getResourceType() {
        ResourceType resourceTypeCopy = new ResourceType(resourceType.getLabel());
        return resourceTypeCopy;
    }
}
