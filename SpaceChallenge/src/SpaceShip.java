public interface SpaceShip {
    /**
     * judge whether the U1 can launch
     * @return True or False
     */
    boolean launch();
    /**
     * judge whether the U1 can land
     * @return True or False
     */
    boolean land();
    /**
     * judge whether the rocket can carry the item
     * @param item
     * @return True or False
     */
    boolean canCarry(Item item);
    /**
     * update the total weight the spaceship carry
     * @param item
     */
    void carry(Item item);
}
