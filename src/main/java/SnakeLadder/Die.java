package SnakeLadder;
import java.util.Random;


public class Die {

    private Random random;

    /**
     *
     * initialize the field
     */
    public int Die () {
        random = newRandom();
        /****
         * rolls a D6 and random the return value
         * return an random int value b/w 1-6 inclusive
         *
         */
        int rollD6() {
            return random.nextInt(6)+1;
        }
    }
}
