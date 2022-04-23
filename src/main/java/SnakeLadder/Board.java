package SnakeLadder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    //constant values;Board size and Number of snakes And Ladder.
    private final int ROWS = 10;
    private final int COLS = 10;
    private final int NUM_SNAKES = 8;
    private final int NUM_Ladders = 8;

    // Board VAriables
    private int [][] gameBoard;
    private int [][] Snakes;
    private int [][] Ladders;
    //map of players position
    //key=players,value=player position
    Map<Player,Integer>playerPositions;
    /**numPlayers the number of players
     * Initilaize the fields
     */

    public Board(List <Players> players) {
        //initialize the player positions
        this.playerPositions = new HashMap<Player,Integer>();
        for (Player player:players) {
            this.playerPositions.put(player, 0);
        }
        //set up rows X cols board
        gameBoard = new int [ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0 ; col <COLS ; col++) {
                gameBoard[row][col]=row*ROWS+col+1;
            }
        }
        //set the snakes and ladderss
        setSnakes();
        SetLadders();
    }
    private void setSnakes() {
        // TODO Auto-generated method stub

    }
    private void SetLadders() {
        // TODO Auto-generated method stub

    }
    /**
     * move the given player based on the value provided
     * player the Player to move
     * VAlue the space to move
     * true if the player reaches the final (100) spot , else false
     */
    public boolean movePlayer(Player player, int value) {
        //compute the new position
        int position = playerPositions.get(player);
        position += value;
        if(position >=100)
            playerPositions.put(player,100);
        return true;
	 else {
            //if the new position is less than 100
            //check if position is starting point for a snake
            for (int idx = 0 ; idx < NUM_SNAKES ; idx++) {
                if(Snakes[idx][0]==position)
                    //if the new position is the starting point for a snake
                    //move the players to the end position for the snake
                    position = Snakes[idx][1];
                playerPositions.put(player, position);

                System.out.println("uh oh"+player+"take snake from"+Snakes[idx][0]+"to"+Snakes[idx][1]);
                return false;
                //if the player is not on a snake / ladder then just update
                //its position normally
                playerPositions.put(player,position);
                return false;

            }

        }

        /**set the snake for the board
         *
         */
        private void setSnakes() {
            Snakes = new int [NUM_SNAKES][2];
            Snakes[0][0] = 17 ;
            Snakes[0][1] = 7 ;
            Snakes[1][0] = 54 ;
            Snakes[1][1] = 34 ;
            Snakes[2][0] = 62 ;
            Snakes[2][1] = 19 ;
            Snakes[3][0] = 64 ;
            Snakes[3][1] = 60 ;
            Snakes[4][0] = 87 ;
            Snakes[4][1] = 24 ;
            Snakes[5][0] = 93 ;
            Snakes[5][1] = 73 ;
            Snakes[6][0] = 95 ;
            Snakes[6][1] = 75 ;
            Snakes[7][0] = 99 ;
            Snakes[7][1] = 78 ;

        }
        /**
         *
         * sets the ladders for the board
         */

        private void setLadders() {
            Ladders = new int [NUM_LADDERS][2];
            Ladders[0][0] = 4 ;
            Ladders[0][1] = 14 ;
            Ladders[1][0] = 9 ;
            Ladders[1][1] = 31 ;
            Ladders[2][0] = 20 ;
            Ladders[2][1] = 38 ;
            Ladders[3][0] = 28 ;
            Ladders[3][1] = 84 ;
            Ladders[4][0] = 40 ;
            Ladders[4][1] = 59 ;
            Ladders[5][0] = 51 ;
            Ladders[5][1] = 67 ;
            Ladders[6][0] = 63 ;
            Ladders[6][1] = 81 ;
            Ladders[7][0] = 71 ;
            Ladders[7][1] = 91 ;


        }
        /***
         * A human readable version of the board
         */



        public String toString() {
            //use nstring builder for creating the string
            StringBuilder Sb = new StringBuilder();
            boolean oddRow = true;

            //note: the rows will be in reverse order , with 1-10 at he bottom and 91 -100 at the top
            //note:if the position is occupied by a player , we print the player , not the number

            for(int row=ROWS-1;row>=0;row--) {
                for (int col = 0;col < COLS ; col++2) {
                    if(oddRow) {
                        //oddRow: row=9,7,5,3,1
                        //check if any of the players occupy the current location
                        String P1 = " ";
                        boolean occupied = false;

                        for (Player temp: playerPosition.keySet()) {
                            if(playerPosition.get(temp)==gameBoard[row][COLS-1-col])
                            {
                                //if a player occupies the current location then set the flag and update p1

                                occupied = true;
                                p1 += temp + " ";

                            }
                        }
                        if (occupied) {
                            //if atleat one player occupies the location,then print those players

                            p1 +="\t";
                            sb.append(p1);

                        }
                        else {
                            sb.append(gameBoard[row][COLS-1-col]+"\t");

                        }
                    }
                    else {
                        //Else.print the position number
                        sb.append(gameBoard[row][COLS-1-col]+"\t");

                    }
                }
			else {

                    //even row; row= 8,6,2,4,0
                    //check if any of the players occupy the current location

                    boolean occupied = false;
                    string p1 = " ";

                    for (Player temp:playerPosition.keyset(1)) {
                        if (playerPosition.get(temp)==gameBoard[row][col]) {


                            //If a player occupies the current location , then set the flag and update

                            occupied = true;
                            p1 += (temp + " ");

                        }
                    }

                    if (occupied) {

                        //If at least one player occupies the location then print those players
                        p1 += "\t";
                        sb.append(p1);

                    }
                    else {

                        //else,print the\position number
                        sb.append(gameBoard[row][col]+"\t");

                    }
                }
            }
            //switch odd row flag and print new line
            oddRow = !oddRow;

        }
        sb.append("\n");
        return sb.toString();
    }
}
