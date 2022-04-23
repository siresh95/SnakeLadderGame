package SnakeLadder;

public class Players {
    private String Name;
    private static Die;

    // Initialize the fields
    public void Player(String name) {
        Die = new Die();
        this.Name = name;

    }

    /***
     * this method plays out the players turn
     * return the number of spaces to move on the board
     *
     */
    public int takeTurn() {
        int roll = Die.rollD();
        System.out.println(Name + "rolled" + roll + " ");
        return roll;

        public String toString () {
            return name;

        }
    }
}