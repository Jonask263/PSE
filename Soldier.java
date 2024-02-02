package de.unistuttgart.iste.sqa.pse.sheet13.homework.settler;

/**
 * Represents a Soldier, a specialized Settler
 */
public final class Soldier extends Settler {
    /**
     * Creates a soldier
     * @param name, the name of the soldier
     * @param position, the position of the soldier
     */
    public Soldier(final String name, final Position position) {
        super(name, position);
    }

    /**
     * specialized settle method
     */
    public void settle(){
        //TODO
    }

    /**
     * Soldier fights against an enemy
     * @param enemy, the enemy the soldier fights against
     */
    public void fightEnemy(final Settler enemy){
        //TODO
    }
}
